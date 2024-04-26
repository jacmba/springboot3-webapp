<!doctype html>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"

             rel="stylesheet"

             integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"

             crossorigin="anonymous">

        <title>Login page</title>
    </head>
    <body>
        <div class="container">
            <h2>Welcome ${name} to the login page!</h2>
            <pre class="text-warning">${error}</pre>
            <form:form method="post" modelAttribute="loginData">
                Name: <form:input type="text" name="name" placeholder="Your user name"
                    required="required" path="user"/>
                <form:errors path="user" cssClass="text-warning" />
                Password: <input type="password" name="password"
                    placeholder="Your password here" required="required"
                    path="password"/>
                <form:errors path="password" cssClass="text-warning" />
                <input type="submit" class="btn btn-success"/>
            </form:form>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"

             integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"

             crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    </body>
</html>