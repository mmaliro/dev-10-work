import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { deleteById, findById } from "../services/sightingService";

function Delete() {

    const [sighting, setSighting] = useState();
    const navigate = useNavigate();
    const { id } = useParams();

    useEffect(() => {
        if (id) {
            findById(id)
                .then(setSighting)
                .catch(() => navigate("/"));
        } else {
            navigate("/");
        }
    }, [id, navigate])

    const cancel = () => navigate("/");
    const handleDelete = () => {
        deleteById(id)
            .then(() => navigate("/"))
            .catch(() => navigate("/error", { state: { msg: "👎🏾" } }));
    };

    return (
        <>
            <div>Are you sure you want to delete {sighting && sighting.bugType}?</div>
            <div>
                <button onClick={handleDelete}>Yes, Delete</button>
                <button onClick={cancel}>No, Cancel</button>
            </div>
        </>
    )
}

export default Delete;