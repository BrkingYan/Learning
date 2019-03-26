package MySql;

import java.sql.*;

public class CreateDBTest {
    public static void main(String[] args) {
        //jdbc驱动
        String driver="com.mysql.cj.jdbc.Driver";
        //这里我的数据库是cxxt
        String url="jdbc:mysql://localhost:3306/myclass?&useSSL=false&serverTimezone=UTC";
        //String url="jdbc:mysql://localhost:3306/myclass";
        String user="root";
        String password="yy123";

        Connection con = null;
        Statement stmt = null;
        try {
            //注册JDBC驱动程序
            Class.forName(driver);
            //建立连接
            con = DriverManager.getConnection(url, user, password);
            if (!con.isClosed()) {
                System.out.println("数据库连接成功");
            }
            //执行query
            stmt = con.createStatement();
            //创建一个数据库
            String sql = "create database studentsInJDBC";
            stmt.executeUpdate(sql);
            //关闭
            stmt.close();
            con.close();
        } catch (ClassNotFoundException e) {
            System.out.println("数据库驱动没有安装");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
        }
    }
}
