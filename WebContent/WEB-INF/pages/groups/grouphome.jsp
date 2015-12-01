<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<link href="css/reset.css" rel="stylesheet" media="screen">
		<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
		<link rel="stylesheet" href="css/profile.css" media="screen">
		<script src="bootstrap.min.js"></script>
		<script src="uilang.js"></script> 
		<title>Group Home</title>
	</head>
	<body>
	    <!-- Static navbar -->
		<nav class="navbar navbar-default navbar-static-top navbar-inverse">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" 
	          		  		data-target="#navbar" aria-expanded="false" aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Yala</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li><a href="WebContent/WEB-INF/pages/Newsfeed.jsp">Feeds</a></li>
						<li><a href="WebContent/WEB-INF/pages/Registration/Profile-Settings.jsp">Profile</a></li>
					</ul>
				</div><!--/.nav-collapse -->
			</div>
		</nav>
	
		<div class="container">
			<div class="row">
				<div class="col-md-8 col-lg-8 col-sm-12 col-xs-12">
		        	<div class="feeds feeds-nob clearfix">
						<div class="col-md-4 col-lg-4 col-xs-12 col-sm-12 feed-content">
				            <s:form method="post">
								<div display="inline-block">
									<img src="<s:url action='imageAction?imageName=%{group.profilePic}'/>" width="100" height="100" />
								</div>
								<div display="inline-block">
									<s:label name="groupName" value="%{group.groupName}" />
								</div>
								<s:submit value="Delete Group" action="deleteGroup" align="left" cssClass="btn btn-primary"
										  onclick="return confirm('Are you sure you want to delete the group?');"/>
								<s:submit value="View Members" action="getMembers" align="left" cssClass="btn btn-primary" />
								<s:hidden name="group.profilePic" value="%{group.profilePic}"></s:hidden>
								<s:hidden name="group.groupName" value="%{group.groupName}"></s:hidden>
								<s:hidden name="group.groupId" value="%{group.groupId}"></s:hidden>
								<s:hidden name="group.creator" value="%{group.creator}"></s:hidden>
								<s:hidden name="group.groupPrivacy" value="%{group.groupPrivacy}"></s:hidden>
								<s:hidden name="groupMembers" value="%{groupMembers}"></s:hidden>
							</s:form>
							<s:form action="refreshfeeds">
   			<s:submit value ="Refresh the Feeds"/></s:form>
   			<s:form action="addgroupNewsfeed">
<%--    			<s:textfield name="groupName" label="Groupname"/> --%>
			<s:label name="groupName" value="%{group.groupName}" />	
   			<s:textfield name="username" label="Username"/>
   			<s:textfield name="status" label="Status" size ="75px"/>
  			 <s:submit/>
   <hr/>
   <table>
      <tr>
         <td>Groupname</td>
         <td>Username</td>
         <td>Status</td>
         <td>Date Created</td>
      </tr>
      <s:iterator value="groupnewsfeeds">	
         <tr>
         	<td><s:property value="groupName"/></td>
            <td><s:property value="username"/></td>
            <td><s:property value="status"/></td>
           	<td><s:property value="created"/></td>
           </tr>
      </s:iterator>	
   </table>
   </s:form>
						</div>  
					</div>
				</div>
	
				<div class="col-md-4 col-sm-12 col-lg-4 col-xs-12" id="sidebar">
					<h3 class="">Groups</h3>
						<ul>
							<li><a href="">BTown Pokkiris</a></li>
							<li><a href="">BTown Pokkiris</a></li>
							<li><a href="">BTown Pokkiris</a></li>
							<li><a href="">BTown Pokkiris</a></li>
						</ul>
					<h3 class="">Chat Room</h3>
					<a href="WebContent/WEB-INF/pages/chat.jsp" class="btn btn-primary">Join Chat</a>
				</div>
			</div>  
		</div>
	</body>
</html>