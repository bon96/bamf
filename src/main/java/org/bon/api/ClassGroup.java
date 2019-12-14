package org.bon.api;

import org.bon.api.containers.Classes;
import org.bon.jvm.ClassFile;
import org.bon.jvm.containers.ClassFiles;

import java.io.DataInputStream;
import java.io.File;
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

    public static ClassGroup from(String path) throws IOException {
        return from(new JarFile(path));
    }

    public static ClassGroup from(File file) throws IOException {
        return from(new JarFile(file));
    }

    public static ClassGroup from(JarFile jarFile) throws IOException {
        try (jarFile) {
            ClassGroup classGroup = new ClassGroup();
            Enumeration<JarEntry> enr = jarFile.entries();

            while (enr.hasMoreElements()) {
                JarEntry entry = enr.nextElement();
                if (entry.getName().endsWith(".class")) {
                    ClassFile cf = ClassFile.from(new DataInputStream(jarFile.getInputStream(entry)));
                    classGroup.getClassFiles().add(cf);
                    classGroup.getClasses().add(new Class(classGroup, cf));
                }
            }
            return classGroup;
        }
    }
}
