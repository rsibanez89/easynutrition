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

function dateFormat(value) {
	return $.datepicker.formatDate("yy-mm-dd", new Date(value));
}

function dataTableI18N() {
	var tablei18n = {
		es : '//cdn.datatables.net/plug-ins/1.10.7/i18n/Spanish.json',
		en : '//cdn.datatables.net/plug-ins/1.10.7/i18n/English.json'
	};

	return tablei18n[locale];
}

/**
 * Creates data table
 * 
 * @param id HTML table id
 * @param url REST url
 * @param columns Columns data
 * @param columnsFilter Columns to filter
 * @returns
 */
function dataTableCreate(id, url, columns, columnsFilter) {
	return $(id).DataTable({
		processing: true,
		serverSide: true,
		ajax: {
			url: absoluteUrl(url),
			data: {
				columnsFilter: columnsFilter
			}
		},
		language: {
			url: dataTableI18N()
		},
		columns: columns,
		scrollX: true
	});
}