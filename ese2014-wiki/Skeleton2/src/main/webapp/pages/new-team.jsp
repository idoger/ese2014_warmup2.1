<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<c:import url="template/header.jsp" />

Here you can
<h1>Create A New Team</h1>


<form:form method="post" modelAttribute="newTeamForm"
	action="new-team/create" id="newTeamForm" cssClass="form-horizontal"
	autocomplete="off">
	<fieldset>
		<legend></legend>

		<c:set var="teamErrors">
			<form:errors path="team" />
		</c:set>
		<div
			class="control-group<c:if test="${not empty teamErrors}"> error</c:if>">
			<label class="control-label" for="field-team">Choose A Team
				Name</label>

			<div class="controls">
				<form:input path="team" id="field-team" tabindex="1" maxlength="45"
					placeholder="team" />
				<form:errors path="team" cssClass="help-inline" element="span" />
			</div>		
		</div>
		<div class="form-actions">
			<button type="submit" class="btn btn-primary">Create</button>
		</div>
	</fieldset>
</form:form>
<script>
 function goBack() {
     window.history.back()
 }
 </script>
 <body>
<button onclick="goBack()">Go Back</button>  to the User Registration Page
 </body>
 

<c:if test="${page_error != null }">
	<div class="alert alert-error">
		<button type="button" class="close" data-dismiss="alert">&times;</button>
		<h4>Error!</h4>
		${page_error}
	</div>
</c:if>


<c:import url="template/footer.jsp" />
