<%@ page import="java.util.*, com.example.jsp.MenuItem" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Menu Item</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<header>
    <h1>Edit Menu Item</h1>
</header>
<nav>
    <a href="index.jsp">Home</a>
    <a href="addItem.jsp">Add Item</a>
    <a href="viewMenu.jsp">View Menu</a>
</nav>
<div class="container">
    <%
        int index = Integer.parseInt(request.getParameter("index"));
        List<MenuItem> menu = (List<MenuItem>) session.getAttribute("menu");
        MenuItem item = menu.get(index);
    %>
    <form action="updateItem.jsp" method="post">
        <input type="hidden" name="index" value="<%= index %>">

        <label>Item Name:</label><br>
        <input type="text" name="item_name" value="<%= item.getItemName() %>" required><br><br>

        <label>Category:</label><br>
        <input type="text" name="category" value="<%= item.getCategory() %>" required><br><br>

        <label>Price:</label><br>
        <input type="number" step="0.01" name="price" value="<%= item.getPrice() %>" required><br><br>

        <button type="submit">Update Item</button>
    </form>
</div>
</body>
</html>
