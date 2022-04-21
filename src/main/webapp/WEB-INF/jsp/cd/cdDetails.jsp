<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../../../pub/html/header.html" %>
<%--<jsp:include page="../include/header.jsp" />--%>
<jsp:include page="../include/navbar.jsp"/>
<link
<c:url value="/src/main/webapp/pub/css/composerlist.css"/> rel="stylesheet">

<!-- one section to rule them all . kludge in the view height to 200 to allow for the errors to show up -->
<section class="gradient-custom">
    <div class="container h-100">
        <!-- Use the bootstrap semantics  each field is assigned a row, each row centered ,
max two items per row so each item in a row set to col-6 or col-12 -->
        <div class="row justify-content-center align-items-center h-90" style="margin-bottom: 250px">
            <div class="col-11 ">
                <!-- set a nice border shadow and round the edges of the card -->
                <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
                    <!-- Set a nice image at the top -->
                    <img src="../pub/img/horsecarriage.jpg" class="w-100 card-img-top" alt="CD Details"
                         style="border-radius: 15px 15px 0px 0px; height: 35vh !important;">
                    <div class="card-body p-4 p-md-5">
                        <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">CD Details</h3>
                        form= ${form}<br>
                        <div class="container">
                            <div class="row">
                                <div class="col-md-3 mb-2 pb-2">
                                    <b>Label/Publisher</b>
                                </div>
                                <div class="col-md-3 mb-2 pb-2">
                                    <b>Catalog Number</b>
                                </div>
                                <div class="col-md-3 mb-2 pb-2">
                                    <b>Location</b>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-3 mb-2 pb-2">
                                    ${form.label}
                                </div>
                                <div class="col-md-3 mb-2 pb-2">
                                    ${form.catalogNumber}
                                </div>
                                <div class="col-md-3 mb-2 pb-2">
                                    ${form.locationName}
                                </div>
                            </div>
                        </div>
                        <br>
                        <div class="myScrollable" style="height: 500px; overflow-y: scroll;">
                            <%--                        <div class="myScrollable">--%>
                            <table class="table table-bordered" data-virtual-scroll="true">
                                <col style="width: 25%"/>
                                <col style="width: 40%"/>
                                <col style="width: 35%"/>
                                <tr scope="row">
                                    <th>Composer</th>
                                    <th>Performance</th>
                                    <th>Artist</th>
                                </tr>
                                <c:forEach items="${form.composers}" var="composer" varStatus="i">
                                    <tr scope="row">
<%--                                        <td><a href="/cd/cdDetails?cdId=${cd.id}"/>--%>
<%--                                            <c:out value="${i.getCount()}"/>--%>
<%--                                        </td>--%>
                                        <td>${composer}</td>
                                        <td>${form.works[i.index]}</td>
                                        <td>${form.artists[i.index]}</td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>