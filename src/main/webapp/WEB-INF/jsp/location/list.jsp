<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>


<h1>This is my Location placeholder Header</h1>

<table class="table">
    <tr scope="row">
        <th>Id</th>
        <th>Location Name</th>
        <th>Size</th>
    </tr>
    <c:forEach items="${locations}" var="location">
        <tr scope="row">
            <td>${location.id}</td>
            <td>${location.locationName}</td>
            <td>${location.cds.size()}</td>
        </tr>
    </c:forEach>
</table>
<br>

Test locations Size = ${locations.size()} <br>
Locations = ${locations}

