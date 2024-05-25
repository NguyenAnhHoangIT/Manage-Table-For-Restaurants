
function datmon(id, tt) {
    window.location = "datmon?id=" + id + "&trangthai=" + tt;
}
function chonmon(id, mb, tt) {
    window.location = "add_hoadon?id=" + id + "&maban=" + mb + "&trangthai=" + tt;
}
function xoamon(id, mb, tt) {
    window.location = "remove_hoadon?id=" + id + "&maban=" + mb + "&trangthai=" + tt;
}
function order(hd, mb, tt) {
    window.location = "order?hoadon=" + hd + "&maban=" + mb + "&trangthai=" + tt;
}
function back() {
    window.location = "ClearSession?id=back";
}
function done(mb, tt) {
    window.location = "Xuathoadon?maban=" + mb + "&trangthai=" + tt;
}

function inc_dec(a, id ,hd, mb, tt) {
     window.location = "inc_dec?action="+ a + "&id="+ id +"&hoadon=" + hd + "&maban=" + mb + "&trangthai=" + tt;
}

function openTab(evt, tabName) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("hide");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }

    tablinks = document.getElementsByClassName("tab_item");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }

    document.getElementById(tabName).style.display = "grid";
    evt.currentTarget.className += " active";
}
window.onload = function () {
    var today = new Date().toISOString().split('T')[0];
    document.getElementById('tungay').value = today;
    
};
document.addEventListener("DOMContentLoaded", function () {
    var themButton = document.querySelector('.them_con');
    var addSection = document.querySelector('.add_con');

    themButton.addEventListener('click', function () {
        if (addSection.style.display === "block") {
            addSection.style.display = "none";
        } else {
            addSection.style.display = "block";
        }
    });
});
function showForm(formClass) {
    var themkhuvucForm = document.querySelector('.themkhuvuc');
    var thembanForm = document.querySelector('.themban');
    var formToToggle = document.querySelector('.' + formClass);

    if (formClass === 'themkhuvuc') {
        thembanForm.style.display = 'none';
    } else if (formClass === 'themban') {
        themkhuvucForm.style.display = 'none';
    }

    if (formToToggle.style.display === 'none' || formToToggle.style.display === '') {
        formToToggle.style.display = 'block';
    } else {
        formToToggle.style.display = 'none';
    }
}





