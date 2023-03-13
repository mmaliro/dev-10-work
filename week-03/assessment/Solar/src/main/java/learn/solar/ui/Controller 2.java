package learn.solar.ui;

import learn.solar.data.DataException;
import learn.solar.domain.PanelResult;
import learn.solar.domain.PanelService;
import learn.solar.models.Panel;

import java.util.List;
import java.util.Scanner;

public class Controller {
    private View view;
    private PanelService service;

    public Controller(View v, PanelService pService) {
        this.view = v;
        this.service = pService;
    }

    public void run() {
        view.printHeader("Welcome To Solar Farm!");

        try {
            runMenu();
        } catch (DataException ex) {
            view.printHeader("ERROR:" + ex.getMessage());
        }

        view.printHeader("Goodbye");
    }



    private void runMenu() throws DataException {

        for (int option = view.chooseOptionFromMenu();
             option > 0;
             option = view.chooseOptionFromMenu()) {

            Scanner sc = new Scanner(System.in);
            boolean quit = false;
            while (!quit) {
                int choice = view.chooseOptionFromMenu();
                switch (choice) {
                    case 1:
                       viewBySection();
                        break;
                    case 2:
                        addPanel();
                        break;
                    case 3:
                        updatePanel();
                        break;
                    case 4:
                        deletePanel();
                        break;
                    case 5:
                        quit = true;
                        break;
                }
            }
        }

    }



    private void viewBySection() throws DataException {
        String section = view.viewSection();
        List<Panel> panels = service.findBySection(section);
        view.displayPanels(panels);
    }

    private void addPanel() throws DataException {
        Panel panel = view.addPanel();
        PanelResult result = service.add(panel);
        view.displayAddPanelResult(result, "Panel %s added.%n");
    }

    private void updatePanel() throws DataException {
        List<Panel> panels = service.findAll();
        Panel panel = view.updatePanel(panels);

        if (panel != null) {
            Panel updatedPanel = view.updatePanel(panel);
            PanelResult result = service.update(updatedPanel);
            view.printResult(result, "Panel %s updated.%n");
        }
    }

    private void deletePanel() throws DataException {

        List<Panel> panels = service.findAll();
        Panel panel = view.selectPanel(panels);

        if (panel != null) {
            PanelResult result = service.deleteById(panel.getPanelId());

            result.setPanel(panel);

            view.printResult(result, "Panel %s deleted.%n");
        }

        }


    }


