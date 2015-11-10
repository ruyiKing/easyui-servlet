package com.yrw.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yrw.service.LoginService;
import com.yrw.service.impl.LoginServiceImpl;
import com.yrw.vo.Form;

/**
 * Created by fate on 2015/9/17.
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LoginService loginService;

    public LoginServlet() {
        super();
    }

    /**
     * Destruction of the servlet. <br>
     */
    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getContextPath();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String login_no = request.getParameter("login_no");
        String password = request.getParameter("password");

        List<Object> params = new ArrayList<Object>();
        params.add(login_no);
        //params.add(password);
        System.out.println(params);
        Form user = loginService.doLogin(params);
        if(user == null ){
            out.println("登录用户不存在");
            //response.sendRedirect(path + "/jsp/eror.jsp");
        }
        if(!"1".equals(password)){
        	out.print("用户名或密码不正确，请重新输入");
        	return;
        }

        if("admin".equals(user.getLogin_no()) && "1".equals(password)){
            out.println("登录成功");
            System.out.println("1跳转路径："+path + "/jsp/Success.jsp");
            response.sendRedirect(path + "/jsp/listForm.jsp");
            //response.sendRedirect(path+ "/jsp/Success.jsp");
        }else{
            out.println("失败");
            response.sendRedirect(path + "/jsp/eror.jsp");
        }
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void init() throws ServletException{
        loginService = new LoginServiceImpl();
    }
}
