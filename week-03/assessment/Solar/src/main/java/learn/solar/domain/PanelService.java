package learn.solar.domain;

import learn.solar.data.DataException;
import learn.solar.data.PanelRepository;
import learn.solar.models.Panel;

import java.util.List;

public class PanelService {
    private PanelRepository repository;

    public PanelService(PanelRepository repository) {
        this.repository = repository;
    }

    public List<Panel> findBySection() throws DataException {
        return repository.findBySection();
    }

    public Panel add(Panel panel) throws DataException {
        PanelResult result = validate(panel);
        if (!result.isSuccess()) {
            return null;
        }
        return repository.add(panel);
    }

    public boolean update(Panel panel) throws DataException {
        PanelResult result = validate(panel);
        if (!result.isSuccess()) {
            return false;
        }
        return repository.update(panel);
    }

    public boolean deleteById(int id) throws DataException {
        return repository.deleteById(id);
    }

    private PanelResult validate(Panel panel) {
        PanelResult result = new PanelResult();
        result.addMessage("Validation Successful");
        result.setPanel(panel);
        return result;
    }


}
