<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../../../pub/html/header.html" %>
<jsp:include page="../include/navbar.jsp" />

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
                         style="border-radius: 15px 15px 0px 0px" ;>
                    <div class="card-body p-4 p-md-5">
                        <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">COMPOSERS</h3>


                        <table class="table">
                            <tr scope="row">
                                <th>Composer</th>
                                <th>Composer Name</th>
                                <th>Number of Recordings</th>
                            </tr>
                            <c:forEach items="${composers}" var="composer" varStatus="i">
                                <tr scope="row">
                                    <td><a href="/composer/details?composerId=${composer.id}" />
                                        <c:out value="${i.getCount()}" />
                                    </td>
                                    <td>${composer.composerName}</td>
                                    <td>${composer.performances.size()}</td>
                                        <%--                                    <td>--%>
                                        <%--                                        <form action="/user/composerChange/delete" id="deleteForm1">--%>
                                        <%--                                            <input type="hidden" name="composerName" id="deleteComposer1"--%>
                                        <%--                                                   value=${composer.composerName}>--%>
                                        <%--                                            <input class="btn btn-outline-primary btn-md" type="submit"--%>
                                        <%--                                                   value="delete" />--%>
                                        <%--                                        </form>--%>
                                        <%--                                    </td>--%>
                                </tr>
                            </c:forEach>
                        </table>
                        <!-- Row #6 the Submit button. Use bootstrap to make the button an outline with blue color  -->
                        <!-- This row is divided 3 3 6  : 3 for SuUbmit button ; 3 blank space ; 6 Message to the user -->
                        <form action="/composer/composerChange/add" id="addForm">
                            <div class="row">
                                <div class="col-md-1 mb-4"></div>
                                <div class="col-md-4 mb-4">
                                    <div class="form-outline">
                                        <input type="text" id="newComposer" class="form-control form-control-lg"
                                               placehoder="Add New Composer" name="composerName" />
                                        <label class="form-label" for="newComposer">Add New Composer</label>
                                        <div id="validationnewcomposerFeedback" class="invalid-feedback"></div>
                                    </div>
                                </div>
                                <div class="col-md-1 mb-4"></div>
                                <div class="col-md-3 pt-2">
                                    <input class="btn btn-outline-primary btn-md" type="submit" value="add" />
                                </div>
                            </div>
                        </form>
                        <br>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

${composers}

<jsp:include page="../include/footer.jsp" />