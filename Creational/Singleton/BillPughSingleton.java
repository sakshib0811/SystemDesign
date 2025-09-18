package Singleton;

class BillPughSingleton {

    private BillPughSingleton() {
    }

    // static inner helper class to hold instances. This class is not loaded into
    // the memory until it's referenced for the first time in the getInstances().
    private static class SingletonHealper {
        private static final BillPughSingleton instances = new BillPughSingleton();
    }

    public static BillPughSingleton getInstances() {
        return SingletonHealper.instances;
    }

}

// It is thread safe without using sinchronization.
