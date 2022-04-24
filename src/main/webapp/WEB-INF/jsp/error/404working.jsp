<%@include file="../include/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    * {
        box-sizing: border-box;
    }

    body {
        font: 110%/1.5 system-ui, sans-serif;
        background: #131417;
        color: white;
        height: 100vh;
        margin: 0;
        display: grid;
        place-items: center;
        padding: 2rem;
    }

    main {
        max-width: 350px;
    }

    /*a {*/
    /*    color: #56BBF9;*/
    /*}*/
</style>
</head>
<body>
<main>
    <h1 data-test-id="text-404">404</h1>
    <p>I'm afraid you've found a page that doesn't exist on CD Home. That can happen when you follow a link to something
        that has since been deleted. Or the link was incorrect to begin&nbsp;with.</p>
    <p>Sorry about that.</p>
    <ul>
        <li>
            <a href="/../menu/menu">Go to the menu</a>
        </li>
    </ul>
</main>
<%@include file="../include/footer.jsp" %>