import { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";
import { deleteById, findById } from "../services/agentService";

function ConfirmDelete() {

    const [agent, setAgent] = useState({});
    const navigate = useNavigate();
    const { agentId } = useParams();

    useEffect(() => {
        if (agentId) {
            findById(agentId)
                .then(setAgent)
                .catch(() => navigate("/agents"));

        } else {
            navigate("/agents");
        }
    }, [agentId, navigate]);

    function handleDelete() {
        deleteById(agent.agentId)
            .finally(() => navigate("/agents"));
    }

    return (
        <>
            <div className="alert alert-danger">
                Are you sure you want to delete agent {agent.firstName} {agent.lastName}?
            </div>
            <div>
                <button onClick={handleDelete} className="btn btn-danger me-2">Yes, Delete</button>
                <Link to="/agents" className="btn btn-warning">No, Cancel</Link>
            </div>
        </>
    );
}

export default ConfirmDelete;