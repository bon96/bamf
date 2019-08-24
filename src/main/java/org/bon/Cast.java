package org.bon;

@SuppressWarnings("unchecked")
public interface Cast {
    default <T> T cast() {
        return (T) this;
    }
}

