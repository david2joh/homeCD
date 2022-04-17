<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../../../pub/html/header.html" %>
<%--<jsp:include page="../include/header.jsp" />--%>
<jsp:include page="../include/navbar.jsp" />
<link <c:url value="/src/main/webapp/pub/css/composerlist.css"/> rel="stylesheet">

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
                    <img src="../pub/img/bach_sm.jpg" class="w-100 card-img-top" alt="Composer Details"
                         style="border-radius: 15px 15px 0px 0px;" >
                    <div class="card-body p-4 p-md-5">
                        <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">COMPOSERS</h3>

                        <div class="myScrollable" style="height: 300px; overflow-y: scroll;">
<%--                        <div class="myScrollable">--%>
                        <table class="table table-bordered" data-virtual-scroll="true">
                            <tr scope="row">
                                <th>Composer</th>
                                <th>Composer Name</th>
                                <th>Number of Recordings</th>
                            </tr>
                            <c:forEach items="${composers}" var="composer" varStatus="i">
                                <tr scope="row">
                                    <td><a href="/composer/composerDetails?composerId=${composer.id}" />
                                        <c:out value="${i.getCount()}" />
                                    </td>
                                    <td>${composer.composerName}</td>
                                    <td>${composer.performances.size()}</td>
                                </tr>
                            </c:forEach>
                        </table>
                        </div>
                        <!-- Use bootstrap to make the button an outline with blue color  -->
                        <!-- This row is divided 1 4 1 3 -->
                        <br>
                        <form action="/composer/composerChange/add" id="addForm">
                            <div class="row">
                                <div class="col-md-1 mb-4"></div>
                                <div class="col-md-4 mb-4">
                                    <div class="form-outline">
                                        <input type="text" id="newComposer" class="form-control form-control-sm"
                                               placehoder="Add New Composer" name="composerName" />
                                        <label class="form-label" for="newComposer">Add New Composer</label>
                                        <div id="validationnewcomposerFeedback" class="invalid-feedback"></div>
                                    </div>
                                </div>
                                <div class="col-md-1 mb-4"></div>
                                <div class="col-md-3 mb-4">
                                    <input class="btn btn-outline-primary btn-sm" type="submit" value="add" />
                                </div>
                                <c:forEach items='${bindingResult.getFieldErrors("composerName")}' var="error">
                                    <div style="color:red;">${error.getDefaultMessage()}</div>
                                </c:forEach>
                            </div>
                        </form>
                        <br>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp" />