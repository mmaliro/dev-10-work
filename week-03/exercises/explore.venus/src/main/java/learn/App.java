package learn;

import learn.data.OrbiterFileRepository;
import learn.domain.OrbiterService;
import learn.ui.Controller;
import learn.ui.View;

public class App {

    public static void main(String[] args) {
        OrbiterFileRepository repository = new OrbiterFileRepository("./data/orbiters.csv");
        OrbiterService service = new OrbiterService(repository);
        View view = new View();
        Controller controller = new Controller(service, view);
        controller.run();

    }
}