package MySql;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class javaTest {

    public static void main(String[] args) {
        Connection con;
        //jdbc驱动
        String driver="com.mysql.cj.jdbc.Driver";
        //这里我的数据库是cxxt
        String url="jdbc:mysql://localhost:3306/myclass?&useSSL=false&serverTimezone=UTC";
        String user="root";
        String password="yy123";
        try {
            //注册JDBC驱动程序
            Class.forName(driver);
            //建立连接
            con = DriverManager.getConnection(url, user, password);
            if (!con.isClosed()) {
                System.out.println("数据库连接成功");
            }
            Statement stmt = con.createStatement();

            String sql = "select * from students";
            ResultSet ret = stmt.executeQuery(sql);
            while (ret.next()){
                int id = ret.getInt("id");
                String name = ret.getString("name");
                System.out.print("id: " + id);
                System.out.println(", name: " + name);
            }

            con.close();
        } catch (ClassNotFoundException e) {
            System.out.println("数据库驱动没有安装");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
        }
    }
}
