$(function() {
	// create date picker
	$('#birthday').datetimepicker({
		format: 'DD/MM/YYYY',
		viewMode : 'years'
	});

	// set focus
	var control = $("span[id$=errors]:first").siblings().last();
	control = control.length == 0 ? $("#firstName") : control[0];
	control.focus();
});