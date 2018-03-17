package com.igumnov.common.reflection;

import com.igumnov.common.Log;
import com.igumnov.common.orm.SimpleField;
import com.igumnov.common.orm.annotations.Entity;
import com.igumnov.common.orm.annotations.Id;
import com.igumnov.common.orm.Table;
import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.text.MessageFormat;
import java.util.*;

public class ReflectionAPI {

    private static List<Table> tables = new ArrayList<>();


    public static List<Table> getAllEntities(String path) {
        Reflections ref = new Reflections(path);
        for (Class<?> cl : ref.getTypesAnnotatedWith(Entity.class)) {
            Entity findable = cl.getAnnotation(Entity.class);
            Table table = new Table(cl, findable.tableName(),getAnnotatedFields(cl));
            tables.add(table);
        }
        return tables;
    }

    public static List<SimpleField> getAnnotatedFields(final Class<?> clazz) {
        List<SimpleField> tableFields = new ArrayList<>();
        Collection<Field> fields = Arrays.asList(clazz.getDeclaredFields());
        Iterator<Field> iterator = fields.iterator();
        while (iterator.hasNext()) {
            Field field = iterator.next();
            try {
                if (!java.lang.reflect.Modifier.isStatic(field.getModifiers()))
                if(field.isAnnotationPresent(com.igumnov.common.orm.annotations.Field.class)) {
                    tableFields.add(new SimpleField(field.getName(),field.
                            getAnnotation(com.igumnov.common.orm.annotations.Field.class).
                            fieldName(), field.getType(), false, field.
                            getAnnotation(com.igumnov.common.orm.annotations.Field.class).autoIncremental()));
                } else if (field.isAnnotationPresent(Id.class)) {
                    tableFields.add(new SimpleField(field.getName(),field.
                            getAnnotation(Id.class).
                            fieldName(), field.getType(), true, field.
                            getAnnotation(Id.class).autoIncremental()));
                }
            } catch (SecurityException se) {
                Log.error(MessageFormat
                        .format("Security exception while setting accessible: {0}",
                                se));
            }

        }
        return tableFields;
    }
    public static Map<String, Object> getAnnoptatedFields(Object obj) throws IllegalAccessException {
        Map<String, Object> fields = new LinkedHashMap<>();
        String pkField = null;
        Object pkFieldValue = null;
        for (Field field : obj.getClass().getDeclaredFields()) {
            if (!java.lang.reflect.Modifier.isStatic(field.getModifiers())) {
                for (Annotation annotation : field.getDeclaredAnnotations()) {
                    if (annotation.annotationType().equals(Id.class)) {
                        pkField = field.getName();
                        field.setAccessible(true);
                        pkFieldValue = field.get(obj);
                    } else
                    if (annotation.annotationType().equals(com.igumnov.common.orm.annotations.Field.class)) {
                        field.setAccessible(true);
                        fields.put(field.getName(), field.get(obj));
                    }
                }
            }
        }
        return fields;
    }
    public static List<Table> getTables(){
        return tables;
    }
}
