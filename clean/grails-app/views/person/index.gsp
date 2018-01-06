
<%@ page import="clean.Person" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'person.label', default: 'Person')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		id:   <g:fieldValue  bean="${person1}" field="idp"/><br/>
		name: <g:fieldValue  bean="${person1}" field="name"/><br/>
		email:<g:fieldValue  bean="${person1}" field="email"/><br/>
		id:   <g:fieldValue  bean="${person2}" field="idp"/><br/>
		name: <g:fieldValue  bean="${person2}" field="name"/><br/>
		email:<g:fieldValue  bean="${person2}" field="email"/><br/>
		id:   <g:fieldValue  bean="${person3}" field="idp"/><br/>
		name: <g:fieldValue  bean="${person3}" field="name"/><br/>
		email:<g:fieldValue  bean="${person3}" field="email"/><br/>
		age:   <g:fieldValue  bean="${person3}" field="age"/><br/>
	</body>
</html>
