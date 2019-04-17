package ThinkingInJava.Annotation.UseAnnotation;



class Person {
    @FieldAnnotation(fieldId = 1,description = "name")
    private String name;
    @FieldAnnotation(fieldId = 2,description = "age")
    private int age;

    @UseCase(id = 1,description = "show something")
    void show(){
        System.out.println("show() invoked");
    }

    @UseCase(id = 2,description = "print something")
    void print(){
        System.out.println("print() invoked");
    }
}
