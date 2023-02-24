package learn.solar.data;

import learn.solar.models.Material;
import learn.solar.models.Panel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PanelFileRepositoryTest {

    static final String SEED_FILE_PATH = "./data/solar-seed.csv";
    static final String TEST_FILE_PATH = "./data/solar-test.csv";
    PanelFileRepository repository = new PanelFileRepository(TEST_FILE_PATH);

    @BeforeAll
    static void setup() throws IOException {
        Path seedPath = Paths.get(SEED_FILE_PATH);
        Path testPath = Paths.get(TEST_FILE_PATH);

        Files.copy(seedPath, testPath, StandardCopyOption.REPLACE_EXISTING);
    }


    @Test
    void findBySectionWhenThereIsNoPanelInTheSection() throws DataException {
        String section = "A";

        var result = repository.findBySection(section);

        assertTrue(result.isEmpty());
    }

    @Test
    void findBySectionWhenThereArePanelsInTheSection() throws DataException {
        Panel panel1 = new Panel(1, "A", 1, 1, 2019, Material.multi_Si, true);
        Panel panel2 = new Panel(2, "A", 1, 2, 2019, Material.multi_Si, true);
        Panel panel3 = new Panel(3, "A", 1, 3, 2019, Material.multi_Si, true);

        List<Panel> panels = repository.findBySection("A");

        assertEquals(0, panels.size());
        assertFalse(panels.contains(panel1));
        assertFalse(panels.contains(panel2));
        assertFalse(panels.contains(panel3));
    }

    @Test
    void addWhenFileNotFoundThenThrowException() {
        PanelFileRepository repository = new PanelFileRepository("");
        Panel panel = new Panel();
        assertThrows(DataException.class, () -> repository.add(panel));
    }

    @Test
    void addWhenFileIsCorruptedThenThrowException() {
        PanelFileRepository repository = new PanelFileRepository(TEST_FILE_PATH);
        Panel panel = new Panel();
        panel.setPanelId(1);
        panel.setSection("A");
        panel.setRow(1);
        panel.setColumn(1);
        panel.setInstallationYear(2019);
        panel.setMaterial(Material.multi_Si);
        panel.setTracking(true);
    }

    @Test
    void shouldUpdate() throws DataException {
        Panel encounterToUpdate = new Panel(1, "Materials", 1, 2, 2020, Material.multi_Si, true);
        assertTrue(repository.update(encounterToUpdate));

        Panel actual = repository.findById(1);
        assertNotNull(actual);
        assertEquals(encounterToUpdate, actual);


    }

    @Test
    void shouldNotUpdate() throws DataException {
        Panel encounterToUpdate = new Panel(999999, "Materials", 1, 2, 2020, Material.multi_Si, true);
        assertFalse(repository.update(encounterToUpdate));
    }

    @Test
    void shouldDeleteById() throws DataException {
        boolean actual = repository.deleteById(1);
        assertTrue(actual);

        Panel result = repository.findById(1);
        assertNull(repository.findById(1));
    }

    @Test
    void shouldNotDeleteById() throws DataException {
        boolean actual = repository.deleteById(999999);
        assertFalse(actual);
    }
}