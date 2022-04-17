<%@include file="../include/header.jsp"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/navbar.jsp"/>

<!-- Bootstrap sematics Line up 3 cards in 1 row with a gap (gutter g-4) Add our color between cards -->
<!-- each card is identical in shape/size and set to cover height 100 -->
<%--<div class="row row-cols-1 row-cols-3 g-4 gradient-custom">--%>
<div class="row row-cols-1 row-cols-3 g-4">

    <!-- Card #1 in first col -  Our composer search card  -->
    <div class="col">
        <div class="card h-100">
            <a href="../composer/list">
                <img src="../pub/img/bach_sm.jpg" class="card-img-top top-bach" alt="Bach portrait">
            </a>
            <div class="card-body">
                <h5 class="card-title">Composer Search</h5>
                <p class="card-text">Find Disks by Composer</p>
            </div>
        </div>

    </div>

    <!-- Card #2 - Our location card with a table indicating how many disks in our current location list -->
    <!-- This became rather verbose  -->
    <div class="col">
        <div class="card h-100">
            <a href="../location/list">
                <img src="../pub/img/highwaylights.jpg" class="card-img-top" alt="Location">
            </a>
            <div class="card-body">
                <h5 class="card-title">Location</h5>
                <p class="card-text">Where did I put that now?</p>
                <!-- Table : Bootstrap feature as a responsive table stays in the card and adds a scroll bar when needed -->
                <div class="table-responsive">
                    <table class="table" style="width: 300px;">
                        <thead>
                        <tr>
                            <th>Name</th>
                            <th>Disks held</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${locations}" var="location">
                            <tr scope="row">
                                <td>${location.locationName}</td>
                                <td>${location.cnt}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

    <!-- Card #3 our performance search card -->
    <div class="col">
        <div class="card h-100">
            <a href="../performance/list">
                <img src="../pub/img/conductor.jpg" class="card-img-top" alt="Performance">
            </a>
            <div class="card-body">
                <h5 class="card-title">Performance</h5>
                <p class="card-text">Who? What? Where?</p>
            </div>
        </div>
    </div>

</div>


<%@include file="../../../pub/html/footer.html" %>