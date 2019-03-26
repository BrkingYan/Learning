package MySql;

import java.sql.*;

public class BatchTest {
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

            stmt = con.createStatement();
            //手动提交
            con.setAutoCommit(false);
            /*
            * 注意 java代码中的sql语句不需要分号
            * */
            //批量处理
            //创建数据库
            String sql = "create database mydatabase";
            stmt.addBatch(sql);
            //使用该数据库
            sql = "use mydatabase";
            stmt.addBatch(sql);
            //创建一个table
            sql = "create table brothers("
                    + "id   int     unsigned    auto_increment,"
                    + "name   varchar(6)     not null ,"
                    + "age   int     not null ,"
                    + "tel   char(11)    not null ,"
                    + "primary key (id)"
                    + ")ENGINE=InnoDB DEFAULT CHARSET=utf8";
            stmt.addBatch(sql);
            //插入一条数据
            sql = "insert into brothers "
                    + "values(1,'Mike',21,'13456785678')";
            stmt.addBatch(sql);
            //批量执行
            int[] count = stmt.executeBatch();
            con.commit();

            /*//插入一个数据
            sql = ""
            //从result set 提取数据
            while (ret.next()){
                int id = ret.getInt("id");
                String name = ret.getString("name");
                int age = ret.getInt("age");
                System.out.print("id: " + id);
                System.out.print(", name: " + name);
                System.out.println(", age: " + age);
            }*/

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
