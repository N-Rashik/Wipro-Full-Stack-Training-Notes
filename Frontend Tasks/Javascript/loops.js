// for loop: increasing
/*
for (let i = 1; i <= 5; i++) {
    alert("The index number is: " + i);
    document.write("The index number is: " + i+"<br>");
    console.log("The index number is: " + i);
}

// for loop: decreasing
for (let j = 5; j >= 1; j--) {
    console.log("The index number is: " + j);
}

// while loop
let k = 1;
while (k <= 5) {
    console.log("The index number is: " + k);
    k++;
}

// do-while loop
let l = 1;
do {
    console.log("The current index no. is " + l);
    l++;
} 

while (l <= 5);

*/


// let arrColors=["Red","Black","Yellow","Pink"];
// for(let colors in arrColors)
// {
//     document.write("<li> The color name is: "+arrColors[colors]+"</li>");
// }


// let objEmployee={'empName':'Rashik','empAddress':'Rasipuram','empAge':'45'};
// document.writeln("Employee details are: ");
// for(emp in objEmployee)
// {
//     document.writeln(emp+" is "+objEmployee[emp]);
// }


// for(props in window)
// {
//     document.writeln(props);
// }


// let name="Rashik Nagarajan";
// for(let letters in name)
// {
//     document.writeln("Letters are: "+name[letters]);
// }


//let arrDays = ["Monday", "Tuesday", "Wednesday", "Thursday"];


// let i = 0; 
// while (i < arrDays.length) {
//     if (i === 3) { 
//         break;
//     }
//     console.log(i);
//     i++;
// }

// i = 1;
// while (i <= 20) {
//     if (i % 2 === 0) {
//         console.log("Even number is: " + i);
//         i++;
//         continue; // Skip printing odd in this iteration
//     }
//     console.log("Odd number is: " + i);
//     i++;
// }


// let userName="admin";
// if(userName=="admin"){
//     window.alert("Welcome: "+userName);
// }
// else{
//     window.alert("Wrong user name entered:");
// }


// let age=17
// if(age>=60){
//     window.alert("Welccome to senior citizen family portal: "+age);
// }
// else if(age<18){
//     window.alert("Welcome to minor family: "+age);
// }
// else{
//     console.log("Middle age: "+age);
// }


var choice = prompt("Enter your choice :");
switch(choice)
{

case 'A':
    document.writeln("Great Job (Added Student):");
    break;

case 'B':
    document.writeln("Great Job (Deleted Student):");
    break;

case 'C':
    document.writeln("Great Job (Displayed Student):");
    break;
default :
    document.writeln("Wrong Choice : try again!" );
    break;
}



