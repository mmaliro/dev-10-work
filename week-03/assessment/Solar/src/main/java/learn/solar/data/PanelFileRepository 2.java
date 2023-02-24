package learn.solar.data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import learn.solar.models.Material;
import learn.solar.models.Panel;

public class PanelFileRepository implements PanelRepository {

    private String filePath;
    private static final String DELIMITER = ",";

    private static final String DELIMITER_REPLACEMENT = "@@@";
    private static final String HEADER = "panelId, sectionName, row, column, installationYear, material, tracking";


    public PanelFileRepository(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Panel> findBySection(String section) throws DataException {
        ArrayList<Panel> result = new ArrayList<>();
        List<Panel> panels = findAll();
        for (Panel panel : panels) {
            if (panel.getSection() == section) {
                result.add(panel);
            }

        }

        return result;
    }


    @Override
    public Panel add(Panel panel) throws DataException {
        List<Panel> all = findAll();
        panel.setPanelId(getNextId(all));
        all.add(panel);
        writeAll(all);
        return panel;
    }


    private int getNextId(List<Panel> allPanels) {
        int nextId = 0;
        for (Panel e : allPanels) {
            nextId = Math.max(nextId, e.getPanelId());
        }
        return nextId + 1;
    }

    @Override
    public boolean update(Panel panel) throws DataException {
        List<Panel> panels = findAll();
        boolean isSuccessful = false;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Panel p : panels) {
                if (p.getPanelId() == panel.getPanelId()) {
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
    public boolean deleteById(int panelId) throws DataException {
        List<Panel> all = findAll();
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getPanelId() == panelId) {
                all.remove(i);
                writeAll(all);
                return true;
            }
        }
        return false;
    }


    @Override
    public List<Panel> findAll() throws DataException {
        ArrayList<Panel> result = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            for (String line = br.readLine(); line != null; line = br.readLine()) {
                Panel panel = deserialize(line);
                if (panel != null) {
                    result.add(panel);
                }
            }

            } catch (FileNotFoundException ex) {

        } catch (IOException ex) {
            throw new DataException(ex.getMessage());
        }

        return result;
    }

    private void writeAll(List<Panel> panels) throws DataException {
        try (PrintWriter writer = new PrintWriter(filePath)) {
            writer.println(HEADER);
            for (Panel e : panels) {
                writer.println(serialize(e));
            }
        } catch (IOException ex) {
            throw new DataException(ex.getMessage(), ex);
        }
    }


    private String serialize(Panel panel) {
        return String.format("%s,%s,%s,%s,%s,%s,%s",
                panel.getPanelId(),
                panel.getSection(),
                clean(String.valueOf(panel.getRow())),
                clean(String.valueOf(panel.getColumn())),
                panel.getInstallationYear(),
                panel.getMaterial(),
                panel.isTracking());
    }

    private Panel deserialize(String line) {
        String[] parts = line.split(DELIMITER, -1);
        if (parts.length == 7) {
            Panel panel = new Panel();
            panel.setPanelId(Integer.parseInt(parts[0]));
            panel.setSection(restore(parts[1]));
            panel.setRow(Integer.parseInt(parts[2]));
            panel.setColumn(Integer.parseInt(parts[3]));
            panel.setInstallationYear(Integer.parseInt(parts[4]));
            panel.setMaterial(Material.valueOf(parts[5]));
            panel.setTracking(Boolean.parseBoolean((parts[6])));
            return panel;
        }

        return null;
    }

    private String clean(String value) {
        return value.replace(DELIMITER, DELIMITER_REPLACEMENT);
    }

    private String restore(String value) {
        return value.replace(DELIMITER_REPLACEMENT, DELIMITER);
    }


}


