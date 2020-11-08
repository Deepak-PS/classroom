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

	$.ajax({
		type: "GET",
		url: "http://localhost:8080/get",
		headers: {
			'Accept': 'application/json',
			'Content-Type': 'application/json'
		},
		success: function(data) {
			for (x in data) {
				$("#nList").append("<ul style='display: inline-block;'><li> Title: " + data[x].title + "</li><li> Body: " + data[x].body + "</li></ul");
			}
		}
	});
});