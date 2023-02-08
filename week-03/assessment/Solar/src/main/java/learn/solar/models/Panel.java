package learn.solar.models;

import java.util.Calendar;
import java.util.Objects;

public class Panel {
    private int id;
    private String section;
    private int row;
    private int column;
    private int installationYear;
    private Material material;
    private boolean isTracking;

    public Panel(String section, int row, int column, int yearInstalled, Material material) {
        this.id = id;
        this.section = section;
        this.row = row;
        this.column = column;
        this.installationYear = installationYear;
        this.material = material;
        this.isTracking = isTracking;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSection() {

        return section;
    }

    public void setSection(String section) {
        if (section == null || section.trim().isEmpty()) {
            throw new IllegalArgumentException("Section is required and cannot be blank.");
        }
        this.section = section;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        if (row <= 0 || row > 250) {
            throw new IllegalArgumentException("Row must be a positive number less than or equal to 250.");
        }
        this.row = row;
    }

    public int getColumn() {

        return column;
    }

    public void setColumn(int column) {
        if (column <= 0 || column > 250) {
            throw new IllegalArgumentException("Column must be a positive number less than or equal to 250.");
        }
        this.column = column;
    }

    public int getInstallationYear() {
        return installationYear;
    }

    public void setInstallationYear(int installationYear) {
        Calendar calendar = Calendar.getInstance();
        if (installationYear >= calendar.get(Calendar.YEAR)) {
            throw new IllegalArgumentException("Year Installed must be in the past.");
        }
        this.installationYear = installationYear;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        if (material == null || material.isEmpty() || !(material.equals("Multicrystalline Silicon") || material.equals("Monocrystalline Silicon") || material.equals("Amorphous Silicon") || material.equals("Cadmium Telluride") || material.equals("Copper Indium Gallium Selenide"))) {
            throw new IllegalArgumentException("Material is required and can only be one of the five materials listed.");
        }
            this.material = material;
        }



    public boolean isTracking() {
        return isTracking;
    }

    public void setTracking(boolean tracking) {
        this.isTracking = isTracking;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Panel panel = (Panel) o;

        if (id != panel.id) return false;
        if (row != panel.row) return false;
        if (column != panel.column) return false;
        if (installationYear != panel.installationYear) return false;
        if (isTracking != panel.isTracking) return false;
        if (!Objects.equals(section, panel.section)) return false;
        return material == panel.material;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (section != null ? section.hashCode() : 0);
        result = 31 * result + row;
        result = 31 * result + column;
        result = 31 * result + installationYear;
        result = 31 * result + (material != null ? material.hashCode() : 0);
        result = 31 * result + (isTracking ? 1 : 0);
        return result;
    }
}
