package ThinkingInJava.Reflect.DynamicProxy.MyCompany;

import java.util.ArrayList;

class StaffList extends ArrayList<Position> {


    StaffList(String... jobTitles){
        add(jobTitles);
    }

    void add(String jobTitle,Person person){
        add(new Position(jobTitle,person));
    }

    void add(String... jobTitles){
        for (String jobTitle : jobTitles){
            add(new Position(jobTitle));
        }
    }

    boolean positionAvailable(String jobTitle){
        for (Position position : this){
            if (position.getJobTitle().equals(jobTitle) &&
                position.getPerson() == Person.NULLPERSON){
                return true;
            }
        }
        return false;
    }

    void fillPosition(String jobTitle,Person person){
        for (Position position : this){
            if (position.getJobTitle().equals(jobTitle) &&
                position.getPerson().equals(Person.NULLPERSON))
            {
                position.setPerson(person);
                return;
            }
        }
        throw new RuntimeException("Position " + jobTitle + " not available");
    }
}
