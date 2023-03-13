package learn.solar.domain;
import java.util.ArrayList;
import learn.solar.models.Panel;
import java.util.List;

public class PanelResult {

    private ArrayList<String> messages = new ArrayList<>();

    private Panel panel;


    public boolean isSuccess() {
        return messages.size() == 0;
    }

    public List<String> getMessages() {
        return new ArrayList<>(messages);
    }

    public Panel getPanel() {
        return panel;
    }

    public void setPanel(Panel panel) {
        this.panel = panel;
    }

    public void addMessage(String message) {
        messages.add(message);
    }

}

