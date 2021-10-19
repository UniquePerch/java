package com.vol;

import com.vol.JDBC.dao.Userdao;
import com.vol.JDBC.dao.VolDao;
import com.vol.JDBC.entity.User;
import com.vol.JDBC.entity.Volunt;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        User user = new User("lyh","20042025","177",1,"123456");
        Userdao dao = new Userdao();
        int res = dao.apply(user);
        System.out.println(res);
    }
}
