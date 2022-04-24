<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../../../pub/html/header.html" %>
<%--<jsp:include page="../include/header.jsp" />--%>
<jsp:include page="../include/navbar.jsp"/>
<link rel="stylesheet" href="../css/general.css">

<section class="gradient-custom vh-200">
    <div class="container py-5 vh-100">
        <!-- Use the bootstrap semantics  each field is assigned a row, each row centered ,
    max two items per row so each item in a row set to col-6 or col-12 -->
        <div class="row justify-content-center align-items-center h-90">
            <div class="col-12 col-lg-9 col-xl-7">
                <!-- set a nice border shadow and round the edges of the card -->
                <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
                    <!-- Set a nice image at the top -->
                    <img src="../pub/img/lighthouse.jpg" class="w-100 card-img-top" alt="User Search"
                         style="border-radius: 15px 15px 0px 0px;">
                    <div class="card-body p-4 p-md-5">
                        <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">USER SEARCH</h3>
                        <form action="/user/search" method="get">
                            <div class="row">
                                <div class="col-md-4 mb-2">
                                    <div class="form-outline">
                                        <input type="text" id="searchUserName" name="searchUserName"
                                               value="${searchUserName}" class="form-control form-control-sm" required
                                               placeholder="Find User by Name"/>
                                        <label class="form-label" for="searchUserName">Find User by User
                                            Name</label>
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-3 mt-2 pt-2 mb-2">
                                    <input class="btn btn-outline-primary btn-md" type="submit"/>
                                </div>
                                <%-- <div class="col-md-3 mt-2 pt-2"> --%>
                                <%-- </div> --%>

                                <div class="col-md-6 mt-2 pt-2" id="message">Welcome to User Search - Lost
                                    and NOT Found
                                </div>
                            </div>
                            <%-- <button type="submit">Submit</button>--%>
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
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp"/>