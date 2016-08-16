function Hello(){
    alert("Hello, World");
}

function checkvalue() { 
    var mystring = document.getElementById('Username').value; 
    if(!mystring.match(/\S/)) {
        alert ('Empty value is not allowed');
        return false;
    } else {
        alert("correct input");
        return true;
    }
}
window.onerror = function (msg, url, num) {
    alert("Error: " + msg + "\nURL: " + url + "\nLine: " + num);
    return true;
};