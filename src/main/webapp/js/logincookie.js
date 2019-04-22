function createCookie(){
    var name=getElementById("useremail").value;
    var password=getElementById("password").value;
        document.cookie="useremail="+name+";password="+password+";";
        document.write( document.cookie);
}

function getookie(){
//    var cookie=document.cookie;
//
//    for(var i=0; i<cookie.length; i++) {
//       name = cookie[i].split('=')[0];
//       cvalue = cookie[i].split('=')[1];
//    }
//       document.getElementById("userName").value=cvalue;
// 
	var allcookies=document.cookie;
	 cookiearray = allcookies.split(';');
     
     // Now take key value pair out of this array
     for(var i=0; i<cookiearray.length; i++) {
        name = cookiearray[i].split('=')[0];
        value = cookiearray[i].split('=')[1];
      //  document.write ("Key is : " + name + " and Value is : " + value);
       if (cookiearray[i].split('=')[0]=="useremail"){
        document.getElementById("useremail").value=value;
       }
       else if(cookiearray[i].split('=')[0]=="password"){
           document.getElementById("password").value=value;

       }
     }
}