const url = "http://localhost:8080/api/agent";

export async function findAll() {
    const response = await fetch(url);
    if (response.ok) {
      
        return response.json();
    }
    return Promise.reject("Could not fetch solar agents.")
}

export async function findById(agentId) {
    const response = await fetch(`${url}/${agentId}`);
    if (response.ok) {
        return response.json();
    }
    return Promise.reject(`Could not fetch agent with id ${agentId}.`)
}

export async function deleteById(agentId) {
    const response = await fetch(`${url}/${agentId}`, { method: "DELETE" });
    if (response.ok) {
        return;
    }
    return Promise.reject(`Could not delete agent with id ${agentId}.`)
}

async function postPutPatch(agent, method, theUrl) {

    const config = {
        method: method,
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(agent)
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

async function update(agent) {
    return postPutPatch(agent, "PUT", `${url}/${agent.agentId}`);
}

async function add(agent) {
    return postPutPatch(agent, "POST", url);
}

export async function save(agent) {
    if (agent.agentId) {
        return update(agent);
    } else {
        return add(agent);
    }
}