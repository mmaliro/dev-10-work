const url = "http://localhost:8080/api/solarpanel";

export async function findAll() {
    const response = await fetch(url);
    if (response.ok) {
        // const panels = await response.json();
        // panels.sort((a, b) => a.id - b.id);
        // return Promise.resolve(panels);
        return response.json();
    }
    return Promise.reject("Could not fetch solar panels.")
}

export async function findById(panelId) {
    const response = await fetch(`${url}/${panelId}`);
    if (response.ok) {
        return response.json();
    }
    return Promise.reject(`Could not fetch solar panel with id ${panelId}.`)
}

export async function deleteById(panelId) {
    const response = await fetch(`${url}/${panelId}`, { method: "DELETE" });
    if (response.ok) {
        return;
    }
    return Promise.reject(`Could not delete solar panel with id ${panelId}.`)
}

async function postPutPatch(panel, method, theUrl) {

    const config = {
        method: method,
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(panel)
    }

    const response = await fetch(theUrl, config);
    if (response.ok) {
        if (method === "POST") {
            return response.json();
        }
        return;
    }

    if (response.status === 400) {
        const errors = await response.json();
        return Promise.reject(errors);
    }
    return Promise.reject();
}

async function update(panel) {
    return postPutPatch(panel, "PUT", `${url}/${panel.id}`);
}

async function add(panel) {
    return postPutPatch(panel, "POST", url);
}

export async function save(panel) {
    if (panel.id) {
        return update(panel);
    } else {
        return add(panel);
    }
}