<%@ page import="java.util.*, com.example.jsp.MenuItem" %>
<%
    // Get menu list from session
    List<MenuItem> menu = (List<MenuItem>) session.getAttribute("menu");

    // If menu is null, initialize empty list (to avoid NullPointerException)
    if (menu == null) {
        menu = new ArrayList<>();
        session.setAttribute("menu", menu);
    }

    // Read the index parameter from the request
    String indexParam = request.getParameter("index");
    boolean itemNotFound = false;

    if (indexParam != null) {
        try {
            int index = Integer.parseInt(indexParam);

            // Check if the index is valid
            if (index >= 0 && index < menu.size()) {
                // Remove item at that index
                menu.remove(index);
            } else {
                itemNotFound = true;
            }
        } catch (NumberFormatException e) {
            itemNotFound = true;
        }
    } else {
        itemNotFound = true;
    }

    // Redirect to viewMenu.jsp with a message
    if (itemNotFound) {
        response.sendRedirect("viewMenu.jsp?msg=Item Not Found");
    } else {
        response.sendRedirect("viewMenu.jsp?msg=Item Deleted Successfully");
    }
%>
