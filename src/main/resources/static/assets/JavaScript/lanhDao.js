$(document).ready(function() {
	// --------------------------------------------NEW
	initialTable();
	$('#tbl_datatables_lanhDao').DataTable().ajax.reload();

	$('#search').keyup(function(e) {
		var code = e.key;
		if (code === "Enter") {
			loadInfor();
		}
	});
	// sự kiện click 1 row tại table
	var table = $('#tbl_datatables_lanhDao').DataTable();
	$('#tbl_datatables_lanhDao tbody').on('click', 'tr', function() {
		if ($(this).children().hasClass('dataTables_empty')) {
			return;
		}
		var data = table.row(this).data();
		showModal(data);
	});
});
	function initialTable() {

		// Define Columns
		var columns = [ {
			data : 'soHieuCAND'
		}, {
			data : 'hoTen'
		}, {
			data : 'sdt'
		}, {
			data : 'nhanHieu'
		}, {
			data : 'soLuong'
		}, {
			data : 'lyDo'
		}, {
			data : 'maMuon'
		} ];

		// Create DataTable
		createDataTableCommon();
		$('#tbl_datatables_lanhDao').DataTable(
				{
					'columns' : columns,
					'columnDefs' : [ {
						'targets' : [ 0 ],
						'searchable' : false,
						'orderable' : false
					}, {
						'targets' : [ 1 ],
						'searchable' : false,
						'orderable' : false
					}, {
						'targets' : [ 2 ],
						'searchable' : false,
						'orderable' : false
					}, {
						'targets' : [ 3 ],
						'searchable' : false,
						'orderable' : false
					}, {
						'targets' : [ 4 ],
						'searchable' : false,
						'orderable' : false
					}, {
						'targets' : [ 5 ],
						'searchable' : false,
						'orderable' : false
					}, {
						'targets' : [ 6 ],
						'searchable' : false,
						'orderable' : false,
						'visible' : false
					} ],
					'order' : [ [ 1, "ASC" ] ],
					'ajax' : {
						'url' : baseUrl + 'api/LanhDao/search',
						'contentType' : 'application/json',
						'type' : 'GET',
						'data' : function(d) {

							// set search keyword to parameter
							d.timKiem = $('#timKiem').val();
						},
						'complete' : function(response) {
							checkDataTable('tbl_datatables_lanhDao',
									response.responseJSON.recordsTotal);
						},
						'error' : function(xhr) {
							handleApiError(xhr);
						}
					}
				});
		checkDataTable('tbl_datatables_lanhDao', 0);
	}
	function showModal(data) {
		$("body").addClass("modal-open");
		var obj = document.getElementById('js-modal-detail');
		obj.classList.add('open');
		$('#soHieuCAND').val(data.soHieuCAND);
		$('#hoTen').val(data.hoTen);
		$('#sdt').val(data.sdt);
		$('#nhanHieu').val(data.nhanHieu);
		$('#soLuong').val(data.soLuong);
		$('#lyDo').val(data.lyDo);
		$('#maMuon').val(data.maMuon);
	}
	function hideModal() {
		var obj = document.getElementById('js-modal-detail');
		obj.classList.remove('open');
		$("body").removeClass("modal-open");
	}
	
function timKiem() {
	$('#tbl_datatables_lanhDao').DataTable().ajax.reload();
}
function pheDuyet() {
	$.ajax({
		url : baseUrl + 'api/LanhDao/duyetMuon',
		contentType : "application/json",
		type : "GET",
		dataType : 'json',
		data : {
			maMuon : $('#maMuon').val()
		},
		success : function(data) {
				handleMessageResponse(data);
				hideModal();
				timKiem();
		},
		error : function(xhr) {
			showPopupCommon('error', 'Exception', null);
		}
	});
}
function tuChoi() {
	$.ajax({
		url : baseUrl + 'api/LanhDao/tuChoi',
		contentType : "application/json",
		type : "GET",
		dataType : 'json',
		data : {
			maMuon : $('#maMuon').val()
		},
		success : function(data) {
				handleMessageResponse(data);
				hideModal();
				timKiem();
		},
		error : function(xhr) {
			showPopupCommon('error', 'Exception', null);
		}
	});
}