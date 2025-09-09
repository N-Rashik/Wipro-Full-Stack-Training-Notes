<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<%@ include file="header.jsp" %>

<h3 class="error">Oops! An error occurred.</h3>
<p style="text-align:center;">Error Details: <%= exception.getMessage() %></p> 

<%@ include file="footer.jsp" %>
no sql