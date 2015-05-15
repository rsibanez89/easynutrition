$(function() {
	// create date picker
	$('#birthday').datetimepicker({
		format: 'DD/MM/YYYY',
		viewMode : 'years'
	});

	// set focus
	$('#name').focus();
});