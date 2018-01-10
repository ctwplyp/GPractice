<%@ page import="clean.Company" %>



<div class="fieldcontain ${hasErrors(bean: companyInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="company.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${companyInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: companyInstance, field: 'persons', 'error')} ">
	<label for="persons">
		<g:message code="company.persons.label" default="Persons" />
		
	</label>
	<g:select name="persons" from="${clean.Person.list()}" multiple="multiple" optionKey="id" size="5" value="${companyInstance?.persons*.id}" class="many-to-many"/>

</div>

