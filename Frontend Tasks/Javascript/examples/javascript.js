const num1 = parseInt(prompt("Enter first number"));
const num2 = parseInt(prompt("Enter second number"));

const add = (num1,num2) => num1 + num2;
const sub = (num1,num2) => num1 - num2;
document.writeln(`The addition of ${num1} and ${num2} is: ${add(num1,num2)}`);
document.writeln(`The subtraction of ${num1} and ${num2} is: ${sub(num1,num2)}`);
