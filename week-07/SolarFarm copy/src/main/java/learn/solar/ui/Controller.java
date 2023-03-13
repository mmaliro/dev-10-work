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



    private void viewBySection() throws DataException {
        view.printHeader("Find Panels by Section");
        String section = view.readSection();
        List<Panel> panels = service.findBySection(section);
        System.out.println();
        System.out.println("Panels in " + section);
        view.printPanels(section, panels);
        System.out.println();
    }

    private void addPanel() throws DataException {
        view.printHeader("Add a Panel");
        Panel panel = view.makePanel();
        PanelResult result = service.add(panel);
        view.printResult(result, "Panel " + panel.getSection() + " " + panel.getRow() + "-" + panel.getColumn()+" added.\n");
    }

    private void updatePanel() throws DataException {
        view.printHeader("Update a Panel");
        String section = view.readSection();
        List<Panel> panels = service.findBySection(section);
        Panel panel = view.choosePanel(section, panels);


        if (panel != null) {
            panel = view.update(panel);
            PanelResult result = service.update(panel);
            view.printResult(result, "Panel " + panel.getSection() + " " + panel.getRow() + "-" + panel.getColumn()+" updated.\n");
        }else{
            System.out.println("Panel not found.");
        }
    }

    private void deletePanel() throws DataException {
        view.printHeader("Remove a Panel");
        String section = view.readSection();
        List<Panel> panels = service.findBySection(section);
        Panel panel = view.choosePanel(section, panels);



        if (panel != null) {
            PanelResult result = service.deleteById(panel.getPanelId());

            result.setPanel(panel);

            view.printResult(result, "Panel " + panel.getSection() + "-" + panel.getRow() + "-" + panel.getColumn()+" removed.\n");
        }else{
            System.out.println("Panel not found.");
        }

        }


    }


