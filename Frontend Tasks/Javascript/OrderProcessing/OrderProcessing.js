// let menu = [
//     { item: "Burger", price: 150 },
//     { item: "Pasta", price: 250 },
//     { item: "Brownie", price: 350 },
//     { item: "Meals", price: 170 }
// ];

// console.log("***MENU***");
// for (let i = 0; i < menu.length; i++) {
//     console.log(menu[i].item + " - Rs." + menu[i].price);
// }

// let custOrder = ["Burger", "Pasta", "Brownie", "Meals"]; 
// if (custOrder.length === 0) {
//     console.log("No items ordered by customer");
// } else {
//     console.log("\nCustomer ordered: " + custOrder.join(", "));
// }

// let total = 0;
// for (let i = 0; i < custOrder.length; i++) {
//     let orderedItem = custOrder[i];
//     let found = false;
//     for (let j = 0; j < menu.length; j++) {
//         if (orderedItem === menu[j].item) {
//             total += menu[j].price;
//             found = true;
//             break;  
//         }
//     }
//     if (!found) {
//         console.log("Item not found in menu: " + orderedItem);
//     }
// }

// let discount = 0;
// if (custOrder.length > 3) {
//     discount = total * 0.10;  
//     total -= discount;
// }

// console.log("\n***Order Details***");
// for (let i = 0; i < custOrder.length; i++) {
//     console.log("Item: " + custOrder[i]);
// }
// console.log("Discount applied: Rs." + discount.toFixed(2));
// console.log("Total Rs. to pay: Rs." + total.toFixed(2));


// const items = {
//     burger: 120,
//     pizza: 250,
//     pasta: 180,
//     coffee: 80
// };

// let order = ["burger", "pizza", "pasta", "coffee"];
// let total = 0;

// // Calculate total price of ordered items
// for (let i = 0; i < order.length; i++) {
//     let item = order[i];
//     if (items[item]) {
//         total += items[item];
//     } else {
//         console.log("Item is not in the list: " + item);
//     }
// }

// let discount = 0;
// console.log("Total price: " + total);

// // Apply discount if order has more than 3 items
// if (order.length > 3) {
//     discount = total * 0.10;
//     console.log("Discount applied: " + discount);
// }

// const totalbill = total - discount;

// // Create bill object
// const bill = {
//     itemsOrdered: order,      // array of items
//     discountApplied: discount,
//     finalAmount: totalbill
// };

// // Output the bill object as formatted JSON
// console.log(JSON.stringify(bill, null, 2));

// // Output final price
// console.log("Final price is: " + totalbill);


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
