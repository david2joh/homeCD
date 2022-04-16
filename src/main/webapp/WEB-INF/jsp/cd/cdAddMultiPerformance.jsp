<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../include/header.jsp" %>
<jsp:include page="../include/navbar.jsp" />


<h1>I'm at cdAdd</h1>




<br>
${form}
<section>
    <form class="" id="myCdAddForm" action="/cd/cdAddSubmit" method="post">
        <input type="hidden" name="id" value="${form.id}">
        <div class="table-responsive">
            <table class="table table-bordered w-auto" id="childTable">
                <thead class="table-info">
                <tr>
                    <th>#</th>
                    <th>Composer</th>
                    <th>Work</th>
                    <th>Artist</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td class="col-sm-1">1</td>
                    <td class="col-sm-3">
                        <input type="text" name="composer" class="form-control" />
                    </td>
                    <td class="col-sm-3">
                        <input type="text" name="work" class="form-control" />
                    </td>
                    <td class="col-sm-3">
                        <input type="text" name="artist" class="form-control" />
                    </td>
                    <td class="col-sm-1">
                        <input type="button" class="btn btn-block btn-default" id="addrow"
                               onclick="childrenRow()" value="+" />
                    </td>
                </tr>
                </tbody>
            </table>
            <div class="row">
                <div class="col-md-3 mt-4 pt-2">
                    <input class="btn btn-outline-primary btn-md" id="mySubmitBtn" type="submit"
                           value="Submit" />
                </div>
                <div class="col-md-1 mt-4 pt-2">
                </div>
                <div class="col-md-6 mt-4 pt-2" id="message">Welcome to the Home CD catalog : Add CD page</div>
            </div>
        </div>
    </form>



</section>




<script>
    function deleteRow(id) {
        document.getElementById(id).remove()
    }


    function childrenRow() {

        var table = document.getElementById("childTable");
        // GET TOTAL NUMBER OF ROWS
        var x = table.rows.length;
        let y = table.rows.length - 1;
        var id = "tbl" + x;
        console.log(x, y, id);
        var row = table.insertRow(x);
        row.id = id;
        console.log(id);
        var cell1 = row.insertCell(0);
        var cell2 = row.insertCell(1);
        var cell3 = row.insertCell(2);
        var cell4 = row.insertCell(3);
        var cell5 = row.insertCell(4);
        cell1.outerHTML = `<th> ${x}</th>`;
        cell2.innerHTML = ' <input type="text" name="composer" class="form-control" />';
        cell3.innerHTML = ' <input type="text" name="work" class="form-control" />';
        cell4.innerHTML = ' <input type="text" name="artist" class="form-control" />';
        cell5.innerHTML = '  <input type="button" class="btn btn-block btn-default" id="addrow" onclick="deleteRow(\'' + id + '\')" value="Delete" /> ';
    }
</script>




<%@include file="../include/footer.jsp" %>