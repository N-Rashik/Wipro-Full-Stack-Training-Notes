// JavaScript to toggle Home and TimeTable sections

document.getElementById('timeTableBtn').addEventListener('click', () => {
  document.getElementById('timeTableSection').style.display = 'block';
  document.getElementById('homeSection').style.display = 'none';

  // Update active menu styling
  setActiveNav('timeTableBtn');
});

document.getElementById('homeBtn').addEventListener('click', () => {
  document.getElementById('timeTableSection').style.display = 'none';
  document.getElementById('homeSection').style.display = 'block';

  // Update active menu styling
  setActiveNav('homeBtn');
});

function setActiveNav(activeId) {
  document.querySelectorAll('.nav-link').forEach(link => {
    if (link.id === activeId) {
      link.classList.add('active');
    } else {
      link.classList.remove('active');
    }
  });
}
