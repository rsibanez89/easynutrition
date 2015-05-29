(function($) {
	"use strict";
	var mainApp = {

		main_fun : function() {
			/*
			 * ==================================== LOAD APPROPRIATE MENU BAR
			 * ======================================
			 */
			$(window).bind("load resize", function() {
				if ($(this).width() < 768) {
					$('div.sidebar-collapse').addClass('collapse');
				} else {
					$('div.sidebar-collapse').removeClass('collapse');
				}
			});
		}

	};

	// Initializing ///
	$(document).ready(function() {
		mainApp.main_fun();
	});

}(jQuery));

/*
 * GENERAL UTILITY FUNCTIONS
 */
function absoluteUrl(relativeUrl) {
	return baseUrl + "/" + relativeUrl;
}