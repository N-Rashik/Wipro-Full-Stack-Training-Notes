<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<h2>Loan Summary</h2>
<div class="summary">
    <jsp:useBean id="loan" class="com.bank.LoanBean" scope="session" />
    <p><strong>Customer Name:</strong> <%= loan.getCustomerName() %></p>
    <p><strong>Loan Amount:</strong> ₹<%= loan.getLoanAmount() %></p>
    <p><strong>Tenure:</strong> <%= loan.getTenure() %> months</p>
    <p><strong>EMI:</strong> ₹<%= String.format("%.2f", loan.getEmi()) %></p>
</div>

<%@ include file="footer.jsp" %>
