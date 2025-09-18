package AbstractFactory;

public class WindowsCheckBox implements CheckBox {

    @Override
    public void onSelect() {
        System.out.println("Windows Style checkbox selected");
    }

    @Override
    public void paint() {
        System.out.println("Windows Style checkbox paint");
    }
}
