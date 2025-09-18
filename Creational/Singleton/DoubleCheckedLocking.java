package Singleton;

class DoubleCheckedLocking {

    // Volatile ensure that changes to the instance variable are immediately visible
    // to other variable.
    private static volatile DoubleCheckedLocking instances;

    private DoubleCheckedLocking() {
    }

    public static DoubleCheckedLocking getInstances() {
        if (instances == null) {
            synchronized (DoubleCheckedLocking.class) {
                if (instances == null)
                    instances = new DoubleCheckedLocking();
            }
        }
        return instances;
    }
}

// bit complex to implement.
