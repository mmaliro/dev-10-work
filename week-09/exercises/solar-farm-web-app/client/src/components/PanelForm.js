import { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";
import { findById, save } from "../services/panelService";

function PanelForm() {

    const [currentPanel, setCurrentPanel] = useState({
        section: "",
        row: "",
        column: "",
        yearInstalled: "",
        material: "",
        tracking: true
    });
    const [errors, setErrors] = useState([]);
    const [wait, setWait] = useState(true);

    const navigate = useNavigate();
    const { id } = useParams();

    useEffect(() => {
        if (id) {
            findById(id)
                .then(panel => {
                    setCurrentPanel(panel);
                    setWait(false);
                })
                .catch(() => navigate("/"));

        } else {
            setWait(false);
        }
    }, [id, navigate]);

    function handleChange(evt) {
        const nextPanel = { ...currentPanel };
        if (evt.target.name === "tracking") {
            nextPanel[evt.target.name] = evt.target.checked;
        } else {
            nextPanel[evt.target.name] = evt.target.value;
        }
        setCurrentPanel(nextPanel);
    }

    function handleSubmit(evt) {
        evt.preventDefault();
        save(currentPanel)
            .then(() => navigate("/"))
            .catch(errs => {
                if (errs) {
                    setErrors(errs);
                } else {
                    navigate("/");
                }
            });
    }

    if (wait) {
        return null;
    }

    return (
        <form onSubmit={handleSubmit}>
            <div>
                <label htmlFor="section" className="form-label">Section</label>
                <input type="text" id="section" name="section" className="form-control"
                    value={currentPanel.section} onChange={handleChange} required />
            </div>
            <div>
                <label htmlFor="row" className="form-label">Row</label>
                <input type="number" id="row" name="row" className="form-control"
                    value={currentPanel.row} onChange={handleChange} required />
            </div>
            <div>
                <label htmlFor="column" className="form-label">Column</label>
                <input type="number" id="column" name="column" className="form-control"
                    value={currentPanel.column} onChange={handleChange} required />
            </div>
            <div>
                <label htmlFor="yearInstalled" className="form-label">Year Installed</label>
                <input type="number" id="yearInstalled" name="yearInstalled" className="form-control"
                    value={currentPanel.yearInstalled} onChange={handleChange} required />
            </div>
            <div>
                <label htmlFor="material" className="form-label">Material</label>
                <select className="form-control" id="material" name="material"
                    value={currentPanel.material} onChange={handleChange} required>
                    <option value=""> [ Select a material ]</option>
                    <option value="POLY_SI">Multicrystalline Silicon</option>
                    <option value="MONO_SI">Monocrystalline Silicon</option>
                    <option value="A_SI">Amorphous Silicon</option>
                    <option value="CD_TE">Cadmium Telluride</option>
                    <option value="CIGS">Copper Indium Gallium Selenide</option>
                </select>
            </div>
            <div className="form-check my-2">
                <input className="form-check-input" type="checkbox" id="tracking" name="tracking"
                    checked={currentPanel.tracking} onChange={handleChange} />
                <label className="form-check-label" htmlFor="tracking">
                    Is Tracking?
                </label>
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

export default PanelForm;