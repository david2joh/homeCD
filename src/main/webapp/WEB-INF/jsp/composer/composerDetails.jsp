<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp" />
<jsp:include page="../include/navbar.jsp" />
<link rel="stylesheet" href="../css/general.css">

<div class="gradient-custom" style="height: 100vh">

<div class="container py-5 h-100">
        <!-- Use the bootstrap semantics  each field is assigned a row, each row centered ,
    max two items per row so each item in a row set to col-6 or col-12 -->
        <div class="row justify-content-center align-items-center h-90">
            <div class="col-12 col-lg-9 col-xl-7">
                <!-- set a nice border shadow and round the edges of the card -->
                <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
                    <!-- Set a nice image at the top -->
                    <img src="../pub/img/bach_sm.jpg" class="w-100 card-img-top" alt="Composer Details" style="border-radius: 15px 15px 0px 0px"; >
                    <div class="card-body p-4 p-md-5">
                        <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">${form.composerName}</h3>
                        <!-- row #1 with first_name and last_name each place in 1/2 of the card with a bootstrtrap bottom margin (mb-4)-->
<%--                        <div class="row">--%>
<%--                            <div class="col-md-12 mb-4">--%>
                           <div class="myScrollable" style="height: 300px; overflow-y: scroll;">
                                <table class="table" data-virtual-scroll="true">
                                    <tr scope="row">
                                        <th>Id</th>
                                        <th>Work</th>
                                        <th>Artist</th>
                                        <th>Location</th>
                                    </tr>
                                    <c:forEach items="${cdDetails}" var="cd" varStatus="i">
                                        <tr scope="row">
                                            <td><c:out value="${i.getCount()}"/></td>
                                            <td>${cd.performance}</td>
                                            <td>${cd.artist}</td>
                                            <td>${cd.locationName}</td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
<%--                        </div>--%>
                        <!-- DIV SOUP  -->
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="../../../pub/html/footer.html" %>