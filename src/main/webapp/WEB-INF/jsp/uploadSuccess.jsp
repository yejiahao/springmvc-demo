<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>

<%@ include file="/header.jsp" %>
<body>
<div class="alert alert-info" role="alert">上传成功</div>
<div class="container">
  <img alt="图片在这" src="${filePath}" />
</div>
</body>
</html>