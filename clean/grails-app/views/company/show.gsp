
<%@ page import="clean.Company" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'company.label', default: 'Company')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-company" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-company" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list company">

				<g:if test="${company?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="company.name.label" default="Id : " /></span>
					<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${company}" field="id"/></span>
					<span id="name-label" class="property-label"><g:message code="company.name.label" default="Name : " /></span>
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${company}" field="name"/></span>
				</li>
				</g:if>
				<g:if test="${company?.persons}">
				<li class="fieldcontain">
					<span id="persons-label" class="property-label"><g:message code="company.persons.label" default="People : " /></span>
						<g:each in="${company.persons}" var="person">
								<g:link controller="person" action="show" id="${person.id}">${fieldValue(bean: person, field: "name")}</g:link>
						</g:each>

				</li>
				</g:if>

			</ol>
			<g:form url="[resource:companyInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${companyInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
