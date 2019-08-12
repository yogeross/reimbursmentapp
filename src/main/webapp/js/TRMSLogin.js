function logout(){
    window.location.href="logout.html";
}

function verifyUser(){
    
}



window.onload=function(){
    document.getElementById("login").addEventListener("click", verifyUser,false);
}