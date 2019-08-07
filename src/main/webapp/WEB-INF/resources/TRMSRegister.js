function registerFormCheck(){
    console.log("in regi");
    if (document.getElementById("pword").value!==document.getElementById("vpword").value){
        alert("Your passwords do not match");
    }
}

window.onload=function(){
    console.log("in onload");
   document.getElementById("registerForm").addEventListener("submit",registerFormCheck,false);
}