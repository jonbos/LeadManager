$(document).ready(function() {
	$("#searchinput").on("keyup", function() {
		var value = $(this).val().toLowerCase();
		$("#leads-table tbody tr").filter(function() {
			$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		});		
	});
});