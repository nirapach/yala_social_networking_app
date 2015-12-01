<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search</title>
</head>
<body>
Friend request has been given
<s:form action="Search">
<s:textfield name="name" label="UserName"></s:textfield>

<%-- <s:radio list="{'male','female'}" name="gender"></s:radio> --%>
<%-- <s:select cssStyle="width:155px;" list="{'india','pakistan','nepal','bhutan'}" name="country" label="Country"></s:select> --%>

<s:submit value="register"></s:submit>
</s:form>

</body>
</html>