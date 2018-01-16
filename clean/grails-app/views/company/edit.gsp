<%@ page import="clean.Company" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'company.label', default: 'Company')}" />
		<title><g:message code="default.edit.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#edit-company" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="edit-company" class="content scaffold-edit" role="main">
			<h1><g:message code="default.edit.label" args="[entityName]" /></h1>
			<g:form controller="Company" action="update">
				<label>Id</label>
				<g:textField name="id" value="${company.id}"/><br/>
				<label>Company Name</label>
				<g:textField name="name" value="${company.name}"/><br/>
				<label>Employee Names: </label>
				<g:each in="${company.persons}" var="person">
					<g:hiddenField name="persons" value ="${person.name}"/>${person.name} ,
				</g:each> <br/>
				<g:actionSubmit value="Update"/>
				<g:actionSubmit value="Cancel"/>
			</g:form>
		</div>
	</body>
</html>
