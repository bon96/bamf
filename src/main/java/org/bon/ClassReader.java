package org.bon;

import org.bon.api.Class;
import org.bon.api.ClassGroup;
import org.bon.api.Field;
import org.bon.api.Method;
import org.bon.jvm.attributes.annotations.Annotation;

import java.util.jar.JarFile;


public class ClassReader {
    public static void main(String[] args) throws Exception {
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
