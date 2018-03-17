import com.igumnov.common.ORM;
import com.igumnov.common.orm.Reference;
import com.igumnov.common.orm.annotations.Constraint;
import com.igumnov.common.orm.annotations.Entity;
import com.igumnov.common.orm.annotations.Field;
import com.igumnov.common.orm.annotations.Id;
import com.igumnov.common.reflection.ReflectionException;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.ArrayList;

@Entity(tableName = "O")
public class TEST {
    @Id(autoIncremental = false, fieldName = "id")
    public String field;
    @Constraint(referenceType = Reference.ONE_TO_MANY,fieldName = "Test.id")
    @Field(fieldName = "SEX", autoIncremental = false)
    public int id;
    public static void main(String[] args) throws NoSuchFieldException, SQLException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, ReflectionException, IOException, InstantiationException {
        ORM.LoadProperties(TEST.class, "db_config");
        Object o = new TEST();
        Type t = TEST.class;
        System.out.println(t.getTypeName());
        System.out.println(o.getClass().getSimpleName());
        TEST test = new TEST();
        test.setId(2);
        test.setField("asdacscss");

        //System.out.println(((TEST)al).getField());
        //ORM.delete(test);
        ORM.insert(test);
        Object al = ORM.findOne(TEST.class,"asdacs");
        ORM.findBy("id=?",TEST.class,new Integer(2));
       // ORM.update(test);
        //ReflectionAPI.getAllEntities("");
       /* java.lang.reflect.SimpleField field = TEST.class.getField("d");
        Type fieldType = field.getType();
        System.out.println(fieldType.toString()+" "+String.class.toString());*/
    }
    public String getField() {return field;}
    public void setField(String field) {this.field=field;}
    public void setId(int id){this.id=id;}
}

