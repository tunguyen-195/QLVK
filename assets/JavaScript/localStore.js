
//     // tab item

// const $ = document.querySelector.bind(document);
// const $$ = document.querySelectorAll.bind(document);

// const tabs = $$(".tab-item");
// const panes = $$(".tab-pane");

// const tabActive = $(".tab-item.active");
// const line = $(".tabs .line");

// // line.style.left = tabActive.offsetLeft + "px";
// line.style.left = tabActive.offsetLeft + "px";
// line.style.width = tabActive.offsetWidth + "px";

// tabs.forEach((tab, index) => {
//   const pane = panes[index];

//   tab.onclick = function () {
//     $(".tab-item.active").classList.remove("active");
//     $(".tab-pane.active").classList.remove("active");

//     line.style.left = this.offsetLeft + "px";
//     line.style.width = this.offsetWidth + "px";

//     this.classList.add("active");
//     pane.classList.add("active");
//   };
// });


//     // Automatic Slideshow - change image every 4 seconds
// var myIndex = 0;
// carousel();

// function carousel() {
//   var i;
//   var x = document.getElementsByClassName("js-slide-show");
//   for (i = 0; i < x.length; i++) {
//     x[i].style.display = "none"
//   }

//   myIndex++;
//   if (myIndex > x.length) {myIndex = 1}    
//   x[myIndex-1].style.display = "block";  
//   setTimeout(carousel, 4000); 
// //   setInterval(carousel, 4000); 
// }

// // show modal button

//     const loginBtn = document.getElementById('js-dangnhap');
//     const modalLogin = document.querySelector('.js-modal-login');
//     const modalClose = document.querySelector('.js-modal-close-button');
//     const modalForm = document.querySelector('.js-modal-login-form');

//     function showModal(){
//         modalLogin.classList.add('open');
//     };

//     function hideModal(){
//         modalLogin.classList.remove('open');
//     };

//     function preventBubble(event){
//         event.stopPropagation();
//     }

//     loginBtn.addEventListener('click',showModal);

//     modalClose.addEventListener('click',hideModal);
//     modalLogin.addEventListener('click',hideModal);

//     modalForm.addEventListener('click',preventBubble);
