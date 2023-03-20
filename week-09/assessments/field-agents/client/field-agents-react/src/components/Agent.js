import { Link } from "react-router-dom";

function Agent({ agent }) {

    return (
        
        <div className="row mb-2">
            <div className="col">{agent.agentId}</div>
            <div className="col">{agent.firstName}</div>
            <div className="col">{agent.middleName}</div>
            <div className="col">{agent.lastName}</div>
            <div className="col">{agent.dob}</div>
            <div className="col">{agent.heightInInches}</div>
            <div className="col-3 d-flex justify-content-end">
                <Link to={`/agents/delete/${agent.agentId}`} className="btn btn-danger me-1">🗑</Link>
                <Link to={`/agents/edit/${agent.agentId}`} className="btn btn-info">📝</Link>
            </div>
        </div>
    );
}

export default Agent;