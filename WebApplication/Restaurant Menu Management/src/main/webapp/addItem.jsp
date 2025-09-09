<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Menu Item</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<header>
    <h1>Add New Menu Item</h1>
</header>
<nav>
    <a href="index.jsp">Home</a>
    <a href="viewMenu.jsp">View Menu</a>
</nav>
<div class="container">
    <form action="saveItem.jsp" method="post">
        <label>Item Name:</label><br>
        <input type="text" name="item_name" required><br><br>

        <label>Category:</label><br>
        <input type="text" name="category" required><br><br>

        <label>Price:</label><br>
        <input type="number" step="0.01" name="price" required><br><br>

        <button type="submit">Add Item</button>
    </form>
</div>
</body>
</html>
