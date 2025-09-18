package Singleton;

class ThreadSafeSingleton {
    private static ThreadSafeSingleton insatnces;

    private ThreadSafeSingleton() {
    }

    // synchronized will insure that only one thread can perform the null check and
    // create the object.
    public static synchronized ThreadSafeSingleton getInstances() {
        if (insatnces == null)
            insatnces = new ThreadSafeSingleton();
        return insatnces;
    }
}

// using synchronized can cause substantial overhead and reduce performance
// which can cause bottleneck if used
// frequently
// So we move to Double-CHECKED LOCKING
