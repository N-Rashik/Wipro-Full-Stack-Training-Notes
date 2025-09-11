function updateTimer() {
    document.getElementById('timer').textContent = new Date().toLocaleTimeString();
}

setInterval(updateTimer, 1000);
updateTimer();


function createTodo() {
  let tasks = []; // empty list to keep  task

  return {
    add: t => t && tasks.push(t),
    remove: () => tasks.pop(),
    removeAt: (index) => {
      if(index >= 0 && index < tasks.length) {
      }
    },
    get: () => tasks.slice()
  };
}

const todo = createTodo();

const taskInput = document.getElementById('taskInput');
const taskList = document.getElementById('taskList');

document.getElementById('addBtn').onclick = () => {
  const task = taskInput.value.trim(); 
  if (!task) return alert('Enter task'); 
  todo.add(task); 
  taskInput.value = ''; 
  alert('Task added'); 
};

document.getElementById('removeBtn').onclick = () => {
  if (todo.get().length === 0) return alert('No tasks'); 
  todo.remove(); 
  alert('Last task removed'); 
  showTasks(); 
};

document.getElementById('showBtn').onclick = () => showTasks();

function showTasks() {
  const tasks = todo.get(); 
  if(tasks.length === 0) {
    taskList.innerHTML = '<li>No tasks</li>'; s
    return;
  }

  taskList.innerHTML = tasks.map((task, index) =>
    `<li>${task} <button onclick="removeTask(${index})">Remove</button></li>`
  ).join('');
}

function removeTask(index) {
  todo.removeAt(index); 
  showTasks(); 
}


document.getElementById('calcBtn').onclick = () => {
  const n1 = +document.getElementById('num1').value;
  const n2 = +document.getElementById('num2').value;
  
  const operator = document.getElementById('operation').value;

  if (!n1 || !n2) return alert('Enter valid numbers');

  let res; 

  if (operator === '+') res = n1 + n2;
  else if (operator === '-') res = n1 - n2;
  else res = n1 * n2;

  document.getElementById('result').textContent = res;
};
