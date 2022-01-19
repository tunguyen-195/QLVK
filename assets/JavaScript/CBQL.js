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

var defaultChucvu = document.getElementById('js-addVK-danhmuc'); // give an id to your input and set it as variable
    defaultChucvu.value ='Vũ khí'; // set default value instead of html attribute
    defaultChucvu.onfocus = function() { defaultChucvu.value =''; }; // on focus - clear input
    // defaultChucvu.onblur = function() { defaultChucvu.value ='Cán bộ chiến sỹ'; }; // on leave restore it.

  