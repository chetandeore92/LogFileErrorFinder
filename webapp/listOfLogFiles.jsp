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
<c:forEach  items="${bean.list}" var="tempFile">
<h2><a href="errorsummury?name=${tempFile.getAbsolutePath()}">${tempFile.getName().toUpperCase()}</a></h2>
</c:forEach>

<a href="index.jsp">Back</a>
</body>
</html>