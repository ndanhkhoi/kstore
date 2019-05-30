function setIdProfileToModal(id, name) {
	document.getElementById("id-profile-modal").value = id;	
	document.getElementById("profile-name-modal").innerHTML = name;	
}

function deleteProfile() {
	var id = document.getElementById("id-profile-modal").value;
	var password = document.getElementById("password-admin").value;
	var  xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var result = this.responseText;
			if (result == "ok"){
				alert("Đã xóa");
				window.location.reload();
			}
			else alert("Bạn đã nhập sai mật khẩu");
		}
	};
	xhttp.open("POST", "../admin-delete", false);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send("id=" + id + "&password=" + password);
}

function setIdProductToModal(id, name) {
	document.getElementById("id-product-modal").value = id;	
	document.getElementById("product-name-modal").innerHTML = name;	
}

function closePhoneAlert(){
	document.getElementById("alert-bg-phone").style.display = "none";
}

function deletePhone() {
	var id = document.getElementById("id-product-modal").value;
	var password = document.getElementById("password-admin").value;
	var  xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var result = this.responseText;
			if (result == "ok"){
				alert("Đã xóa");
				window.location.reload();
			}
			else alert("Bạn đã nhập sai mật khẩu");
		}
	};
	xhttp.open("POST", "admin-delete-phone", false);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send("id=" + id + "&password=" + password);
}

