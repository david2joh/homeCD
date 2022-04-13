<style>
    #navright {
        flex : 1;
        margin-left: auto;
    }
    .dropdown-menu {
        background-color: #85A7F8;
        color : white;
        text-align: center;
        min-width : inherit;
        /*width: max-content !important;*/
    }
    /*.dropdown-item {*/
    /*    width: max-content !important;*/
    /*}*/
    #myNavBar {
        width: 100%;
    }
</style>
<nav class="navbar navbar-expand-lg navbar-light">
<%--    <nav class="navbar navbar-expand-lg navbar-light gradient-custom">--%>
    <div class="container-fluid">
        <a class="navbar-brand" href="../menu/menu"><b>Menu</b></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0" id="myNavBar">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="../menu/menu">| Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="../composers/list">| Composers</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="../location/list">| Locations</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="../perforamaces/list">| Performances</a>
                </li>

               <li class="nav-item dropdown" id="navright">
                   <a class="nav-link dropdown-toggle text-end" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                       Admin
                   </a>
                   <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                       <li><a class="dropdown-item" href="/cd/">Add a CD</a></li>
                       <li><a class="dropdown-item" href="/user/search">Find a User</a></li>
<%--                       <li><hr class="dropdown-divider"></li>--%>
<%--                       <li><a class="dropdown-item" href="#"></a></li>--%>
                   </ul>
               </li>

            </ul>
<%--            <form class="d-flex">--%>
<%--                <input class="form-control me-2" type="search" placeholder="Find a CD" aria-label="Search">--%>
<%--                <button class="btn btn-outline-primary" type="submit">Search</button>--%>
<%--            </form>--%>
        </div>
    </div>
</nav>