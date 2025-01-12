<%@page import="com.staya.servlet.*" import="java.util.Base64" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product List</title>
</head>
<!-- BootStarp CDN Link to Get the Support of BootStrap -->
    <Link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<body>
     <h1 class="text-center text-success">LIST OF PODUCTS</h1>
     
        <div>
    <c:if test="${saveResult==1}">
        <h1 class="text-success text-center">DATA INSERTED SUCCESS FULLY...............</h1>
    </c:if>
    </div>
     
     <div>
         <a class="btn btn-success" href="Add-product.html">save Product</a>
     
     </div>
         <div class="form-group">
           
           <form method="get" action="searchResult.jsp">
            <input type="search" name="ch" placeholder="search here" aria-label="search"/>
            <button type="submit">Search</button>
           </form>
          
     </div>
     
    <div>
    <c:if test="${deleteResult==1}">
        <h1 class="text-danger text-center">DELETION  SUCCESSFULL...............</h1>
    </c:if>
    </div>
        <div>
    <c:if test="${deleteResult==0}">
        <h1 class="text-danger text-center">DELETION FAILED...............</h1>
    </c:if>
    </div>
     
     <div>
    <c:if test="${result==1}">
        <h1 class="text-success text-center">DATA updated SUCCESS FULLY...............</h1>
    </c:if>
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
<c:forEach var="product" items="<%=new ProdcutDao().findAll()%>">
     <tr>
     <td>${product.proId}</td>
     <td>${product.proName}</td>
     <td>${product.proPrice}</td>
     <td>${product.proBrand}</td>
     <td>${product.proMadeIn}</td>
     <td>${product.proMfgDate}</td>
     <td>${product.proExpdate }</td>
    <td><img src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(product.proImage)}" alt="product image" style="max-width: 100px; max-height:100px;">
     
      </td>
       
        <td>
        <audio controls>
        <source  src="data:audio/mp3;base64,${Base64.getEncoder().encodeToString(product.proAudio)}"  type="audio/mp3">
     </audio>
       </td>
       
        <td>
        <video controls width="200" height="200">
        <source src="data:Video/mp4;base64,${Base64.getEncoder().encodeToString(product.proVideo)}" type="video/mp4">
        </video>
         </td>
       <td>
       <a class="btn btn-primary" href="./DeletProductServlet?proId=${product.proId }">Delete</a>
       <a class="btn btn-primary" href="./EditProductServlet?proId=${product.proId}">Edit</a>
       </td>
       </tr>
</c:forEach>

</tbody> 
</table>  
</body>
</html>