$(document).ready(function() {
	getListImgVK();
});

// show modal button
function showModal(soHieuVk) {
	$("body").addClass("modal-open");
	var obj = document.getElementById('js-modal-detail');
	obj.classList.add('open');
	getDetailVk(soHieuVk);
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
	str += ' onclick="showModal(' + data.soHieuVK + ');"> '
	str += '<label>' + data.nhanHieu + '</label>';
	str += '</td>';
	return str;
}

function getDetailVk(soHieuVK) {
	$.ajax({
		url : baseUrl + 'api/CBCS/getDetailVk',
		contentType : "application/json",
		type : "GET",
		dataType : 'json',
		data : {
			soHieuVK : soHieuVK
		},
		success : function(data) {
			if (data.statusCode == '200') {
				setDataToModal(data.data);
			}
		},
		error : function(xhr) {
			showPopupCommon('error', 'Exception', null);
		}
	});
}
function setDataToModal(data) {
	$('#soHieu').text(data.soHieuVK);
	$('#soHieuHidden').val(data.soHieuVK);
	$('#chungLoai').text(data.chungLoai);
	$('#nhanHieu').text(data.nhanHieu);
	$('#donViTinh').text(data.donViTinh);
	$('#nuocSanXuat').text(data.nuocSx);
	if (data.soLuongTonKho == '0') {
		$('#modal-muon-button').prop('disabled', true);
	}
	$('#soLuong').attr('max', data.soLuongTonKho)
	$('#soLuong').val(data.soLuongTonKho);
	$('input.input-qty')
			.each(
					function() {
						var $this = $(this), qty = $this.parent().find(
								'.is-form'), min = Number($this.attr('min')), max = Number($this
								.attr('max'))
						if (min == 0) {
							var d = 0
						} else
							d = min
						$(qty).on('click', function() {
							if ($(this).hasClass('minus')) {
								if (d > min)
									d += -1
							} else if ($(this).hasClass('plus')) {
								var x = Number($this.val()) + 1
								if (x <= max)
									d += 1
							}
							$this.attr('value', d).val(d)
						})
					});
}

function loadNhanHieu() {
	$.ajax({
		url : baseUrl + 'api/CBCS/getNhanHieu',
		contentType : "application/json",
		type : "GET",
		dataType : 'json',
		data : {
			chungLoai : $('#list-chungloai').val()
		},
		success : function(data) {
			if (data.statusCode == '200') {
				createNhanHieuByChungLoai(data.data);
			}
		},
		error : function(xhr) {
			showPopupCommon('error', 'Exception', null);
		}
	});
	getListImgVK();
}

function createNhanHieuByChungLoai(data) {
	$('#list-nhanHieu').empty();
	var str = '<option value="">--Lựa chọn--</option>';
	for (var i = 0; i < data.length; i++) {
		str += '<option value="' + data[i] + '">' + data[i] + '</option>'
	}
	$('#list-nhanHieu').append(str);
}

function requestMuon() {
	var soLuong = $('#soLuong').val();
	var soHieuVK = $('#soHieuHidden').val();
	$.ajax({
		url : baseUrl + 'api/CBCS/requestMuon',
		contentType : "application/json",
		type : "GET",
		dataType : 'json',
		data : {
			soLuong : soLuong,
			soHieuVK : soHieuVK
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