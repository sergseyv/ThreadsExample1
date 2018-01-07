<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

  <c:forEach var="status" items="${times1}" >
      <c:out value="${status.key}" />
      <c:out value="${status.value}" /><p>
  </c:forEach>



</body>
</html>
