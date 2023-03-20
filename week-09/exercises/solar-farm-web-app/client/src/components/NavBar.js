import { Link } from "react-router-dom";

function NavBar() {

    return (
        <nav className="navbar">
            <h1>Solar Farm</h1>
            <div className="col d-flex justify-content-end">
                <Link to="/add" className="btn btn-primary">Add Panel</Link>
            </div>
        </nav>
    );
}

export default NavBar;