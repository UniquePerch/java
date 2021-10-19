package com.vol.Admin;

import com.vol.JDBC.dao.VolDao;
import net.sf.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Set_inactive", value = "/Set_inactive")
public class Set_inactive extends HttpServlet {
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
        No = Integer.parseInt(request.getParameter("No"));
        VolDao dao = new VolDao();
        int res = dao.set_inactive(No);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("res",res);
        response.getWriter().write(jsonObject.toString());
    }
}
