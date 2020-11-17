	function mapForm()
	{
		document.getElementById("mapUser").value = Cookies.get('username');
		document.getElementById("mapPass").value = Cookies.get('password');
		return true;
	}
	
	function profileForm()
	{
		document.getElementById("profileUser").value = Cookies.get('username');
		document.getElementById("profilePass").value = Cookies.get('password');
	}
	
	function messagesForm()
	{
		document.getElementById("messagesUser").value = Cookies.get('username');
		document.getElementById("messagesPass").value = Cookies.get('password');
	}
	
	function searchForm()
	{
		document.getElementById("searchUser").value = Cookies.get('username');
		document.getElementById("searchPass").value = Cookies.get('password');
	}