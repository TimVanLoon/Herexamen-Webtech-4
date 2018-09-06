function validate() {

	var firstName = document.getElementById('firstName').value;
	var lastName = document.getElementById('lastName').value;
	var grade = document.getElementById('grade').value;
	
	if (firstName == '') {
		alert('Please enter a valid first name.');
		return false;
	}
	
	if (lastname == '') {
		alert('Please enter a valid last name.');
		return false;
	}
	
}