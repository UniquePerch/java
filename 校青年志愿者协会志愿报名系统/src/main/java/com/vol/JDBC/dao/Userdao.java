package com.vol.JDBC.dao;

import com.vol.JDBC.entity.User;
import com.vol.JDBC.util.JDBCutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Userdao {
    public int apply(User user){
        int res = 0;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        JDBCutil utill = new JDBCutil();
        try {
            String name = user.getName();
            String number = user.getNumber();
            String Tel = user.getTel();
            int volnum = user.getVolnum();
            String qq =user.getQQ();
            connection = utill.getconnection();
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            statement.addBatch("insert into user(name,number,tel,volnum,qq) values('"+name+"','"+number+"','"+Tel+"','"+volnum+"','"+qq+"')");
            statement.addBatch("update volunt set nowpeo = nowpeo+1 where NO = '"+user.getVolnum()+"'");
            int result[] = statement.executeBatch();
            connection.commit();
            if(result[0] == result[1]&&result[1] ==1 ) res = 1;
        }catch (Exception e){
            e.printStackTrace();
            connection.rollback();
        }finally {
            utill.close(connection,statement,resultSet);
            return res;
        }
    }

    public ArrayList<User> query(int No){
        ArrayList<User> list = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        JDBCutil utill = new JDBCutil();
        try {
            connection = utill.getconnection();
            String sql = "select name,number,tel,QQ where volnum = "+No;
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String name = resultSet.getString("name");
                String Number = resultSet.getString("number");
                String tel = resultSet.getString("tel");
                String QQ = resultSet.getString("QQ");
                list.add(new User(name,Number,tel,QQ));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            utill.close(connection,statement,resultSet);
            return list;
        }
    }
}
