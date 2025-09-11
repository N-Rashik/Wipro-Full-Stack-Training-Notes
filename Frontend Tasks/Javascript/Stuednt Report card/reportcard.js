function generateReport() {
    const name = document.getElementById("studentName").value.trim();
    const marksInput = document.getElementById("marks").value.trim();

    if (!name || !marksInput) {
        alert("Please enter both student name and marks.");
        return;
    }

    // Split marks by comma and convert to numbers
    const marksArr = marksInput
      .split(",")
      .map((m) => m.trim())
      .filter((m) => m !== "")
      .map(Number);

    if (marksArr.length !== 3 || marksArr.some(isNaN)) {
        alert("Please enter valid marks for Math, Science, and English separated by commas.");
        return;
    }

    const subjects = ["Math", "Science", "English"];

    // Function to calculate grade based on marks
    function getGrade(mark) {
        if (mark >= 90) return "A+";
        if (mark >= 80) return "A";
        if (mark >= 70) return "B+";
        if (mark >= 60) return "B";
        if (mark >= 50) return "C";
        return "F";
    }

    // Build table rows with subjects, marks and grades
    let tableRows = "";
    let reportData = { studentName: name, results: [] };

    for (let i = 0; i < subjects.length; i++) {
        const grade = getGrade(marksArr[i]);
        tableRows += `
            <tr>
                <td>${subjects[i]}</td>
                <td>${marksArr[i]}</td>
                <td>${grade}</td>
            </tr>
        `;
        reportData.results.push({
            subject: subjects[i],
            marks: marksArr[i],
            grade: grade,
        });
    }

    // Display image
    const studentImage = document.getElementById("studentImage");
    studentImage.src =
     "https://cdn.pixabay.com/photo/2023/10/05/11/06/student-8295511_1280.png";
    studentImage.style.display = "block";

    // Display student name and marks table
    document.getElementById("displayName").textContent = name;
    document.getElementById("marksTable").innerHTML = tableRows;
    document.getElementById("reportSection").style.display = "block";

    // Log the JSON to console
    console.log(JSON.stringify(reportData, null, 4));
}
