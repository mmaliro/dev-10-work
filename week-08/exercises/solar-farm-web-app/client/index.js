const url = "http://localhost:8080/api/solarpanel";
const grid = document.getElementById("grid");
const form = document.querySelector("form");
const confirmDelete = document.getElementById("confirmDelete");
const errorMessage = document.getElementById("errorMessage");
let currentPanel;

function populateGrid(panels) {
    let html = `<div class="row bg-secondary text-light mb-2">
        <div class="col">Id</div>
        <div class="col">Section</div>
        <div class="col">Row</div>
        <div class="col">Column</div>
        <div class="col">Installed</div>
        <div class="col">Material</div>
        <div class="col">Tracking?</div>
        <div class="col-3"></div>
        </div>`;
    for (const panel of panels) {
        html += `<div class="row mb-2">
        <div class="col">${panel.id}</div>
        <div class="col">${panel.section}</div>
        <div class="col">${panel.row}</div>
        <div class="col">${panel.column}</div>
        <div class="col">${panel.yearInstalled}</div>
        <div class="col">${panel.material}</div>
        <div class="col">${panel.tracking ? "✔" : "❌"}</div>
        <div class="col-3">
            <button type="button" class="btn btn-danger" onclick="deletePanel(${panel.id})">Delete</button>
            <button type="button" class="btn btn-info" onclick="editPanel(${panel.id})">Edit</button>
        </div>
        </div>`;
    }
    grid.innerHTML = html;
}

function findById(panelId, callback) {
    fetch(`${url}/${panelId}`)
        .then(response => {
            if (response.status === 200) {
                return response.json();
            }
            return Promise.reject("findById failed");
        })
        .then(panel => {
            currentPanel = panel;
            callback();
        })
        .catch(showErrorMessage);
}

function editPanel(panelId) {
    findById(panelId, showForm);
}

function deletePanel(panelId) {
    findById(panelId, showConfirmDelete);
}

function findAll() {

    fetch(url)
        .then(response => {
            if (response.status === 200) {
                return response.json();
            }
            return Promise.reject("Failed to fetch.");
        })
        .then(populateGrid)
        .catch(showErrorMessage);
}

function getPanelFromForm() {
    const row = parseInt(document.getElementById("row").value, 10);
    const column = parseInt(document.getElementById("column").value, 10);
    const yearInstalled = parseInt(document.getElementById("yearInstalled").value, 10);
    return {
        section: document.getElementById("section").value,
        row,
        column,
        yearInstalled,
        material: document.getElementById("material").value,
        tracking: document.getElementById("tracking").checked
    };
}

function add() {
    const panel = getPanelFromForm();
    if (panel) {

        const config = {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(panel)
        }

        fetch(url, config)
            .then(response => {
                if (response.status === 201) {
                    findAll();
                    showGrid();
                    return;
                } else if (response.status === 400) {
                    return response.json();
                }
                return Promise.reject("add failed");
            })
            .then(errors => {
                if (errors) {
                    showErrorMessage(errors);
                }
            })
            .catch(showErrorMessage);
    }
}

function update() {
    const panel = getPanelFromForm();
    if (panel) {

        panel.id = currentPanel.id;

        const config = {
            method: "PUT",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(panel)
        }

        fetch(`${url}/${panel.id}`, config)
            .then(response => {
                if (response.status === 204) {
                    findAll();
                    showGrid();
                    currentPanel = null;
                    return;
                } else if (response.status === 400) {
                    return response.json();
                }
                return Promise.reject("update failed");
            })
            .then(errors => {
                if (errors) {
                    showErrorMessage(errors);
                }
            })
            .catch(showErrorMessage);
    }
}

function save(evt) {
    evt.preventDefault();
    if (currentPanel) {
        update();
    } else {
        add();
    }
}

function sendDelete() {
    fetch(`${url}/${currentPanel.id}`, { method: "DELETE" })
        .then(response => {
            if (response.status === 204) {
                currentPanel = null;
                findAll();
                showGrid();
                return;
            }
            return Promise.reject("delete failed");
        })
        .catch(showErrorMessage);
}

function showGrid() {
    grid.classList.remove("d-none");
    form.classList.add("d-none");
    confirmDelete.classList.add("d-none");
    errorMessage.classList.add("d-none");
    currentPanel = null;
    form.reset();
}

function showForm() {
    if (currentPanel) {
        document.getElementById("section").value = currentPanel.section;
        document.getElementById("row").value = currentPanel.row;
        document.getElementById("column").value = currentPanel.column;
        document.getElementById("yearInstalled").value = currentPanel.yearInstalled;
        document.getElementById("material").value = currentPanel.material;
        document.getElementById("tracking").checked = currentPanel.tracking;
    }
    grid.classList.add("d-none");
    form.classList.remove("d-none");
    confirmDelete.classList.add("d-none");
    errorMessage.classList.add("d-none");
}

function showConfirmDelete() {
    if (currentPanel) {
        const key = `${currentPanel.section}-${currentPanel.row}-${currentPanel.column}`;
        document.getElementById("panelKey").innerText = key;
        grid.classList.add("d-none");
        form.classList.add("d-none");
        confirmDelete.classList.remove("d-none");
        errorMessage.classList.add("d-none");
    } else {
        showGrid();
    }

}

function showErrorMessage(message) {
    if (typeof message === "string") {
        errorMessage.innerText = message;
    } else { // else it's an array of strings
        errorMessage.innerHTML = `<ul>
            ${message.map(item => `<li>${item}</li>`).join("")}
        </ul>`
    }

    errorMessage.classList.remove("d-none");
}

// wiring up event handlers

document.getElementById("btnAdd")
    .addEventListener("click", () => showForm());

form.addEventListener("submit", save);

const cancelButtons = document.querySelectorAll(".cancel");
for (const btn of cancelButtons) {
    btn.addEventListener("click", showGrid);
}

document.getElementById("btnDelete")
    .addEventListener("click", sendDelete);

findAll();