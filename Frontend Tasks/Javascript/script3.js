function sayHello()
    {
alert("Hello All!Now click on a button to ddisplay the sum of two numbers.");

    }
function showTotal()
{
var num1=20;
var num2=32;
var total=num1+num2;

alert("Total is: "+total);
}

//get the references of a button
const helloButton=document.getElementById("button1");
const totalButton=document.getElementById("button2");

helloButton.addEventListener('click',sayHello);
totalButton.addEventListener('click',showTotal);