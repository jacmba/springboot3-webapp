<!doctype html>
<html>
    <head>
        <title>Login page</title>
    </head>
    <body>
    <h2>Welcome ${name} to the login page!</h2>
    <div>
        <font color="red">${error}</font>
    </div>
    <form method="post">
        Name: <input type="text" name="name"/><br/>
        Password: <input type="password" name="password"/><br/>
        <input type="submit"/>
    </form>
    </body>
</html>