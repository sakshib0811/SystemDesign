package Structural.CompositePattern.FileSystem;

import java.util.*;

public class Directory implements FileSystem {
    String directoryName;
    List<FileSystem> list;

    Directory(String name) {
        this.directoryName = name;
        list = new ArrayList<>();
    }

    public void add(FileSystem fs) {
        list.add(fs);
    }

    @Override
    public void ls() {
        System.out.println("Directory name is : " + this.directoryName);
        for (FileSystem fs : list) {
            fs.ls();
        }
    }
}
