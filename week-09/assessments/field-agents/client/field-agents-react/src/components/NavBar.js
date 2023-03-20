import { Link } from "react-router-dom";

function NavBar() {
  return (
    <nav>
      <ul>
        <li>
          <Link to="/">Home</Link>
        </li>
        <li>
          <Link to="/agents">Agents</Link>
        </li>
        <li>
          <Link to="/agents/add">Add an Agent</Link>
        </li>
      </ul>
    </nav>
  );
}

export default NavBar;
