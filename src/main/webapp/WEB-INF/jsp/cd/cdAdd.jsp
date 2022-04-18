<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp" />
<jsp:include page="../include/navbar.jsp" />
<link rel="stylesheet" href="../css/general.css">

<div class="gradient-custom" style="height: 100vh">

 <div class="container py-5 h-100">
  <!-- Use the bootstrap semantics  each field is assigned a row, each row centered ,
max two items per row so each item in a row set to col-6 or col-12 -->
  <div class="row justify-content-center align-items-center h-100">
   <div class="col-12">
    <!-- set a nice border shadow and round the edges of the card -->
    <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
     <!-- Set a nice image at the top -->
     <img src="../pub/img/cdstorage.jpg" class="w-100 card-img-top" alt="ADD CD"
          style="border-radius: 15px 15px 0px 0px" ;>
     <div class="card-body p-4 p-md-5">
      <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">ADD CD</h3>
      <form class="" id="myCdAddForm" action="/cd/cdAddSubmit" method="post">
       <input type="hidden" name="id" value="${form.id}">
       CD label <input type="text" id="userName" placeholder="Label" name="label"
                       value="${form.label}" />
       <br>
       CD catalog# <input type="text" id="catalogNum" placeholder="catalogNumber"
                          name="catalogNumber" value="${form.catalogNumber}" />
       <br>
       Composer <input type="text" id="composer" placeholder="composer" name="composer"
                       value="${form.composer}" />
       <br>
       Performance <input type="text" id="performance" placeholder="Work Name" name="work"
                          value="${form.work}" />
       <br>
       Artist <input type="text" id="artist" placeholder="Artist" name="artist"
                     value="${form.artist}" />
       <br>
       Location <input type="text" id="location" placeholder="Location Name"
                       name="locationName" value="${form.locationName}" />
       <br><br>
       <input class="btn btn-outline-primary btn-md" id="mySubmitBtn" type="submit"
              value="Submit" />
      </form>

      <c:forEach items='${bindingResult}' var="error">
       <div style="color:red;">${error.getDefaultMessage()}</div>
      </c:forEach>
      ${errors}
      <c:forEach items='${errors}' var="error">
       <div style="color:red;">${error}</div>
      </c:forEach>
      <br>
      <div class="myScrollable" style="height: 300px; overflow-y: scroll;">
       <table class="table table-bordered table-striped" data-virtual-scroll="true">
        <col style="width: 15%" />
        <col style="width: 40%" />
        <col style="width: 30%" />
        <col style="width: 10%" />
        <tr scope="row">
         <th class="col-1-md">Composer</th>
         <th class="col-4-md">Work</th>
         <th class="col-3-md">Artist</th>
         <th></th>
        </tr>
        <c:forEach var="composer" items="${form.composers}" varStatus="i">
         <tr scope="row">
          <td>${composer}</td>
          <td>${form.works[i.index]}</td>
          <td>${form.artists[i.index]}</td>
          <td><input class="btn btn-outline-success btn-sm" type="submit" value="Modify" />
           <input class="btn btn-outline-danger btn-sm" type="submit" value="Delete" />
          </td>
         </tr>
        </c:forEach>
       </table>
      </div>
<%--      <br><br>${form}--%>
     </div>
    </div>
   </div>
  </div>
 </div>
</div>
<%@include file="../include/footer.jsp" %>