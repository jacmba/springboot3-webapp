<!doctype html>
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
            <pre>${error}</pre>
            <form method="post">
                Name: <input type="text" name="name"/>
                Password: <input type="password" name="password"/>
                <input type="submit"/>
            </form>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"

             integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"

             crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    </body>
</html>