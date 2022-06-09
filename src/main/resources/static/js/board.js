function showModal(id) {
	$.ajax({
		url: "/view/"+id,
		success: function(data) {
			$("#modal-shell").html(data);
			$('#modal-block').modal('show');

		}
	});
	

}