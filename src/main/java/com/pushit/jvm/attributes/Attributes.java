package com.pushit.jvm.attributes;

import java.util.List;

public class Attributes {

    private List<Attribute> attributes;

    public Attributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public List<Attribute> list() {
        return attributes;
    }

    public <T extends Attribute> T ofType(Class<T> attributeClass) {
        for (Attribute attribute : attributes) {
            if (attributeClass.isAssignableFrom(attribute.getClass())) {
                return attribute.cast();
            }
        }
        throw new IllegalArgumentException("Attribute of type " + attributeClass.getName() + " wasn't found.");
    }
}
