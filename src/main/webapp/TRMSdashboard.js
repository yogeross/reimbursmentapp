function logout(){
    window.location.href="logout.html";
}
function estimateCost(){
    console.log("in estimateCost");
    let eventType= document.querySelector("#eventType");
    let event=eventType.options[eventType.selectedIndex].value;
    let cost= document.querySelector("#cost").value;
    let estimate=0;
    switch (event){
        case "certify":
            document.querySelector("#estimate").value="Estimated Cost we cover: $"+cost.toString();
            break;
        case "prep":
                estimate=cost*.75;
                document.querySelector("#estimate").value="Estimated Cost we cover: $"+estimate.toString();
                break;
        case "seminar":
            estimate=cost*.6;
            document.querySelector("#estimate").value="Estimated Cost we cover: $"+estimate.toString();
            break;
        case "training":
            estimate= cost*.9;
                document.querySelector("#estimate").value="Estimated Cost we cover: $"+estimate.toString();
                break;
        case "course":
                estimate=cost*.8;
                document.querySelector("#estimate").value="Estimated Cost we cover: $"+estimate.toString();
                break;
        case "other":
                estimate=cost*.3;
                document.querySelector("#estimate").value="Estimated Cost we cover: $"+cost.toString();
                break;
    }
}
function loadPastRequests(request){
    document.getElementById("event_id").innerHTML=request.event_id;
    document.getElementById("date").innerHTML=request.date;
    document.getElementById("status").innerHTML=request.status;
    document.getElementById("empComments").innerHTML=request.empComments;
    document.getElementById("denialReason").innerHTML=request.denialReason;
    document.getElementById("amountApproval").innerHTML=request.amountApproval;
    document.getElementById("supeID").innerHTML=request.supeID;
    document.getElementById("supeApprovalDate").innerHTML=request.supeApprovalDate;
    document.getElementById("headID").innerHTML=request.headID;
    document.getElementById("headApprovalDate").innerHTML=request.headApprovalDate;
    document.getElementById("bencoID").innerHTML=request.bencoID;
    document.getElementById("bencoApprovalDate").innerHTML=request.bencoApprovalDate;
}

function getPastRequests(){
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        if(xhr.readyState==4 && xhr.status==200){
            var request =JSON.parse(xhr.responseText);
            loadPastRequests(request);
        }
    }
}

function lateSubmission(event){
    let curDate =  new Date();
    curDate.setHours(0,0,0,0); //Set to midnight
 
    let userDate = document.getElementById("date").value;
    userDate = userDate.split("-");
    userDate = new Date(userDate[0], userDate[1]-1, userDate[2], 0, 0, 0); //Months are zero-indexed
 
    if (userDate-curDate <= 86400000*3) {//ms per day; 3 days before
      document.getElementById("submitForm").disabled=true;
    }
    else{
        alert("You cannot submit a request less than 1 week from now");
      document.getElementById("submitForm").disabled=false; //reenable in case it was disabled before
    }}

document.querySelector("#date").addEventListener("change",lateSubmission,true)