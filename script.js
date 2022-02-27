function Time() {
  document.getElementById("time").innerHTML = new Date().toLocaleTimeString();
  setTimeout(Time, 1000);
}

function sleep(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
}

window.addEventListener('beforeunload', function (e) {
  localStorage.save = document.getElementById("edittext").value;
});

function Copy() {
  navigator.clipboard.writeText(document.getElementById("edittext").value);
}

function Cut() {
  navigator.clipboard.writeText(document.getElementById("edittext").value);
  document.getElementById("edittext").value = "";
}

function Delete() {
  document.getElementById("edittext").value = "";
}

function Undo(){
  document.execCommand('undo', false, null);
}

function Redo(){
  document.execCommand('redo', false, null);
}

function Translate(){
  window.open("https://translate.google.com/?text=" + document.getElementById("edittext").value);
}

function SelectAll(){
  document.getElementById("edittext").select();
  document.getElementById("edittext").setSelectionRange(0, 99999);
}

function Paste(){
  navigator.clipboard.readText()
  .then(pasted => {
    document.getElementById("edittext").value += pasted;
  })
}

function Export(){
  var hiddenElement = document.createElement('a');
  hiddenElement.href = 'data:attachment/text,' + encodeURI(document.getElementById("edittext").value);
  hiddenElement.target = '_blank';
  hiddenElement.download = 'Text.txt';
  hiddenElement.click();
}

function Auto() {
  document.getElementById("edittext").value = localStorage.save;
  if (document.getElementById("edittext").value == "undefined") {
    document.getElementById("edittext").value = "Hello World!"
  }
}