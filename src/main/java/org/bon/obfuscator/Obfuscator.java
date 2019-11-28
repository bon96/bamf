package org.bon.obfuscator;

import org.bon.api.Class;
import org.bon.api.ClassGroup;
import org.bon.jvm.ClassFile;
import org.bon.jvm.ShallowClassFile;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Tommi
 * Date: 06/11/2019
 * Time: 4.07
 */

public class Obfuscator {

    public static Map<Class, ShallowClassFile> classes = new HashMap<>();

    public static void main(String[] args) throws IOException {
        JarFile jarFile = new JarFile("./client-1.5.38-shaded.jar");
        ClassGroup.from(jarFile);
        Enumeration<JarEntry> enr = jarFile.entries();

        while (enr.hasMoreElements()) {
            JarEntry entry = enr.nextElement();
            if (entry.getName().endsWith(".class")) {
                ClassFile cf = ClassFile.from(new DataInputStream(jarFile.getInputStream(entry)));
                ShallowClassFile scf = ShallowClassFile.from(new DataInputStream(jarFile.getInputStream(entry)));
                classes.put(new Class(null, cf), scf);
            }
        }

        ClassMappings mappings = new ClassMappings();

        for (Class c : classes.keySet()) {
            mappings.map(c.getName(), c.getName() + ThreadLocalRandom.current().nextInt(0, 100000));
        }

        for (Map.Entry<String, String> entry : mappings.getMappings()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
