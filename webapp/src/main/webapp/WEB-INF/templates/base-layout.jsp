<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">

   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <!-- CSS Styles -->
      <link rel="stylesheet" href="${contextPath}/resources/uikit/css/uikit.almost-flat.min.css">
      <link rel="stylesheet" href="${contextPath}/resources/uikit/css/components/autocomplete.css">
      <link rel="stylesheet" href="${contextPath}/resources/css/main.css">
      <!-- Page Title -->
      <title>
         <tiles:insertAttribute name="title"></tiles:insertAttribute>
      </title>
   </head>
   
   <body>
      <tiles:insertAttribute name="navbar"></tiles:insertAttribute>
      <div class="uk-container uk-container-center uk-height-viewport cd-main">
         <tiles:insertAttribute name="body"></tiles:insertAttribute>
      </div>
      <tiles:insertAttribute name="footer"></tiles:insertAttribute>
      <!-- JS Scripts -->
      <script src="${contextPath}/resources/js/jquery-1.12.0.js"></script>
      <script src="${contextPath}/resources/uikit/js/uikit.min.js"></script>
      <script src="${contextPath}/resources/uikit/js/components/autocomplete.js"></script>
   </body>
   
</html>