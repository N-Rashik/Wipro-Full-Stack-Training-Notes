
const STORAGE_KEY = "restaurant_menu_items";

function getStoredItems() {
  const data = localStorage.getItem(STORAGE_KEY);
  if (data) return JSON.parse(data);
  return [];
}

function saveStoredItems(items) {
  localStorage.setItem(STORAGE_KEY, JSON.stringify(items));
}


function apicreateitem(item) {
  return new Promise((resolve) => {
    setTimeout(() => {
      const items = getStoredItems();
      item.id = Date.now().toString(); 
      items.push(item);
      saveStoredItems(items);
      resolve(item);
    }, 300);
  });
}

function apigetAllitems() {
  return new Promise((resolve) => {
    setTimeout(() => {
      resolve(getStoredItems());
    }, 300);
  });
}

function apideleteitem(id) {
  return new Promise((resolve) => {
    setTimeout(() => {
      let items = getStoredItems();
      items = items.filter((item) => item.id !== id);
      saveStoredItems(items);
      resolve(true);
    }, 300);
  });
}

function apiupdateitem(updatedItem) {
  return new Promise((resolve) => {
    setTimeout(() => {
      let items = getStoredItems();
      items = items.map((item) =>
        item.id === updatedItem.id ? updatedItem : item
      );
      saveStoredItems(items);
      resolve(updatedItem);
    }, 300);
  });
}

// DOM references
const itemForm = document.getElementById("itemForm");
const itemsList = document.getElementById("itemsList");
const submitBtn = document.getElementById("submitBtn");
const itemIdInput = document.getElementById("itemId");
const itemNameInput = document.getElementById("itemName");
const itemDescriptionInput = document.getElementById("itemDescription");
const itemCategoryInput = document.getElementById("itemCategory");
const itemPriceInput = document.getElementById("itemPrice");
const itemAvailabilityInput = document.getElementById("itemAvailability");

let isEditing = false;

// Render list of menu items
function renderItems(items) {
  if (items.length === 0) {
    itemsList.innerHTML =
      '<div class="alert alert-info">No menu items found. Add some!</div>';
    return;
  }

  itemsList.innerHTML = "";
  items.forEach((item) => {
    const itemElem = document.createElement("div");
    itemElem.className =
      "list-group-item d-flex justify-content-between align-items-start flex-column flex-md-row";
    itemElem.innerHTML = `
      <div class="ms-2 me-auto">
        <div class="fw-bold">${item.itemName} <span class="badge bg-secondary">${item.category}</span></div>
        <div>${item.description}</div>
        <div>Price: ₹${parseFloat(item.price).toFixed(2)}</div>
        <div>Status: <span class="badge ${
          item.availability === "available"
            ? "bg-success"
            : "bg-danger"
        }">${item.availability}</span></div>
      </div>
      <div class="btn-group mt-2 mt-md-0" role="group" aria-label="actions">
        <button class="btn btn-sm btn-outline-primary edit-btn" data-id="${
          item.id
        }">Edit</button>
        <button class="btn btn-sm btn-outline-danger delete-btn" data-id="${
          item.id
        }">Delete</button>
      </div>
    `;
    itemsList.appendChild(itemElem);
  });
}

function loadItems() {
  apigetAllitems().then((items) => {
    renderItems(items);
  });
}

function resetForm() {
  itemForm.reset();
  itemIdInput.value = "";
  submitBtn.textContent = "Add Item";
  isEditing = false;
}

function fillForm(item) {
  itemIdInput.value = item.id;
  itemNameInput.value = item.itemName;
  itemDescriptionInput.value = item.description;
  itemCategoryInput.value = item.category;
  itemPriceInput.value = item.price;
  itemAvailabilityInput.value = item.availability;
  submitBtn.textContent = "Update Item";
  isEditing = true;
}

itemForm.addEventListener("submit", (e) => {
  e.preventDefault();

  const itemData = {
    itemName: itemNameInput.value.trim(),
    description: itemDescriptionInput.value.trim(),
    category: itemCategoryInput.value.trim(),
    price: parseFloat(itemPriceInput.value).toFixed(2),
    availability: itemAvailabilityInput.value,
  };

  if (isEditing) {
    if (!confirm("Are you sure you want to update this item?")) {
      return;
    }
    itemData.id = itemIdInput.value;
    apiupdateitem(itemData).then(() => {
      loadItems();
      resetForm();
    });
  } else {
    apicreateitem(itemData).then(() => {
      loadItems();
      resetForm();
    });
  }
});


itemsList.addEventListener("click", (e) => {
  if (e.target.classList.contains("edit-btn")) {
    const id = e.target.getAttribute("data-id");
    apigetAllitems().then((items) => {
      const item = items.find((i) => i.id === id);
      if (item) fillForm(item);
    });
  } else if (e.target.classList.contains("delete-btn")) {
    const id = e.target.getAttribute("data-id");
    if (confirm("Are you sure you want to delete this item?")) {
      apideleteitem(id).then(() => loadItems());
    }
  }
});


loadItems();
