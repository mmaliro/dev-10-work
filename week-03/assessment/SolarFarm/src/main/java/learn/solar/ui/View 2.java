package learn.solar.ui;
import java.util.Scanner;
import java.util.List;
import learn.solar.domain.PanelResult;
import learn.solar.models.Material;
import learn.solar.models.Panel;

public class View {
    private Scanner console = new Scanner(System.in);

    public int chooseOptionFromMenu() {
        printHeader("Main Menu");
        System.out.println("1. View panels by section");
        System.out.println("2. Add panel");
        System.out.println("3. Update panel");
        System.out.println("4. Delete panel");
        System.out.println("5. Exit");
        int choice = readInt("Select [1-5]: ", 1, 5);
        System.out.println();
        return choice;
    }

    public void printHeader(String header) {
        System.out.println(header);
        System.out.println("=".repeat(header.length()));
        System.out.println();
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

        System.out.println("Row\tColumn\tInstallation Year\tMaterial\tTracking");
        for(Panel panel : panels){
            System.out.printf("%d\t%d\t\t%d\t\t\t\t%s", panel.getRow(), panel.getColumn(), panel.getInstallationYear(), panel.getMaterial());
            if(panel.isTracking()){
                System.out.println("\t\tyes");
            }else{
                System.out.println("\t\tno");
            }
        }
    }



    public Panel choosePanel(String sectionName, List<Panel> panels) {
        int row = readInt("Row: ", 1, 250);
        int column = readInt("Column: ", 1, 250);
        System.out.println();
        for(Panel panel : panels){
            if(panel.getRow() == row && panel.getColumn() == column){
                return panel;
            }
        }

        return null;
    }

    public Panel makePanel() {
        Panel panel = new Panel();
        int year;
        String tracking;
        panel.setSection(readRequiredString("Section:"));
        panel.setRow(readInt("Row: ", 1, 250));
        panel.setColumn(readInt("Column: ", 1, 250));
        year = readInt("Installation year: ");
        while(year > 2023){
            System.out.println("[Err]\nEnter a year in the past.");
            year = readInt("Installation year: ");
        }
        panel.setInstallationYear(year);
        System.out.print("Material: ");
        panel.setMaterial(readMaterial());
        tracking = readRequiredString("Track (y/n): ");
        while (!(tracking.equalsIgnoreCase("y") || tracking.equalsIgnoreCase("n"))) {
            System.out.println("[Err]\nPlease enter \'y\' or \'n\'");
            tracking = readRequiredString("Track (y/n): ");
        }
        if (tracking.equalsIgnoreCase("y")) {
            panel.setTracking(true);
        } else if (tracking.equalsIgnoreCase("n")) {
            panel.setTracking(false);
        }
        return panel;
    }

    public Panel update(Panel panel) {
        int year;
        String tracking;
        panel.setSection(readRequiredString("Section(" + panel.getSection() + "): "));
        panel.setRow(readInt("Row(" + panel.getRow() + "): ", 1, 250));
        panel.setColumn(readInt("Column(" + panel.getColumn() + "): ", 1, 250));
        year = readInt("Installation year(" + panel.getInstallationYear() + "): ");
        while(year > 2023){
            System.out.println("[Err]\nEnter a year in the past.");
            year = readInt("Installation year(" + panel.getInstallationYear() + "): ");
        }
        panel.setInstallationYear(year);
        System.out.print("Material(" + panel.getMaterial() + "): ");
        panel.setMaterial(readMaterial());

        tracking = readRequiredString("Track (y/n): ");
        while (!(tracking.equalsIgnoreCase("y") || tracking.equalsIgnoreCase("n"))) {
            System.out.println("[Err]\nPlease enter \'y\' or \'n\'");
            tracking = readRequiredString("Track (y/n): ");
        }
        if (tracking.equalsIgnoreCase("y")) {
            panel.setTracking(true);
        } else if (tracking.equalsIgnoreCase("n")) {
            panel.setTracking(false);
        }


        return panel;
        }




    public String readSection() {
        return readRequiredString("Enter the section: ");
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

    private int readInt(String read) {
        String input = null;
        int result = 0;
        boolean isValid = false;
        do {
            try {
                input = readString(read);
                result = Integer.parseInt(input);
                isValid = true;
            } catch (NumberFormatException ex) {
                System.out.printf("%s is not a valid number.%n", input);
            }
        } while (!isValid);

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
        String choice = readString("");
        switch (choice) {
            case "multi_Si": return Material.multi_Si;
            case "mono_Si": return Material.mono_Si;
            case "A_Si": return Material.A_Si;
            case "CdTe": return Material.CdTe;
            case "CIGS": return Material.CIGS;
        }

        do {
            System.out.println("[Err]\nMaterials must be one of the below:");
            System.out.println("multi_Si");
            System.out.println("mono_Si");
            System.out.println("A_Si");
            System.out.println("CdTe");
            System.out.println("CIGS");
            choice = readRequiredString("Material: ");

            switch (choice) {
                case "multi_Si": return Material.multi_Si;
                case "mono_Si": return Material.mono_Si;
                case "A_Si": return Material.A_Si;
                case "CdTe": return Material.CdTe;
                case "CIGS": return Material.CIGS;
            }
        }while(true);

    }

}



