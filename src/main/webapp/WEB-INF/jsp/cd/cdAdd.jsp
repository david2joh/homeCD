<%@include file="../include/header.jsp"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/navbar.jsp"/>

<h1>I'm at cdAdd</h1>

<form class="" id="myCdAddForm" action="/cd/cdAddSubmit/${form.id}" method="post">
 <input type="hidden" name="id" value="${form.id}">
 CD label     <input type="text" id="userName" placeholder="Label" name="label" value="${form.label}"/>
 <br>
 CD catalog#  <input type="text" id="catalogNum" placeholder="catalogNumber" name="catalogNumber" value="${form.catalogNumber}"/>
 <br>
 Composer     <input type="text" id="composer" placeholder="composer" name="composer" value="${form.composer}"/>
 <br>
 Performance  <input type="text" id="performance" placeholder="Work Name" name="work" value="${form.work}"/>
 <br>
 Artist       <input type="text" id="artist"   placeholder="Artist" name="artist" value="${form.artist}"/>
 <br>
 Location     <input type="text" id="location" placeholder="Location Name" name="locationName" value="${form.locationName}"/>
 <br>
 <input class="btn btn-outline-primary btn-md" id="mySubmitBtn" type="submit" value="Submit" />
 </form>

 <c:forEach items='${bindingResult}' var="error">
           <div style="color:red;">${error.getDefaultMessage()}</div>
 </c:forEach>

<%@include file="../include/footer.jsp"  %>