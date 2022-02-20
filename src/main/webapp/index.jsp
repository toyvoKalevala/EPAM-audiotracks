<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>

<html>
<head>
    <link rel="stylesheet" href="static/styles/style.css"/>
</head>
    <body>

        <header class="header">

        <div class="logo">
          <a href="index.jsp"><img src="static/images/logo.jpg"></a>
        </div>

        <div class="dropdown">
          <a class="dropbtn"><img src="static/images/eng.jpg"></a>
          <div class="dropdown-content">
            <a href="test.html"><img src="static/images/eng.jpg"></a>
            <a href="test.html"><img src="static/images/rus.jpg"></a>
            <a href="test.html"><img src="static/images/by.jpg"></a>
          </div>
        </div>

        </header>

        <div class="container">
            <form method="post" action="controller?command=login">
                <%--@declare id="login"--%><%--@declare id="password"--%>
                <label class="login-row" for="login">LOGIN</label>
                <input class="login-row" type="text" name="login"/>
                <label class="login-row" for="password">PASSWORD</label>
                <input class="login-row" type="password" name="password"/>
                <input class="login-row-btn" type="submit" value="LET'S ROCK!!!"/>
                <label style="color:red";>${errorMessage}</label>
            </form>
        </div>

        <footer class="footer">

            <div class="about">
                <a href="index.jsp">+375 29 000 00 00</a>
            </div>

        </footer>

    </body>

</html>
