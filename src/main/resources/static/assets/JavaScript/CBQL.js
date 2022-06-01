var modeSearch;
$(document).ready(function() {
	// --------------------------------------------NEW
	initialTableQL();
	initialTableMuon();
	initialTableTra();
	$('#tbl_datatables_vk').DataTable().ajax.reload();
	$('#tab-ql').click(function() {
		$('#tbl_datatables_vk').DataTable().ajax.reload();
	});
	$('#tab-muon').click(function() {
		$('#tbl_datatables_muon').DataTable().ajax.reload();
	});
	$('#tab-tra').click(function() {
		$('#tbl_datatables_tra').DataTable().ajax.reload();
	});

	$('#search').keyup(function(e) {
		var code = e.key;
		if (code === "Enter") {
			loadInfor();
		}
	});

	var tableVk = $('#tbl_datatables_vk').DataTable();
	$('#tbl_datatables_vk tbody').on('click', 'tr', function() {
		if ($(this).children().hasClass('dataTables_empty')) {
			return;
		}
		var data = tableVk.row(this).data();
		showModalVk(data);
	});

	var tableMuon = $('#tbl_datatables_muon').DataTable();
	$('#tbl_datatables_muon tbody').on('click', 'tr', function() {
		if ($(this).children().hasClass('dataTables_empty')) {
			return;
		}
		var data = tableMuon.row(this).data();
		showModalMuon(data);
	});
	
	$('#btn-download').click(function() {

		$.ajax({
			contentType : "application/json",
			url : baseUrl + 'api/CBQL/download',
			data : {
				chungLoai:$('#list-chungloai').val(),nhanHieu:$('#list-nhanHieu').val(),tinhTrang:$('#list_tinhTrang').val()
			},
			type : "GET",
			dataType : 'json',
			timeout : 30000, // ms
			success : function(data) {
				if (data.statusCode == '200') {
					executeDownloadFile(data.idFileDownload);
				} else {
					showToastMessage('error', 'TODO');
				}
			},
			error : function(xhr) {
				showPopupCommon('error', 'Exception', null);
			}
		});
	});
})
function loadInfor() {
	if (!modeSearch || modeSearch == '0') {
		$('#tbl_datatables_vk').DataTable().ajax.reload();
	} else if (modeSearch == '1') {
		getListVuKhi();
	} else if (modeSearch == '2') {

	} else if (modeSearch == '3') {

	}
}
function initialTableQL() {

	// Define Columns
	var columns = [ {
		data : 'soHieu'
	}, {
		data : 'chungLoai'
	}, {
		data : 'nhanHieu'
	}, {
		data : 'donViTinh'
	}, {
		data : 'nuocSX'
	}, {
		data : 'tinhTrang'
	} ];

	// Create DataTable
	createDataTableCommon();
	$('#tbl_datatables_vk').DataTable(
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
				} ],
				'order' : [ [ 1, "ASC" ] ],
				'ajax' : {
					'url' : baseUrl + 'api/CBQL/searchDsVK',
					'contentType' : 'application/json',
					'type' : 'GET',
					'data' : function(d) {

						// set search keyword to parameter
						d.chungLoai = $('#list-chungloai').val();
						d.nhanHieu = $('#list-nhanHieu').val();
						d.tinhTrang = $('#list_tinhTrang').val();
					},
					'complete' : function(response) {
						checkDataTable('tbl_datatables_vk',
								response.responseJSON.recordsTotal);
					},
					'error' : function(xhr) {
						handleApiError(xhr);
					}
				}
			});
	checkDataTable('tbl_datatables_vk', 0);
}
function initialTableMuon() {

	// Define Columns
	var columns = [ {
		data : 'lanhDaoDuyet'
	}, {
		data : 'soHieuCBCS'
	}, {
		data : 'hoTenCBCS'
	}, {
		data : 'soHieuVK'
	}, {
		data : 'nhanHieuVK'
	}, {
		data : 'soLuong'
	} ];

	// Create DataTable
	createDataTableCommon();
	$('#tbl_datatables_muon').DataTable(
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
				} ],
				"order" : [ [ 1, "ASC" ] ],
				'ajax' : {

					'url' : baseUrl + 'api/CBQL/searchDsMuon',
					"contentType" : "application/json",
					"type" : "GET",
					'data' : function(d) {
						// set search keyword to parameter
						d.timKiem = $('#txt_timKiem_muon').val();
					},
					complete : function(response) {
						checkDataTable('tbl_datatables_muon',
								response.responseJSON.recordsTotal);
					},
					error : function(xhr) {
						handleApiError(xhr);
					}
				}
			});
	checkDataTable('tbl_datatables_muon', 0);
}
function initialTableTra() {

	// Define Columns
	var columns = [ {
		data : 'soHieuCBCS'
	}, {
		data : 'hoTenCBCS'
	}, {
		data : 'donVi'
	}, {
		data : 'soHieuVK'
	}, {
		data : 'nhanHieuVK'
	}, {
		data : 'soLuong'
	}, {
		data : 'ngayMuon'
	}, {
		data : 'hoTenCBQL'
	}, {
		data : 'soHieuCBQL'
	}, {
		data : 'lanhDaoDuyet'
	} ];

	// Create DataTable
	createDataTableCommon();
	$('#tbl_datatables_tra').DataTable(
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
					'orderable' : false
				}, {
					'targets' : [ 7 ],
					'searchable' : false,
					'orderable' : false
				}, {
					'targets' : [ 8 ],
					'searchable' : false,
					'orderable' : false
				}, {
					'targets' : [ 9 ],
					'searchable' : false,
					'orderable' : false
				} ],
				"order" : [ [ 1, "ASC" ] ],
				'ajax' : {

					'url' : baseUrl + 'api/CBQL/searchDsTra',
					"contentType" : "application/json",
					"type" : "GET",
					'data' : function(d) {
						// set search keyword to parameter
						d.timKiem = $('#txt_timKiem_tra').val();
					},
					complete : function(response) {
						checkDataTable('tbl_datatables_tra',
								response.responseJSON.recordsTotal);
					},
					error : function(xhr) {
						handleApiError(xhr);
					}
				}
			});
	checkDataTable('tbl_datatables_tra', 0);
}

