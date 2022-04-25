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
                    <img src="../pub/img/highwaylights.jpg" class="w-100 card-img-top" alt="Location Details" style="border-radius: 15px 15px 0px 0px"; >
                    <div class="card-body p-4 p-md-5">
                        <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">${location.locationName}</h3>
                        <!-- row #1 with first_name and last_name each place in 1/2 of the card with a bootstrtrap bottom margin (mb-4)-->
                        <div class="row">
                            <div class="col-md-12 mb-4">
                                <table class="table">
                                    <tr scope="row">
                                        <th>Id</th>
                                        <th>Composer</th>
                                        <th>Work</th>
                                        <th>Artist</th>
                                     </tr>
                                    <c:forEach items="${cdDetails}" var="cd" varStatus="i">
                                        <tr scope="row">
                                            <td><a href="/cd/cdDetails?id=${cd.id}" />
                                            <c:out value="${i.getCount()}"/></td>
                                            <td>${cd.composer}</td>
                                            <td>${cd.performance}</td>
                                            <td>${cd.artist}</td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                        </div>
                        <!-- Row #6 the Submit button. Use bootstrap to make the button an outline with blue color  -->
                        <!-- This row is divided 3 3 6  : 3 for SUbmit button ; 3 blank space ; 6 Message to the user -->
                        <form action="/location/locationChange/update" id="addForm">
                        <div class="row">
                            <div class="col-auto mb-4">
                                <div class="form-outline">
                                    <input type="hidden" id ="formId" name="id" value="${form.id}">
                                    <input type="text" id="newLocation" class="form-control form-control-lg"
                                           required placeHolder="New Location Name" name="locationName"
                                           value="${form.locationName}"/>
                                    <label class="form-label" for="newLocation"></label>
                                    <div id="validationlocationNameFeedback" class="invalid-feedback">
                                        Please enter a valid Location Name. Locations must be between 3 and 15 characters
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-1 mb-4"></div>
                            <div class="col-md-3 pt-2">
                                <input class="btn btn-outline-primary btn-md" type="submit" value="Change Location Name" />
                            </div>
                    </div>
                            </form>
                        <!-- DIV SOUP  -->
                </div>
            </div>
        </div>
    </div>
    </div>
</section>

<%@include file="../../../pub/html/footer.html" %>