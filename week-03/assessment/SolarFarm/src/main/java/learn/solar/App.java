package learn.solar;

import learn.solar.data.PanelFileRepository;
import learn.solar.domain.PanelService;
import learn.solar.ui.Controller;
import learn.solar.ui.View;

public class App {
    public static void main(String[] args) {
        PanelFileRepository farm = new PanelFileRepository("./data/solar-production.csv");
        PanelService pService = new PanelService(farm);
        View view = new View();

        Controller controller = new Controller(view, pService);
        controller.run();
    }
}