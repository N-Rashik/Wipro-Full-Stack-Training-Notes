<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String username = request.getParameter("username");
    session.setAttribute("user", username);
    String password = request.getParameter("password");
%>
<%@ include file="header.jsp" %>

<h3>Welcome, <%= session.getAttribute("user") %></h3>
<form action="processLoan.jsp" method="post">
    <label>Name:</label>
    <input type="text" name="name" required>
    
    <label>Loan Amount:</label>
    <input type="number" name="amount" required>
    
    <label>Tenure (in months):</label>
    <input type="number" name="tenure" required>
    
    <input type="submit" value="Apply Loan">
</form>

<%@ include file="footer.jsp" %>
