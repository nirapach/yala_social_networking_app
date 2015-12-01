/**
 * 
 */
// Below Function Executes On Form Submit
function ValidationEvent() {
	// Storing Field Values In Variables
	alert("Error: Username cannot be blank!");
	var name = document.getElementById("name").value;
	var email = document.getElementById("email").value;
	var pwd1 = document.getElementById("password").value;
	var f_name = document.getElementById("full_name").value;
	var date = document.getElementById("dob").value;
	
	    if(name == "" || f_name == "") {
	      alert("Error: Username cannot be blank!");
	      return false;
	    }
	    re = /^\w+$/;
	    if(!re.test(name)) {
	      alert("Error: Username must contain only letters, numbers and underscores!");
	      return false;
	    }

	    if(pwd1 != "" ) {
	      if(form.pwd1.value.length < 6) {
	        alert("Error: Password must contain at least six characters!");
	        form.pwd1.focus();
	        return false;
	      }
	      if(pwd1 == name) {
	        alert("Error: Password must be different from Username!");
	        form.pwd1.focus();
	        return false;
	      }
	      re = /[0-9]/;
	      if(!re.test(pwd1)) {
	        alert("Error: password must contain at least one number (0-9)!");
	        form.pwd1.focus();
	        return false;
	      }
	      re = /[a-z]/;
	      if(!re.test(pwd1)) {
	        alert("Error: password must contain at least one lowercase letter (a-z)!");
	        form.pwd1.focus();
	        return false;
	      }
	      re = /[A-Z]/;
	      if(!re.test(pwd1)) {
	        alert("Error: password must contain at least one uppercase letter (A-Z)!");
	        form.pwd1.focus();
	        return false;
	      }
	    } else {
	      alert("Error: Please check that you've entered !");
	      form.pwd1.focus();
	      return false;
	    }
	    if(date != "")
	    {
	    	if(!checkdate(date))
	    		return false;
	    }
//	    alert("You entered a valid password: " + form.pwd1.value);
//	    return true;
	    var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
		// Conditions
		if (name != '' && email != '' && contact != '') {
			if (email.match(emailReg)) {
			} else {
				alert("Invalid Email Address...!!!");
				return false;
			}
		} else {
			alert("All fields are required.....!");
			return false;
		}
		return true;
	//var contact = document.getElementById("contact").value;
	// Regular Expression For Email
	
}
function ValidatePassword(uemail) {
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	if (uemail.value.match(mailformat)) {
		return true;
	} else {
		alert("You have entered an invalid email address!");
		uemail.focus();
		return false;
	}
}
function ValidateEmail(uemail) {
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	if (uemail.value.match(mailformat)) {
		return true;
	} else {
		alert("You have entered an invalid email address!");
		uemail.focus();
		return false;
	}
}

function allLetter(uname) {
	var letters = /^[A-Za-z]+$/;
	if (uname.match(letters)) {
		return true;
	} else {
		alert('Username must have alphabet characters only');
		uname.focus();
		return false;
	}
}
function checkdate(input){
	var validformat=/^\d{2}\/\d{2}\/\d{4}$/ ;//Basic check for format validity
	var returnval=false;
	if (!validformat.test(input.value))
	alert("Invalid Date Format. Please correct and submit again.");
	else{ //Detailed check for valid date ranges
	var monthfield=input.value.split("/")[0];
	var dayfield=input.value.split("/")[1];
	var yearfield=input.value.split("/")[2];
	var dayobj = new Date(yearfield, monthfield-1, dayfield);
	if ((dayobj.getMonth()+1!=monthfield)||(dayobj.getDate()!=dayfield)||(dayobj.getFullYear()!=yearfield))
	alert("Invalid Day, Month, or Year range detected. Please correct and submit again.");
	else
	returnval=true;
	}
	if (returnval==false) input.select();
	return returnval;
	}
function numbersonly(myfield, e, dec)
{
var key;
var keychar;

if (window.event)
   key = window.event.keyCode;
else if (e)
   key = e.which;
else
   return true;
keychar = String.fromCharCode(key);

// control keys
if ((key==null) || (key==0) || (key==8) || 
    (key==9) || (key==13) || (key==27) )
   return true;

// numbers
else if ((("abcdefghijklmnopqrstuvwxyz0123456789").indexOf(keychar) > -1))
   return true;

// decimal point jump
else if (dec && (keychar == "."))
   {
   myfield.form.elements[dec].focus();
   return false;
   }
else
   return false;
}

// copyright 1999 Idocs, Inc. http://www.idocs.com
function dobonly(myfield, e, dec)
{
var key;
var keychar;

if (window.event)
   key = window.event.keyCode;
else if (e)
   key = e.which;
else
   return true;
keychar = String.fromCharCode(key);

// control keys
if ((key==null) || (key==0) || (key==8) || 
    (key==9) || (key==13) || (key==27) )
   return true;

// numbers
else if ((("/0123456789").indexOf(keychar) > -1))
   return true;

// decimal point jump
else if (dec && (keychar == "."))
   {
   myfield.form.elements[dec].focus();
   return false;
   }
else
   return false;
}
function lettersOnly(myfield, e, dec)
{
var key;
var keychar;

if (window.event)
   key = window.event.keyCode;
else if (e)
   key = e.which;
else
   return true;
keychar = String.fromCharCode(key);

// control keys
if ((key==null) || (key==0) || (key==8) || 
    (key==9) || (key==13) || (key==27) )
   return true;

// numbers
else if ((("abcdefghijklmnopqrstuvwxyzQWERTYUIOPASDFGHJKLZXCVBNM ").indexOf(keychar) > -1))
   return true;

// decimal point jump
else if (dec && (keychar == "."))
   {
   myfield.form.elements[dec].focus();
   return false;
   }
else
   return false;
}