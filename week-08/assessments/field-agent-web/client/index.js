const url = "http://localhost:8080/api/agent";
const grid = document.getElementById("grid");
const form = document.querySelector("form");
const confirmDelete = document.getElementById("confirmDelete");
const errorMessage = document.getElementById("errorMessage");
let currentAgent;

function populateGrid(agents) {
    let html = `<div class="row bg-secondary text-light mb-2">
        <div class="col">Id</div>
        <div class="col">First Name</div>
        <div class="col">Middle Initial</div>
        <div class="col">Last Name</div>
        <div class="col">DOB</div>
        <div class="col">Height In Inches</div>
        <div class="col-3"></div>
        </div>`;
    for (const agent of agents) {
        html += `<div class="row mb-2">
        <div class="col">${agent.agentId}</div>
        <div class="col">${agent.firstName}</div>
        <div class="col">${agent.middleName}</div>
        <div class="col">${agent.lastName}</div>
        <div class="col">${agent.dob}</div>
        <div class="col">${agent.heightInInches}</div>
        <div class="col-3">
            <button type="button" class="btn btn-danger" onclick="deletePanel(${agent.agentId})">Delete</button>
            <button type="button" class="btn btn-info" onclick="editPanel(${agent.agentId})">Edit</button>
        </div>
        </div>`;
    }
    grid.innerHTML = html;
}

function findById(agentId, callback) {
    fetch(`${url}/${agentId}`)
        .then(response => {
            if (response.status === 200) {
                return response.json();
            }
            return Promise.reject("findById failed");
        })
        .then(agent => {
            currentAgent = agent;
            callback();
        })
        .catch(showErrorMessage);
}

function editAgent(agentId) {
    findById(agentId, showForm);
}

function deleteAgent(agentId) {
    findById(agentId, showConfirmDelete);
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
  
function getAgentFromForm() {
    const agentId = parseInt(document.getElementById("agentId").value, 10);
    const firstName = document.getElementById("firstName").value;
    const middleName = document.getElementById("middleName").value;
    const lastName = document.getElementById("lastName").value;
    const dob = document.getElementById("dob").value;
    const heightInInches = parseInt(document.getElementById("heightInInches").value, 10);
    return {
        agentId,
        firstName,
        middleName,
        lastName,
        dob,
        heightInInches
    };
}

function add() {
    const agent = getAgentFromForm();
    if (agent) {

        const config = {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(agent)
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
    const agent = getAgentFromForm();
    if (agent) {

        agent.agentId = currentAgent.agentId;

        const config = {
            method: "PUT",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(agent)
        }

        fetch(`${url}/${agent.agentId}`, config)
            .then(response => {
                if (response.status === 204) {
                    findAll();
                    showGrid();
                    currentAgent = null;
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
    if (currentAgent) {
        update();
    } else {
        add();
    }
}

function sendDelete() {
    fetch(`${url}/${currentAgent.agentId}`, { method: "DELETE" })
        .then(response => {
            if (response.status === 204) {
                currentAgent = null;
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
    currentAgent = null;
    form.reset();
}

function showForm() {
    if (currentAgent) {
        document.getElementById("agentId").value = currentAgent.agentId;
        document.getElementById("firstName").value = currentAgent.firstName;
        document.getElementById("middleName").value = currentAgent.middleName;
        document.getElementById("lastName").value = currentAgent.lastName;
        document.getElementById("dob").value = currentAgent.dob;
        document.getElementById("heightInInches").value = currentAgent.heightInInches;
    }
    grid.classList.add("d-none");
    form.classList.remove("d-none");
    confirmDelete.classList.add("d-none");
    errorMessage.classList.add("d-none");
}

function showConfirmDelete() {
    if (currentAgent) {
        const key = `${currentAgent.firstName}-${currentAgent.middleName}-${currentAgent.lastName}`;
        document.getElementById("agentKey").innerText = key;
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