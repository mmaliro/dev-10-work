package learn.solar.domain;

import learn.solar.data.DataException;
import learn.solar.data.PanelRepository;
import learn.solar.models.Material;
import learn.solar.models.Panel;

import java.util.List;
import java.util.Objects;

public class PanelService {
    private PanelRepository repository;

    public PanelService(PanelRepository repository) {
        this.repository = repository;
    }

    public List<Panel> findAll() throws DataException{
        return repository.findAll();
    }

    public List<Panel> findBySection(String section) throws DataException {
        return repository.findBySection(section);
    }

    public PanelResult add(Panel panel) throws DataException {
        PanelResult result = validate(panel);
        if (!result.isSuccess()) {
            return result;
        }

        panel = repository.add(panel);
        result.setPanel(panel);
        return result;

    }

    public PanelResult update(Panel panel) throws DataException {
        PanelResult result = validate(panel);
        if (!result.isSuccess()) {
            return result;
        }
        if (panel.getPanelId() <= 0) {
            result.addMessage("Panel Id is required");
        }

        if (result.isSuccess()) {
            if (repository.update(panel)) {
                result.setPanel(panel);
            } else {
                String message = String.format("Panel Id %s was not found.", panel.getPanelId());
                result.addMessage(message);
            }
        }
        return result;
    }

    public PanelResult deleteById(int solarId) throws DataException {
        PanelResult result = new PanelResult();
        if (!repository.deleteById(solarId)) {
            String message = String.format("Encounter Id %s was not found.", solarId);
            result.addMessage(message);
        }
        return result;

    }

    private PanelResult validate(Panel panel) throws DataException {
        PanelResult result = new PanelResult();
        if (panel == null) {
            result.addMessage("Field cannot be null");
            return result;
        }

        if (panel.getSection() == null || panel.getSection().trim().length() == 0) {
            result.addMessage("Section name is required.");
        }

        if (panel.getRow() <= 0 || panel.getRow() > 250) {
            result.addMessage("Enter row number from 1 to 250.");
        }

        if (panel.getColumn() <= 0 || panel.getColumn() > 250) {
            result.addMessage("Enter column number from 1 to 250");
        }

        if (panel.getInstallationYear() >= 2023) {
            result.addMessage("Installation year should be in the past");
        }

        if (panel.getMaterial() != Material.multi_Si || panel.getMaterial() != Material.mono_Si || panel.getMaterial() != Material.A_Si || panel.getMaterial() != Material.CdTe || panel.getMaterial() != Material.CIGS) {
            result.addMessage("Must be one of the 5 materials on file.");
        }

        else {
            result.addMessage("Validation Successful");
        }

        List<Panel> panels = repository.findAll();
        for (Panel e : panels) {
            if (Objects.equals(panel.getPanelId(), e.getPanelId())
                    && Objects.equals(panel.getSection(), e.getSection())
                    && Objects.equals(panel.getRow(), e.getRow())
                    && Objects.equals(panel.getColumn(), e.getColumn())
                    && Objects.equals(panel.getInstallationYear(), e.getInstallationYear())
                    && Objects.equals(panel.getMaterial(), e.getMaterial())
                    && Objects.equals(panel.isTracking(), e.isTracking())) {
                result.addMessage("Duplicates are not allowed");
                break;
            }
        }
        return result;
    }


}
