package com.yrw.test.passbyvaluejson;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JsonServlet() {
        super();
    }
    public void destroy() {
        super.destroy();
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                                                                                                                                                                             
        response.setContentType("text/xml");
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        AthleteAction athleteaction=new AthleteAction();
        try {
            String json1 = request.getParameter("athletehead");//接收athlete表的头数据
            String json2 = request.getParameter("athlete");//接收athlete表数据
            json1 = java.net.URLDecoder.decode(json1,"UTF-8");
            json2 = java.net.URLDecoder.decode(json2, "UTF-8");
            if ((json1 != "") && (json2 != "")) {
                //System.out.println("json1:"+json1);
                JSONObject jsonObject1 =JSONObject.fromObject(json1);//生成json对象
                JSONArray jsonArray2 = JSONArray.fromObject(json2);//生成JSON数组
                for(int i=0;i<jsonArray2.size();i++){
                    JSONObject resultObj = jsonArray2.optJSONObject(i);//根据JSONArray生成JSONObject
                    int athlete_id=resultObj.getInt("athlete_id");
                    String athlete_name=resultObj.getString("athlete_name");
                    String athlete_sex=resultObj.getString("athlete_sex");
                    String age=resultObj.getString("athlete_age");
                    Date athlete_age = Date.valueOf(age);//转换成java.sql.Date
                    //System.out.println(athlete_age);
                    int coach_id=resultObj.getInt("coach_id");
                    int event_id=resultObj.getInt("event_id");
                    System.out.println(athlete_name);
                    String service_status=resultObj.getString("service_status");
                    String experience=resultObj.getString("experience");
                    athleteaction.athleteAdd(athlete_id,athlete_name,athlete_sex,athlete_age,coach_id,event_id,service_status,experience);//对数据库进行操作，具体代码未附
                }
                String result = "数据上传成功！";
                out.println("<response>");
                out.println("<result>" + result + "</result>");
                out.println("</response>");
                out.close();
            } else{
                                                                                                                                                                                     
                String result = "传输过程出错，请重传！";
                out.println("<response>");
                out.println("<result>" + result + "</result>");
                out.println("</response>");
                out.close();
            }
        } catch (Exception e) {
            System.out
                    .println("JsonServlet doPost(HttpServletRequest request, HttpServletResponse response) 报错："
                            + e.getMessage());
        }
    }
    public void init() throws ServletException {
    }
                                                                                                                                                                         
                                                                                                                                                                         
}