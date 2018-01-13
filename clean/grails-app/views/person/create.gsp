<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="main"/>
	<title>Create</title>
	<g:set var="entityName" value="${message(code: 'person.label', default: 'Person')}" />
</head>
<body>
<div class="nav" role="navigation">
	<ul>
		<li><a class="home" href="${createLink(uri: '/person/index')}"><g:message code="default.home.label"/></a></li>
		<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
		<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
	</ul>
</div>
<g:form controller="person" action="save">
	<label>Name: </label>
	<g:textField name="name"/><br/>
	<label>Email: </label>
	<g:textField name="email"/><br/>
	<g:select id="company.id" from="${companys}" value="${companys.name}" name="companyId" /><br/>
	<g:actionSubmit value="Save"/>
	<g:actionSubmit value="Cancel"/>
</g:form>

</body>
</html>
