
<%@ include file="common/header.jspf" %>

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

<%@ include file="common/footer.jspf" %>