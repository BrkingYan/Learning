package String_Algorithm.SortString.KeyIndexCounting;

public class Person {
    private String name;
    private int groupId;

    Person(String name,int groupId){
        this.name = name;
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return name + "--" + groupId;
    }

    public String getName() {
        return name;
    }

    public int getGroupId() {
        return groupId;
    }
}
