function checkpass(){
	var input = document.getElementById("pass");
	var div = document.getElementById("result");
  var regex1 = RegExp('(?=.*[0-9])');
  var regex2 = RegExp('(?=.*[a-z])');
  var regex3 = RegExp('(?=.*[A-Z])');
  var regex4 = RegExp('(?=.*[!@#$%^^&*=+])');
	var count=0;
  if(input.value.length<6){
    div.innerHTML ="mật khẩu phải trên 6 kí tự";
  }else{
	if(regex1.test(input.value)){
		 count++;
	  }
  if(regex2.test(input.value)){
		 count++;
	  }
  if(regex3.test(input.value)){
		 count++;
	  }
  if(regex4.test(input.value)){
		 count++;
	  }
   switch(count){
    case 1:{
      div.innerHTML ="kém ☹";
      break;
      }
    case 2:{
      div.innerHTML ="trung bình ☹";
      break;
    }
      case 3:{
      div.innerHTML ="tốt ☺";
      break;
    }
      case 4:{
      div.innerHTML ="tuyệt vời ☻";
      break;
    }
      
  }
  }
	
}