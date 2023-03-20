import { useLocation } from "react-router-dom";

function Confirmation() {
  const location = useLocation();

  return (
    <p>
      CRUD {location.state ? location.state.msg : "✅"}
    </p>
  );
}

export default Confirmation;
