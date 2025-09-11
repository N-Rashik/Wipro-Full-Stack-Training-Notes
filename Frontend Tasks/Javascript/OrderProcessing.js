let menu = [
    { item: "Burger", price: 150 },
    { item: "Pasta", price: 250 },
    { item: "Brownie", price: 350 },
    { item: "Meals", price: 170 }
];

console.log("***MENU***");
for (let i = 0; i < menu.length; i++) {
    console.log(menu[i].item + " - Rs." + menu[i].price);
}

let custOrder = ["Burger", "Pasta", "Brownie", "meals"];
if (custOrder.length == 0) {
    console.log("No items ordered by customer");
} else {
    console.log("\nCustomer ordered: " + custOrder.join(", "));
}

let total = 0;
for (let i = 0; i < custOrder.length; i++) {
    for (let j = 0; j < menu.length; j++) {
        if (custOrder[i] === menu[j].item) {
            total += menu[j].price;
        }
    }
}

let discount = 0;
if (custOrder.length > 3) {
    discount = total * 0.10;
    total -= discount;
}

console.log("\n***Order Details***");
for (let i = 0; i < custOrder.length; i++) {
    console.log("Item: " + custOrder[i]);
}
console.log("Discount applied: Rs." + discount);
console.log("Total Rs. to pay: Rs." + total);
