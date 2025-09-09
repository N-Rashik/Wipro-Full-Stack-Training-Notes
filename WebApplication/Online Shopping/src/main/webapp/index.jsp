<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online Shopping Form</title>
<style>
    body {
        background-color: cyan;
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
    }
    .container {
        text-align: center;
        margin-top: 100px;
    }
    h1 {
        margin-bottom: 30px;
        color: darkblue;
    }
    select {
        padding: 8px;
        font-size: 14px;
        margin-right: 10px;
    }
    input[type="submit"] {
        padding: 8px 16px;
        font-size: 14px;
        background-color: darkblue;
        color: white;
        border: none;
        cursor: pointer;
    }
    input[type="submit"]:hover {
        background-color: navy;
    }
    a {
        display: inline-block;
        margin-top: 20px;
        font-size: 16px;
        color: darkblue;
        text-decoration: none;
        border: 1px solid darkblue;
        padding: 6px 12px;
        border-radius: 4px;
    }
    a:hover {
        background-color: darkblue;
        color: white;
    }
</style>
</head>
<body>
    <div class="container">
        <h1>Online Shopping!</h1>
        <form action="AddToCartServlet" method="post">
            <select name="product">
                <option value="Laptop">Laptop</option>
                <option value="Mobile">Mobile</option>
                <option value="Speaker">Speaker</option>
                <option value="Headphone">Headphone</option>
            </select>
            <input type="submit" value="Add to Cart">
        </form>
        <br>
        <a href="ViewCartServlet">View Cart</a>
    </div>
</body>
</html>
