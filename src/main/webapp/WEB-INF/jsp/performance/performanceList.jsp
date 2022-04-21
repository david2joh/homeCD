<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../../../pub/html/header.html" %>
<%--<jsp:include page="../include/header.jsp" />--%>
<jsp:include page="../include/navbar.jsp" />
<link <c:url value="/src/main/webapp/pub/css/composerlist.css"/> rel="stylesheet">

<!-- one section to rule them all . kludge in the view height to 200 to allow for the errors to show up -->
<section class="gradient-custom">
    <div class="container h-100">
        <!-- Use the bootstrap semantics  each field is assigned a row, each row centered ,
max two items per row so each item in a row set to col-6 or col-12 -->
        <div class="row justify-content-center align-items-center h-90" style="margin-bottom: 250px">
            <div class="col-12 col-lg-9 col-xl-7">
                <!-- set a nice border shadow and round the edges of the card -->
                <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
                    <!-- Set a nice image at the top -->
                    <img src="../pub/img/conductor.jpg" class="w-100 card-img-top" alt="Composer Details"
                         style="border-radius: 15px 15px 0px 0px;" >
                    <div class="card-body p-4 p-md-5">
                        <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">PERFORMANCES</h3>

                        <div class="myScrollable" style="height: 300px; overflow-y: scroll;">
                            <table class="table table-bordered" data-virtual-scroll="true">
                                <tr scope="row">
                                    <th>#</th>
                                    <th>Work</th>
                                    <th>Composer Name</th>
                                    <th>Artist</th>
                                    <th>Location</th>
                                </tr>
                                <c:forEach items="${pDetails}" var="pDetail" varStatus="i">
                                    <tr scope="row">
                                        <td><a href="/cd/cdDetails?id=${pDetail.cdId}" />
                                            <c:out value="${i.getCount()}" />
                                        </td>
                                        <td>${pDetail.performance}</td>
                                        <td>${pDetail.composer}</td>
                                        <td>${pDetail.artist}</td>
                                        <td>${pDetail.locationName}</td>
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

<jsp:include page="../include/footer.jsp" />