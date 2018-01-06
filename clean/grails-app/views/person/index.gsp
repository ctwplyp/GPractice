
<%@ page import="clean.Person" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'person.label', default: 'Person')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<p>Id:		Name:	Email: </p>
		<g:each in="${persons}" var="person" status="i">
			<h3>${i+1}.	${person.name}	${person.email}</h3>
		</g:each>
	</body>
</html>
