const date = new Date();
  const months = [
    "January",
    "February",
    "March",
    "April",
    "May",
    "June",
    "July",
    "August",
    "September",
    "October",
    "November",
    "December",
  ];

var month = date.getMonth();

document.querySelector(".month h1").innerHTML = months[month];

document.querySelector("#submitLeft").onclick = function() {
    month--;
    if(month < 0) {
        month = 11;
    }
    document.querySelector(".month h1").innerHTML = months[month];
}

document.querySelector("#submitRight").onclick = function() {
    month++;
    if(month > 11) {
        month = 0;
    }
    document.querySelector(".month h1").innerHTML = months[month];
}
