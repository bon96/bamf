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
    private List<Element> elements = new ArrayList<>();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Element> getElements() {
        return elements;
    }

    public void setElements(List<Element> elements) {
        this.elements = elements;
    }

    public static Annotation from(DataInputStream in, ConstPool constPool) throws IOException {
        Annotation a = new Annotation();
        a.type = constPool.get(in.readUnsignedShort()).toString();

        int elementCount = in.readUnsignedShort();
        for (int i = 0; i < elementCount; i++) {
            a.elements.add(Element.from(in, constPool, true));
        }
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

        public void setName(String name) {
            this.name = name;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public static Element<?> from(DataInputStream in, ConstPool constPool, boolean isValuePair) throws IOException {
            String name = null;

            if (isValuePair) {
                name = constPool.get(in.readUnsignedShort()).toString();
            }

            int tag = in.readUnsignedByte();

            switch (tag) {
                case 'S':
                case 'B':
                case 'D':
                case 'F':
                case 'I':
                case 'J':
                    ValueConstant s = constPool.get(in.readUnsignedShort()).cast();
                    return new Element<>(name, s.getValue());
                case 'Z':
                    IntegerConstant z = constPool.get(in.readUnsignedShort()).cast();
                    return new Element<>(name, z.getValue() != 0);
                case 'C':
                    IntegerConstant c = constPool.get(in.readUnsignedShort()).cast();
                    return new Element<>(name, (char) (int) c.getValue());
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
                        elements.add(Element.from(in, constPool, false));
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

            public void setType(String type) {
                this.type = type;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
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

            public void setDescriptor(String descriptor) {
                this.descriptor = descriptor;
            }
        }
    }
}
