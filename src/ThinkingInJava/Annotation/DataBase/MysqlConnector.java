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
            //注册JDBC驱动程序
            //jdbc驱动
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);
            //建立连接
            String url = "jdbc:mysql://localhost:3306/myclass?&useSSL=false&serverTimezone=UTC";
            //String url="jdbc:mysql://localhost:3306/myclass";
            String user = "root";
            String password = "yy123";
            con = DriverManager.getConnection(url, user, password);
            if (!con.isClosed()) {
                System.out.println("数据库连接成功");
            }

            stmt = con.createStatement();
            //手动提交
            con.setAutoCommit(false);
        } catch (ClassNotFoundException e) {
            System.out.println("数据库驱动没有安装");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
        }
    }

    void executeAll(){
        try {
            //注意 java代码中的sql语句末尾不需要分号
            //批量执行
            int[] count = stmt.executeBatch();
            con.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭
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
            //创建一个table
            stmt.addBatch(createString);
            System.out.println(createString);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void insertData(){
        try {
            //插入一条数据
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
            //创建数据库
            String sql = "create database " + dataBaseName;
            stmt.addBatch(sql);
            System.out.println(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void useDatabase(String databaseName){
        try {
            //使用该数据库
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
                System.out.println("连接关闭成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
