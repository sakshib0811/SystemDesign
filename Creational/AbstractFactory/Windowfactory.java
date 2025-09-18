package AbstractFactory;

public class Windowfactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new WindowsBtn();
    }

    @Override
    public CheckBox creatCheckBox() {
        return new WindowsCheckBox();
    }
}
