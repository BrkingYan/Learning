package ThinkingInJava.Annotation.DataBase;

public class Test {
    public static void main(String[] args) {
        TableCreator creator = new TableCreator();
        //System.out.println(creator.createTableString());
        MysqlConnector connector = new MysqlConnector();
        connector.connect();
        connector.useDatabase("mycompany");
        connector.createTable(creator.createTableString());
        connector.executeAll();
    }
}
