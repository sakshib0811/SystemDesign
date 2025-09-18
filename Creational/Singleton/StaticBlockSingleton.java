package Singleton;

import javax.management.RuntimeErrorException;

class StaticBlockSingleton {

    private static StaticBlockSingleton instances;

    private StaticBlockSingleton() {
    }

    // static block will get executed when the class is loaded by JVM.
    static {
        try {
            instances = new StaticBlockSingleton();
        } catch (Exception e) {
            throw new RuntimeErrorException(null, "Exception while creating new instances");
        }
    }

    public static StaticBlockSingleton getInstances() {
        return instances;
    }

}

// This implementation is thread safe but not lazy loaded, so it may casue some
// issues when initialization is resource-intensive or time consuming.
