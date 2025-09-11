function wait(time)
{
    //creating a promise that resolves after the provided time in milliseconds
    return new Promise(resolve => setTimeout(resolve,time));
    //before calling resolve() it will wait for milliseconds you have defined
}

//async function tell JS that this function will use promise and use the await keyword
// async function run(){
//     console.log("Started...");
//     await wait(1000);//it will wait for a second and then resolves
//     console.log("After 1000 ms it sis stopped");

// }

function fetchProducts() {
  return new Promise(resolve => {
    setTimeout(() => {
      resolve(["laptop", "Mouse", "speakers"]);
    }, 2000);
  });
}


async function displayProducts(){
    console.log("fetching the products from the backend");
    const products=await fetchProducts();
    const productList=document.getElementById("products");
    productList.innerHTML=products.map(p=>products);


}
displayProducts();

// const numbers=[5,6,7];
// numbers.map(n=> n*n);
// console.log(n);


