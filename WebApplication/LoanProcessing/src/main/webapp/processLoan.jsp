<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="errorPage.jsp" %>
<%@ include file="header.jsp" %>

<jsp:useBean id="loan" class="com.bank.LoanBean" scope="session"/>
<jsp:setProperty property="customerName" name="loan" param="name"/>
<jsp:setProperty property="loanAmount" name="loan" param="amount"/>
<jsp:setProperty property="tenure" name="loan" param="tenure"/>

<%! 
    double interestRate = 8.5; 
    double calculateEMI(double amount, double rate, int tenureMonths) {
        double monthlyRate = rate / (12 * 100);
        return (amount * monthlyRate * Math.pow(1 + monthlyRate, tenureMonths)) /
               (Math.pow(1 + monthlyRate, tenureMonths) - 1);
    }
%>

<%
    int tenureInMonths = loan.getTenure();
    double emi = calculateEMI(loan.getLoanAmount(), interestRate, tenureInMonths);
    loan.setEmi(emi);
%>

<jsp:forward page="loanSummary.jsp" />

<%@ include file="footer.jsp" %>
