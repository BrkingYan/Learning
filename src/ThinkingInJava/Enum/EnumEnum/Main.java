package ThinkingInJava.Enum.EnumEnum;

import ThinkingInJava.Enum.EnumRandomUtil;

public class Main {
    public static void main(String[] args) {
        for (int i = 0;i<10;i++){
            School school = EnumRandomUtil.getRandomEnumMember(School.class);
            System.out.println(school + " : " + school.getRandomPerson());
        }
    }
}
