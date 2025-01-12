<%@page import="com.staya.servlet.*" import="java.util.Base64" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search PRODUCT LIST</title>
</head>
<!-- BootStarp CDN Link to Get the Support of BootStrap -->
    <Link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script type="text/javascript" src="formvalidation.js"></script>
<body>
    <%
        String input= request.getParameter("ch");
     %>
     
     <h2 style="color:red; text-align: center">results are---------</h2>

     
     <div class ="form-group">
     
      <a   href ="productlist.jsp" class="btn btn-success">LIST OF PRODUCTS</a>
      
     </div>
     
     
       
   <table class="table table-bordered table-striped">
   <thead class="thead-dark">
      <tr>
        <th> PRODUCT ID</th>
        <th>PRODUCT NAME</th>
        <th>PRODUCT COST</th>
        <th>BRAND</th>
        <th>MADE IN</th>
        <th>MANUFACTURE DATE</th>
        <th>EXPIRY DATE</th>
        <th>IMAGE</th>
        <th>AUDIO</th>
        <th>VIDEO</th>
        <th>Action</th>
        </tr>
   </thead>
<tbody>
<c:forEach var="product" items="<%=new ProdcutDao().SearchByInput(input)%>">
     <tr>
     <td>${product.proId}</td>
     <td>${product.proName}</td>
     <td>${product.proPrice}</td>
     <td>${product.proBrand}</td>
      <td>${product.proMadeIn}</td>
     <td>${product.proMfgDate}</td>
     <td>${product.proExpdate }</td>
    
       
      
       </tr>
</c:forEach>

</tbody> 
</table>  
</body>
</html>