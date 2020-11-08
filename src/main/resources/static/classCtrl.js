/**
 * 
 */
$(document).ready(function() {

	$.ajax({
		type: "GET",
		url: "http://localhost:8080/welcomeData",
		headers: {
			'Accept': 'application/json',
			'Content-Type': 'application/json'
		},
		success: function(data) {
			$("#notifications").text(data.message);
		}
	});

	$('#send').click(function() {
		$.ajax({
			type: "POST",
			url: "http://localhost:8080/note",
			data: JSON.stringify({ "title": $('#title').val(), "body": $('#body').val() }),
			headers: {
				'Accept': 'application/json',
				'Content-Type': 'application/json'
			},
			success: function() {
				alert("Success!");
			}
		});
	});
});
