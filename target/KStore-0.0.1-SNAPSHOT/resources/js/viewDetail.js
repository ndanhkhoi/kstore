function provinceChoose(id)
{
    xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            var a = document.getElementById("district");
            a.innerHTML = this.responseText; 
            var district_id = document.getElementById("district").value;
            districtChoose(district_id);
        }
    };
    xhttp.open("GET", url + "districtList?province_id="+id, false);
    xhttp.send();      
}

function districtChoose(id)
{
    xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            var a = document.getElementById("ward");
            a.innerHTML = this.responseText; 
        }
    };
    xhttp.open("GET", url + "wardList?district_id="+id, false);
    xhttp.send();      
}

window.onload = function()
{
    var province_id = document.getElementById("province").value;
    url = document.getElementById("realUrl").value;
    provinceChoose(province_id);
    
    var district = document.getElementById("district");
    var idDistrict = document.getElementById("idDistrict").value;
    var districtOptions = document.getElementById("district").options;
    getTrueAddress(district, districtOptions, idDistrict);
    districtChoose(idDistrict);
    		
    var ward = document.getElementById("ward");
    var idWard = document.getElementById("idWard").value;
    var wardOptions = document.getElementById("ward").options;
    getTrueAddress(ward, wardOptions, idWard);
};

function getTrueAddress(select ,options, id){
    for (var index = 0; index < options.length; index++){
    	if (options[index].value == id){
    		select.selectedIndex = index;
    	}
    } 	
}

function resetPassword(path) {
    var pass1 = document.forms["reset-password"]["newpass"].value;   
    var pass2 = document.forms["reset-password"]["repass"].value;   
    if (validatePassword(pass1, pass2)){
    	var form = document.forms.namedItem("reset-password");
    	var formData = new FormData(form);
    	var  xhttp = new XMLHttpRequest();
    	xhttp.onreadystatechange = function() {
    		if (this.readyState == 4 && this.status == 200) {
    			if (this.responseText == "ok")
				{
    				alert("Thành công");
        			window.location.reload();
				}
    			else alert("Sai mật khẩu!!");
    		}
    	};
    	xhttp.open("POST", path, false);
    	xhttp.send(formData);
    }
}

function validatePassword(pass1, pass2){
	if (pass1 != pass2) {
		alert("Xác nhận mật khẩu sai");
		return false;
	}
    var passcheck1 = /([A-Za-z][0-9]|[0-9][A-Za-z])+/;  //phai co ca chu cai va so
    var passcheck2 = /.{6,15}/;     //dai  6 - 15 ky tu
    if (pass1 == null || pass1 == "")
    {
        alert("Mật khẩu không được để trống");
        return false;
    }
    else if (! (passcheck1.test(pass1) && passcheck2.test(pass1) ) )
    {
        alert ("Mật khẩu phải có cả chữ cái và số; dài từ 6 đến 15 ký tự.");
        return false;
    }
    return true;
}
