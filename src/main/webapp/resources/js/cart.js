function adjust(id, inc) {
	if (document.getElementById("number-"+id).innerHTML == 1 && !inc) alert("Số lượng đã tối thiểu");
	else
	if (document.getElementById("number-"+id).innerHTML == 10 && inc) alert("Số lượng đã tối đa");
	else
	{
	 	var xmlhttp = new XMLHttpRequest();
	    xmlhttp.onreadystatechange = function() {
	        if (this.readyState == 4 && this.status == 200) {
	        	 if (this.responseText != "error")
	           	 {
	        		 text = this.responseText;
	        		 i = text.indexOf(" ");
  	            	 document.getElementById("number-"+id).innerHTML = text.substring(0, i);
	        	 	 document.getElementById("totalPrice").innerHTML = text.substring(i+1);
	        		 
	        	 }
	        }
	    };
	    if (inc)
	    	xmlhttp.open("GET", "customer-adjust-cart?id=" + id + "&inc=true", false);
	    else
	    	xmlhttp.open("GET", "customer-adjust-cart?id=" + id + "&inc=false", false);
	    xmlhttp.send();
	}
}
