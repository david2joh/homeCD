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
                        <form class="" id="myCdAddForm" action="/cd/cdAddDisk" method="post">
                            <input type="hidden" name="id" value="${form.id}">
                            CD label <input type="text" id="userName" placeholder="Label" name="label"
                                            value="${form.label}" />
                            <br>
                            CD catalog# <input type="text" id="catalogNum" placeholder="catalogNumber"
                                               name="catalogNumber" value="${form.catalogNumber}" />
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