$(document).ready(function() {
	kiemTraYeuCau();
	getListImgVK();

	$('input.is-form').on('click', function() {
		var $this = $(this);
		var $soLuong = $('#soLuong');
		var min = Number($soLuong.attr('min'));
		var max = Number($soLuong.attr('max'));
		var d = Number($soLuong.val());
		if ($(this).hasClass('minus')) {
			if (d > min) {
				d += -1
			}
			$soLuong.val(d);
		} else if ($(this).hasClass('plus')) {
			var x = d + 1;
			if (x <= max) {
				d += 1
			}
			$soLuong.val(d);
		}
		
	});
});

// show modal button
function showModal(nhanHieuVK) {
	$("body").addClass("modal-open");
	var obj = document.getElementById('js-modal-detail');
	obj.classList.add('open');
	$('#soLuong').val('');
	$('#lyDo').val('');
	getSoLuongVK(nhanHieuVK);
};

function hideModal() {
	var obj = document.getElementById('js-modal-detail');
	obj.classList.remove('open');
	$("body").removeClass("modal-open");
};

function preventBubble(event) {
	event.stopPropagation();
};

function getListImgVK() {
	$.ajax({
		url : baseUrl + 'api/CBCS/searchImgVK',
		contentType : "application/json",
		type : "GET",
		dataType : 'json',
		data : {
			chungLoai : $('#list-chungloai').val(),
			nhanHieu : $('#list-nhanHieu').val()
		},
		success : function(data) {
			if (data.statusCode == '200') {
				displayImgVK(data.data);
			}
		},
		error : function(xhr) {
			showPopupCommon('error', 'Exception', null);
		}
	});
}
function displayImgVK(data) {
	$("#table_image").empty();
	var count = 0;
	var str = '';
	for (var i = 0; i < data.length; i++) {
		dataIndex = data[i];
		if (count == 0) {
			str += '<tr style="display: flex;">';
		}
		count++;
		str += createImgVK(dataIndex);
		if (count == 4) {
			str += '</tr>';
			count = 0;
		}
	}
	$("#table_image").append(str);
}

function createImgVK(data) {
	var str = '<td style="display: grid">';
	str += '<img src="/QLVK/resources/assets/img/' + data.srcImg + '" '
	str += ' class="table_image" alt="' + data.srcImg + '"'
	str += ' onclick="showModal(&#39;' + data.nhanHieu + '&#39;);"> '
	str += '<label>' + data.nhanHieu + '</label>';
	str += '</td>';
	return str;
}

function getSoLuongVK(nhanHieuVK) {
	$.ajax({
		url : baseUrl + 'api/CBCS/getSoLuong',
		contentType : "application/json",
		type : "GET",
		dataType : 'json',
		data : {
			nhanHieuVK : nhanHieuVK
		},
		success : function(data) {
			if (data.statusCode == '200') {
				setDataToModal(data.data, nhanHieuVK);
			}
		},
		error : function(xhr) {
			showPopupCommon('error', 'Exception', null);
		}
	});
}
function setDataToModal(data, nhanHieuVK) {
	if (data.soLuongConLai <= '0') {
		$('#modal-muon-button').prop('disabled', true);
		$('#soLuong').attr('min', '0');
		$('#soLuong').attr('max', '0');
		$('#soLuong').val('0');
		$('#hetSoLuong').show();
	} else {
		$('#modal-muon-button').prop('disabled', false);
		$('#soLuong').attr('min', '1');
		$('#soLuong').attr('max', data.soLuongConLai);
		$('#soLuong').val('1');
		$('#hetSoLuong').hide();
	}
	$('#nhan_hieu_hidden').val(nhanHieuVK);
}

function loadNhanHieu() {
	$.ajax({
		url : baseUrl + 'api/QLVK/getNhanHieu',
		contentType : "application/json",
		type : "GET",
		dataType : 'json',
		data : {
			chungLoai : $('#list-chungloai').val()
		},
		success : function(data) {
			if (data.statusCode == '200') {
				createNhanHieuByChungLoai(data.data);
				getListImgVK();
			}
		},
		error : function(xhr) {
			showPopupCommon('error', 'Exception', null);
		}
	});
}

function createNhanHieuByChungLoai(data) {
	$('#list-nhanHieu').empty();
	var str = '<option value="">--L???a ch???n--</option>';
	for (var i = 0; i < data.length; i++) {
		str += '<option value="' + data[i] + '">' + data[i] + '</option>'
	}
	$('#list-nhanHieu').append(str);
}

function requestMuon() {
	var soLuong = $('#soLuong').val();
	var nhanHieuVK = $('#nhan_hieu_hidden').val();
	var lyDo = $('#lyDo').val();
	if (soLuong <= 0) {
		alert("s??? l?????ng ph???i kh??c 0");
	} else {
		$.ajax({
			url : baseUrl + 'api/CBCS/requestMuon',
			contentType : "application/json",
			type : "GET",
			dataType : 'json',
			data : {
				soLuong : soLuong,
				nhanHieuVK : nhanHieuVK,
				lyDo : lyDo
			},
			success : function(data) {
				handleMessageResponse(data);
				hideModal();
			},
			error : function(xhr) {
				showPopupCommon('error', 'Exception', null);
			}
		});
	}
}
var listMaMuon = [];
function kiemTraYeuCau() {
	listMaMuon = [];
	$.ajax({
		url : baseUrl + 'api/CBCS/kiemTra',
		contentType : "application/json",
		type : "GET",
		dataType : 'json',
		data : {},
		success : function(data) {
			if(data.status == 'ng') {
				taoDsNhanHieu(data.listNhanHieu);
				listMaMuon = data.listMaMuon;
				showModalhuy();
			}
		},
		error : function(xhr) {
			showPopupCommon('error', 'Exception', null);
		}
	});
}
function taoDsNhanHieu(data){
	var str = '';
	for( var i = 0; i < data.length; i++) {
		str += '<input class="nhanHieu model-huy-text" value="'+data[i]+'" readonly="readonly">';
	}
	$('#dsNhanHieu').empty();
	$('#dsNhanHieu').append(str);
}
function xacNhan(){
	var listNhanHieu = $('.nhanHieu').map((_,el) => el.value).get();
	$.ajax({
		url : baseUrl + 'api/CBCS/xacNhanHuy',
		contentType : "application/json",
		type : "DELETE",
		dataType : 'json',
		data : JSON.stringify(listMaMuon),
		success : function(data) {
			handleMessageResponse(data);
			hideModalHuy();
		},
		error : function(xhr) {
			showPopupCommon('error', 'Exception', null);
		}
	});
}
function showModalhuy() {
	$("body").addClass("modal-open");
	var obj = document.getElementById('js-modal-tuChoi');
	obj.classList.add('open');
};

function hideModalHuy() {
	var obj = document.getElementById('js-modal-tuChoi');
	obj.classList.remove('open');
	$("body").removeClass("modal-open");
};