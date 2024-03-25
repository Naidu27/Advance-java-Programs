<%@page import="com.staya.servlet.*" import="java.util.Base64" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADD PRODUCT</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<script  type="text/javascript" src="formvalidation.js"></script>
</head>
<body>
    <div class="container mt-5 text-center">
    
      <h2 class="text-center font-italic mb-1">EDIT PRODUCT DATA</h2>
      
       <form method="post" action="./UpdatesProductServlet" enctype="multipart/form-data" onsubmit="return validationForm()">
           
       
          	<div class="form-group">
            <label class="font-italic font-weigth-bold" for="proId">PRODUCT ID:</label>
            <input type="text" class="form-control-sm" id="proId"  name="proId"  value="${existingProduct.proId}" required>
            </div>
            
            <div class="form-group">
               <label class="font-italic font-weigth-bold" for="proName">PRODUCT NAME:</label>
                <input type="text" class="form-control-sm" id="proName"  name="proName"  value="${existingProduct.proName}" required>
            </div>
            
             <div class="form-group">
                <label class="font-italic font-weigth-bold" for="proPrice">PRODUCT PRICE:</label>
                <input type="number" class="form-control-sm" id="proPrice"  name="proPrice"  value="${existingProduct.proPrice}" required>
            </div>
            
             <div class="form-group">
                <label class="font-italic font-weigth-bold" for="proBrand">PRODUCT BRAND:</label>
                <input type="text" class="form-control-sm" id="proBrand"  name="proBrand"  value="${existingProduct.proBrand}" required>
            </div>
            
             <div class="form-group">
                 <label class="font-italic font-weigth-bold" for="proMade In">PRODUCT MADE-IN:</label>
                  <input type="text" class="form-control-sm" id="proMadeIn"  name="proMadeIn"  value="${existingProduct.proMadeIn}" required>
            </div>
            
             <div class="form-group">
                  <label class="font-italic font-weigth-bold" for="proMfg Date">PRODUCT MFG-DATE:</label>
                   <input type="date" class="form-control-sm" id="proMfgdate"  name="proMfgdate" value="${existingProduct.proMfgDate}" required>
            </div>
 
            
             <div class="form-group">
                <label class="font-italic font-weigth-bold" for="proExp Date">PRODUCT EXP-DATE:</label>
                <input type="date" class="form-control-sm" id="proExpdate"  name="proExpdate" value="${existingProduct.proExpdate}" required>
            </div>
            
             <!-- -------Display the current Product image -->
            <div class="form-group">
             <label class="font-italic font-weight-bold" for="proImage">Current product Image:</label>
             <img id="currentImage" src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(existingProduct.proImage)}" alt="Current Product Image"  style="max-width:100px; max-height:100px;">
             <input type="hidden" id="existingImage" name="existingImage" value="${Base64.getEncoder().encodeToString(existingProduct.proImage)}"/>
            </div>
            
            <!-- Allow the user to upload a new image -->
            <div class="form-group"> 
            <label class="font-italic font-weight-bold" for="newProImage">New Product Image:</label>
            <input type="file" class="form-control-file-sm" id="newProImage" name="newProImage" accept="image/*">
            </div>
            
             <div class="form-group">
                <input type="submit" class="btn btn-success"  value="update product" />
            </div>     
      </form>
    </div>
</body>
</html>