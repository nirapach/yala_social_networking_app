<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
  <meta charset="UTF-8">
  <link href="css/reset.css" rel="stylesheet" media="screen">
  <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
  <link rel="stylesheet" href="css/general.css" media="screen">
  <script src="js/bootstrap.min.js"></script>
  <script src="uilang.js"></script> 
  <script src="js/registration-form-validation.js"></script>
  <title>Welcome to Yala - Login or Sign Up</title>
  <style type="text/css">
  .label {color:blue; font-style:normal; font-weight:bold}
</style>
<head>

<body>
<div class="site-wrapper">

      <div class="site-wrapper-inner">

        <div class="cover-container">

          <div class="masthead clearfix">
            <div class="inner">
              <a href=""><h3 class="masthead-brand">Yala</h3></a>
<!--               <nav>
                <ul class="nav masthead-nav">
                  <li class="active"><a href="#">Home</a></li>
                  <li><a href="#">Features</a></li>
                  <li><a href="#">Contact</a></li>
                </ul>
              </nav> -->
            </div>
          </div>

          <div class="inner cover">
            <h1 class="cover-heading">Welcome to Yala</h1>
            <p class="lead">Lorem ipsum dolor sit amet, consectetur adipisicing elit. In repudiandae ullam exercitationem magnam. Perspiciatis doloribus atque, architecto aut repudiandae, itaque explicabo quis eos eaque totam mollitia tenetur omnis rerum a.</p>
            <p class="lead col-md-6 col-lg-6 col-sm-6 col-xs-12">
              <a class="btn btn-lg btn-success sign-up" href="#">Sign Up</a>
            </p>
            <p class="lead col-md-6 col-lg-6 col-sm-6 col-xs-12 ">
              <a class="btn btn-lg btn-primary sign-in" href="#">Sign In</a>
            </p>
          </div>
		
          <div class="mastfoot">
            <div class="inner">
<!--               <p>Cover template for <a href="http://getbootstrap.com">Bootstrap</a>, by <a href="https://twitter.com/mdo">@mdo</a>.</p> -->
            </div>
          </div>
          <div id=overlay>
            <div id=registration>
              <a href=# class=close>Close</a>
              <h1>Sign Up</h1>
              
<!--               <input placeholder=username class="input"> -->
<!--               <input placeholder="password" class="input" type=password> -->
<!--               <input placeholder="Email" class="input" type=email> -->
<!--               <input placeholder="Full Name" class="input"> -->
<!--               <input placeholder="Date" type="date" class="input"> --> 
					<s:form action="register" method="post">
					
					<s:textfield name="name" label="User Name"  value="" requiredLabel="true" required="true" onKeyPress="return numbersonly(this, event)"/>
					<s:password name="password" label="Password" value="" requiredLabel="true" required="true" onKeyPress="return numbersonly(this, event)"></s:password>
					<s:textfield name="email" label="Email ID"  requiredLabel="true" required="true"></s:textfield>
					<s:textfield name="full_name" label="Full Name"  requiredLabel="true" required="true" onKeyPress="return lettersOnly(this, event)"></s:textfield>
<%--  					<sx:datetimepicker name="date1" label="Format (dd-mm-YYYY)" displayFormat="dd-MM-yyyy" value="todayDate" /> --%>
					<s:textfield name="dob" label="Date Of Birth" requiredLabel="true" required="true" onKeyPress="return dobonly(this, event)"></s:textfield>
					<s:submit  value="Register" ></s:submit> 
					</s:form>
<!--               <a href=# class=confirm>Confirm</a> -->
              </div>
            </div>
            <div id=overlay1>
              <div id=registration1>
                <a href=# class=close>Close</a>
                <h1>Sign In</h1>
                <s:form action="login">
                <s:textfield name="name" label="User Name" value="" requiredLabel="true" required="true" onKeyPress="return numbersonly(this, event)"/>
					<s:password name="password" label="Password"  requiredLabel="true" required="true" onKeyPress="return numbersonly(this, event)"></s:password>
                <s:submit value="Confirm"></s:submit>
                </s:form>
              </div>
            </div>
          </div>
          <code>
          clicking on ".sign-up" adds class "open" on "#overlay"
          clicking on ".close, .confirm" removes class "open1" on "#overlay1"
          clicking on ".close, .confirm" removes class "open" on "#overlay"
          clicking on ".sign-in" adds class "open1" on "#overlay1"
          </code>


        </div>

      </div>

    </div>

</body>
</html>