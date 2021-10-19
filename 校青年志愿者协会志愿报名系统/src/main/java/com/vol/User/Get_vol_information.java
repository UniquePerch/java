package com.vol.User;

import com.vol.JDBC.dao.VolDao;
import com.vol.JDBC.entity.Volunt;
import net.sf.json.JSONArray;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Get_vol_information", value = "/Get_vol_information")
public class Get_vol_information extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 允许跨域的请求方法GET, POST, HEAD 等 */
        response.setHeader("Access-Control-Allow-Methods", "*");
        /* 重新预检验跨域的缓存时间 (s) */
        response.setHeader("Access-Control-Max-Age", "3600");
        /* 允许跨域的请求头 */
        response.setHeader("Access-Control-Allow-Headers", "*");
        /* 是否携带cookie */
        response.setHeader("Access-Control-Allow-Credentials", "true");
        JSONArray jsonArray = new JSONArray();
        VolDao dao = new VolDao();
        ArrayList<Volunt> list = dao.get_basic_information();
        jsonArray = JSONArray.fromObject(list);
        response.getWriter().write(jsonArray.toString());
    }
}
