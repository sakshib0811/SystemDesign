package AbstractFactory;

public class WindowsBtn implements Button {

    @Override
    public void onClick() {
        System.out.println("Windows style btn clicked");
    }

    @Override
    public void paint() {
        System.out.println("Windows style btn paint");
    }
}
