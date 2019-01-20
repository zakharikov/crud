<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Search results</title>
</head>
<body>
<div align="center">
    <h1>Результаты поиска</h1>
    <c:if test="${listPart.size() > 0}">
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
    </c:if>
    <c:if test="${listPart.size() == 0}">
        <h2>Ничего не найдено</h2>
    </c:if>
    <c:if test="${listPart == null}">
        <h2>Ничего не найдено</h2>
    </c:if>
</div>
<div>
    <h3>Фильтры</h3>
    <h5>
        <a href="/crud_war_exploded/">Все детали</a>
        <a href="needed">Обязательные детали</a>
        <a href="unneeded">Необязательные детали</a>
    </h5>
</div>

</body>
</html>