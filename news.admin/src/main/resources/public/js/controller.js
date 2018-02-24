function get(url) {
	$("#main").load(url, function(response){
		init();
		$('.dataTable').each ( function () { $(this).dataTable().fnDraw(); });
	});
}

$().ready(function() {
	$.ajaxSetup({
		timeout : 10000
	});
});
