<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online Shopping</title>
<style>
    body {
        background: linear-gradient(to right, #a8edea, #fed6e3);
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
    }
    .container {
        max-width: 500px;
        background: white;
        margin: 60px auto;
        padding: 30px;
        border-radius: 12px;
        box-shadow: 0 4px 15px rgba(0,0,0,0.2);
        text-align: center;
    }
    h1 {
        color: #2c3e50;
        margin-bottom: 10px;
    }
    .store-name {
        color: #e67e22;
        font-weight: bold;
        font-size: 18px;
        margin-bottom: 20px;
    }
    .greet {
        color: #27ae60;
        font-size: 16px;
        margin-bottom: 25px;
    }
    select {
        padding: 10px;
        font-size: 14px;
        border: 1px solid #ccc;
        border-radius: 6px;
        margin-bottom: 15px;
        width: 80%;
    }
    input[type="submit"] {
        padding: 10px 20px;
        background-color: #2980b9;
        border: none;
        color: white;
        font-size: 14px;
        border-radius: 6px;
        cursor: pointer;
        transition: 0.3s;
    }
    input[type="submit"]:hover {
        background-color: #1c5980;
    }
    a {
        display: inline-block;
        margin-top: 20px;
        font-size: 14px;
        background: #27ae60;
        color: white;
        padding: 8px 15px;
        border-radius: 6px;
        text-decoration: none;
        transition: 0.3s;
    }
    a:hover {
        background: #1e7c47;
    }
</style>
</head>
<body>

<div class="container">
    <h1>Online Shopping!</h1>
    <p class="store-name">${storename}</p>

    <% 
        Cookie[] cookies = request.getCookies();
        String uname = null;
        if(cookies != null) {
            for(Cookie co : cookies) {
                if("username".equals(co.getName()))
                    uname = co.getValue();
            }
        }
    %>

    <p>Hi! <strong><%= uname %></strong></p>
    <p class="greet">${greet}</p>

    <form action="AddToCartServlet" method="post">
        <select name="product">
            <option value="Laptop">Laptop</option>
            <option value="Mobile">Mobile</option>
            <option value="Speaker">Speaker</option>
            <option value="Headphone">Headphone</option>
        </select>
        <br><br>
        <input type="submit" value="Add to Cart">
    </form>

    <a href="ViewCartServlet">View Cart</a>
</div>

</body>
</html>
