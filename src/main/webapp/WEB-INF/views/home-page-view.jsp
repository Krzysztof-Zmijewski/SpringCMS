<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>home-page-view</title>
</head>
<body>
<c:forEach items="${articles}" var="article">
    <h1>${article.title}</h1>
    <h6>Utworzono: ${article.createdOn}</h6>
    <div>
        ${article.content}
    </div>
</c:forEach>
</body>
</html>
