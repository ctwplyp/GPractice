<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="main"/>
	<title>Create</title>
</head>
<body>
<g:form controller="person" action="save">
	<label>Name: </label>
	<g:textField name="name"/><br/>
	<label>Email: </label>
	<g:textField name="email"/><br/>
	<g:actionSubmit value="Save"/>
</g:form>
</body>
</html>
