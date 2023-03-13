package learn.ui;

public enum MenuOption {
    EXIT("Exit"),
    DISPLAY_ORBITERS("Display Orbiters"),


    private final String title;


    MenuOption(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
