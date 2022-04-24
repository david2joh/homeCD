<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<h3>Search for User</h3>
<%--    <form action="/user/search" method="get">--%>
<%--        <input type="text" id="searchUserName" name="searchUserName" value="${searchUserName}"--%>
<%--         placeholder="Enter User Name">--%>
<%--    <br><br><button id = "searchBtn" type="submit">Search</button>--%>
<%--    </form>--%>

<form action="/user/search" method="get">
    <div class="row">
        <div class="col-md-4 mb-2">
            <div class="form-outline">
                <input type="text" id="searchUserName" name="searchUserName" value="${searchUserName}"
                       class="form-control form-control-sm" required placeholder="Find User by Name"/>
                <label class="form-label" for="searchUserName">Find User by User Name</label>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-3 mt-2 pt-2 mb-2">
            <input class="btn btn-outline-primary btn-md" type="submit"/>
        </div>
        <%--        <div class="col-md-3 mt-2 pt-2"> --%>
        <%--       </div>  --%>

        <div class="col-md-6 mt-2 pt-2" id="message">Welcome to User Search - Lost and NOT Found</div>
    </div>
    <%--    <button type="submit">Submit</button>--%>
</form>
<c:if test="${not empty users}">
    <h6> Search Results Found ${users.size()} Users</h6>

    <br><br>
    <h3> Users</h3>

    <table class="table">
        <tr scope="row">
            <th>Username</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th></th>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr scope="row">
                <td>${user.userName}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>
                    <form action="/user/edit/${user.id}" id="editUserForm">
                        <input type="hidden" name="userName" id="userName"
                               value=${user.userName}>
                        <input class="btn btn-outline-primary btn-md" type="submit"
                               value="Edit User"/>
                    </form>
                </td>

            </tr>
        </c:forEach>
    </table>
</c:if>
<br>
<jsp:include page="../include/footer.jsp"/>
