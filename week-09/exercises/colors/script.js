var colorarray = ["#e58e26","#f9b4ab","#B1FB17","#78e08f","#fd79a8"];

function bgchange() {
    var randomColor = colorarray[Math.floor(Math.random() * colorarray.length)];
    document.body.style.background = randomColor;
}

var str = "";
for (var i = 0; i < colorarray.length; i++) {
    str += '<span onclick="bgchange()" style="background-color: ' + colorarray[i] + '"></span>';
}

document.getElementById("colorbox").innerHTML = str;
