\<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
  <title>Profile Setting Page</title>
</head>
<body>
    <!-- Static navbar -->
    <nav class="navbar navbar-default navbar-static-top navbar-inverse">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
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
            <li class="active"><a href="#about">Profile</a></li>
            <li>
			<s:form action="checkfriends">
			<s:submit value="Get Notification" cssClass="btn btn-primary"></s:submit>
			</s:form> </li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>


    <div class="container">
      <div class="row">
        <h3 class="feeds_header">Welcome, <s:property value="%{loggedUser.Full_Name}"/></h3>
        <div class="col-md-8 col-lg-8 col-sm-12 col-xs-12">
        <div class="feeds feeds-nob clearfix">
          <div class="col-md-4 col-lg-4 col-xs-12 col-sm-12 feed-content">
            <s:form action="uploadFiles" enctype="multipart/form-data" method="post">
				<s:hidden name="id" value="%{loggedUser}" />
				
				<%-- 	<img src="<s:url action='imageaction?imageName="%{name}+.jpg"'/>" width="300" height="300" /> --%>
				<img src="<s:url action='imageAction?imageName=%{uploadFileFileName}.jpg'/>" width="200" height="200"/>
					<s:file name="uploadFile" size="10" />
					<s:submit value="Upload" align="left" cssClass="btn btn-primary"/>
			</s:form>
          </div>  
           <div class="col-md-8 col-lg-8 col-xs-12 col-sm-12 feed-content">
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
          <h3 class="">Search for Friends</h3>
           <s:form action="Search">
				<s:textfield name="name" font-size="20" label="Friend Name"></s:textfield>
				<s:submit value="Search" cssClass="btn btn-primary"></s:submit>
				</s:form>
          <h3 class="">Chat Room</h3>
          <a href="WebContent/WEB-INF/pages/chat.jsp" class="btn btn-primary">Join Chat</a>
        </div>
      </div>  
    </div>
</body>
</html>





<body>



</body>

</html>