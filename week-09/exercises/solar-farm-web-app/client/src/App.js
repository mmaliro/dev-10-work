import {
  BrowserRouter as Router,
  Routes,
  Route
} from 'react-router-dom';
import ConfirmDelete from './components/ConfirmDelete';
import NavBar from './components/NavBar';
import Panels from './components/Panels';
import PanelForm from './components/PanelForm';

function App() {
  return (

    <Router>
      <div className="container">
        <NavBar />
        <Routes>
          <Route path="/" element={<Panels />} />
          <Route path="/add" element={<PanelForm />} />
          <Route path="/edit/:id" element={<PanelForm />} />
          <Route path="/delete/:id" element={<ConfirmDelete />} />
          <Route path="*" element={<h2>Not found</h2>} />
        </Routes>
      </div>
    </Router>

  );
}

export default App;