function loadNhanHieu(chungLoai, flg) {
	$.ajax({
		url : baseUrl + 'api/QLVK/getNhanHieu',
		contentType : "application/json",
		type : "GET",
		dataType : 'json',
		data : {
			chungLoai : $(chungLoai).val()
		},
		success : function(data) {
			if (data.statusCode == '200') {
				createNhanHieuByChungLoai(data.data, flg);
			}
		},
		error : function(xhr) {
			showPopupCommon('error', 'Exception', null);
		}
	});
}

function createNhanHieuByChungLoai(data, flg) {
	var str = '<option value="">--Lựa chọn--</option>';
	for (var i = 0; i < data.length; i++) {
		str += '<option value="' + data[i] + '">' + data[i] + '</option>'
	}
	if (flg == 1) {
		$('#list-nhanHieu').empty();
		$('#list-nhanHieu').append(str);
	} else {
		$('#in_nhanHieu').empty();
		$('#in_nhanHieu').append(str);
	}
}
function timKiemVK() {
	$('#tbl_datatables_vk').DataTable().ajax.reload();
}
function timKiemMuon() {
	$('#tbl_datatables_muon').DataTable().ajax.reload();
}

// show modal button
function showModalVk(data) {
	$("body").addClass("modal-open");
	var obj = document.getElementById('js-modal-add');
	obj.classList.add('open');
	$('#modal-add-button').hide();
	$('#modal-update-button').show();
	$('#modal-del-button').show();
	$("#txt_soHieu").prop("readonly", true);
	$('#txt_soHieu').val(data.soHieu);
	$('#in_chungloai').val(data.chungLoai);
	$('#in_nhanHieu').val(data.nhanHieu);
	$('#txt_donViTinh').val(data.donViTinh);
	$('#txt_nuocSX').val(data.nuocSX);
	$('#in_tinhTrang').val(data.tinhTrang);
};
function hideModal(obj) {
	obj.classList.remove('open');
	$("body").removeClass("modal-open");
};

