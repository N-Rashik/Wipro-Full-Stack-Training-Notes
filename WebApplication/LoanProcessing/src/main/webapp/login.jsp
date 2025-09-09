<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"></jsp:include>

<h2>Login</h2>
<form action="loanForm.jsp">
    <label>Username:</label>
    <input type="text" name="username" required>
    
    <label>Password:</label>
    <input type="password" name="password" required>
    
    <input type="submit" value="Login">
</form>

<jsp:include page="footer.jsp"></jsp:include>
