<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search results</title>
</head>
<body>
<s:form action="approve">
	<table border="1" width="100%">
	<tr>
   <th>Full Name</th>
	</tr>
	<tc>
	<s:iterator value = "searchednamesreceiver">
	
	<td><input type="checkbox" name="name"  value="<s:property />" /><s:property /></td>
	<%-- </s:textfield>--%>
	</tc>
	</s:iterator></table>
	<s:submit value="Add Friends"/>
	<s:submit action = "reject" value = "Reject"/>

</s:form>
</body>
</html>