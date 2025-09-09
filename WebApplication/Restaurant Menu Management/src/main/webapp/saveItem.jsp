<%@ page import="java.util.*, com.example.jsp.MenuItem" %>
<%
    String name = request.getParameter("item_name");
    String category = request.getParameter("category");
    double price = Double.parseDouble(request.getParameter("price"));

    // Get menu list from session
    List<MenuItem> menu = (List<MenuItem>) session.getAttribute("menu");
    if (menu == null) {
        menu = new ArrayList<>();
    }

    menu.add(new MenuItem(name, category, price));
    session.setAttribute("menu", menu);

    response.sendRedirect("viewMenu.jsp");
%>
