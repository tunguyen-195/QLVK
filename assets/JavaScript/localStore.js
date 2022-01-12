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

// tab item

const $ = document.querySelector.bind(document);
const $$ = document.querySelectorAll.bind(document);

const tabs = $$(".tab-item");
const panes = $$(".tab-pane");

const tabActive = $(".tab-item.active");
const line = $(".tabs .line");

line.style.left = tabActive.offsetLeft + "px";
line.style.width = tabActive.offsetWidth + "px";

tabs.forEach((tab, index) => {
  const pane = panes[index];

  tab.onclick = function () {
    $(".tab-item.active").classList.remove("active");
    $(".tab-pane.active").classList.remove("active");

    line.style.left = this.offsetLeft + "px";
    line.style.width = this.offsetWidth + "px";

    this.classList.add("active");
    pane.classList.add("active");
  };
});


    // Automatic Slideshow - change image every 4 seconds

// var myIndex = 0;
// carousel();

// function carousel() {
//     var i;
//     var x = document.getElementsByClassName("js-slide-show");
//     for (i = 0; i < x.length; i++) {
//         x[i].style.display = "none";  
//     }

//     myIndex++;
//     if (myIndex > x.length) {myIndex = 1}    
//     x[myIndex-1].style.display = "block";  
//     setTimeout(carousel, 4000); 
// }

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


// stop bubble in modal
    const modalBubbles = document.querySelectorAll('.js-modal-Bubble');

    for (const modalBubble of modalBubbles) {
        modalBubble.addEventListener('click', preventBubble,false);
    };



    //Show passwork
    function showPass() {
        var inputPasswords = document.getElementsByClassName("js-input-pass");
        for (const inputPassword of inputPasswords) {
            if (inputPassword.type === "password") {
                inputPassword.type = "text";
            } else {
                inputPassword.type = "password";
            }
        }
        
    };

//check confirm
    var checkConfirm = function() {
        if (document.getElementById('js-password').value === document.getElementById('js-confirm-password').value) {
            document.getElementById('js-message-confirm').style.color = 'green';
            document.getElementById('js-message-confirm').innerHTML = ' giống nhau';
        } 
        else {
            document.getElementById('js-message-confirm').style.color = 'red';
            document.getElementById('js-message-confirm').innerHTML = ' khác nhau';
            // chỉ lập lại 1 lần
            setTimeout(removeConfirm, 4000)
            clearTimeout();
        }
    }

    function removeConfirm(){
        if (document.getElementById('js-password').value === document.getElementById('js-confirm-password').value) {
        document.getElementById('js-message-confirm').innerHTML = '';
        }
    }

    // Mặc định giá trị chức vụ trong form đăng ký
    var defaultChucvu = document.getElementById('js-register-chucvu'); // give an id to your input and set it as variable
    defaultChucvu.value ='Cán bộ chiến sỹ'; // set default value instead of html attribute
    defaultChucvu.onfocus = function() { defaultChucvu.value =''; }; // on focus - clear input
    // defaultChucvu.onblur = function() { defaultChucvu.value ='Cán bộ chiến sỹ'; }; // on leave restore it.
