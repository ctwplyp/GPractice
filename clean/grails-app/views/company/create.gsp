<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'company.label', default: 'Company')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#create-company" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/company/index')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
	<g:form controller="company" action="save">
		<label>Company Name: </label>
		<g:textField name="name"/><br/>
		<label>People: </label>
		<g:select id="person" from="${persons.name}" value="person" name="person" /><br/>
		<g:actionSubmit value="Save"/>
		<g:actionSubmit value="Cancel"/>
	</g:form>
	</body>
</html>
