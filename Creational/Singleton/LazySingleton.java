package Singleton;

class LazySingleton {

    // single instance, initially null
    private static LazySingleton instance;

    // private constructor to prevent re-initiallization
    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

}

// this implementation is not thread safe, if multiple threads call
// getInstances()
// simultaneously when instance is null, then it's possible to create multiple
// instances.
// Better approch is THREAD-SAFE SINGLETON.