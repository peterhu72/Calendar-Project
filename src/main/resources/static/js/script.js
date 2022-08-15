const date = new Date();



const Calendar = () => {
  date.setDate(1);

  const monthDays = document.querySelector(".days");

  const lastDay = new Date(date.getFullYear(), date.getMonth() + 1, 0).getDate();

  const prevLastDay = new Date(date.getFullYear(), date.getMonth(), 0).getDate();

  const firstDayIndex = date.getDay();

  const lastDayIndex = new Date(date.getFullYear(), date.getMonth() + 1, 0).getDay();
  

  const nextDays = 7 - lastDayIndex - 1;

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

  document.querySelector(".date h1").innerHTML = months[date.getMonth()];

  document.querySelector(".date p").innerHTML = new Date().toDateString();

  let days = "";

  for (let a = firstDayIndex; a > 0; a--) {
	// days from previous months, don't matter
    days += `<div class="prev-date">${prevLastDay - a + 1}</div>`;
  }

  for (let b = 1; b <= lastDay; b++) {
    if (
      b === new Date().getDate() &&
      date.getMonth() === new Date().getMonth()
    ) {
		// today's date'
      	days += `<div class="today">${b}</div>`;
    } else {
		// all normal days	
     	days += `<div>${b}</div>`;
    }
  }

  for (let c = 1; c <= nextDays; c++) {
	//next month days
    days += `<div class="next-date">${c}</div>`;
    monthDays.innerHTML = days;
  }
};



function getDate(){
	return date.getMonth() + "-" + date.getDay() + "-" + date.getFullYear();
}

document.querySelector(".prev").addEventListener("click", () => {
  date.setMonth(date.getMonth() - 1);
  Calendar();
});

document.querySelector(".next").addEventListener("click", () => {
  date.setMonth(date.getMonth() + 1);
  Calendar();
});


Calendar();


document.querySelector(".popup").style.display = "none";

document.getElementById("button").addEventListener("click", function(){
	document.querySelector(".popup").style.display = "flex";
});

document.querySelector(".close").addEventListener("click", function(){
	document.querySelector(".popup").style.display = "none";
});





