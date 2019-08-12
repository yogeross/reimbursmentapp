


function readCookie(name) {
    var nameEQ = name + "=";
    var ca = document.cookie.split(';');
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') c = c.substring(1, c.length);
        if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length, c.length);
    }
    return null;
}




function logout(){
    window.location.href="logout.html";
}

function buildRequestTable(request){
    var table='';
    let rows= request.length;
    table+='<tr>';
    table+='<th>' +"Event ID"+'</th>';
    table+='<th>' +"Date Submitted"+'</th>';
    table+='<th>' +"Status"+'</th>';
    table+='<th>' +"Employee Comments"+'</th>';
    table+='<th>' +"Denial Reason"+'</th>';
    table+='<th>' +"Amount Approval"+'</th>';
    table+='<th>' +"Supervisor ID"+'</th>';
    table+='<th>' +"Supervisor Approval Date"+'</th>';
    table+='<th>' +"Head ID"+'</th>';
    table+='<th>' +"Head Approval Date"+'</th>';
    table+='<th>' +"Benco ID"+'</th>';
    table+='<th>' +"Benco Approval Date"+'</th>';
    table+='</tr>';
    for (let r=0;r<rows;r++){
        table+='<tr>';
        table=loadPastRequests(request[r],table);
        table+='</tr>';
    }
    document.getElementById("requests").insertAdjacentHTML('beforeend','<table border=1>'+table+'</table>');
    
}

function loadPastRequests(request, table){
    table+='<td>'+request.event_id+'</td>';
    table+='<td>' +request.date+'</td>';
    table+='<td>' +request.status+'</td>';
    table+='<td>' +request.empComments+'</td>';
    table+='<td>' +request.denialReason+'</td>';
    table+='<td>' +request.amountApproval+'</td>';
    table+='<td>' +request.supeID+'</td>';
    table+='<td>' +request.supeApprovalDate+'</td>';
    table+='<td>' +request.headID+'</td>';
    table+='<td>' +request.headApprovalDate+'</td>';
    table+='<td>' +request.bencoID+'</td>';
    table+='<td>' +request.bencoApprovalDate+'</td>';
    return table;
    // document.getElementById("event_id").innerHTML=request.event_id;
    // document.getElementById("date").innerHTML=request.date;
    // document.getElementById("status").innerHTML=request.status;
    // document.getElementById("empComments").innerHTML=request.empComments;
    // document.getElementById("denialReason").innerHTML=request.denialReason;
    // document.getElementById("amountApproval").innerHTML=request.amountApproval;
    // document.getElementById("supeID").innerHTML=request.supeID;
    // document.getElementById("supeApprovalDate").innerHTML=request.supeApprovalDate;
    // document.getElementById("headID").innerHTML=request.headID;
    // document.getElementById("headApprovalDate").innerHTML=request.headApprovalDate;
    // document.getElementById("bencoID").innerHTML=request.bencoID;
    // document.getElementById("bencoApprovalDate").innerHTML=request.bencoApprovalDate;
}

function getPastRequests(){
	let username= readCookie("username");
	console.log("TEST");
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        if(xhr.readyState==4 && xhr.status==200){
            var request =JSON.parse(xhr.responseText);
            console.log(typeof request);
            console.log("Printing request to log");
            console.log(request);
            buildRequestTable(request);
        }
    }
    xhr.open("GET","http://localhost:8080/Project1/list-reimbursements?username="+username,true);
    //xhr.open("GET","http://localhost:8080/Project1/list-reimbursements?username=MHara5",true);
    xhr.send();

}



function lateSubmission(event){
    let curDate =  new Date();
    curDate.setHours(0,0,0,0); //Set to midnight
 
    let userDate = document.getElementById("date").value;
    console.log("LATE SUBMISSION");
    userDate = userDate.split("-");
    userDate = new Date(userDate[0], userDate[1]-1, userDate[2], 0, 0, 0); //Months are zero-indexed
 
    if (userDate-curDate <= 86400000*3) {//ms per day; 3 days before
      document.getElementById("submitForm").disabled=true;
    }
    else{
        alert("You cannot submit a request less than 1 week from now");
      document.getElementById("submitForm").disabled=false; //reenable in case it was disabled before
    }}

window.onload = function(){
	console.log("ON LOAD");
	console.log(document.cookie);
	getPastRequests();
};

document.querySelector("#date").addEventListener("change",lateSubmission,true);




