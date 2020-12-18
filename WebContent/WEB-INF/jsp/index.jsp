<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>目录页</title>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="<%= application.getContextPath()%>/js/JQuery3.5.1.js"></script>
<!-- Bootstrap -->
<!-- 获得项目路径 http://localhost:8080/项目名/ 
    	 application 最大的域 
    	 servletContext Servlet 在jsp中就是application 项目上下文
    	 获得项目访问的路径
    -->
<link href="<%= application.getContextPath()%>/css/bootstrap.min.css "
	rel="stylesheet">
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="<%= application.getContextPath()%>/js/bootstrap.min.js"></script>
<!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
<!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
<!--[if lt IE 9]>
      <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
      <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <![endif]-->
</head>
<style>
form {
	margin: 100px auto;
	padding-top: 40px;
	padding-right: 50px;
	border-radius: 5px;
	width: 600px;
}
</style>
<body>
	<div class="container">
	<div class="row" style="margin:100px auto 20px;">
	<h3 style="text-align: center;">图书馆后台管理设置</h3>
	</div>
		<div class="row">
			<a type="button" class="btn btn-primary btn-lg btn-block" href="<%=application.getContextPath()%>/AllBookListServlet">1.图书列表</a>
			<a type="button" class="btn btn-primary btn-lg btn-block">2.查找图书</a>
			<a type="button" class="btn btn-primary btn-lg btn-block">3.添加图书</a>
			<a type="button" class="btn btn-primary btn-lg btn-block">4.退出主菜单</a>
		</div>
	</div>

	<!-- 域对象获取错误 隐藏域存一下 el表达式 请求参数 el也可以获取请求参数 -->
	<input type="hidden" value="${error}" id="error">
	<script type="text/javascript">
		/* jq的代码 获得隐藏值 jq是浏览器的脚本[只能获取浏览器上显示的东西] 怎么能获得服务器的东西 */
		var error = $("#error").val();
		if (error != null && error != "") {
			alert(error);
		}
	</script>
	<!-- jsp和servlet是服务器代码
	     js jq是浏览器脚本，只能操作浏览器的页面(jsp发给到浏览器上，才能操作)
	-->
</body>
</html>