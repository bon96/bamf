package org.bon.api;

import org.bon.jvm.ClassFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Tommi
 * Date: 27/07/2019
 * Time: 22.16
 */

public class ClassGroup {

    private List<ClassFile> classes = new ArrayList<>();

    public static ClassGroup from(JarFile jarFile) throws IOException {
        ClassGroup classGroup = new ClassGroup();
        Enumeration<JarEntry> enr = jarFile.entries();

        while (enr.hasMoreElements()) {
            JarEntry entry = enr.nextElement();
            if (entry.getName().endsWith(".class")) {
                classGroup.add(new ClassFile(jarFile.getInputStream(entry).readAllBytes()));
            }
        }
        return classGroup;
    }

    public void add(ClassFile classFile) {
        classes.add(classFile);
    }

    public void remove(ClassFile classFile) {
        classes.remove(classFile);
    }

    public List<ClassFile> getClasses() {
        return classes;
    }

    public ClassFile find(String className) {
        for (ClassFile classFile : classes) {
            if (className.equals(classFile.getName())) {
                return classFile;
            }
        }
        return null;
    }
}
