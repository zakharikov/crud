<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Unneeded</title>
</head>
<body>
<div align="center">
    <h1>Список необязательных комплектующих</h1>
    <h5>
        <a href="newPart">Добавить/Изменить позицию</a>
    </h5>
    <h3>Поиск</h3>
    <form:form action="searchResults" method="post">
        <div class="form-group">
            <label for="name">Введите название детали:</label>
            <input type="text" class="form-control" id="name" name="partname">
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Поиск"></td>
            </tr>
        </div>
    </form:form>
    <h3>Фильтры</h3>
    <h5>
        <a href="/crud_war_exploded/">Все детали</a>
        <a href="needed">Обязательные детали</a>
    </h5>
    <table border="1">

        <th>Наименование</th>
        <th>Необходимость</th>
        <th>Колличество</th>
        <th>Действия</th>

        <c:forEach var="part" items="${listPart}">
            <tr>
                <td>${part.partName}</td>
                <td align="center">${part.mandatory ? 'Да' : 'Нет'}</td>
                <td align="center">${part.quantity}</td>
                <td><a href="editPart?id=${part.id}">Изменить</a>
                    <a href="deletePart?id=${part.id}">Удалить</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
<div align="center" class="panel-footer" id="pagination">
    <c:url value="/unneeded" var="prev">
        <c:param name="page" value="${page-1}"/>
    </c:url>
    <c:if test="${page > 1}">
        <a href="<c:out value="${prev}" />" class="pn prev">Prev</a>
    </c:if>

    <c:forEach begin="1" end="${maxPages}" step="1" varStatus="i">
        <c:choose>
            <c:when test="${page == i.index}">
                <span>${i.index}</span>
            </c:when>
            <c:otherwise>
                <c:url value="/unneeded" var="url">
                    <c:param name="page" value="${i.index}"/>
                </c:url>
                <a href='<c:out value="${url}" />'>${i.index}</a>
            </c:otherwise>
        </c:choose>
    </c:forEach>
    <c:url value="/unneeded" var="next">
        <c:param name="page" value="${page + 1}"/>
    </c:url>
    <c:if test="${page + 1 <= maxPages}">
        <a href='<c:out value="${next}" />' class="pn next">Next</a>
    </c:if>
</div>

<div align="center">
    <h2>Можно собрать <td><c:out value="${count}"/></td> компьютеров</h2>
</div>
</body>
</html>