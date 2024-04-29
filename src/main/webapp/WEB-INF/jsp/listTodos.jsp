
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
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

<%@include file="common/footer.jspf"%>