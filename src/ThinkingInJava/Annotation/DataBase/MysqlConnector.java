package ThinkingInJava.Annotation.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class MysqlConnector {
    private Connection con = null;
    private Statement stmt = null;

    public static void main(String[] args) {
        MysqlConnector c = new MysqlConnector();
        c.connect();
        c.createDatabase("mycompany");
        c.useDatabase("mycompany");
        c.createTable("employees");
        c.insertData();
        c.executeAll();
        c.closeConnection();
    }
    void connect(){
        try {
            //ע��JDBC��������
            //jdbc����
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);
            //��������
            String url = "jdbc:mysql://localhost:3306/myclass?&useSSL=false&serverTimezone=UTC";
            //String url="jdbc:mysql://localhost:3306/myclass";
            String user = "root";
            String password = "yy123";
            con = DriverManager.getConnection(url, user, password);
            if (!con.isClosed()) {
                System.out.println("���ݿ����ӳɹ�");
            }

            stmt = con.createStatement();
            //�ֶ��ύ
            con.setAutoCommit(false);
        } catch (ClassNotFoundException e) {
            System.out.println("���ݿ�����û�а�װ");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("���ݿ�����ʧ��");
        }
    }

    void executeAll(){
        try {
            //ע�� java�����е�sql���ĩβ����Ҫ�ֺ�
            //����ִ��
            int[] count = stmt.executeBatch();
            con.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //�ر�
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            closeConnection();
        }
    }

    void createTable(String createString){
        try {
            //����һ��table
            stmt.addBatch(createString);
            System.out.println(createString);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void insertData(){
        try {
            //����һ������
            String sql = "insert into employees \n"
                    + "values \n (1,'Mike',21,'13456785678')";
            stmt.addBatch(sql);
            System.out.println(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void createDatabase(String dataBaseName){
        try {
            //�������ݿ�
            String sql = "create database " + dataBaseName;
            stmt.addBatch(sql);
            System.out.println(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void useDatabase(String databaseName){
        try {
            //ʹ�ø����ݿ�
            String sql = "use " + databaseName;
            stmt.addBatch(sql);
            System.out.println(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    private void closeConnection(){
        try {
            con.close();
            if (con.isClosed()){
                System.out.println("���ӹرճɹ�");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
