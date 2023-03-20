import { Link } from "react-router-dom";

function Panel({ panel }) {

    return (
        <div className="row mb-2">
            <div className="col">{panel.id}</div>
            <div className="col">{panel.section}</div>
            <div className="col">{panel.row}</div>
            <div className="col">{panel.column}</div>
            <div className="col">{panel.yearInstalled}</div>
            <div className="col">{panel.material}</div>
            <div className="col">{panel.tracking ? "✔" : "❌"}</div>
            <div className="col-2 d-flex justify-content-end">
                <Link to={`/delete/${panel.id}`} className="btn btn-danger me-1">🗑</Link>
                <Link to={`/edit/${panel.id}`} className="btn btn-info">📝</Link>
            </div>
        </div>
    );
}

export default Panel;