const url = "http://localhost:8080/sighting";

export async function findAll() {
    const response = await fetch(url);
    if (response.ok) {
        return response.json();
    }
    return Promise.reject("Could not find Bugs.");
}

export async function findById(sightingId) {
    const response = await fetch(`${url}/${sightingId}`)
    if (response.ok) {
        return response.json();
    }
    return Promise.reject(`Could not find sighting id: ${sightingId}`)
}

export async function deleteById(sightingId) {
    const response = await fetch(`${url}/${sightingId}`, { method: "DELETE" })
    if (response.ok) {
        return;
    }
    return Promise.reject(`Could not find sighting id: ${sightingId}`)
}

async function update(sighting) {

    const config = {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(sighting)
    };

    const response = await fetch(`${url}/${sighting.sightingId}`, config);

    if (response.ok) {
        return;
    }

    if (response.status === 400) {
        const errors = await response.json();
        return Promise.reject(errors);
    }

    return Promise.reject();
}

async function add(sighting) {

    const config = {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(sighting)
    };

    const response = await fetch(url, config);

    if (response.ok) {
        return;
    }

    if (response.status === 400) {
        const errors = await response.json();
        return Promise.reject(errors);
    }

    return Promise.reject();
}

export async function save(sighting) {
    if (sighting.sightingId) {
        return update(sighting);
    } else {
        return add(sighting);
    }
}