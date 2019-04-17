package ThinkingInJava.Annotation.DataBase;

@Table(name = "Students")
class Student {
    @SQLInteger(constraints = @Constraints(isPrimaryKey = true)) int id;
    @SQLString(10) String name;
    @SQLInteger(constraints = @Constraints(allowNull = false)) int age;

}
