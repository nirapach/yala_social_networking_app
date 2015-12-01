<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<s:form action="addGroup" method="post" >
		<s:textfield label="Group Name" name="group.groupName" />
		<s:radio label="Privacy" value="defaultPrivacySetting" name="group.groupPrivacy"
				 list="privacy" listKey="key" listValue="value" />
		<s:submit />
		<s:submit action="returnHome" value="Cancel" />
	</s:form>
</html>