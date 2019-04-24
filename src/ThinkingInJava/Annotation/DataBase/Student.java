package ThinkingInJava.Annotation.DataBase;

@Table(name = "Students")
class Student {
    @SQLInteger(name = "the_ID" ,constraints = @Constraints(isPrimaryKey = true)) int id;
    @SQLString(10) String name;
    @SQLInteger(name = "the_Age",constraints = @Constraints(allowNull = false)) int age;
}
