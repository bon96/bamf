package com.pushit.api;

import com.pushit.jvm.ClassFile;

import java.io.IOException;
import java.io.InputStream;
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

    public void add(ClassFile classFile) {
        this.classes.add(classFile);
    }

    public void remove(ClassFile classFile) {
        this.classes.remove(classFile);
    }

    public List<ClassFile> getClasses() {
        return classes;
    }

    public ClassFile find(String name) {
        for (ClassFile classFile : classes) {
            if (name.equals(classFile.getName())) {
                return classFile;
            }
        }
        return null;
    }

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
}
