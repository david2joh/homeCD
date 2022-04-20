<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp" />
<jsp:include page="../include/navbar.jsp" />
<link rel="stylesheet" href="../css/general.css">

<div class="gradient-custom" style="height: 100vh">

    <div class="container py-3 h-100">
        <!-- Use the bootstrap semantics  each field is assigned a row, each row centered ,
  max two items per row so each item in a row set to col-6 or col-12 -->
        <div class="row justify-content-center  h-100">
            <div class="col-11">
                <!-- set a nice border shadow and round the edges of the card -->
                <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
                    <!-- Set a nice image at the top -->
                    <img src="../pub/img/cdstorage.jpg" class="w-100 card-img-top" alt="ADD CD"
                         style="border-radius: 15px 15px 0px 0px" ;>
                    <div class="card-body p-4 p-md-5">
                        <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">ADD CD</h3>
                        <form class="" id="myCdAddForm" action="/cd/cdAddDisk" method="post">
                            <input type="hidden" name="id" value="${form.id}">
                            <!-- row #1 with label , catalog and locationeach place in 1/3 of the card with a bootstrtrap bottom margin (mb-2)-->
                            <div class="row">
                                <div class="col-md-3 mb-2">
                                    <div class="form-outline">
                                        <input type="text" id="label" class="form-control form-control-sm"
                                               placeholder="CD Label/Publisher" name="label" value="${form.label}" required/>
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
                                               placeholder="Catalog Number" name="catalogNumber" value="${form.catalogNumber}" required/>
                                        <label class="form-label" for="catalogNumber">Catalog Number</label>
                                        <div id="validationcatalogNumberFeedback" class="invalid-feedback">
                                            Please enter a Catalog Number
                                        </div>
                                        <c:forEach items='${bindingResult.getFieldErrors("catalogNumber")}' var="error">
                                            <div style="color:red;">${error.getDefaultMessage()}</div>
                                        </c:forEach>
                                    </div>
                                </div>
                                <div class="col-md-4 mb-2">
                                    <div class="form-outline">
                                        <input type="text" id="locationName" class="form-control form-control-sm"
                                               placeholder="locationName" name="locationName" value="${form.locationName}" required/>
                                        <label class="form-label" for="locationName">LocationName</label>
                                        <div id="validationlocationNameFeedback" class="invalid-feedback">
                                            Please enter a Location Name
                                        </div>
                                        <c:forEach items='${bindingResult.getFieldErrors("locationName")}' var="error">
                                            <div style="color:red;">${error.getDefaultMessage()}</div>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-3 mt-4 pt-2">
                                    <input class="btn btn-outline-primary btn-md" id="mySubmitBtn" onclick="validate()" type="submit" value="Submit" />
                                </div>
                                <div class="col-md-3 mt-4 pt-2">
                                </div>
                                <div class="col-md-6 mt-4 pt-2" id="message">Welcome to the Home CD catalog</div>
                            </div>
                        </form>
                       <c:forEach items='${errors}' var="error">
                            <div style="color:red;">${error}</div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="../include/footer.jsp" %>