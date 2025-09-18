package AbstractFactory;

public class Application {

    private final Button button;
    private final CheckBox checkBox;

    public Application(GUIFactory factory) {
        this.button = factory.createButton();
        this.checkBox = factory.creatCheckBox();
    }

    public void renderUI() {
        button.paint();
        checkBox.paint();
    }

}
