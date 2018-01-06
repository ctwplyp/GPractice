
<%@ page import="clean.Person" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'person.label', default: 'Person')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		id:   <g:fieldValue  bean="${person}" field="id"/><br/>
		name: <g:fieldValue  bean="${person}" field="name"/><br/>
		email:<g:fieldValue  bean="${person}" field="email"/><br/>
	</body>
</html>
