<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"

             rel="stylesheet"

             integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"

             crossorigin="anonymous">

        <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.10.0/css/bootstrap-datepicker.css" rel="stylesheet" >

        <title>ToDo details</title>
    </head>
    <body>
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
                <input type="submit" class="btn btn-success"/>
            </form:form>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"

             integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"

             crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.js"></script>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.10.0/js/bootstrap-datepicker.min.js"></script>

        <script type="text/javascript">
        $('#targetDate').datepicker({
            format: 'mm/dd/yyyy'
        });
        </script>
    </body>
</html>