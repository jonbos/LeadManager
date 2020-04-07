$(document).ready(
		function() {
			$('#lead-form').submit(
					function() {
						if ($.trim($("#lead-phone-number").val()) === ""
								&& $.trim($("#lead-email").val()) === "") {					
							
							$('#lead-email').parent().append("<p class='help is-danger'>You must supply at least one contact method</p>");
							$('#lead-phone-number').parent().append("<p class='help is-danger'>You must supply at least one contact method</p>");

							$("#lead-email").addClass("is-danger");
							$("#lead-phone-number").addClass("is-danger");
							return false;
						}
						;
					});
		});
