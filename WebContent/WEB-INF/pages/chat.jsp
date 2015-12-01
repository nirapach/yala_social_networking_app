<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- <!DOCTYPE html>
<html>
<head>
<title>Click to Join in the Chat Room</title>
<s:head />
</head>
<body>
<s:form action="application" >
<s:textfield name="username" label="username"/>
<s:submit value ="Click to Join Chat"/>
</s:form>
</body>
</html> -->
<!DOCTYPE html>
<html>
<head>
<title>Click to Join in the Chat Room</title>
</head>
<body>
<form action="/WEB-INF/pages/application.jsp" method="POST">
<input type="text" name="username">
<input type="submit" value="Join">
</form>
</body>
</html>