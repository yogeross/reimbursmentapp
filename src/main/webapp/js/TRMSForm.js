var today = new Date();
var dd = String(today.getDate() + 7).padStart(2, '0');
var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
var yyyy = today.getFullYear();
week = yyyy + '-' + mm + '-' + dd;

document.getElementById("date").addEventListener("change", function(){
	var input = this.value;
    if(input >= week){
    	document.getElementById("errors").innerHTML = "";
        document.getElementById("submitForm").disabled = false;
    }else{
    	document.getElementById("errors").innerHTML = "Events must start past " + week + " to be submitted.";
        document.getElementById("submitForm").disabled = true;
    }
})

function logout(){
    window.location.href="logout.html";
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