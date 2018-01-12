<%@ page import="clean.Person" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'person.label', default: 'Person')}" />
		<title><g:message code="default.edit.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#edit-person" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/person/index')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
	<g:form controller="person" action="update">
		<label>Id</label>
		<g:hiddenField name="id" value="${person.id}"/>${person.id}<br/>
		<label>Company Name</label>
		<g:hiddenField name="Company Name:" value="${person.company.name}"/>${person.company.name}<br/>
		<label>Name: </label>
		<g:textField name="name" value ="${person.name}"/><br/>
		<label>Email: </label>
		<g:textField name="email" value ="${person.email}"/><br/>
		<g:actionSubmit value="Update"/>
		<g:actionSubmit value="Cancel"/>
	</g:form>
	</body>
</html>
