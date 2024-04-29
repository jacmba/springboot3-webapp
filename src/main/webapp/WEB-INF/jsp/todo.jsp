<%@include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf" %>
<div class="container">
<h2>Enter ToDo details</h2>

<form:form method="post" modelAttribute="todo">

    <fieldset class="mb-3">
        <form:label path="description">Description</form:label>
        <form:input type="text" name="description"
            placeholder="Enter the description of your ToDo here"
            required="required"
            path="description"/>
        <form:errors path="description" cssClass="text-warning" />
    </fieldset>

    <fieldset class="mb-3">
        <form:label path="targetDate">Target Date</form:label>
        <form:input type="text" name="targetDate"
            placeholder="Enter the description of your ToDo here"
            required="required"
            path="targetDate"/>
        <form:errors path="targetDate" cssClass="text-warning" />
    </fieldset>

    <form:input type="hidden" path="id" />
    <form:input type="hidden" path="done" />
    <form:input type="hidden" path="targetDate" />
    <form:input type="hidden" path="username" />
    <input type="submit" class="btn btn-success"/>
</form:form>
</div>

<%@ include file="common/footer.jspf"%>