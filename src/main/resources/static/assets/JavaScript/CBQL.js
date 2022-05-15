var modeSearch;
$(document).ready(function() {
    //--------------------------------------------NEW
    initialTable();
    $('#tbl_datatables').DataTable().ajax.reload();
	$('#search').keyup(function(e){
		var code = e.key;
		if(code==="Enter") {
			loadInfor();
		}
	});

	$('.tabs #tab-TL').click(function(){
		modeSearch = '0';
		$('#search').val('');
		$('.tab-content').show();
		loadInfor();
	});
	$('.tabs #tab-VK').click(function(){
		modeSearch = '1';
		$('#search').val('');
		$('.tab-content').hide();
		loadInfor();
	});

	$('.tabs #tab-VLN').click(function(){
		modeSearch = '2';
		$('#search').val('');
		$('.tab-content').hide();
		loadInfor();
	});
	
	$('.tabs #tab-CCHT').click(function(){
		modeSearch = '3';
		$('#search').val('');
		$('.tab-content').hide();
		loadInfor();
	});

	var table = $('#tbl_datatables').DataTable();
	$('#tbl_datatables tbody').on('click', 'tr', function () {
		if ( $(this).children().hasClass('dataTables_empty') ) {
			return;
		}
		showModal(document.getElementById('js-modal-info'));
	});

	//--------------------------------------------------------------------------
	
    const jQUery = document.querySelector.bind(document);
    const jQUery2 = document.querySelectorAll.bind(document);
    
    const tabs = jQUery2(".tab-item");
    const panes = jQUery2(".tab-pane");
    
    const tabActive = jQUery(".tab-item.active");
    const line = jQUery(".tabs .line");
    
    line.style.left = tabActive.offsetLeft + "px";
    line.style.width = tabActive.offsetWidth + "px";
    
    tabs.forEach((tab, index) => {
      const pane = panes[index];
    
      tab.onclick = function () {
    	  jQUery(".tab-item.active").classList.remove("active");
    	  jQUery(".tab-pane.active").classList.remove("active");
    
        line.style.left = this.offsetLeft + "px";
        line.style.width = this.offsetWidth + "px";
    
        this.classList.add("active");
        pane.classList.add("active");
      };
    });

 // stop bubble in modal
    const modalBubbles = document.querySelectorAll('.js-modal-Bubble');

    for (const modalBubble of modalBubbles) {
      modalBubble.addEventListener('click', preventBubble,false);
    };

    //var defaultChucvu = document.getElementById('js-addVK-danhmuc'); // give an id to your input and set it as variable
    //    defaultChucvu.value ='Vũ khí'; // set default value instead of html attribute
    //    defaultChucvu.onfocus = function() { defaultChucvu.value =''; }; // on focus - clear input
        // defaultChucvu.onblur = function() { defaultChucvu.value ='Cán bộ chiến sỹ'; }; // on leave restore it.

        //search
        document.getElementById('searchIcon').onclick = function() {
          document.getElementById('search').classList.add("visible");
          document.getElementById('clear').classList.add("visible");
          document.getElementById('search-icon').classList.add("visible");
          document.getElementById('search').focus();
          document.getElementById('searchIcon').classList.add("hide");
      }
      document.getElementById('clear').onclick = function() {
        document.getElementById('searchIcon').classList.remove("hide");
        document.getElementById('search').classList.remove("visible");
        document.getElementById('clear').classList.remove("visible");
      }
});

