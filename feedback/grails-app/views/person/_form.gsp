<%@ page import="feedback.Person" %>



<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="person.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${personInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'email', 'error')} required">
	<label for="email">
		<g:message code="person.email.label" default="Email" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="email" required="" value="${personInstance?.email}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'companys', 'error')} required">
	<label for="companys">
		<g:message code="person.companys.label" default="Companys" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="companys" name="companys.id" from="${feedback.Company.list()}" optionKey="id" required="" value="${personInstance?.companys?.id}" class="many-to-one"/>

</div>

