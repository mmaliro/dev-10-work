import { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";
import { findById, save } from "../services/agentService";

function AgentsForm() {

    const [currentAgent, setCurrentAgent] = useState({
        agentId: "",
        firstName: "",
        middleName: "",
        lastName: "",
        dob: "",
        heightInInches: ""
    });
    const [errors, setErrors] = useState([]);
    const [wait, setWait] = useState(true);

    const navigate = useNavigate();
    const { agentId } = useParams();

    useEffect(() => {
        if (agentId) {
            findById(agentId)
                .then(agent => {
                    setCurrentAgent(agent);
                    setWait(false);
                })
                .catch(() => navigate("/agents"));

        } else {
            setWait(false);
        }
    }, [agentId, navigate]);


    function handleSubmit(evt) {
        evt.preventDefault();
        save(currentAgent)
            .then(() => navigate("/agents"))
            .catch(errs => {
                if (errs) {
                    setErrors(errs);
                } else {
                    navigate("/agents");
                }
            });
    }

    function handleChange(evt) {
        const { name, value } = evt.target;
        setCurrentAgent(prevState => ({ ...prevState, [name]: value }));
    }

    if (wait) {
        return null;
    }

    return (
        <form onSubmit={handleSubmit}>
            <div>
                <label htmlFor="firstName" className="form-label">First Name</label>
                <input type="text" id="firstName" name="firstName" className="form-control"
                    value={currentAgent.firstName} onChange={handleChange} required />
            </div>
            <div>
                <label htmlFor="middleName" className="form-label">Middle Initial</label>
                <input type="text" id="middleName" name="middleName" className="form-control"
                    value={currentAgent.middleName} onChange={handleChange} required />
            </div>
            <div>
                <label htmlFor="lastName" className="form-label">Last Name</label>
                <input type="text" id="lastName" name="lastName" className="form-control"
                    value={currentAgent.lastName} onChange={handleChange} required />
            </div>
            <div>
                <label htmlFor="dob" className="form-label">DOB</label>
                <input type="date" id="dob" name="dob" className="form-control"
                    value={currentAgent.dob} onChange={handleChange} required />
            </div>
            <div>
                <label htmlFor="heightInInches" className="form-label">Height In Inches</label>
                <input type="number" id="heightInInches" name="heightInInches"
                    value={currentAgent.heightInInches} onChange={handleChange} required />  
            </div>
        
            <div>
                <button type="submit" className="btn btn-primary me-2">Save</button>
                <Link to="/" className="btn btn-warning">Cancel</Link>
            </div>
            {errors.length > 0 && <div className="alert alert-danger mt-2">
                <ul>
                    {errors.map(err => <li key={err}>{err}</li>)}
                </ul>
            </div>}
        </form>
    );
}

export default AgentsForm;