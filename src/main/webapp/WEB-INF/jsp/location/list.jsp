<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>


<h1>Locations</h1>

<table class="table">
    <tr scope="row">
        <th>counter</th>
         <th>Id</th>
        <th>Location Name</th>
        <th>Size</th>
    </tr>
    <c:forEach items="${locations}" var="location" varStatus="i">
        <tr scope="row">
            <td><a href="/location/details?locationId=${location.id}"/><c:out value="${i.getCount()}"/></td>
            <td>${location.id}</td>
            <td>${location.locationName}</td>
            <td>${location.cds.size()}</td>
        </tr>
    </c:forEach>
</table>
    <!-- Row #6 the Submit button. Use bootstrap to make the button an outline with blue color  -->
    <!-- This row is divided 3 3 6  : 3 for SUbmit button ; 3 blank space ; 6 Message to the user -->
<form action="/user/locationChange">
    <div class="row">
        <div class="col-md-1 mb-4"></div>
        <div class="col-md-4 mb-4">
            <div class="form-outline">
                <input type="text" id="newLocation" class="form-control form-control-lg"
                      placehoder="Add New Location" name="locationName"/>
                <label class="form-label" for="newLocation">Add New Location</label>
                <div id="validationfirstNameFeedback" class="invalid-feedback"></div>
            </div>
        </div>
        <div class="col-md-1 mb-4"></div>
        <div class="col-md-3 pt-2">
            <input class="btn btn-outline-primary btn-md" type="submit" value="Submit" />
        </div>

<br>


<jsp:include page="../include/footer.jsp"/>