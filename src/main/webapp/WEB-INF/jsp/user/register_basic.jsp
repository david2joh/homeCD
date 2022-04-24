<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>


<c:if test="${empty form.id}">
    <h3>Register</h3>
</c:if>

<c:if test="${not empty form.id}">
    <h3> Edit User</h3>
</c:if>
<br>


<%-- <h3>Register Page</h3>--%>
<form action="/user/registerSubmit" method="get">

    <input type="hidden" name="id" value="${form.id}">


    <div class="row">
        <div class="col-md-4 mb-4">
            <div class="form-outline">
                <input type="text" id="userName" name="userName" value="${form.userName}"
                       class="form-control form-control-sm" required placeholder="userName"/>
                <label class="form-label" for="userName">userName</label>
                <c:forEach items='${bindingResult.getFieldErrors("userName")}' var="error">
                    <div style="color:red;">${error.getDefaultMessage()}</div>
                </c:forEach>
            </div>
        </div>
    </div>
    <%--    Username <input type="userName" name="userName" id="userNameId" value="${form.userName}">--%>
    <%--    <c:forEach items='${bindingResult.getFieldErrors("userName")}' var="error">--%>
    <%--        <div style="color:red;">${error.getDefaultMessage()}</div>--%>
    <%--    </c:forEach>--%>

    <div class="row">
        <div class="col-md-3 mb-4">
            <div class="form-outline">
                <input type="text" id="firstName" name="firstName" value="${form.firstName}"
                       class="form-control form-control-sm" required placeholder="First Name"/>
                <label class="form-label" for="firstName">First Name</label>
                <c:forEach items='${bindingResult.getFieldErrors("firstName")}' var="error">
                    <div style="color:red;">${error.getDefaultMessage()}</div>
                </c:forEach>
            </div>
        </div>
        <div class="col-md-3 mb-4">
            <div class="form-outline">
                <input type="text" id="lastName" name="lastName" value="${form.lastName}"
                       class="form-control form-control-sm" required placeholder="Last Name"/>
                <label class="form-label" for="lastName">Last Name</label>
                <c:forEach items='${bindingResult.getFieldErrors("lastName")}' var="error">
                    <div style="color:red;">${error.getDefaultMessage()}</div>
                </c:forEach>

            </div>
        </div>
    </div>

    <%--    <br>--%>
    <%--    First Name <input type="text" name="firstName" id="firstNameId" value="${form.firstName}">--%>
    <%--    <c:forEach items='${bindingResult.getFieldErrors("firstName")}' var="error">--%>
    <%--        <div style="color:red;">${error.getDefaultMessage()}</div>--%>
    <%--    </c:forEach>--%>
    <%--    <br>--%>
    <%--    Last Name <input type="text" name="lastName" id="lastNameId" value="${form.lastName}">--%>
    <%--    <c:forEach items='${bindingResult.getFieldErrors("lastName")}' var="error">--%>
    <%--        <div style="color:red;">${error.getDefaultMessage()}</div>--%>
    <%--    </c:forEach>--%>
    <%--    <br>--%>

    <div class="row">
        <div class="col-md-3 mb-2">
            <div class="form-outline">
                <input type="text" id="password" name="password" value="${form.password}"
                       class="form-control form-control-sm" required placeholder="Password"/>
                <label class="form-label" for="password">Password</label>
                <c:forEach items='${bindingResult.getFieldErrors("password")}' var="error">
                    <div style="color:red;">${error.getDefaultMessage()}</div>
                </c:forEach>

            </div>
        </div>
        <div class="col-md-3 mb-2">
            <div class="form-outline">
                <input type="text" id="confirmPassword" value="${form.confirmPassword}"
                       name="confirmPassword" class="form-control form-control-sm" required
                       placeholder="Confirm Password"/>
                <label class="form-label" for="confirmPassword">Confirm Password</label>
                <c:forEach items='${bindingResult.getFieldErrors("confirmPassword")}' var="error">
                    <div style="color:red;">${error.getDefaultMessage()}</div>
                </c:forEach>

            </div>
        </div>
    </div>

    <%--    Password <input type="text" name="password" id="passwordId" value="${form.password}">--%>
    <%--    <c:forEach items='${bindingResult.getFieldErrors("password")}' var="error">--%>
    <%--        <div style="color:red;">${error.getDefaultMessage()}</div>--%>
    <%--    </c:forEach>--%>
    <%--    <br>--%>
    <%--    Confirm Password <input type="text" name="confirmPassword" id="confirmPasswordId" value="${form.confirmPassword}">--%>
    <%--    <c:forEach items='${bindingResult.getFieldErrors("confirmPassword")}' var="error">--%>
    <%--        <div style="color:red;">${error.getDefaultMessage()}</div>--%>
    <%--    </c:forEach>--%>
    <%--    <br><br>--%>

    <div class="row">
        <div class="col-md-3 mt-2 pt-2">
            <input class="btn btn-outline-primary btn-sm" type="submit" value="Submit"/>
        </div>
        <%--        <div class="col-md-3 mt-2 pt-2">--%>
        <%--            Check Box <input type="checkbox" name="checkbox">--%>
        <%--        </div>--%>

        <div class="col-md-6 mt-2 pt-2" id="message">Welcome to the Home CD database</div>
    </div>

</form>


<div style="color:plum;">
    <c:if test="${not empty errorMessages}">
        <br>
        <c:forEach items="${errorMessages}" var="message">
            <div> ${message}</div>
        </c:forEach>
    </c:if>
</div>

<jsp:include page="../include/footer.jsp"/>

