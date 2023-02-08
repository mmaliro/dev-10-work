package learn.solar.data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import learn.solar.models.Panel;

public class PanelFileRepository implements PanelRepository {

    private String filePath;
    private final String delimiter = "~";


    public PanelFileRepository(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Panel> findBySection(String section) throws DataException {
        List<Panel> panels = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                Panel panel = deserialize(line);
                if (panel.getSection().equals(section)) {
                    panels.add(panel);
                }
            }
        } catch (IOException e) {
            throw new DataException("An error occurred while finding panels by section.", e);
        }

        return panels;
    }

    private Panel deserialize(String line) throws DataException {
        String[] parts = line.split(delimiter);

        return null;
    }


    @Override
    public List<Panel> findAll() throws DataException {
        List<Panel> panels = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                Panel panel = deserialize(line);
                panels.add(panel);
            }
        } catch (IOException e) {
            throw new DataException("An error occurred while finding all panels.", e);
        }

        return panels;
    }

    @Override
    public Panel add(Panel panel) throws DataException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            String line = serialize(panel);
            bw.write(line);
            bw.newLine();
        } catch (IOException e) {
            throw new DataException("An error occurred while adding panels.", e);
        }

        return panel;
    }

    @Override
    public boolean update(Panel panel) throws DataException {
        List<Panel> panels = findAll();
        boolean isSuccessful = false;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Panel p : panels) {
                if (p.getId() == panel.getId()) {
                    bw.write(serialize(panel));
                    bw.newLine();
                    isSuccessful = true;
                } else {
                    bw.write(serialize(p));
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            throw new DataException("An error occurred while updating the panel.", e);
        }

        return isSuccessful;
    }

    @Override
    public boolean deleteById(int id) throws DataException {
        return false;
    }

    @Override
    public List<Panel> findBySection() throws DataException {
        return null;
    }

    private String serialize(Panel panel) {
        return null;
    }


}


