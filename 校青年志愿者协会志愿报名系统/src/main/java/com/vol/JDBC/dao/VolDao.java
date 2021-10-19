package com.vol.JDBC.dao;

import com.vol.JDBC.entity.Volunt;
import com.vol.JDBC.util.JDBCutil;

import java.sql.*;
import java.util.ArrayList;

public class VolDao{
    public ArrayList<Volunt> get_basic_information(){
        ArrayList<Volunt> list = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        JDBCutil utill = new JDBCutil();
        try {
            connection = utill.getconnection();
            String sql = "select no,name,time,location,maxpeo,nowpeo from volunt where active = 1";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                int No = resultSet.getInt("no");
                String name = resultSet.getString("name");
                String time = resultSet.getString("time");
                String location = resultSet.getString("location");
                int maxpeo = resultSet.getInt("maxpeo");
                int nowpeo = resultSet.getInt("nowpeo");
                list.add(new Volunt(No,name,location,time,maxpeo,nowpeo));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            utill.close(connection,statement,resultSet);
            return list;
        }
    }

    public ArrayList<Volunt> get_my_information(String number){
        ArrayList<Volunt> list = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        JDBCutil utill = new JDBCutil();
        try {
            connection = utill.getconnection();
            statement   = connection.createStatement();
            String sql = "select no,name,time " +
                         "from volunt " +
                         "where no = (select volnum from user where number = "+number+")";
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                int no = resultSet.getInt("no");
                String name = resultSet.getString("name");
                String time = resultSet.getString("time");
                list.add(new Volunt(no,name,time));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            utill.close(connection,statement,resultSet);
            return list;
        }
    }

    public Volunt get_detailed_information(int number){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Volunt volunt = null;
        JDBCutil utill = new JDBCutil();
        try {
            connection = utill.getconnection();
            String sql = "select * from volunt where no = "+number;
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                int no = resultSet.getInt("No");
                String name = resultSet.getString("Name");
                String work = resultSet.getString("Work");
                String location = resultSet.getString("Location");
                String time = resultSet.getString("Time");
                String benefits = resultSet.getString("benefits");
                String etc = resultSet.getString("etc");
                int maxpeo = resultSet.getInt("Maxpeo");
                int nowpeo = resultSet.getInt("Nowpeo");
                volunt = new Volunt(no,name,work,location,time,benefits,etc,maxpeo,nowpeo);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            utill.close(connection,statement,resultSet);
            return volunt;
        }
    }

    public int add(Volunt volunt){
        int res = 0;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        JDBCutil utill = new JDBCutil();
        try {
            connection = utill.getconnection();
            String sql = "insert into volunt(name,work,location,time,benefits,etc,maxpeo) values(?,?,?,?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1,volunt.getName());
            statement.setString(2,volunt.getWork());
            statement.setString(3,volunt.getLacation());
            statement.setString(4,volunt.getTime());
            statement.setString(5,volunt.getBenefits());
            statement.setString(6,volunt.getEtc());
            statement.setInt(7,volunt.getMaxpeo());
            res = statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            utill.close(connection,statement,resultSet);
            return res;
        }
    }

    public int set_inactive(int no){
        int res = 0;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        JDBCutil utill = new JDBCutil();
        try {
            connection = utill.getconnection();
            String sql = "update volunt set active = 0 where no = "+no;
            statement = connection.createStatement();
            res = statement.executeUpdate(sql);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            utill.close(connection,statement,resultSet);
            return res;
        }
    }

    public int update(int No,Volunt volunt){
        int res = 0;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        JDBCutil utill = new JDBCutil();
        try {
            connection = utill.getconnection();
            String Name = volunt.getName();
            String Work = volunt.getWork();
            String Location = volunt.getLacation();
            String Time = volunt.getTime();
            String Benefits = volunt.getBenefits();
            String Etc = volunt.getEtc();
            int maxpeo = volunt.getMaxpeo();
            String sql = "update volunt set name='"+Name+
                    "',Work='"+ Work +
                    "',Location='"+ Location +
                    "',Time='"+ Time +
                    "',Benefits='"+Benefits+
                    "',Etc='"+Etc+
                    "',Maxpeo= '"+maxpeo+
                    "'where No="+No;
            statement = connection.createStatement();
            res = statement.executeUpdate(sql);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            utill.close(connection,statement,resultSet);
            return res;
        }
    }

    public int delete(int no){
        int res = 0;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        JDBCutil utill = new JDBCutil();
        try {
            connection = utill.getconnection();
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            statement.addBatch("delete from user where volnum ="+no);
            statement.addBatch("delete from volunt where NO ="+no);
            int result[] = statement.executeBatch();
            connection.commit();
            if(result[0] >= 1 && result[1] >= 1 ) res = 1;
        }catch (Exception e){
            e.printStackTrace();
            connection.rollback();
        }finally {
            utill.close(connection,statement,resultSet);
            return res;
        }
    }
}
