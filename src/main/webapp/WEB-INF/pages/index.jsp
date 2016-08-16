<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <meta charset="utf-8">
    <title>JavaRush TestTask</title>

    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="http://getbootstrap.com/dist/css/bootstrap-responsive.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1>Tasks</h1>
    <form:form method="post" action="add" commandName="task" role="form">
        <div class="form-group">
            <form:label path="taskName">Name:</form:label>
            <form:input path="taskName" class="form-control" placeholder="Name"/>
        </div>
        <button type="submit" class="btn btn-success">Add Task</button>
    </form:form>

    <c:if test="${!empty tasks}">
        <h3>Tasks</h3>
        <table class="table table-bordered table-striped">
            <thead>
            <tr>
                <th>Done</th>
                <th>Name</th>
                <th>&nbsp;</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${tasks}" var="task">
                <tr>
                    <td>${task.done}</td>
                    <td>${task.taskName}</td>
                    <td>
                        <form:form action="edit/${task.id}" method="post"><input type="submit"
                                                                                   class="btn btn-info btn-mini"
                                                                                   value="Edit"/>
                        </form:form>
                        <form:form action="delete/${task.id}" method="post"><input type="submit"
                                                                                   class="btn btn-danger btn-mini"
                                                                                   value="Delete"/>
                        </form:form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
</body>
</html>
