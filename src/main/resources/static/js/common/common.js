$('.navbar-light .dmenu').hover(function () {
    $(this).find('.sm-menu').first().stop(true, true).slideDown(150);
}, function () {
    $(this).find('.sm-menu').first().stop(true, true).slideUp(105)
});
var messageHeaderModelDetailUpdate='';
var messageHeaderModelDetailAdd='';
var isChanged = false;
$(document).ready(function() {
	$(".date_picker").datepicker(
		{dateFormat: 'dd/mm/yy'}
	);
	$(".number").focus(function() {
		$(this).val(removeComma($(this).val()));
	});
	$(".number").blur(function() {
		$(this).val(setComma($(this).val()));
	});
	$(".date_picker").focus(function() {
		dateFocus($(this));
	});
	$(".date_picker").blur(function() {
		dateBlur($(this));
	});
	$(".item-input-search").change(function() {
		isChanged = true;
	});
});


function setComma(str) {
	for (i=0;i<str.length;i++) {
		if (i != 0 && (str.length-i) % 3 == 0 ) {
 	       str = str.replace(/^([+-]?\d+)(\d\d\d)/,"$1,$2");
		}
    }
	return str;
}
function removeComma(str) {
	var shosu = "";
	if (str.indexOf(".") > -1) {
		shosu = str.substring(str.indexOf("."));
		str = str.substring(0,str.indexOf("."));
	}
	var tmp = "";
	for (i=0;i<str.length;i++) {
		ch = str.charAt(i);
		if (ch != ",") {
			tmp += ch;
		}
	}
	return tmp+shosu;
}
var dateFormat = '/';
function dateBlur($item) {

	str = $item.val();
	tmp = "";
	//if(str.length == 6) {
	//	str = "20" + str;
	//}
	for (i=0;i<str.length;i++) {
		if (i == 2 || i == 4) {//4桁目と6桁目に"/"をいれる
			tmp += dateFormat;
		}
		tmp += str.charAt(i);
	}
	$item.val(tmp);
}

function dateFocus($item) {
	str = $item.val();
	var tmp = "";
	if(str.length > 5) {
		for (i=0;i<str.length;i++) {
			ch = str.charAt(i);
			if (ch != dateFormat) {
				tmp = tmp + ch;
			}
		}
	} else {
		tmp = str;
	}
	$item.val(tmp);
}

function showModelDetail() {
	$('#modal-detail').modal('show');
}
function hideModelDetail() {
	$('#modal-detail').modal('hide');
}
function toggleModelDetail() {
	$('#modal-detail').modal('toggle');
}
function showModelDelete() {
	$('#modal-delete').modal('show');
}
function hideModelDelete() {
	$('#modal-delete').modal('hide');
}
function toggleModelDelete() {
	$('#modal-delete').modal('toggle');
}

