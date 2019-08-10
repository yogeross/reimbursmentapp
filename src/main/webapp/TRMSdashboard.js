function chooseTab() {
    console.log("in choosetab");
    alert("clicked");
    //let tabcontent = document.getElementsByClassName("tabcontent");
//     for (let i = 0; i < tabcontent.length; i++) {
//       tabcontent[i].style.display = "none";
//     }
//     let tablinks = document.getElementsByClassName("tablink");
//     for (let i = 0; i < tablinks.length; i++) {
//       tablinks[i].style.backgroundColor = "";
//     }
//     document.getElementById(pageName).style.display = "block";
//     elmnt.style.backgroundColor = color;
   }
  
  
  
window.onload=function(){
    console.log("in onload");
//document.getElementById("defaultOpen").click();
document.getElementsByClassName("tabs").add ("click",chooseTab);
}    