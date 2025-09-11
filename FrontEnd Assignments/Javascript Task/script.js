const apiUrl = "https://dummy.restapiexample.com/api/v1/employees";
const loadingDiv = document.getElementById("loading");
const employeeTable = document.getElementById("employeeTable");
const tbody = document.querySelector("#employeeTable tbody");

// Show loading message
loadingDiv.style.display = "block";
employeeTable.style.display = "none";

fetch(apiUrl)
    .then(response => {
        if (!response.ok) {
            throw new Error(`HTTP error! Status: ${response.status}`);
        }
        return response.json();
    })
    .then(data => {
        const employees = data.data; // employee array

        employees.forEach(emp => {
            const row = document.createElement("tr");
            row.innerHTML = `
                <td>${emp.id}</td>
                <td>${emp.employee_name}</td>
                <td>${emp.employee_salary}</td>
                <td>${emp.employee_age}</td>
            `;
            tbody.appendChild(row);
        });

        // Hide loading message and show table
        loadingDiv.style.display = "none";
        employeeTable.style.display = "table";
    })
    .catch(error => {
        loadingDiv.textContent = "Failed to load data. Please try again later.";
        console.error("Error fetching data:", error);
    });
