import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { findAll } from "../services/sightingService";
import Sighting from "./Sighting";

function Home() {

  const [sightings, setSightings] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    findAll()
      .then(setSightings)
      .catch(error => navigate("/error", { state: { msg: error } }))
  }, [navigate]); // this will happen only once when the component is loaded

  return sightings.map((sighting) => (
    <Sighting key={sighting.sightingId} sighting={sighting} />
  ));
}

export default Home;