function showModelThem() {
	$("body").addClass("modal-open");
	var obj = document.getElementById('js-modal-add');
	obj.classList.add('open');
	$('#modal-add-button').show();
	$('#modal-update-button').hide();
	$('#modal-del-button').hide();
	$("#txt_soHieu").prop("readonly", false);
}
function themMoi() {
	var danhSachVKModel = {};
	danhSachVKModel.soHieu = $.trim($('#txt_soHieu').val());
	danhSachVKModel.chungLoai = $.trim($('#in_chungloai').val());
	danhSachVKModel.nhanHieu = $.trim($('#in_nhanHieu').val());
	danhSachVKModel.nuocSX = $.trim($('#txt_nuocSX').val());
	danhSachVKModel.tinhTrang = $.trim($('#in_tinhTrang').val());
	danhSachVKModel.donViTinh = $.trim($('#txt_donViTinh').val());
	$.ajax({
		url : baseUrl + 'api/CBQL/createVK',
		contentType : "application/json",
		type : "POST",
		dataType : 'json',
		data : JSON.stringify(danhSachVKModel),
		success : function(data) {
			handleMessageResponse(data);
			hideModal(document.getElementById('js-modal-add'));
			timKiemVK();
		},
		error : function(xhr) {
			showPopupCommon('error', 'Exception', null);
		}
	});
}
function capNhat() {
	var danhSachVKModel = {};
	danhSachVKModel.soHieu = $.trim($('#txt_soHieu').val());
	danhSachVKModel.chungLoai = $.trim($('#in_chungloai').val());
	danhSachVKModel.nhanHieu = $.trim($('#in_nhanHieu').val());
	danhSachVKModel.nuocSX = $.trim($('#txt_nuocSX').val());
	danhSachVKModel.tinhTrang = $.trim($('#in_tinhTrang').val());
	danhSachVKModel.donViTinh = $.trim($('#txt_donViTinh').val());
	$.ajax({
		url : baseUrl + 'api/CBQL/updateVK',
		contentType : "application/json",
		type : "PUT",
		dataType : 'json',
		data : JSON.stringify(danhSachVKModel),
		success : function(data) {
			handleMessageResponse(data);
			hideModal(document.getElementById('js-modal-add'));
			timKiemVK();
		},
		error : function(xhr) {
			showPopupCommon('error', 'Exception', null);
		}
	});
}
function xoa() {
	var danhSachVKModel = {};
	danhSachVKModel.soHieu = $.trim($('#txt_soHieu').val());
	$.ajax({
		url : baseUrl + 'api/CBQL/delVK',
		contentType : "application/json",
		type : "DELETE",
		dataType : 'json',
		data : JSON.stringify(danhSachVKModel),
		success : function(data) {
			handleMessageResponse(data);
			hideModal(document.getElementById('js-modal-add'));
			timKiemVK();
		},
		error : function(xhr) {
			showPopupCommon('error', 'Exception', null);
		}
	});
}
function showModalMuon(data) {
	$("body").addClass("modal-open");
	var obj = document.getElementById('js-modal-muon');
	obj.classList.add('open');
	$('#txt_lanhDao').val(data.lanhDaoDuyet);
	$('#txt_soHieu').val(data.soHieuCBCS);
	$('#txt_hoTenCBCS').val(data.hoTenCBCS);
	$('#soHieuVK').val(data.soHieuVK);
	$('#txt_nhanHieu').val(data.nhanHieuVK);
	$('#txt_soLuong').val(data.soLuong);
	$('#txt_maMuon').val(data.maMuon);
	$('#txt_maDuyet').val(data.maDuyet);
	getSoHieuVK(data.nhanHieuVK);
}

function showModalTra(data) {
	$("body").addClass("modal-open");
	var obj = document.getElementById('js-modal-tra');
	obj.classList.add('open');
	$('#txt_lanhDao').val(data.lanhDaoDuyet);
	$('#txt_soHieu').val(data.soHieuCBCS);
	$('#txt_hoTenCBCS').val(data.hoTenCBCS);
	$('#soHieuVK').val(data.soHieuVK);
	$('#txt_nhanHieu').val(data.nhanHieuVK);
	$('#txt_soLuong').val(data.soLuong);
}
function getSoHieuVK(nhanHieu) {
	$.ajax({
		url : baseUrl + 'api/CBQL/getSoHieu',
		contentType : "application/json",
		type : "GET",
		dataType : 'json',
		data : {
			nhanHieu : nhanHieu
		},
		success : function(data) {
			taoDanhSachSoHieu(data.data);
		},
		error : function(xhr) {
			showPopupCommon('error', 'Exception', null);
		}
	});
}
function taoDanhSachSoHieu(data) {
	var str = '<option value="">--Lựa chọn--</option>';
	for (var i = 0; i < data.length; i++) {
		str += '<option value="' + data[i] + '">' + data[i] + '</option>'
	}
	$('#soHieuVK').empty();
	$('#soHieuVK').append(str);
}
function choMuon() {
	var choMuonModel = {};
	choMuonModel.maMuon = $('#txt_maMuon').val();
	choMuonModel.maDuyet = $('#txt_maDuyet').val();
	choMuonModel.soHieuVK = $('#soHieuVK').val();
	choMuonModel.soLuong = $('#txt_soLuong').val();
	choMuonModel.nhanHieuVK = $('#txt_nhanHieu').val();
	$.ajax({
		url : baseUrl + 'api/CBQL/choMuon',
		contentType : "application/json",
		type : "POST",
		dataType : 'json',
		data : JSON.stringify(choMuonModel),
		success : function(data) {
			handleMessageResponse(data);
			hideModal(document.getElementById('js-modal-muon'));
			taoBienBan(data.data);
		},
		error : function(xhr) {
			showPopupCommon('error', 'Exception', null);
		}
	});
}
function taoBienBan(data) {
	alert("Biên bản nè");
}

function tuChoi(){
	var choMuonModel = {};
	choMuonModel.maMuon = $('#txt_maMuon').val();
	choMuonModel.maDuyet = $('#txt_maDuyet').val();
	$.ajax({
		url : baseUrl + 'api/CBQL/tuChoi',
		contentType : "application/json",
		type : "POST",
		dataType : 'json',
		data : JSON.stringify(choMuonModel),
		success : function(data) {
			handleMessageResponse(data);
			hideModal(document.getElementById('js-modal-muon'));
			timKiemMuon();
		},
		error : function(xhr) {
			showPopupCommon('error', 'Exception', null);
		}
	});
}