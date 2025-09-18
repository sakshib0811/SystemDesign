package Singleton;

enum EnumSingleton {

    INSTANCES;

    public void doSomething(String message) {

        System.out.println("message : " + message);
    }
}

// Thread safe and best singleton implementation in java.
