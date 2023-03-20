import { useEffect, useState } from "react";
import { findAll } from "../services/panelService"
import Panel from "./Panel";

function Panels() {

    const [panels, setPanels] = useState([]);

    useEffect(() => {
        findAll()
            .then(setPanels)
            .catch(alert);
    }, []);

    return (
        <>
            <div className="row text-bg-dark mb-2">
                <div className="col">Id</div>
                <div className="col">Section</div>
                <div className="col">Row</div>
                <div className="col">Column</div>
                <div className="col">Year Installed</div>
                <div className="col">Material</div>
                <div className="col">Tracking</div>
                <div className="col-2"></div>
            </div>
            {panels.map(p => <Panel key={p.id} panel={p} />)}
        </>
    );
}

export default Panels;