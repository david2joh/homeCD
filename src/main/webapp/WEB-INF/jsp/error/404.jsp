<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Home CD Catalog</title>

    <script src="https://code.jquery.com/jquery-3.6.0.js"
            integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link href="<c:url value="../../../pub/css/new404.css"/>" rel="stylesheet" type="text/css"/>
</head>
<header class="top-header">
</header>

<!--dust particel-->
<div>
    <div class="starsec"></div>
    <div class="starthird"></div>
    <div class="starfourth"></div>
    <div class="starfifth"></div>
</div>
<!--Dust particle end--->


<div class="lamp__wrap">
    <div class="lamp">
        <div class="cable"></div>
        <div class="cover"></div>
        <div class="in-cover">
            <div class="bulb"></div>
        </div>
        <div class="light"></div>
    </div>
</div>
<!-- END Lamp -->
<section class="error">
    <!-- Content -->
    <div class="error__content">
        <div class="error__message message">
            <h1 class="message__title" style="color : white">Page Not Found</h1>
            <p class="message__text" style="color : white">We're sorry, the page you were looking for isn't found here.
                The link you followed may either be broken or no longer exists.</p>
        </div>
        <div class="error__nav e-nav">
            <a href="/../menu/menu" target="_blanck" class="e-nav__link"></a>
        </div>
    </div>
    <!-- END Content -->

</section>

