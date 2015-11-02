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

import com.yrw.service.AddFormService;
import com.yrw.service.impl.AddFormServiceImpl;



/**
 * Servlet implementation class FormServlet
 */
@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AddFormService addFormService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /** 
     * Destruction of the servlet. <br> 
     */  
    public void destroy() {  
        super.destroy(); // Just puts "destroy" string in log  
        // Put your code here  
    }  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String message = request.getParameter("message");
		String language = request.getParameter("language");
		
		List<Object> params = new ArrayList<Object>();
		params.add(name);
		params.add(email);
		params.add(subject);
		params.add(message);
		params.add(language);
		System.out.println(params);
		boolean flag = addFormService.addform(params);
	    if(flag){
	        out.println("成功");
	        System.out.println("1跳转路径："+path + "/jsp/Success.jsp");
	        response.sendRedirect(path + "/jsp/Success.jsp");
	        //response.sendRedirect(path+ "/jsp/Success.jsp");
	    }else{
	        out.println("失败");
	        response.sendRedirect(path + "/jsp/eror.jsp");
	    }
	    out.flush();
        out.close();
		
	}
	
	public void init() throws ServletException{
		addFormService = new AddFormServiceImpl();
	}

}
