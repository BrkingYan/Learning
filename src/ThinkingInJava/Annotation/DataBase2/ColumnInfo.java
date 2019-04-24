package ThinkingInJava.Annotation.DataBase2;

import java.lang.annotation.*;


@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface ColumnInfo {

    enum SQLDataType{
        SQLINTEGER,
        SQLSTRING;

    }

    boolean isPrimaryKey() default false;
    boolean allowNull() default true;
    boolean unique() default false;
    SQLDataType dataType();
}
