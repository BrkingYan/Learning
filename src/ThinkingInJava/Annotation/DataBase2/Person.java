package ThinkingInJava.Annotation.DataBase2;


@Table(tableName = "persons")
public class Person {

    @ColumnInfo(dataType = ColumnInfo.SQLDataType.SQLINTEGER,isPrimaryKey = true)
    private int id;
    @ColumnInfo(dataType = ColumnInfo.SQLDataType.SQLSTRING)
    private String name;
    @ColumnInfo(dataType = ColumnInfo.SQLDataType.SQLINTEGER)
    private int age;
}
