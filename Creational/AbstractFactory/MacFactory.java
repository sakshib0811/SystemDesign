package AbstractFactory;

public class MacFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new MacBtn();
    }

    @Override
    public CheckBox creatCheckBox() {
        return new MacCheckBox();
    }
}
