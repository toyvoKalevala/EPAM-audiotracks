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
          <a class="dropbtn">Language</a>
          <div class="dropdown-content">
            <a href="test.html">eng</a>
            <a href="test.html">rus</a>
            <a href="test.html">by</a>
          </div>
        </div>

        </header>

        <div class="container">
            <form method="post" action="controller?command=login">
                <label class="login-row" for="login">LOGIN</label>
                <input class="login-row" type="text" name="login"/>
                <label class="login-row" for="password">PASSWORD</label>
                <input class="login-row" type="password" name="password"/>
                <input class="login-row-btn" type="submit" value="LET'S ROCK!"/>
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
