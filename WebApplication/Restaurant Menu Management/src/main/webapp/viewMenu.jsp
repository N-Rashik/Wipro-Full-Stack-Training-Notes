<%@ page import="java.util.*, com.example.jsp.MenuItem" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Menu</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<header>
    <h1>Restaurant Menu</h1>
</header>
<nav>
    <a href="index.jsp">Home</a>
    <a href="addItem.jsp">Add Item</a>
</nav>
<div class="container">
    <h2>Menu Items</h2>
    <table>
        <tr>
            <th>Index</th>
            <th>Item Name</th>
            <th>Category</th>
            <th>Price</th>
            <th>Actions</th>
        </tr>
        <%
            List<MenuItem> menu = (List<MenuItem>) session.getAttribute("menu");
            if (menu != null && !menu.isEmpty()) {
                for (int i = 0; i < menu.size(); i++) {
                    MenuItem item = menu.get(i);
        %>
        <tr>
            <td><%= i %></td>
            <td><%= item.getItemName() %></td>
            <td><%= item.getCategory() %></td>
            <td><%= item.getPrice() %></td>
            <td>
                <a href="editItem.jsp?index=<%=i%>">Edit</a> | 
                <a href="deleteItem.jsp?index=<%=i%>">Delete</a>
            </td>
        </tr>
        <%
                }
            } else {
        %>
        <tr><td colspan="5">No items available.</td></tr>
        <% } %>
    </table>
</div>
</body>
</html>
