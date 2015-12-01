<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <meta charset="UTF-8">
  <link href="css/reset.css" rel="stylesheet" media="screen">
  <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
  <link rel="stylesheet" href="css/profile.css" media="screen">
  <script src="bootstrap.min.js"></script>
  <script src="uilang.js"></script> 
  <title>Yala News Feed Page</title>
  <s:head />
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
            <li class="active"><a href="#">Feeds</a></li>
            <li><a href="WebContent/WEB-INF/pages/Registration/Profile-Settings.jsp">Profile</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>


    <div class="container">
      <div class="row">
        <h3 class="feeds_header">Add Your Primum !!!(What's on Your Mind) </h3>
        <div class="col-md-8 col-lg-8 col-sm-12 col-xs-12">
        <div class="feeds clearfix">
          <div class="col-md-3 col-lg-3 col-sm-3 col-xs-3 author-info">
            <span class="dp">
              <img src="images/0*w69UIswtaar5cSJf.png" alt="">
            </span>
          </div>
          <div class="col-md-9 col-lg-9 col-xs-9 col-sm-9 feed-content">
            <s:form action="refreshfeeds">
   			<s:submit value ="Refresh the Feeds"/></s:form>
   			<s:form action="addNewsfeed">
   			<s:textfield name="username" label="username"/>
   			<s:textfield name="status" label="status" size ="75px"/>
  			 <s:submit/>
   <hr/>
   <table>
      <tr>
         <td>Username</td>
         <td>Status</td>
         <td>DateCreated</td>
      </tr>
      <s:iterator value="newsfeeds">	
         <tr>
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
        <s:form action="logout">
	        				<s:submit value ="Logout"/></s:form>
          <h3 class="">Groups</h3>
          <ul>
            <li><a href="">BTown Pokkiris</a></li>
            <li><a href="">BTown Pokkiris</a></li>
            <li><a href="">BTown Pokkiris</a></li>
            <li><a href="">BTown Pokkiris</a></li>
          </ul>
          <h3 class="">Chat Room</h3>
          <a href="WebContent/WEB-INF/pages/chat.jsp" class="btn btn-primary">Join Chat</a>
          <!--<s:form action="chatpage">
  				 <s:submit value ="Click to Enter Chat" cssClass="btn btn-primary" /> </s:form>-->
        </div>
      </div>  
    </div>
</body>
</html>
