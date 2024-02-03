<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
 <body>
  <h1>test page</h1>
  
   <%
   //String name=(String)request.getAttribute("name");
   //Integer id= (Integer)request.getAttribute("id");
     
   %>
   <h1>
    Name: ${name}, id= ${id}
   </h1>
   <hr>
   
  
      <c:forEach var="item" items="${marks }">
      <h1>${item }</h1>
      </c:forEach>
 </body>
</html>