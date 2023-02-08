package learn.solar.ui;
import java.util.Scanner;
import java.util.List;
import learn.solar.domain.PanelResult;
import learn.solar.models.Material;
import learn.solar.models.Panel;

public class View {
    private Scanner console;

    public int chooseOptionFromMenu() {
        System.out.println("Please choose an option:");
        System.out.println("1. View panels by section");
        System.out.println("2. Add panel");
        System.out.println("3. Update panel");
        System.out.println("4. Delete panel");
        System.out.println("5. Exit");
        int choice = console.nextInt();
        return choice;
    }

    public void printHeader(String header) {
        System.out.println(header);
    }

    public void printResult(PanelResult result) {
        System.out.println(result.getMessages());
    }

    public void printPanels(String sectionName, List<Panel> panels) {
        System.out.println("Panels in section " + sectionName + ":");
        for (Panel panel : panels) {
            System.out.println(panel);
        }
    }

    public Panel choosePanel(String sectionName, List<Panel> panels) {
        System.out.println("Please choose a panel:");
        int i = 1;
        for (Panel panel : panels) {
            System.out.println(i + ". " + panel);
            i++;
        }
        int choice = console.nextInt();
        return panels.get(choice - 1);
    }

    public Panel makePanel() {
        System.out.println("Enter panel information:");
        String section = readRequiredString("Section:");
        int row = readInt("Row:", 1, 250);
        int column = readInt("Column:", 1, 250);
        int year = readInt("Installation year:", 1000, 9999);
        Material material = readMaterial();
        Panel panel = new Panel(section, row, column, year, material);
        return panel;
    }

    public Panel update(Panel panel) {
        System.out.println("Enter updated panel information:");
        String section = readString("Section (enter to keep current value of " + panel.getSection() + "):");
        if (!section.isEmpty()) {
            panel.setSection(section);
        }
        int row = readInt("Row (enter 0 to keep current value of " + panel.getRow() + "):", 0, 250);
        if (row != 0) {
            panel.setRow(row);
        }
        int column = readInt("Column (enter 0 to keep current value of " + panel.getColumn() + "):", 0, 250);
        if (column != 0) {
            panel.setColumn(column);
        }
        int year = readInt("Installation year (enter 0 to keep current value of " + panel.getYear() + "):", 0, 9999);
        if (year != 0) {
            panel.setYear(year);

