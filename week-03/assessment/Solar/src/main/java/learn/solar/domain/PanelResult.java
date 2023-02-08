package learn.solar.domain;
import java.util.ArrayList;
import learn.solar.models.Panel;
import java.util.List;

public class PanelResult {

    private ArrayList<String> messages;

    private Panel panel;

    public PanelResult() {
        messages = new ArrayList<>();
    }

    public boolean isSuccess() {
        return messages.isEmpty();
    }

    public List<String> getMessages() {
        return messages;
    }

    public Panel getPanel() {
        return panel;
    }

    public void setPanel(Panel panel) {
        this.panel = panel;
    }

    public void addMessage(String strPanel) {
        messages.add(strPanel);
    }
}

