import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Confirmation from "./components/Confirmation";
import Delete from "./components/Delete";
import Error from "./components/Error";
import Home from "./components/Home";
import NavBar from "./components/NavBar";
import NotFound from "./components/NotFound";
import SightingForm from "./components/SightingForm";

function App() {
  return (
    <Router>
      <NavBar />

      <Routes>
        <Route path="/add" element={<SightingForm />} />
        <Route path="/edit/:id" element={<SightingForm />} />
        <Route path="/delete/:id" element={<Delete />} />
        <Route path="/confirmation" element={<Confirmation />} />
        <Route path="/error" element={<Error />} />
        <Route path="/" element={<Home />} />
        <Route path="*" element={<NotFound />} />
      </Routes>
    </Router>
  );
}

export default App;