function loadInfor(){
	if (!modeSearch || modeSearch == '0') {
		$('#tbl_datatables').DataTable().ajax.reload();
	} else if (modeSearch == '1') {
		getListVuKhi();
	} else if (modeSearch == '2') {

	} else if (modeSearch == '3') {

	}
}
function prepareAdd(){
	if (!modeSearch || modeSearch == '0') {
		$('#js-addVK-danhmuc').val('')
	} else if (modeSearch == '1') {
		$('#js-addVK-danhmuc').val('Vũ khí');
	} else if (modeSearch == '2') {
		$('#js-addVK-danhmuc').val('Vật liệu nổ');
	} else if (modeSearch == '3') {
		$('#js-addVK-danhmuc').val('Công cụ hỗ trợ');
	}
	resetData();
}
function resetData(){
	$('#js-addVK-chungloai').val('');
	$('#js-addVK-nhanhieu').val('');
	$('#js-addVK-sohieu').val('');
	$('#js-addVK-nuocsanxuat').val('');
	$('#js-addVK-sogiayphep').val('');
	$('#js-addVK-ngaycapphep').val('');
	$('#js-addVK-cogiatriden').val('');
}
function initialTable() {

	// Define Columns
	var columns = [
			{
				data : 'stt'
			},{
				data : 'chungLoai'
			},{
				data : 'nhanHieu'
			},{
				data : 'nuocSanXuat'
			},{
				data : 'soHieu'
			},{
				data : 'soGiayPhep'
			},{
				data : 'ngayCapPhep'
			},{
				data : 'coGiaTriDen'
			}];

	//Create DataTable
	createDataTableCommon();
	$('#tbl_datatables').DataTable({
		'columns' : columns,
		'columnDefs' : [{
			'targets' : [0],
			'searchable' : false,
			'orderable': false
		},{
			'targets' : [1],
			'searchable' : false,
			'orderable': false
		}
		,{
			'targets' : [2],
			'searchable' : false,
			'orderable': false
		}
		,{
			'targets' : [3],
			'searchable' : false,
			'orderable': false
		}
		,{
			'targets' : [4],
			'searchable' : false,
			'orderable': false
		},{
			'targets' : [5],
			'searchable' : false,
			'orderable': false
		},{
			'targets' : [6],
			'searchable' : false,
			'orderable': false
		},{
			'targets' : [7],
			'searchable' : false,
			'orderable': false
		}],
		"order": [[ 1, "ASC" ]],
		'ajax' : {
			
			'url' : baseUrl + 'api/QLVK/searchTongLuc',
			"contentType": "application/json",
			"type": "GET",
			'data' : function(d) {

				// set search keyword to parameter
				d.allSearch = $('#search').val();

				// set order to parameter
				var order = $('#tbl_datatables').DataTable().order();
				var columnIndex = order[0][0];
				d.orderColumn = columns[columnIndex].data;
				d.orderDirection = order[0][1];
			},
			complete : function(response) {
				checkDataTable('tbl_datatables', response.responseJSON.recordsTotal);
			},
			error : function(xhr) {
				handleApiError(xhr);
			}
		}
	});
	checkDataTable('tbl_datatables', 0);
}

function getListVuKhi() {
	$.ajax({
		contentType : "application/json",
		url : baseUrl + 'api/QLVK/searchTongLuc',
		data : {allSearch:$('#search').val(), type:'0'},
		type : "GET",
		dataType : 'json',
		timeout : 30000, // ms
		success : function(data) {
			if (data.statusCode == '200') {
				reloadPageVuKhi(data.data);
			}
		},
		error : function(xhr) {
			showPopupCommon('error', 'Exception', null);
		}
	});
}

function reloadPageVuKhi(data) {
	$( "#response-vu-khi").empty();
	var dataIndex;
	for (var i = 0; i <data.length;i++) {
		dataIndex = data[i];
		$( "#response-vu-khi").append(createHTMLVuKhi(dataIndex));
	}
}
function createHTMLVuKhi(data){
	var str ='<div class="col col-third tab-item-field">';
	str +='<div class="tab-item-img-vk">';
	str +='<img id = "img123" src="/QLVK/myImage/imageDisplay?id='+data.imgPath+'" style="height:292px;width:336px">';
	str +='</div>';
	str +='<div class="row tab-item-text">';
	str +='<p class="tab-item-name">'+data.chungLoai+'</p>';
	str +='<p class="tab-item-content">';
	str +='Số lượng:<span class="item-quantily">'+data.soLuong+'</span>';
	str +='</p>';
	str +='<p class="tab-item-content">';
	str +='Giấy phép sử dụng:<span class="item-quantily">'+data.soGiayPhep+'</span>';
	str +='</p>';
	str +='<div class="row">';
	str +='<div class="col-right">';
	str +='<input class="modal-login-button" formmethod="post" type="button" value="Mượn">';
	str +='</div>';
	str +='</div>';
	str +='</div>';
	str +='</div>';
	return str;
}

// show modal button
function showModal(obj){
  obj.classList.add('open');
};

function hideModal(obj){
  obj.classList.remove('open');
};

function preventBubble(event){
  event.stopPropagation();
};