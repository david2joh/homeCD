<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>


<h1>Locations</h1>

<table class="table">
    <tr scope="row">
        <th>counter</th>
         <th>Id</th>
        <th>Location Name</th>
        <th>Size</th>
        <th>test</th>
    </tr>
    <c:forEach items="${locations}" var="location" varStatus="i">
        <c:if test="{$location.cds.size() = 0}">
            <p>location size again = <c:out value = "${location.cds.size()}"/></p>
        </c:if>
        <tr scope="row">
            <td><a href="/location/details?locationId=${location.id}"/><c:out value="${i.getCount()}"/></td>
            <td>${location.id}</td>
            <td>${location.locationName}</td>
            <td>${location.cds.size()}</td>
             <td>
              <form action="/user/locationChange/delete" id="deleteForm1">
                <input type="hidden" name="locationName" id="deleteLocation1" value=${location.locationName}>
                <input class="btn btn-outline-primary btn-md" type="submit" value="delete" />
              </form>
            </td>
        </tr>
    </c:forEach>
</table>
    <!-- Row #6 the Submit button. Use bootstrap to make the button an outline with blue color  -->
    <!-- This row is divided 3 3 6  : 3 for SuUbmit button ; 3 blank space ; 6 Message to the user -->
<form action="/user/locationChange/add" id="addForm">
    <div class="row">
        <div class="col-md-1 mb-4"></div>
        <div class="col-md-4 mb-4">
            <div class="form-outline">
                <input type="text" id="newLocation" class="form-control form-control-lg"
                       placehoder="Add New Location" name="locationName"/>
                <label class="form-label" for="newLocation">Add New Location</label>
                <div id="validationnewlocationFeedback" class="invalid-feedback"></div>
            </div>
        </div>
        <div class="col-md-1 mb-4"></div>
        <div class="col-md-3 pt-2">
            <input class="btn btn-outline-primary btn-md" type="submit" value="add" />
        </div>
    </div>
</form>
<br>
<form action="/user/locationChange/delete" id="deleteForm">
    <div class="row">
        <div class="col-md-1 mb-4"></div>
        <div class="col-md-4 mb-4">
            <div class="form-outline">
                <input type="text" id="deleteLocation" class="form-control form-control-lg"
                       placehoder="Delete a Location" name="locationName" value="${form.locationName}"/>
                <label class="form-label" for="newLocation">Delete a Location</label>
                <div id="validationdeleteLocationFeedback" class="invalid-feedback"></div>
            </div>
        </div>
        <div class="col-md-1 mb-4"></div>
        <div class="col-md-3 pt-2">
            <input class="btn btn-outline-primary btn-md" type="submit" value="delete" />
        </div>
    </div>
</form>


<jsp:include page="../include/footer.jsp"/>