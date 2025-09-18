package Singleton;

class EagerSingleton {

    // single instances created immediately
    // final prevent instances from being reassigned.
    private static final EagerSingleton instances = new EagerSingleton();

    private EagerSingleton() {
    }

    public static EagerSingleton getInstances() {
        return instances;
    }

}
// It is thread safe
// but if the singleton instances is never used by the client it could possibly
// waste the resources.
