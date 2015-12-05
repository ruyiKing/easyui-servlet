<%@ page language="java" import="java.util.Date,com.badminton.utils.JsonDateValueProcessor,java.text.SimpleDateFormat,java.util.List,net.sf.json.JSONArray,net.sf.json.JSONObject,net.sf.json.JsonConfig,java.util.ArrayList,com.badminton.entity.Athlete,net.sf.json.JSONObject" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My first json page</title>
<%
    SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
    Athlete athlete1 = new Athlete();
    athlete1.setAthlete_id(1003);
    athlete1.setAthlete_name("林丹");
    athlete1.setAthlete_sex("男");
    Date athlete_age1 = format1.parse("1983-10-14");//是java.util.date
    athlete1.setAthlete_age(athlete_age1);
    athlete1.setCoach_id(101);
    athlete1.setEvent_id(1);
    athlete1.setService_status("1");
    athlete1.setExperience("2013年第12届全运会男单冠军。");
    Athlete athlete2 = new Athlete();//记录2
    athlete2.setAthlete_id(1004);
    athlete2.setAthlete_name("鲍春来");
    athlete2.setAthlete_sex("男");
    Date athlete_age2 = format1.parse("1988-10-14");
    athlete2.setAthlete_age(athlete_age2);
    athlete2.setCoach_id(101);
    athlete2.setEvent_id(1);
    athlete2.setService_status("1");
    athlete2.setExperience("2011年亚洲羽毛球锦标赛亚军。");
                                                                                                                                                               
    List<Athlete> list1 = new ArrayList<Athlete>();
    list1.add(athlete1);
    list1.add(athlete2);
    JsonConfig jsonConfig = new JsonConfig();//解决date类型的传输问题
    jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor());
    JSONArray jsonarray = JSONArray.fromObject(list1, jsonConfig);
%>
<script type="text/javascript" src="js/json2.js"></script>
<script type="text/javascript">
    var xmlHttp;
    function createXmlHttpRequest() {
        if (window.ActiveXObject) {
            xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
        } else if (window.XMLHttpRequest) {
            xmlHttp = new XMLHttpRequest();
        }
    }
    //回调
    function handleStateChange() {
        if (xmlHttp.readyState == 4) {
            if (xmlHttp.status == 200) {
                parseResults();
            }
        }
    }
    //将后台返回的数据显示在层serverResponse中
    function parseResults() {
        var result=xmlHttp.responseXML.getElementsByTagName("result")[0].firstChild.data;
        alert(result);
    }
    function doJSON() {
        var athletehead={athlete_id:1,tablename:"athlete"};
        var myobj=eval(athletehead);
        var str1=JSON.stringify(myobj);//str1以后可用来识别数据库中的表
        var str2='<%=jsonarray%>';
        var url = "servlet/JsonServlet";
        createXmlHttpRequest();
        xmlHttp.open("POST", url, true);
        xmlHttp.onreadystatechange = handleStateChange;//回调
        xmlHttp.setRequestHeader("Content-Type",
                "application/x-www-form-urlencoded;text/xml;charset=utf-8"); //text/xml;charset=utf-8：解决汉字封装json问题
        xmlHttp.send("athletehead="+str1+"&athlete="+str2);//传送了两个对象
    }
</script>
</head>
<body>
<form id="form1">
<table>
 <tr>
   <td align="center"><input type="button" name="submit" value="提交" onClick="doJSON()"></td>
 </tr>
</table>
</form>
</body>
</html>