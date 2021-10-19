package com.vol.User;

import com.vol.JDBC.dao.Userdao;
import com.vol.JDBC.dao.VolDao;
import com.vol.JDBC.entity.User;
import com.vol.JDBC.entity.Volunt;
import net.sf.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Apply_for_vol", value = "/Apply_for_vol")
public class Apply_for_vol extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
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
        String name = null;
        String number = null;
        String tel = null;
        int volnum;
        String QQ = null;
        name = request.getParameter("Name");
        number = request.getParameter("Number");
        tel = request.getParameter("Tel");
        volnum = Integer.parseInt(request.getParameter("Volnum"));
        QQ = request.getParameter("QQ");
        User user = new User(name,number,tel,volnum,QQ);
        Userdao dao = new Userdao();
        int res = dao.apply(user);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("res",res);
        response.getWriter().write(jsonObject.toString());
    }
}
