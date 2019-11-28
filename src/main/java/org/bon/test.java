package org.bon;

import org.bon.api.Class;
import org.bon.api.ClassGroup;
import org.bon.api.Field;
import org.bon.api.Method;
import org.bon.jvm.ShallowClassFile;
import org.bon.jvm.attributes.annotations.Annotation;
import org.bon.jvm.constantpool.constants.Constant;
import org.bon.jvm.constantpool.constants.NameAndTypeConstant;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;


public class test {

    public static void main(String[] args) throws IOException {
        JarFile jarFile = new JarFile("./client-1.5.38-shaded.jar");
        List<ShallowClassFile> classFiles = new ArrayList<>();

        Enumeration<JarEntry> enr = jarFile.entries();

        while (enr.hasMoreElements()) {
            JarEntry entry = enr.nextElement();
            if (entry.getName().endsWith(".class")) {
                ShallowClassFile cf = ShallowClassFile.from(new DataInputStream(jarFile.getInputStream(entry)));
                classFiles.add(cf);
            }
        }

        for (Constant constant : classFiles.get(0).getConstPool().getAll()) {
            if (constant instanceof NameAndTypeConstant) {
                System.out.println(((NameAndTypeConstant) constant).getName());
            }
        }
    }

    public static void main2(String[] args) throws Exception {
        ClassGroup classGroup = ClassGroup.from(new JarFile("./184_deob.jar"));
        for (Class c : classGroup.getClasses()) {
            for (Field field : c.getFields()) {
                for (Annotation annotation : field.getAnnotations()) {
                    System.out.println(annotation.getType());
                    for (Annotation.Element element : annotation.getElements()) {
                        System.out.println(element.getName());
                        System.out.println(element.getValue());
                    }
                }
            }

            for (Method method : c.getMethods()) {
                for (Annotation annotation : method.getAnnotations()) {
                    System.out.println(annotation.getType());
                    for (Annotation.Element element : annotation.getElements()) {
                        System.out.println(element.getName());
                        System.out.println(element.getValue());
                    }
                }
            }
        }
    }
}