function settingCommonBeforeShowModalAdd() {
	$('#LayoutDetailCommon').hide();
	$('#btn-edit-submit').hide();
	$('#btn-clone').hide();
	$('#btn-create-submit').show();
	$('#modal-title').text(messageHeaderModelDetailAdd);
}
function settingCommonBeforeShowModalUpdate() {
	$('#LayoutDetailCommon').show();
	$('#btn-edit-submit').show();
	$('#btn-clone').show();
	$('#btn-create-submit').hide();
	$('#modal-title').text(messageHeaderModelDetailUpdate);
}
function settingHiddenCommon(primaryKey, cmnUpdateDate) {
	$('#primaryKey').val(primaryKey);
	$('#cmnUpdateDate').val(cmnUpdateDate);
}
function resetHiddenCommon() {
	$('#primaryKey').val('');
	$('#cmnUpdateDate').val('');
}
function settingLabelCommon(data) {
	$('#cmnCreateUserLabel').text(data.modelData.cmnCreateUserLabel);
	$('#cmnCreateDateLabel').text(data.modelData.cmnCreateDateLabel);
	$('#cmnUpdateUserLabel').text(data.modelData.cmnUpdateUserLabel);
	$('#cmnUpdateDateLabel').text(data.modelData.cmnUpdateDateLabel);
}
function resetLabelCommon() {
	$('#cmnCreateUserLabel').text('');
	$('#cmnCreateDateLabel').text('');
	$('#cmnUpdateUserLabel').text('');
	$('#cmnUpdateDateLabel').text('');
}
function showErrorDownload(){
	showToastMessage('error', ERROR_COUNT_DOWNLOAD);
}
function showErrorChanged(){
	showToastMessage('error', ERROR_CHANGED);
}
function executeDownloadFile(id){
	CommonDownloadModel.idFileDownload.value=id;
	CommonDownloadModel.submit();
}
function executeAfterUploadSuccess() {
	$( "#btn_search" ).trigger( "click" );
	if ($('#fileUpload').length) {
		$('#fileUpload').val('');
	}
}
function handleMessageResponse(data) {
	clearError();
	if (data.statusCode == 200) {
		if (data.messageInfor) {
			showToastMessage('success',data.messageInfor);
		}
		if (data.messageWarning) {
			showToastMessage('warning',data.messageWarning);
		}
	} else {
		if (data.messageError) {
			showToastMessage('error',data.messageError);
		}
		var listItemError = data.listItemError;
		if (listItemError) {
			var id;
			for (var i = 0; i <listItemError.length; i++) {
				id = listItemError[i].id;
				if (id) {
					$('#'+id).attr('data-toggle', 'tooltip');
					$('#'+id).attr('data-placement', 'top');
					$('#'+id).addClass('error');
					$('#'+id)[0].dataset.originalTitle=listItemError[i].message;
					$('#'+id).tooltip('show');
				}
			}
		}
	}
}
function clearError(){
	$('*').removeClass('error');
	$('*').attr('data-original-title', '');
}
function getLanguageForDataTable() {

	return {

		"decimal" : "",
		"emptyTable" : "",
		"info" : "_START_〜_END_（Tổng: _TOTAL_）",
		"infoEmpty" : "",
		"infoFiltered" : "",
		"infoPostFix" : "",
		"thousands" : ",",
		"lengthMenu" : "Count display: _MENU_",
		'loadingRecords' : '<i class="fa fa-spinner" aria-hidden="true"></i>',
		'processing' : '<i class="fa fa-spinner" aria-hidden="true"></i>',
		'search' : 'Search:',
		'zeroRecords' : '',
		'paginate' : {
			'first' : '<i class="fa fa-fast-backward" aria-hidden="true"></i>',
			'last' : '<i class="fa fa-fast-forward" aria-hidden="true"></i>',
			'next' : '<i class="fa fa-step-forward" aria-hidden="true"></i>',
			'previous' : '<i class="fa fa-step-backward" aria-hidden="true"></i>'
		},
		'aria' : {
			'sortAscending' : '<i class="fa fa-sort-asc" aria-hidden="true"></i>',
			'sortDescending' : '<i class="fa fa-sort-desc" aria-hidden="true"></i>'
		}
	}
}
function handleApiError(xhr) {
	//alert(xhr.status + ': ' + xhr.statusText);
	window.location.href = baseUrl + 'error'; //one level up
}
function checkDataTable(tableId, recordsTotal) {

	var tableSelector = '#' + tableId;

	// Get datatable
	var $tableEmpty = $(tableSelector);
	
	$(tableSelector + '_wrapper thead th').attr('tabindex', '-1');

	// Fix position for table
	$('.dataTables_scrollBody table').css({'z-index': '0', 'position': 'relative'}); 

	if (recordsTotal) {

		// Show info/ length/ paging
		$(tableSelector + "_length").show();
		$(tableSelector + "_info").show();
		$(tableSelector + "_paginate").show();

		// Disable sorting
		$(tableSelector + "_wrapper").find('th.table-sorting-disabled')
				.toggleClass('table-sorting-disabled', false);
		$(tableSelector + "_wrapper").find('th.table-sorting-disabled')
				.toggleClass('sorting', true);
		
		// remove class top
		$(tableSelector + '_wrapper .top').removeClass('d-none');
		$(tableSelector + '_wrapper .top').show();

	} else {

		// Hide info/ length/ paging
		$(tableSelector + "_length").hide();
		$(tableSelector + "_info").hide();
		$(tableSelector + "_paginate").hide();

		// Disable sorting
		$(tableSelector + "_wrapper").find('th.sorting_asc').toggleClass(
				'table-sorting-disabled', true);
		$(tableSelector + "_wrapper").find('th.sorting_desc').toggleClass(
				'table-sorting-disabled', true);
		$(tableSelector + "_wrapper").find('th.sorting').toggleClass(
				'table-sorting-disabled', true);
		$(tableSelector + "_wrapper").find('th').removeClass('sorting_asc',
				true);
		$(tableSelector + "_wrapper").find('th').removeClass('sorting_desc',
				true);
		$(tableSelector + "_wrapper").find('th.sorting').toggleClass('sorting',
				false);
	}
}

