<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Main Login</title>
    <link href="../../../pub/css/login.css" rel="stylesheet">
<%--    <link href="<c:url value="/pub/css/login.css" />" rel="stylesheet"> --%>
</head>

<body class="body">
<!-- Put a container to hold everything as I prefer not to style the body if possible -->
<div class=myContainer>
    <!-- My form class  -->
    <form class="form login-form" action="/login/loginSubmit" method="post">
        <!-- div for the CD image -->
        <div id="layover">
            <div id="myDiv"></div>
            <h4>User Login</h4>
        </div>
        <!-- pretty standard username/password fields , use the placeholder to tell the user inside the boxes -->
        <div class="form-group">
            <label for="userName">User name&nbsp&nbsp</label>
            <input class="form-input" type="text" id="userName" placeholder="username" name="userName">
        </div>
        <div class="form-group">
            <label for="password">Password&nbsp&nbsp&nbsp</label>
            <input class="form-input" type="password" id="password" placeholder="don't forget this" name="password">
        </div>
        <!-- login button tied to onSubmit functions -->
        <button id="myLoginButton" type="submit" value="Submit">
          LOGIN
        </button>

        <div class="registerLogin">
            <a href="../user/register" target="_blank" rel="noopener noreferrer">Register New User</a>

            <p>Forgot your Login?</p>
        </div>
    </form>

</div>
</body>
<script>
    // this doesn't work but left as an academic exercise since neither Eric or Raheem could get this to work
    // And we are going to need form action on submit anyway soon
    function setLocation() {
        window.location.href = "./menu/menu";
    }

    let loginButtonele = document.querySelector('#myLoginButton');
    loginButtonele.addEventListener("click", setLocation);
</script>

</html>