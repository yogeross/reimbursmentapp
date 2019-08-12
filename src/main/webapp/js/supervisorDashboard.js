/**
 * 
 */
function formDisplay() {
    if (document.getElementById("reimbursementForm").style.display === "none") {
        document.getElementById("reimbursementForm").style.display = "block";
    } else {
        document.getElementById("reimbursementForm").style.display = "none"
    }
}





function estimateCost(){
	var eventType = document.getElementById("eventType");
	var event = eventType.options[eventType.selectedIndex].value;
    var cost= document.getElementById("cost").value;
    var estimate=0;
    switch (event){
        case "1":
       		estimate=cost;
            document.getElementById("estimate").innerHTML="Estimated Cost we cover: $"+estimate.toString();
            break;
         case "2":
            estimate=Math.round((cost*.9) * 100) / 100;
            document.getElementById("estimate").innerHTML="Estimated Cost we cover: $"+estimate.toString();
            break;
        case "3":
            estimate=Math.round((cost*.8) * 100) / 100;;
            document.getElementById("estimate").innerHTML="Estimated Cost we cover: $"+estimate.toString();
            break;
        case "4":
            estimate=Math.round((cost*.75) * 100) / 100;
            document.getElementById("estimate").innerHTML="Estimated Cost we cover: $"+estimate.toString();
            break;
        case "5":
            estimate=Math.round((cost*.6) * 100) / 100;
            document.getElementById("estimate").innerHTML="Estimated Cost we cover: $"+estimate.toString();
            break;
        case "6":
                estimate=Math.round((cost*.3) * 100) / 100;;
                document.getElementById("estimate").innerHTML="Estimated Cost we cover: $"+cost.toString();
                break;
    }
}

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


function logout(){
    window.location.href="logout.html";
}






//supervisor, head of department request table
function buildSupervisorAndHeadRequestTable(request) {
    var table = '';
    let rows = request.length;
    table += '<tr>';
    table += '<th>' + "Request ID" + '</th>';
    table += '<th>' + "Event ID" + '</th>';
    table += '<th>' + "Date Submitted" + '</th>';
    table += '<th>' + "Status" + '</th>';
    table += '<th>' + "Employee Comments" + '</th>';
    table += '<th>' + "Denial Reason" + '</th>';
    table += '<th>' + "Amount Approval" + '</th>';
    table += '<th>' + "Request Options" + '</th>';
    table += '</tr>';
    for (let r = 0; r < rows; r++) {
        table += '<tr>';
        table = loadPastRequestsForSupervisorAndHead(request[r], table);
        table += '</tr>';
    }
    document.getElementById("incomingRequests").insertAdjacentHTML('beforeend', '<table border=1>' + table + '</table>');

}




function loadPastRequestsForSupervisorAndHead(request,table){
    table+='<td >'+request.request_id+'</td>';
    table+='<td>'+request.event_id+'</td>';
    table+='<td>' +request.date+'</td>';
    table+='<td>' +getStat(request.status)+'</td>';
    table+='<td>' +request.empComments+'</td>';
    table+='<td>' +request.denialReason+'</td>';
    table+='<td>' +request.amountApproval+'</td>';
    table+='<td>'+'<form method="POST"><input type="hidden" name="requuestID" value="'+request.request_id>+'"><button type="submit" formaction="approve-reimbursment">Approve</button>'+
           '<button type="submit" formaction="deny-reimbursment">Deny</button>'+
           '<button type="submit" formaction="requestInfo-reimbursment">Request Info</button>'+'</form>'+'</td>';
    return table
}
function getStat(id){
    if(id==1){
        return "Approved";
    }
    if(id==2){
        return "Denied";
    }
    if(id==3){
        return "More Info Requested";
    }
    if(id==4){
        return "Waiting for Supervisor Aprroval"
    }
    if(id==5){
        return "Waiting for Department Head Approval";
    }
    if(id==6){
        return "Waiting for Benefits Coordinator Approval";
    }
}
function getIncomingRequestsForSupervisorAndHead(){
	let username= readCookie("username");
	console.log("TEST");

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            var request = JSON.parse(xhr.responseText);
            console.log(typeof request);
            console.log("Printing request to log");
            console.log(request);
            buildSupervisorAndHeadRequestTable(request);
        }
    }
    xhr.open("GET", "http://localhost:8080/Project1/list-reimbursements?username=" + username, true);
    //xhr.open("GET","http://localhost:8080/Project1/list-reimbursements?username=MHara5",true);
    xhr.send();

}






window.onload = function () {
    console.log("ON LOAD");
    console.log(document.cookie);
    
    getIncomingRequestsForSupervisorAndHead();

};







