
<%@ page import="clean.Person" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="main">
	<g:set var="entityName" value="${message(code: 'person.label', default: 'Person')}" />
	<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
<a href="#show-person" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation">
	<ul>
		<li><a class="home" href="${createLink(uri: '/person/index')}"><g:message code="default.home.label"/></a></li>
		<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
		<li><g:link class="list" resource="person" action="edit" id="${person.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link></li>
	</ul>
</div>
<p>Id:		Name:	Email: </p>
	<p><td><g:link resource="person" action="edit" id="${person.id}">${person.id}.	${person.name}	${person.email}</g:link></td></p>
</body>
</html>
