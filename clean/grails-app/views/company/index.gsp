
<%@ page import="clean.Company" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'company.label', default: 'Company')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-company" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-company" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="id" title="${message(code: 'company.id.label', default: 'Id')}" />
						<g:sortableColumn property="name" title="${message(code: 'company.name.label', default: 'Company Name')}" />
						<g:sortableColumn property="name" title="${message(code: 'person.name.label', default: 'People')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${companys}" status="i" var="company">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${company.id}">${fieldValue(bean: company, field: "id") }</g:link></td>
						<td>
							<g:link action="show" id="${company.id}">${fieldValue(bean: company, field: "name") }</g:link>
						</td>
						<td>
							<g:each in="${company.persons}" var ="person">
								<g:link action="show" id="${person.id} ">${fieldValue(bean: person, field: "name")}</g:link>
							</g:each>
						</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${companyCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
