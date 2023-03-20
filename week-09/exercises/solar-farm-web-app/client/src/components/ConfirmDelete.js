import { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";
import { deleteById, findById } from "../services/panelService";

function ConfirmDelete() {

    const [panel, setPanel] = useState({});
    const navigate = useNavigate();
    const { id } = useParams();

    useEffect(() => {
        if (id) {
            findById(id)
                .then(setPanel)
                .catch(() => navigate("/"));

        } else {
            navigate("/");
        }
    }, [id, navigate]);

    function handleDelete() {
        deleteById(panel.id)
            .finally(() => navigate("/"));
    }

    return (
        <>
            <div className="alert alert-danger">
                Are you sure you want to delete panel {panel.section}-{panel.row}-{panel.column}?
            </div>
            <div>
                <button onClick={handleDelete} className="btn btn-danger me-2">Yes, Delete</button>
                <Link to="/" className="btn btn-warning">No, Cancel</Link>
            </div>
        </>
    );
}

export default ConfirmDelete;