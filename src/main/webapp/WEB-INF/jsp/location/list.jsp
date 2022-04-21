<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../../../pub/html/header.html" %>
<jsp:include page="../include/navbar.jsp" />

<!-- one section to rule them all . kludge in the view height to 200 to allow for the errors to show up -->
<section class="gradient-custom">
    <div class="container py-5 h-100">
        <!-- Use the bootstrap semantics  each field is assigned a row, each row centered ,
max two items per row so each item in a row set to col-6 or col-12 -->
        <div class="row justify-content-center align-items-center h-90">
            <div class="col-12 col-lg-9 col-xl-7">
                <!-- set a nice border shadow and round the edges of the card -->
                <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
                    <!-- Set a nice image at the top -->
                    <img src="../pub/img/highwaylights.jpg" class="w-100 card-img-top" alt="Location Details"
                         style="border-radius: 15px 15px 0px 0px" ;>
                    <div class="card-body p-4 p-md-5">
                        <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">LOCATIONS</h3>
                        ${bindingResult}
                        ${errorMessages}

                        <table class="table">
                            <tr scope="row">
                                <th>Id</th>
                                <th>Location Name</th>
                                <th>Size</th>
                            </tr>
                            <c:forEach items="${locations}" var="location" varStatus="i">
                                <tr scope="row">
                                    <td><a href="/location/details?locationId=${location.id}" />
                                        <c:out value="${i.getCount()}" />
                                    </td>
                                    <td>${location.locationName}</td>
                                    <td>${location.cds.size()}</td>
<%--                                    <td>--%>
<%--                                        <form action="/user/locationChange/delete" id="deleteForm1">--%>
<%--                                            <input type="hidden" name="locationName" id="deleteLocation1"--%>
<%--                                                   value=${location.locationName}>--%>
<%--                                            <input class="btn btn-outline-primary btn-md" type="submit"--%>
<%--                                                   value="delete" />--%>
<%--                                        </form>--%>
<%--                                    </td>--%>
                                </tr>
                            </c:forEach>
                        </table>
                        <!-- Row #6 the Submit button. Use bootstrap to make the button an outline with blue color  -->
                        <!-- This row is divided 3 3 6  : 3 for SuUbmit button ; 3 blank space ; 6 Message to the user -->
                        <form action="/location/locationChange/add" id="addForm">
                            <div class="row">
                                <div class="col-md-1 mb-4"></div>
                                <div class="col-md-4 mb-4">
                                    <div class="form-outline">
                                        <input type="text" id="newLocation" class="form-control form-control-lg"
                                               placehoder="Add New Location" name="locationName" />
                                        <label class="form-label" for="newLocation">Add New Location</label>
                                        <div id="validationnewlocationFeedback" class="invalid-feedback"></div>
                                        <c:forEach items='${bindingResult.getFieldErrors("locationName")}' var="error">
                                            <div style="color:red;">${error.getDefaultMessage()}</div>
                                        </c:forEach>
                                    </div>
                                </div>
                                <div class="col-md-1 mb-4"></div>
                                <div class="col-md-3 pt-2">
                                    <input class="btn btn-outline-primary btn-md" type="submit" value="add" />
                                </div>
                            </div>
                        </form>
                        <br>
                        <form action="/location/locationChange/delete" id="deleteForm">
                            <div class="row">
                                <div class="col-md-1 mb-4"></div>
                                <div class="col-md-4 mb-4">
                                    <div class="form-outline">
                                        <input type="text" id="deleteLocation"
                                               class="form-control form-control-lg" placehoder="Delete a Location"
                                               name="locationName" value="${form.locationName}" />
                                        <label class="form-label" for="newLocation">Delete a Location</label>
                                        <div id="validationdeleteLocationFeedback" class="invalid-feedback">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-1 mb-4"></div>
                                <div class="col-md-3 pt-2">
                                    <input class="btn btn-outline-primary btn-md" type="submit"
                                           value="delete" />
                                </div>
                            </div>
                        </form>
                        <c:forEach items='${bindingResult.getFieldErrors("locationName")}' var="error">
                            <div style="color:red;">${error.getDefaultMessage()}</div>
                        </c:forEach>
                        <c:forEach items='${errorMessage}' var="error">
                            <div style="color:red;">${error}</div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>

</section>

<jsp:include page="../include/footer.jsp" />