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

    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="http://getbootstrap.com/dist/css/bootstrap-responsive.min.css" rel="stylesheet">

    <style>
        .container {
            width: 60%;
            margin-left: 5%;
            margin-right: 5%;
            margin-top: 2%;
            height: 95%;
        }

    </style>
</head>
<body>
<div class="container">
    <a href="/fill">Fill data</a> <br>

    <c:if test="${task.id==0}">
        <h2>Add Task</h2>
    </c:if>
    <c:if test="${!(task.id==0)}">
        <h2>Edit Task</h2>
    </c:if>
    <c:url var="addAction" value="/add"/>
    <form:form action="${addAction}" commandName="task">
        <form:hidden path="id"/>
        <form:label path="done">
            <spring:message text="Done:"/>
        </form:label>
        <form:checkbox path="done"/>
        <br>
        <form:label path="taskName">Name:</form:label>
        <form:input path="taskName" class="form-control" placeholder="Name"/>

        <c:if test="${task.id==0}">
            <button type="submit" class="btn btn-success" size="Small">Add Task</button>
        </c:if>
        <c:if test="${!(task.id==0)}">
            <button type="submit" class="btn btn-warning" size="Small">Edit Task</button>
        </c:if>
    </form:form>

    <h2>Tasks</h2>

    <div class="dropdown">
        <button class="btn btn-primary dropdown-toggle" type="button" id="filter" data-toggle="dropdown">Filter
            <span class="caret"/></button>
        <ul class="dropdown-menu" role="menu" aria-labelledby="filter">
            <li role="presentation"><a role="menuitem" href="/">All</a></li>
            <li role="presentation" class="divider"></li>
            <li role="presentation"><a role="menuitem" href="/filter/done">Done</a></li>
            <li role="presentation"><a role="menuitem" href="/filter/undone">Undone</a></li>
        </ul>
    </div>

    <c:if test="${!empty tasks}">

        <table class="table table-bordered table-striped table-hover header-fixed">
            <thead>
            <tr>
                <th width="40px">Done</th>
                <th>Name</th>
                <th width="120px">&nbsp;</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${tasks}" var="task">
                <tr>
                    <td width="40px">${task.done}</td>
                    <td>${task.taskName}</td>
                    <td width="120px">
                        <table>
                            <tr>
                                <td><form:form action="edit/${task.id}" method="post"><input type="submit" size="XSmall"
                                                                                             class="btn btn-info btn-mini"
                                                                                             value="Edit..."/>
                                </form:form></td>
                                <td><form:form action="remove/${task.id}" method="post"><input type="submit"
                                                                                               size="XSmall"
                                                                                               class="btn btn-danger btn-mini"
                                                                                               value="Delete"/>
                                </form:form></td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>

</div>
</body>
</html>
