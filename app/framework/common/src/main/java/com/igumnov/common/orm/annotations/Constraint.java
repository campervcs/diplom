package com.igumnov.common.orm.annotations;

import com.igumnov.common.orm.Reference;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Constraint {
    Reference referenceType();
    String fieldName();
}
