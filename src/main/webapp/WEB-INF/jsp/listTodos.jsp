<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"

             rel="stylesheet"

             integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"

             crossorigin="anonymous">

        <title>ToDo list page</title>
    </head>
    <body>
        <div class="container">
            <h2>List of ToDos for ${name}</h2>
            <table class="table">
                <thead><tr>
                    <th>ID</th>
                    <th>Description</th>
                    <th>Target Date</th>
                    <th>Is Done?</th>
                    <td></td>
                    <td></td>
                </tr></thead>
                <tbody>
                    <c:forEach items="${todos}" var="todo">
                        <tr>
                            <td>${todo.id}</td>
                            <td>${todo.description}</td>
                            <td>${todo.targetDate}</td>
                            <td>${todo.done}</td>
                            <td>
                                <a href="/todos/delete/${todo.id}"
                                    class="btn btn-warning">
                                    DELETE
                                </a>
                            </td>
                            <td>
                                <a href="/todos/update/${todo.id}"
                                    class="btn btn-info">
                                    UPDATE
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a href="todos/add" class="btn btn-success">Add ToDo</a>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"

             integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"

             crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    </body>
</html>