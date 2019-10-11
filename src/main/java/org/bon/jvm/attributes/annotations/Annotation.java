package org.bon.jvm.attributes.annotations;

import org.bon.jvm.constantpool.ConstPool;
import org.bon.jvm.constantpool.constants.IntegerConstant;
import org.bon.jvm.constantpool.constants.ValueConstant;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Annotation {

    private String type;
    private List<Element> elements;

    public String getType() {
        return type;
    }

    public List<Element> getElements() {
        return elements;
    }

    public static Annotation from(DataInputStream in, ConstPool constPool) throws IOException {
        Annotation a = new Annotation();
        a.type = constPool.get(in.readUnsignedShort()).toString();

        List<Element> elements = new ArrayList<>();
        int elementCount = in.readUnsignedShort();
        for (int i = 0; i < elementCount; i++) {
            elements.add(Element.from(in, constPool));
        }
        a.elements = elements;
        return a;
    }

    public static class Element<T> {

        private String name;
        private T value;


        public Element(String name, T value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public T getValue() {
            return value;
        }

        public static Element from(DataInputStream in, ConstPool constPool) throws IOException {
            String name = constPool.get(in.readUnsignedShort()).toString();
            int tag = in.readUnsignedByte();

            switch (tag) {
                case 'S':
                    IntegerConstant s = constPool.get(in.readUnsignedShort()).cast();
                    return new Element<>(name, s.getValue().shortValue());
                case 'Z':
                    IntegerConstant z = constPool.get(in.readUnsignedShort()).cast();
                    return new Element<>(name, z.getValue() != 0);
                case 'B':
                    IntegerConstant b = constPool.get(in.readUnsignedShort()).cast();
                    return new Element<>(name, b.getValue().byteValue());
                case 'C':
                    IntegerConstant c = constPool.get(in.readUnsignedShort()).cast();
                    return new Element<>(name, (char) (int) c.getValue());
                case 'D':
                case 'F':
                case 'I':
                case 'J':
                    ValueConstant v = constPool.get(in.readUnsignedShort()).cast();
                    return new Element<>(name, v.getValue());
                case 's':
                    return new Element<>(name, constPool.get(in.readUnsignedShort()).toString());
                case 'e':
                    String type = constPool.get(in.readUnsignedShort()).toString();
                    String value = constPool.get(in.readUnsignedShort()).toString();
                    return new Element<>(name, new Enum(type, value));
                case 'c':
                    String classDescriptor = constPool.get(in.readUnsignedShort()).toString();
                    return new Element<>(name, new ClassDescriptor(classDescriptor));
                case '@':
                    return new Element<>(name, Annotation.from(in, constPool));
                case '[':
                    int size = in.readUnsignedShort();
                    List<Element> elements = new ArrayList<>();
                    for (int i = 0; i < size; i++) {
                        elements.add(Element.from(in, constPool));
                    }
                    return new Element<>(name, elements);
                default:
                    throw new IOException("Unknown element type " + tag);
            }
        }

        public static class Enum {
            private String type;
            private String name;

            public Enum(String type, String name) {
                this.type = type;
                this.name = name;
            }

            public String getType() {
                return type;
            }

            public String getName() {
                return name;
            }
        }

        public static class ClassDescriptor {
            private String descriptor;

            public ClassDescriptor(String descriptor) {
                this.descriptor = descriptor;
            }

            public String getDescriptor() {
                return descriptor;
            }
        }
    }
}
