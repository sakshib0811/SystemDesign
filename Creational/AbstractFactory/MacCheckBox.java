package AbstractFactory;

public class MacCheckBox implements CheckBox {

    @Override
    public void onSelect() {
        System.out.println("Mac checkbox selected ");
    }

    @Override
    public void paint() {
        System.out.println("Mac style checkbox painted");
    }
}
