
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

function getRequests(){
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        if(xhr.readyState==4 && xhr.status==200){
            var request =JSON.parse(xhr.responseText);
            loadPastRequests(request);
        }
    }
}