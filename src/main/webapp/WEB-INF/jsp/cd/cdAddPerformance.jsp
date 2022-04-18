<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp" />
<jsp:include page="../include/navbar.jsp" />
<link rel="stylesheet" href="../css/general.css">

<div class="gradient-custom" style="height: 125vh">

 <div class="container py-5 h-100">
  <!-- Use the bootstrap semantics  each field is assigned a row, each row centered ,
max two items per row so each item in a row set to col-6 or col-12 -->
  <div class="row justify-content-center align-items-center h-100">
   <div class="col-11">
    <!-- set a nice border shadow and round the edges of the card -->
    <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
     <!-- Set a nice image at the top -->
     <img src="../pub/img/cdstorage.jpg" class="w-100 card-img-top" alt="CD storage racks"
          style="border-radius: 15px 15px 0px 0px" ;>
     <div class="card-body p-4 p-md-5">
      <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Add Performance</h3>
      <form class="" id="myCdPerformance" action="/cd/cdAddPerformance" method="post">
       <input type="hidden" name="id" value="${form.id}">
       <!-- row #1 with label , catalog and locationeach place in 1/3 of the card with a bootstrtrap bottom margin (mb-2)-->
       <div class="row">
        <div class="col-md-3 mb-2">
         <div class="form-outline">
          <input type="text" id="label" class="form-control form-control-sm"
                 placeholder="${form.label}" name="label" value="${form.label}"
                 disabled />
          <label class="form-label" for="label">CD Label/Publisher</label>
          <div id="validationlabelFeedback" class="invalid-feedback">
           Please enter a CD Label/Publisher Name
          </div>
          <c:forEach items='${bindingResult.getFieldErrors("label")}' var="error">
           <div style="color:red;">${error.getDefaultMessage()}</div>
          </c:forEach>
         </div>
        </div>
        <div class="col-md-4 mb-2">
         <div class="form-outline">
          <input type="text" id="catalogNumber" class="form-control form-control-sm"
                 placeholder="${form.catalogNumber}" name="catalogNumber"
                 value="${form.catalogNumber}" disabled />
          <label class="form-label" for="catalogNumber">Catalog Number</label>
          <div id="validationcatalogNumberFeedback" class="invalid-feedback">
           Please enter a Catalog Number
          </div>
          <c:forEach items='${bindingResult.getFieldErrors("catalogNumber")}'
                     var="error">
           <div style="color:red;">${error.getDefaultMessage()}</div>
          </c:forEach>
         </div>
        </div>
        <div class="col-md-4 mb-2">
         <div class="form-outline">
          <input type="text" id="locationName" class="form-control form-control-sm"
                 placeholder="${form.locationName}" name="locationName"
                 value="${form.locationName}" disabled />
          <label class="form-label" for="locationName">LocationName</label>
          <div id="validationlocationNameFeedback" class="invalid-feedback">
           Please enter a Location Name
          </div>
          <c:forEach items='${bindingResult.getFieldErrors("locationName")}'
                     var="error">
           <div style="color:red;">${error.getDefaultMessage()}</div>
          </c:forEach>
         </div>
        </div>
       </div>
       <div class="row">
        <div class="col-md-3 mb-2">
         <div class="form-outline">
          <input type="text" id="composer" class="form-control form-control-sm"
                 placeholder="composer" name="composer" value="${form.composer}"
                 required />
          <label class="form-label" for="composer">composer</label>
          <div id="validationcomposerFeedback" class="invalid-feedback">
           Please enter a Composer Name
          </div>
          <c:forEach items='${bindingResult.getFieldErrors("composer")}' var="error">
           <div style="color:red;">${error.getDefaultMessage()}</div>
          </c:forEach>
         </div>
        </div>
        <div class="col-md-4 mb-2">
         <div class="form-outline">
          <input type="text" id="performance" class="form-control form-control-sm"
                 placeholder="performance" name="performance" value="${form.performance}"
                 required />
          <label class="form-label" for="performance">Performance/Work Name</label>
          <div id="validationperformanceFeedback" class="invalid-feedback">
           Please enter a Performance/Work Name
          </div>
          <c:forEach items='${bindingResult.getFieldErrors("performance")}'
                     var="error">
           <div style="color:red;">${error.getDefaultMessage()}</div>
          </c:forEach>
         </div>
        </div>
        <div class="col-md-4 mb-2">
         <div class="form-outline">
          <input type="text" id="artist" class="form-control form-control-sm"
                 placeholder="artist" name="artist" value="${form.artist}" required />
          <label class="form-label" for="artist">Artist</label>
          <div id="validationartistFeedback" class="invalid-feedback">
           Please enter a Artist Name
          </div>
          <c:forEach items='${bindingResult.getFieldErrors("artist")}' var="error">
           <div style="color:red;">${error.getDefaultMessage()}</div>
          </c:forEach>
         </div>
        </div>
        <div class="row">
         <div class="col-md-3 mt-4 pt-2">
          <input class="btn btn-outline-primary btn-md" id="mySubmitBtn" type="submit"
                 value="Submit" />
         </div>
         <div class="col-md-3 mt-4 pt-2">
         </div>
         <div class="col-md-6 mt-4 pt-2" id="message">
          Welcome to the Home CD catalog
         </div>
        </div>
       </div>
      </form>
      <c:forEach items='${errors}' var="error">
       <div style="color:red;">${error}</div>
      </c:forEach>
      <br>
      <div class="myScrollable" style="height: 300px; overflow-y: scroll;">
       <table class="table table-bordered table-striped" data-virtual-scroll="true">
        <col style="width: 15%" />
        <col style="width: 35%" />
        <col style="width: 30%" />
        <col style="width: 15%" />
        <tr scope="row">
         <th class="col-1-md">Composer</th>
         <th class="col-4-md">Work</th>
         <th class="col-3-md">Artist</th>
         <th></th>
        </tr>
       </table>
     </div>
    </div>
   </div>
  </div>

 </div>
</div>
<%@include file="../include/footer.jsp" %>