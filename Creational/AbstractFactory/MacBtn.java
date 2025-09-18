package AbstractFactory;

public class MacBtn implements Button {

    @Override
    public void onClick() {
        System.out.println("Mac button clicked");
    }

    @Override
    public void paint() {
        System.out.println("Mac style button painted");
    }
}
