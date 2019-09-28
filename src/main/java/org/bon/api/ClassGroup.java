package org.bon.api;

import org.bon.api.containers.Classes;
import org.bon.jvm.ClassFile;
import org.bon.jvm.containers.ClassFiles;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Tommi
 * Date: 27/07/2019
 * Time: 22.16
 */

public class ClassGroup {

    private ClassFiles classFiles = new ClassFiles();
    private Classes classes = new Classes();

    public Classes getClasses() {
        return classes;
    }

    public ClassFiles getClassFiles() {
        return classFiles;
    }

    public ClassFile find(String className) {
        for (ClassFile classFile : classFiles) {
            if (className.equals(classFile.getName())) {
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
                classGroup.getClassFiles().add(ClassFile.from(new DataInputStream(jarFile.getInputStream(entry))));
            }
        }
        return classGroup;
    }
}
