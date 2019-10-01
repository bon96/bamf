package org.bon;

import org.bon.api.Class;
import org.bon.api.ClassGroup;

import java.util.jar.JarFile;


public class ClassReader {
    public static void main(String[] args) throws Exception {
        ClassGroup classGroup = ClassGroup.from(new JarFile("./181.jar"));

        for (Class c : classGroup.getClasses()) {
            System.out.println(c.getType());
            System.out.println(c.getName());
            System.out.println("-------");
        }
    }
}
