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
function estimateCost(){
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
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        if(xhr.readyState==4 && xhr.status==200){
            var request =JSON.parse(xhr.responseText);
            buildRequestTable(request);
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