var notExisted = "";
var hostname = document.getElementById("contentPath").innerHTML;

function validate()
{
    var usercheck = /^[A-Za-z]{1}[A-Za-z0-9]{5,14}$/;
    var passcheck1 = /([A-Za-z][0-9]|[0-9][A-Za-z])+/;  //phai co ca chu cai va so
    var passcheck2 = /.{6,15}/;     //dai  6 - 15 ky tu
    var user = document.forms["my-form"]["USERNAME"].value;
    var a = document.getElementById("usercheck");
    var pass = document.forms["my-form"]["PASSWORD"].value;  
    var b = document.getElementById("passcheck");
    var repass = document.forms["my-form"]["PASSWORD2"].value;  
    var c = document.getElementById("passcheck2");
    var hoten = document.forms["my-form"]["HOTEN"].value;  
    var d = document.getElementById("namecheck");
    var ngaysinh = document.forms["my-form"]["NGAYSINH"].value;  
    var e = document.getElementById("daycheck");
    var sdt = document.forms["my-form"]["SDT"].value;  
    var f = document.getElementById("telcheck");
    var cmnd = document.forms["my-form"]["CMND"].value;  
    var g = document.getElementById("idcheck");
    var avt = document.forms["my-form"]["AVT"].value;  
    var h = document.getElementById("avtcheck");

    var check = true;
    if (user === null || user === "")
    {
        a.innerHTML = "Tên đăng nhập không được để trống";
        a.style.color = "red";
        a.style.fontSize = "12px";
        check = false;
    }
    else if (!usercheck.test(user) )
        {
            a.innerHTML = "Tên đăng nhập bắt đầu phải là chữ cái, theo sau có thể là chữ cái hoặc là số; dài từ 6 đến 15 ký tự.";
            a.style.color = "red";
            a.style.fontSize = "12px";
            check = false;            
        }
    else {
    	existedUser(user);
    	if (notExisted == "false") 
    	{
	       a.innerHTML = "Tên đăng nhập này đã được sủ dụng";
           a.style.color = "red";
           a.style.fontSize = "12px";
           check = false;         
    	}
        else
        {
            a.innerHTML = "";
        }	
    }
    if (pass === null || pass === "")
    {
        b.innerHTML = "Mật khẩu không được để trống";
        b.style.color = "red";
        b.style.fontSize = "12px";
        check = false;
    }
    else if (! (passcheck1.test(pass) && passcheck2.test(pass) ) )
        {
            b.innerHTML = "Mật khẩu phải có cả chữ cái và số; dài từ 6 đến 15 ký tự.";
            b.style.color = "red";
            b.style.fontSize = "12px";
            check = false;            
        }
    else
    {
        b.innerHTML = "";
    }
    if (repass != pass)
    {
        c.innerHTML = "2 mật khẩu phải giống nhau";
        c.style.color = "red";
        c.style.fontSize = "12px";
        check = false;
    }
    else
    {
        c.innerHTML = "";
    }
    if (hoten === null || hoten === "")
    {
        d.innerHTML = "Họ tên không được để trống";
        d.style.color = "red";
        d.style.fontSize = "12px";
        check = false;
    }
    else
    {
        d.innerHTML = "";
    }
    if (ngaysinh === null || ngaysinh === "")
    {
        e.innerHTML = "Ngày sinh không được để trống";
        e.style.color = "red";
        e.style.fontSize = "12px";
        check = false;
    }
    else
    {
        e.innerHTML = "";
    }
    if (sdt === null || sdt === "")
    {
        f.innerHTML = "Số điện thoại không được để trống";
        f.style.color = "red";
        f.style.fontSize = "12px";
        check = false;
    }
    else
    {
        f.innerHTML = "";
    }
    if (cmnd === null || cmnd === "")
    {
        g.innerHTML = "Hình đại diện không được để trống";
        g.style.color = "red";
        g.style.fontSize = "12px";
        check = false;
    }
    else
    {
        g.innerHTML = "";
    }
    if (avt === null || avt === "")
    {
        h.innerHTML = "Hình đại diện không được để trống";
        h.style.color = "red";
        h.style.fontSize = "12px";
        check = false;
    }
    else
    {
        h.innerHTML = "";
    }
   return check;
}

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
    xhttp.open("GET", hostname + "/districtList?province_id="+id, true);
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
    xhttp.open("GET", hostname + "/wardList?district_id="+id, true);
    xhttp.send();      
}

function existedUser(user)
{
    xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
        	notExisted = this.responseText; 
        }
    };
    xhttp.open("GET", hostname + "/existedUser?user="+user, false);
    xhttp.send();    
}

window.onload = function()
{
	xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            var a = document.getElementById("province");
            a.innerHTML = this.responseText; 
            var province_id = document.getElementById("province").value;
            provinceChoose(province_id);
        }
    };
    xhttp.open("GET", hostname + "/provinceList", true);
    xhttp.send();      
};
