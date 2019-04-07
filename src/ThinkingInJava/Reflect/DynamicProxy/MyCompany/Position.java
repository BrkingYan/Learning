package ThinkingInJava.Reflect.DynamicProxy.MyCompany;

class Position {
    private String jobTitle;
    private Person person;

    Position(String jobTitle,Person employee){
        this.jobTitle = jobTitle;
        if (employee == null){
            person = Person.NULLPERSON;
        }else {
            person = employee;
        }
    }
    Position(String jobTitle){
        this.jobTitle = jobTitle;
        person = Person.NULLPERSON;
    }

    String getJobTitle(){
        return jobTitle;
    }

    Person getPerson(){
        return person;
    }

    void setPerson(Person newPerson){
        if (newPerson == null)
            person = Person.NULLPERSON;
        else
            person = newPerson;
    }

    @Override
    public String toString() {
        return "position : " + jobTitle + " " + person + "\n";
    }
}