function createDataTableCommon() {
	$.extend( $.fn.dataTable.defaults, {
		'sAjaxDataProp' : 'data',
		'language' : getLanguageForDataTable(),
		'scrollY' : '640px',
		'scrollCollapse' : true,
		'scrollX' : true,
		'paging' : true,
		"bLengthChange": false,
		"pageLength": 20,
		"pagingType" : "full_numbers",
		'deferLoading': 0,
		'searching' : false,
		'processing' : true,
		'serverSide' : true,
		'info':true
	});
}
/**
 * function show popup common using for popup warning, confirm, error
 * 
 * @param type
 * @param content
 * @returns show modal common
 */
function showPopupCommon(type, content, fcBtn) {
	// show popup common
	$('#modal-common').modal('show');
	
	// show content popup
	$('#content-popup-common').text(content);

	// if type is warning
	if(type === "warning") {
		$('#title-popup-common').text('Chú ý');
		
		// show button OK
		$('#btn-common-ok').removeClass('d-none');
		$('#btn-common-cancel').removeClass('d-none');
		// add function handle event onclick
		$('#btn-common-ok').attr('onClick', fcBtn + '()');
	} 
	// if type is success
	else if(type === "success") {
		$('#title-popup-common').text('Thành công');
		$('#btn-common-ok').removeClass('d-none');
		$('#btn-common-cancel').addClass('d-none');
		$('#btn-common-ok').attr('onClick', 'closeModal()');
	}
	// if type is confirm
	else if (type === "confirm") {
		$('#title-popup-common').text('Xác nhận');
		
		// show button OK
		$('#btn-common-ok').removeClass('d-none');
		$('#btn-common-cancel').removeClass('d-none');
		// add function handle event onclick
		$('#btn-common-ok').attr('onClick', fcBtn + ';closeModal()');
	} 
	
	// if type is error
	else if (type === "error") {
		$('#title-popup-common').text('Lỗi');
		$('#btn-common-ok').addClass('d-none');
		$('#btn-common-cancel').removeClass('d-none');
	}
}
function reloadLanguage(language){

	$xhr = $.ajax({
		contentType : "application/json",
		url : baseUrl + 'api/common/changeLanguage',
		// beforeSend : function(xhr) {
		// xhr.setRequestHeader(header, token);
		// },
		data : {language:$(language).val()},
		type : "GET",
		dataType : 'json',
		timeout : 30000, // ms
		success : function(data) {

			if (data.statusCode != '200') {
				showPopupCommon('error', data.message, null);
			} else {
				location.reload();
			}
		},
		error : function(xhr) {
			showPopupCommon('error', 'Exception', null);
		}
	});
}
function closeModal(){
	$('#modal-common').modal('hide');
}
/**
*	pattern: success
*	pattern: warning
*	pattern: error 
*/
function showToastMessage(pattern, message) {
	if (!pattern) {
		pattern = 'error';
	}
	var id = 'toast-message-' + Math.floor(Math.random() * 100);
	var str = '<div class="toast toast-message-'+pattern+'" id = "'+id+'" data-autohide="true">' +
			'	<div class="toast-body">' +
			'		<b>' + message +
			'		</b>' +
			'	</div>' +
			'	<hr style = "margin-top:0;margin-bottom:0">' +
			'</div>';
	$('#message-toast').append(str);
	$("#"+id).toast({ delay: 5000 });
	$("#"+id).toast('show');
	$("#"+id).click(function(){
		$("#"+id).toast('hide');
	});
	setTimeout(function(){
		$("#"+id).toast('hide');
	},5000);
	setTimeout(function(){
		$("#"+id).remove();
	},5500);
}
function renderButtonUpdDel(id, timestamp){
	var str = '<a href="#" onclick = "showModalUpdate(\''+id+'\',\''+timestamp+'\')" class="edit"><i class="fa fa-pencil" aria-hidden="true"></i></a>';
	str +='<a href="#" onclick = "showModalDelete(\''+id+'\',\''+timestamp+'\')" class="delete"><i class="fa fa-trash" aria-hidden="true"></i></a>';
	return str;
}
function renderButtonUpd(id){
	var str = '<a href="#" onclick = "showModalUpdate(\''+id+'\',\''+timestamp+'\')" class="edit"><i class="fa fa-pencil" aria-hidden="true"></i></a>';
	return str;
}
function renderButtonDel(id){
	var str = '<a href="#" onclick = "showModalDelete(\''+id+'\',\''+timestamp+'\')" class="delete"><i class="fa fa-trash" aria-hidden="true"></i></a>';
	return str;
}
function resetListItemCommon(){
	$('#primaryKey').val('');
	$('#cmnUpdateDate').val('');
}
function showModalById(id) {
	$('#'+id).modal('show');
}
function hideModalById(id) {
	$('#'+id).modal('hide');
}