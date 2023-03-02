package learn.solar.data;

import learn.solar.models.Material;
import learn.solar.models.Panel;

import java.util.ArrayList;
import java.util.List;

public class PanelRepositoryTestDouble implements PanelRepository {

    private List<Panel> panels = new ArrayList<>(List.of(
            new Panel(1, "Material.multi_Si", 1, 2, 2020, Material.multi_Si, true),
            new Panel(1, "Material.multi_Si", 1, 2, 2020, Material.multi_Si, true),
            new Panel(1, "Material.multi_Si", 1, 2, 2020, Material.multi_Si, true)));

    @Override
    public List<Panel> findBySection(String section) throws DataException {
        ArrayList<Panel> result = new ArrayList<>();
        List<Panel> panels = findAll();
        for (Panel panel : panels) {
            if (panel.getSection().equals(section)) {
                result.add(panel);
            }

        }

        return result;
    }



    @Override
    public List<Panel> findAll() throws DataException {
        return panels;
    }

    @Override
    public Panel add(Panel panel) throws DataException {
        return panel;
    }

    @Override
    public boolean update(Panel panel) throws DataException {
        return panel.getPanelId() == 1;
    }

    @Override
    public boolean deleteById(int panelId) throws DataException {
        return panelId == 1;
    }
}
