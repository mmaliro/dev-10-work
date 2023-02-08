package learn.solar.ui;

import learn.solar.data.DataException;
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
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        while (!quit) {
            int choice = view.chooseOptionFromMenu();
            switch (choice) {
                case 1:
                    try {
                        viewBySection();
                    } catch (DataException e) {
                        System.out.println(e.getMessage());
                    }
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
        String section = view.getSection();
        List<Panel> panels = service.findBySection(section);
        view.displayPanels(panels);
    }

    private void addPanel() {
        Panel panel = view.getPanelDetails();
        Panel added = service.add(panel);
        view.displayAddPanelResult(added);
    }

    private void updatePanel() {
        int id = view.getPanelId();
        Panel panel = service.findById(id);
        if (panel == null) {
            view.displayPanelNotFound();
            return;
        }
        Panel updatedPanel = view.updatePanelDetails(panel);
        boolean updated = service.update(updatedPanel);
        view.displayUpdatePanelResult(updated);
    }

    private void deletePanel() {
        int id = view.getPanelId();
        boolean deleted = service.deleteById(id);
        view.displayDeletePanelResult(deleted);
    }
}

