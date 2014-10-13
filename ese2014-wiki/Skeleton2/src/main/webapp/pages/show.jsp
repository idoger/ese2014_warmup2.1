<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:import url="template/header.jsp" />

<h1>${user.firstName} ${user.lastName}, your sign up is complete! </h1>

<c:if test="${not empty user }" > 
 
  
<p><b>ID: </b>${user.id}</p> 
<p><b>First Name: </b>${user.firstName}</p> 
<p><b>Last Name: </b>${user.lastName}</p> 
<p><b>Email: </b>${user.email}</p>  
<p><b>Team: </b>${user.team.team}<c:if test="${empty user.team}">N/A</c:if></p>

</c:if> 


<c:if test="${page_error != null }">
	<div class="alert alert-error">
		<button type="button" class="close" data-dismiss="alert">&times;</button>
		<h4>Error!</h4>
		${page_error}
		
	</div>
	
</c:if>

<c:import url="template/footer.jsp" />