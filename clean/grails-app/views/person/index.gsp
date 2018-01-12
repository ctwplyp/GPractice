
<%@ page import="clean.Person" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'person.label', default: 'Person')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
	<div class="nav" role="navigation">
		<ul>
			<li><a class="home" href="${createLink(uri: '/person/index')}"><g:message code="default.home.label"/></a></li>
			<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
			<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
		</ul>
	</div>
		<p>Id:		Name:	Email:	Company: </p>
		<g:each in="${persons}" var="person">
			<p><td><g:link resource="person" action="show" id="${person.id}">${person.id}.	${person.name}	${person.email} ${person.company.name}</g:link></td></p>
		</g:each>
	</body>
</html>
