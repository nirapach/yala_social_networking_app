<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<head>
		<meta charset="UTF-8">
		<link href="css/reset.css" rel="stylesheet" media="screen">
		<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
		<link rel="stylesheet" href="css/profile.css" media="screen">
		<script src="bootstrap.min.js"></script>
		<script src="uilang.js"></script> 
		<title>View Group Members</title>
	</head>
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
						<li><a href="#">Feeds</a></li>
						<li class="active"><a href="#about">Profile</a></li>
					</ul>
				</div><!--/.nav-collapse -->
			</div>
		</nav>
	
		<div class="container">
			<div class="row">
				<div class="col-md-8 col-lg-8 col-sm-12 col-xs-12">
		        	<div class="feeds feeds-nob clearfix">
						<div class="col-md-4 col-lg-4 col-xs-12 col-sm-12 feed-content">
				            <s:form action="getGroup" method="post">
								<s:submit value="Group Home" cssClass="btn btn-primary" />
								<s:hidden name="group.profilePic" value="%{group.profilePic}"></s:hidden>
								<s:hidden name="group.groupName" value="%{group.groupName}"></s:hidden>
								<s:hidden name="group.groupId" value="%{group.groupId}"></s:hidden>
								<s:hidden name="group.creator" value="%{group.creator}"></s:hidden>
								<s:hidden name="group.groupPrivacy" value="%{group.groupPrivacy}"></s:hidden>
							</s:form>
							<br /><br />
							<ul>
								<s:iterator value="group.groupMembers" var="member">
									<li><s:property value="#member.Full_Name" /></li>
								</s:iterator>
							</ul>
						</div>  
					</div>
				</div>
			</div>  
		</div>
	</body>
</html>