<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>	
<head>
	<meta charset="UTF-8">
	<title>Load Form Data - jQuery EasyUI Demo</title>
	<%@include file="/jsp/public.jsp" %>

	<script type="text/javascript">
		function submitForm(){
			$('#loginServlet').submit();
		}
	</script>
</head>
<body>
	<%--<h2>Custom TextBox</h2>
	<p>This example shows how to custom a login form.</p>
	<div style="margin:20px 0;"></div>
	<div class="easyui-panel" title="Login to system" style="width:400px;padding:30px 70px 20px 70px">
		<div style="margin-bottom:10px">
			<input class="easyui-textbox" style="width:100%;height:40px;padding:12px" data-options="prompt:'Username',iconCls:'icon-man',iconWidth:38">
		</div>
		<div style="margin-bottom:20px">
			<input class="easyui-textbox" type="password" style="width:100%;height:40px;padding:12px" data-options="prompt:'Password',iconCls:'icon-lock',iconWidth:38">
		</div>
		<div style="margin-bottom:20px">
			<input type="checkbox" checked="checked">
			<span>Remember me</span>
		</div>
		<div>
			<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" style="padding:5px 0px;width:100%;">
				<span style="font-size:14px;">Login</span>
			</a>
		</div>
	</div>--%>
	<h2>登录系统</h2>
	<p>输入用户名密码登录系统</p>
	<div style="margin:20px 0;"></div>
	<div class="easyui-panel" title="登录系统" style="width:400px;padding:30px 70px 20px 70px">
		<div style="padding:10px 60px 20px 60px">
			<form action="/LoginServlet" id="loginServlet" method="post">
				<table cellpadding="5">
					<div style="margin-bottom:10px">
						<input class="easyui-textbox" style="width:100%;height:40px;padding:12px" data-options="prompt:'Username',iconCls:'icon-man',iconWidth:38" name="login_no" id="login_no">
					</div>
					<div style="margin-bottom:20px">
						<input class="easyui-textbox" type="password" style="width:100%;height:40px;padding:12px" data-options="prompt:'Password',iconCls:'icon-lock',iconWidth:38" name="password" id="password">
					</div>
					<div style="margin-bottom:20px">
						<input type="checkbox" checked="checked">
						<span>Remember me</span>
					</div>
					<div>
						<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" style="padding:5px 0px;width:100%;" onclick="submitForm()">
							<span style="font-size:14px;">Login</span>
						</a>
					</div>
				</table>
			</form>
			<%--<div style="text-align:center;padding:5px">
				<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">Submit</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">Clear</a>
			</div>--%>
		</div>
	</div>
</body>
</html>