
import {
  BrowserRouter as Router,
  Routes,
  Route
} from 'react-router-dom';
import Home from "./components/Home";
import Agent from "./components/Agent";
import ConfirmDelete from './components/ConfirmDelete';
import NavBar from './components/NavBar';
import Header from './components/Header';
import AgentsForm from './components/AgentsForm';

function App() {
  return (

    <Router>
      <div className="container">
        <NavBar />
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/agents" element={<Header />} />
          <Route path="/agents" element={<Agent />} />
          <Route path="/agents/add" element={<AgentsForm />} />
          <Route path="/agents/edit/:agentId" element={<AgentsForm />} />
          <Route path="/agents/delete/:agentId" element={<ConfirmDelete />} />
          <Route path="*" element={<h2>Not found</h2>} />
        </Routes>
      </div>
    </Router>

  );
}

export default App;