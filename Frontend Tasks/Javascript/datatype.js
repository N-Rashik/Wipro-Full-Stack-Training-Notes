// // use typeof to find the data type of the variables

// alert(typeof "hello"); // "string"
// alert(typeof "21");    // "string"

// console.log(typeof(4567)); // "number"
// console.log(typeof(45.78)); // "number"

// console.log(3 == 4); // false

// var a;
// console.log(a); // undefined
// console.log(typeof undefined); // "undefined"

// var x;
// console.log("Type of x is: " + typeof x); // Type of x is: undefined

// console.log(typeof null); // "object" (JavaScript quirk)
// var x = null;
// console.log("Type of x is: " + typeof x); // Type of x is: object

// alert(typeof document); // "object"
// alert(typeof window); // "object"
// alert(typeof {name: "Rashik", age:23}); // "object"

// var x = [];
// console.log("Type of x is: " + typeof x); // Type of x is: object
// console.log(typeof ['rasi','gowsi','sanjai']); // "object"
// console.log(typeof ['rasi',23,'gowsi']); // "object"

// console.log(typeof function(){}); // "function"
// console.log(typeof alert); // "function"
// console.log(typeof window.alert); // "function" (alert is a function reference)

// alert(typeof Symbol("dob")); // "symbol"

// var value = "Rashik"; // string
// var age = 23; // number
// const pi = 3.14; // number
// let age1 = 34; // number

// var isFemale = true; // boolean
// var isSenior = false; // boolean

// var num1 = 23;
// var num2 = 36;
// var isEqual = (num1 == num2);
// console.log(isEqual); // false

// // let -- are block scoped only
// var num123 = 55;
// function sayHello(){
//     var num12 = 56;
// }

// if (true) {
//     let y = 56;
//     const result = 67;
//     console.log(y);       // Output: 56
//     console.log(result);  // Output: 67
// }

// console.log(result); 
// // ReferenceError: result is not defined

// console.log(ab); // Output: undefined
// var ab = 45;

// console.log(abc); 
// // ReferenceError: Cannot access 'abc' before initialization
// let abc = 45;

// // var: can be reassigned and redeclared
// var name = "Rashik";
// var name = "Gowshik";
// name = "Sanjai"; // Output: Sanjai

// // let: can be reassigned but can't be redeclared
// let age2 = 23;
// age2 = 56; // works
// // let age2 = 67; // SyntaxError: Identifier 'age2' has already been declared

// // const -- cannot be reassigned
// const pii = 3.14;
// pii = 56.78; 
// // TypeError: Assignment to constant variable

// const person = {name: "Rashik"};
// person.name = "Gowshik"; // allowed
// console.log(person); // Output: { name: "Gowshik" }

// person = {name: "Rashik"}; 
// // TypeError: Assignment to constant variable

// const person = {age: 89}; 
// // SyntaxError: Identifier 'person' has already been declared

document.getElementById("orderform").addEventListener("submit",function(event){

    event.preventDefault();  // to wait on a console


const items = {
    burger: 120,
    pizza: 250,
    pasta: 180,
    coffee: 80
};

let orderInput = document.getElementById("orderInput").value; // Taken the values from an input box
let orderedArray = orderInput.split(",");
let order = []; // this is an empty array 

for(let i=0; i<orderedArray.length; i++)
{
    order.push(orderedArray[i].trim()); // it will remove the spaces and push the items in an array 
}
let total = 0;
for(let i=0;i<order.length;i++){
    let item = order[i];
    
    if(items[item] ){
        total = total + items[item];
    }
    else{
        console.log("Item is not in the list");
    }
}
let discount = 0;
console.log("Total price : " + total);
if(order.length > 3){
    discount = total * 0.10;
    console.log("Discount applied: " + discount);
}
const totalbill = total-discount;
const bill =  {

    itemsOrdered: order,  // array form
    discountApplied : discount,
    finalAmount : totalbill
}
console.log(JSON.stringify(bill,null,1));

});
