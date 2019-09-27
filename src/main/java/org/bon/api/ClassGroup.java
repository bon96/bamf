package org.bon.api;

import org.bon.api.containers.Classes;
import org.bon.jvm.ClassFile;
import org.bon.jvm.containers.ClassFiles;

import java.io.IOException;
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

    private List<ClassFile> classFiles = new ClassFiles();
    private List<Class> classes = new Classes();

    public List<Class> getClasses() {
        return classes;
    }

    public List<ClassFile> getClassFiles() {
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
                classGroup.getClassFiles().add(new ClassFile(jarFile.getInputStream(entry).readAllBytes()));
            }
        }
        return classGroup;
    }
}
