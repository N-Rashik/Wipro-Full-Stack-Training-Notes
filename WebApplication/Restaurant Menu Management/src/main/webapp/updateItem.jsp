<%@ page import="java.util.*, com.example.jsp.MenuItem" %>
<%
    int index = Integer.parseInt(request.getParameter("index"));
    String name = request.getParameter("item_name");
    String category = request.getParameter("category");
    double price = Double.parseDouble(request.getParameter("price"));

    List<MenuItem> menu = (List<MenuItem>) session.getAttribute("menu");
    if (menu != null && index >= 0 && index < menu.size()) {
        MenuItem item = menu.get(index);
        item.setItemName(name);
        item.setCategory(category);
        item.setPrice(price);
    }

    response.sendRedirect("viewMenu.jsp");
%>
