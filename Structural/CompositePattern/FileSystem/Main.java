package Structural.CompositePattern.FileSystem;

public class Main {

    public static void main(String[] args) {
        Directory movieDirectory = new Directory("Movie");
        File movie1 = new File("FROM");
        movieDirectory.add(movie1);

        Directory subDirectory = new Directory("Anime");
        File anime1 = new File("Bleach");
        File anime2 = new File("Fullmetal Alchemist");

        subDirectory.add(anime1);
        subDirectory.add(anime2);
        movieDirectory.add(subDirectory);

        movieDirectory.ls();
    }

}
