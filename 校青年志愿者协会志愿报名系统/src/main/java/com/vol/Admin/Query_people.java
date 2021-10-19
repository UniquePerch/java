package com.vol.Admin;

import com.vol.JDBC.dao.Userdao;
import com.vol.JDBC.entity.User;
import net.sf.json.JSONArray;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Query_people", value = "/Query_people")
public class Query_people extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* 允许跨域的主机地址 */
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 允许跨域的请求方法GET, POST, HEAD 等 */
        response.setHeader("Access-Control-Allow-Methods", "*");
        /* 重新预检验跨域的缓存时间 (s) */
        response.setHeader("Access-Control-Max-Age", "3600");
        /* 允许跨域的请求头 */
        response.setHeader("Access-Control-Allow-Headers", "*");
        /* 是否携带cookie */
        response.setHeader("Access-Control-Allow-Credentials", "true");
        int No = 0;
        ArrayList<User> list = new ArrayList<>();
        No = Integer.parseInt(request.getParameter("No"));
        Userdao dao = new Userdao();
        list = dao.query(No);
        JSONArray jsonArray = new JSONArray();
        jsonArray = JSONArray.fromObject(list);
        response.getWriter().write(jsonArray.toString());
    }
}
