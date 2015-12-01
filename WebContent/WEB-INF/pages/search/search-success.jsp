<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Results</title>
<s:head/>
</head>
	<s:form action="save">
		<table border="1" width="100%">
			<tr>
		   		<td>Full Name</td>
		   	</tr>
		   	<tr>
				<s:iterator value="searchednames" var="names">
					<td><input type="checkbox" name="name"  value="<s:property value='#names'/>" /><s:property /></td>
				</s:iterator>
			</tr>
		</table>
		<s:submit value="Add Friends"></s:submit>
	</s:form>
</html>