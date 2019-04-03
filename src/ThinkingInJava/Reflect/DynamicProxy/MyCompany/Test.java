package ThinkingInJava.Reflect.DynamicProxy.MyCompany;

/*
*  空对象模式
* */
public class Test {
    public static void main(String[] args) {
        StaffList list = new StaffList(
                "President",
                "CTO",
                "Marketing Manager",
                "Product Manager",
                "Project Lead",
                "Software Engineer",
                "Software Engineer",
                "Software Engineer",
                "Test Engineer"
        );

        list.fillPosition("President",new Person("Yan yan","22"));
        list.fillPosition("Software Engineer",new Person("Mike","24"));
        list.fillPosition("Software Engineer",new Person("jack","25"));
        System.out.println(list);
    }




}
