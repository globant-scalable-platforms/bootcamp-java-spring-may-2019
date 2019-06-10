<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
    <title>Tag Example</title>
</head>

<body>
<c:forEach var = "i" items="content">
Orden <c:out value = "http://instalaciones.alkosto.com/ie/impresionop2.asp?OP=${i}&US=7"/><p>
    </c:forEach>
</body>
</html>