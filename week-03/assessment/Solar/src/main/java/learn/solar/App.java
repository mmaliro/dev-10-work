package learn.solar;

import learn.solar.data.PanelFileRepository;

public class App {
    public static void main(String[] args) {
        PanelFileRepository farm = new PanelFileRepository("./data/solar-production.csv");
    }
}