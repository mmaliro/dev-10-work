import { useEffect, useState } from "react";
import { findAll } from "../services/agentService"
import Agent from "./Agent";

function Header() {

    const [agents, setAgents] = useState([]);

    useEffect(() => {
        findAll()
            .then(setAgents)
            .catch(alert);
    }, []);

    return (
        <>
            <div className="row text-bg-dark mb-2">
                <div className="col">Id</div>
                <div className="col">First Name</div>
                <div className="col">Middle Initial</div>
                <div className="col">Last Name</div>
                <div className="col">DOB</div>
                <div className="col">Height In Inches</div>
                <div className="col-3"></div>
            </div>
            {agents.map(a => <Agent key={a.agentId} agent={a} />)}
        </>
    );
}

export default Header;