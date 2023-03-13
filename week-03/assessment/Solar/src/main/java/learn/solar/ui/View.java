package learn.solar.ui;
import java.util.Scanner;
import java.util.List;
import learn.solar.domain.PanelResult;
import learn.solar.models.Material;
import learn.solar.models.Panel;

public class View {
    private Scanner console;

    public int chooseOptionFromMenu() {
        System.out.println("Menu");
        System.out.println("1. View panels by section");
        System.out.println("2. Add panel");
        System.out.println("3. Update panel");
        System.out.println("4. Delete panel");
        System.out.println("5. Exit");
        System.out.println("Select [1-5]");
        int choice = console.nextInt();
        return choice;
    }

    public void printHeader(String header) {
        System.out.println(header);
        System.out.println("=".repeat(header.length()));
    }

    public void printResult(PanelResult result, String successTemplate) {
        if (result.isSuccess()) {
            if (result.getPanel() != null) {
                System.out.printf(successTemplate, result.getPanel());
            }
        } else {
            printHeader("Errors");
            for (String msg : result.getMessages()) {
                System.out.printf("- %s%n", msg);
            }
        }
    }

    public void printPanels(String sectionName, List<Panel> panels) {
            System.out.println("Section name: " + sectionName);
            for (int i = 0; i < panels.size(); i++) {
                System.out.println("Panel " + (i + 1) + ": " + panels.get(i).toString());
            }
        }



    public Panel choosePanel(String sectionName, List<Panel> panels) {
        System.out.println("Section name: " + sectionName);
        for (int i = 0; i < panels.size(); i++) {
            System.out.println((i + 1) + ". " + panels.get(i).toString());
        }
        System.out.print("Choose a panel (1-" + panels.size() + "): ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return panels.get(choice - 1);
    }

    public Panel makePanel() {
        Panel panel = new Panel;
        panel.setSection(readRequiredString("Section:"));
        panel.setRow(readInt("Row: "));
        panel.setColumn(readInt("Column: "));
        panel.setInstallationYear(readInt("Installation year: "));
        panel.setMaterial(readRequiredString("Material: "));
        panel.setTracking(readRequiredString("Track (y/n): "));
        return panel;
    }

    public Panel update(Panel panel) {
        System.out.println();
        printPanels(panel);
        System.out.println();

        panel.setSection(readRequiredString("Section:"));
        panel.setRow(readInt("Row: "));
        panel.setColumn(readInt("Column: "));
        panel.setInstallationYear(readInt("Installation year: "));
        panel.setMaterial(readRequiredString("Material: "));
        panel.setTracking(readRequiredString("Track (y/n): "));

        return panel;
        }




    public String readSection() {
        System.out.print("Enter the section name: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


    private String readString(String message) {
        System.out.print(message);
        return console.nextLine();
    }

    private String readRequiredString(String read) {
        String result;
        do {
            result = readString(read);
            if (result.trim().length() == 0) {
                System.out.println("Value is required.");
            }
        } while (result.trim().length() == 0);
        return result;
    }

    private int readInt(String read, int min, int max) {
        int result;
        do {
            result = readInt(read);
            if (result < min || result > max) {
                System.out.printf("Value must be between %s and %s.%n", min, max);
            }
        } while (result < min || result > max);
        return result;
    }

    private Material readMaterial() {
        System.out.println("Materials:");
        System.out.println("1. multi_Si");
        System.out.println("2. mono_Si");
        System.out.println("3. A_Si");
        System.out.println("4. CdTe");
        System.out.println("5. CIGS");
        System.out.print("Choose a material (1-5): ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1: return Material.multi_Si;
            case 2: return Material.mono_Si;
            case 3: return Material.A_Si;
            case 4: return Material.CdTe;
            case 5: return Material.CIGS;
            default: return Material.multi_Si;
        }
    }








    public String viewSection() {
    }

    public Panel addPanel() {
    }

    public void displayAddPanelResult(PanelResult result, String s) {
    }

    public void displayPanels(List<Panel> panels) {
    }

    public Panel updatePanel(List<Panel> panels) {
    }

    public Panel selectPanel(List<Panel> panels) {
    }
}



