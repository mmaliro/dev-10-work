package learn.solar.models;

import java.util.Calendar;
import java.util.Objects;

public class Panel {
    private int panelId;
    private String section;
    private int row;
    private int column;
    private int installationYear;
    private Material material;
    private boolean isTracking;

    public Panel(int panelId, String section, int row, int column, int installationYear, Material material, boolean isTracking) {
        this.panelId = panelId;
        this.section = section;
        this.row = row;
        this.column = column;
        this.installationYear = installationYear;
        this.material = material;
        this.isTracking = isTracking;
    }

    public Panel() {
    }

    public int getPanelId() {
        return panelId;
    }

    public void setPanelId(int panelId) {
        this.panelId = panelId;
    }

    public String getSection() {

        return section;
    }

    public void setSection(String section) {

        this.section = section;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {

        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getInstallationYear() {
        return installationYear;
    }

    public void setInstallationYear(int installationYear) {
        this.installationYear = installationYear;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
            this.material = material;
        }



    public boolean isTracking() {
        return isTracking;
    }

    public void setTracking(boolean tracking) {
        isTracking = tracking;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Panel panel = (Panel) o;

        if (panelId != panel.panelId) return false;
        if (row != panel.row) return false;
        if (column != panel.column) return false;
        if (installationYear != panel.installationYear) return false;
        if (isTracking != panel.isTracking) return false;
        if (!Objects.equals(section, panel.section)) return false;
        return material == panel.material;
    }

    @Override
    public int hashCode() {
        int result = panelId;
        result = 31 * result + (section != null ? section.hashCode() : 0);
        result = 31 * result + row;
        result = 31 * result + column;
        result = 31 * result + installationYear;
        result = 31 * result + (material != null ? material.hashCode() : 0);
        result = 31 * result + (isTracking ? 1 : 0);
        return result;
    }


}
