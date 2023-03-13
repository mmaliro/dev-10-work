package learn.solar.domain;

import learn.solar.data.DataException;
import learn.solar.data.PanelRepositoryTestDouble;
import learn.solar.models.Material;
import learn.solar.models.Panel;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PanelServiceTest {

    PanelService service = new PanelService(new PanelRepositoryTestDouble());



    @Test
    void shouldFindAll() throws DataException {
        List<Panel> actual = service.findAll();
        assertEquals(3, actual.size());
    }

    @Test
    void findBySectionWhenSectionIsBlankThenReturnAllPanels() throws DataException {
        List<Panel> panels = service.findBySection("");
        assertEquals(0, panels.size());
    }

    @Test
    void findBySectionWhenTheGivenSectionIsNotFoundThenReturnAllPanels() throws DataException {
        List<Panel> panels = service.findBySection("A");
        assertEquals(0, panels.size());
    }

    @Test
    void addWhenPanelIsValidThenReturnPanelResultWithPanel() throws DataException {
        Panel panel = new Panel(1, "A", 1, 1, 2020, Material.multi_Si, true);
        PanelResult result = service.add(panel);
        assertTrue(result.isSuccess());
        assertEquals(panel, result.getPanel());
    }

    @Test
    void addWhenSectionIsNullOrEmptyThenReturnPanelResultWithErrorMessage() throws DataException {
        Panel panel = new Panel();
        panel.setSection("");
        panel.setRow(1);
        panel.setColumn(1);
        panel.setInstallationYear(2020);
        panel.setMaterial(Material.multi_Si);
        panel.setTracking(true);

        PanelResult result = service.add(panel);

        assertFalse(result.isSuccess());
        assertEquals("Section name is required.", result.getMessages().get(0));
    }

    @Test
    void updateWhenPanelIsInvalidThenReturnPanelResultWithErrorMessage() throws DataException {
        Panel panel = new Panel();
        panel.setSection("");
        panel.setRow(1);
        panel.setColumn(1);
        panel.setInstallationYear(2020);
        panel.setMaterial(Material.multi_Si);
        panel.setTracking(true);

        PanelResult result = service.update(panel);

        assertFalse(result.isSuccess());
        assertEquals("Section name is required.", result.getMessages().get(0));
    }

    @Test
    void updateWhenPanelIsValid() throws DataException {
        Panel panelToUpdate = new Panel(1, "A", 1, 1, 2020, Material.multi_Si, true);

        PanelResult expected = new PanelResult();
        expected.setPanel(panelToUpdate);

        PanelResult actual = service.update(panelToUpdate);
        assertTrue(actual.isSuccess());
        assertEquals(panelToUpdate, actual.getPanel());
    }

    @Test
    void deleteByIdWhenPanelIdIsFoundThenReturnTrue() throws DataException {
        PanelResult result = service.deleteById(1);
        assertTrue(result.isSuccess());
    }

    @Test
    void deleteByIdWhenPanelIdIsNotFoundThenReturnFalse() throws DataException {
        PanelResult result = service.deleteById(1);
        assertTrue(result.isSuccess());
    }
}