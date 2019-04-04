<%@page import="java.io.FilenameFilter"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page isELIgnored="false"  %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of log files</title>
</head>
<body>
<jsp:useBean id="bean" class="com.appd.bean.ListBean"/>
${bean.getListOfFiles()}

<c:if test="${bean.getLength() == 0}" >
<h4>No Log Files Here</h4>
</c:if>
<c:forEach  items="${bean.list}" var="tempFile">
<div style="height: 100px;width: 100%;background-color: gray;border-color: black;border-radius: 15px">
<h4 style="left: 10px;top: 10px;position: relative;">${bean.count}. ${tempFile.getName()}</h4>
<a style="left: 10px;top: 10px;position: relative;" href="errorsummury?name=${tempFile.getAbsolutePath()}">Get Error Summary</a>
&nbsp;&nbsp;&nbsp;
<a style="top: 10px;position: relative;" href="warningsummury?name=${tempFile.getAbsolutePath()}">Get Warning Summary</a>
${bean.setCount()}
</div>
</c:forEach>

<a href="index.jsp">Back</a>
</body>
</html>