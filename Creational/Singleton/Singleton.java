package Singleton;

public class Singleton {

    public static void main(String[] args) {

        // ENUM SKELETON
        EnumSingleton example1 = EnumSingleton.INSTANCES;
        EnumSingleton example2 = EnumSingleton.INSTANCES;

        System.out.println(example1 == example2);
        example1.doSomething("Hi my name is sakshi");
        example2.doSomething("I am learning LLD");

        // LAZY SKELETON
        LazySingleton lazy = LazySingleton.getInstance();
        LazySingleton lazy2 = LazySingleton.getInstance();
        System.out.println(lazy == lazy2);
    }

}
