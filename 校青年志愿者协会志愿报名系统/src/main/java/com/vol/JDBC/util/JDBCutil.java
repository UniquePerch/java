package com.vol.JDBC.util;
//JDBC工具包，方便使用，风格因人而异
import java.sql.*;

public class JDBCutil {//类中的方法都是私有的
    public JDBCutil(){

    }

    static {//静态代码块在类加载时候执行，只执行一次
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getconnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://8.136.203.42:3306/vol?useUnicode=true&characterEncoding=utf8","root","lyh701721");
        //获取数据库链接
    }
    public static void close(Connection connection, Statement statement, ResultSet resultSet){
         if(resultSet!=null){
             try {
                 resultSet.close();
             } catch (SQLException throwables) {
                 throwables.printStackTrace();
             }
         }
         if(statement!=null){
             try {
                 statement.close();
             } catch (SQLException throwables) {
                 throwables.printStackTrace();
             }
         }
         if(connection!=null){
             try {
                 connection.close();
             } catch (SQLException throwables) {
                 throwables.printStackTrace();
             }
         }//关闭结果集，执行语句，链接，注意关闭的顺序不能交换
    }
}
