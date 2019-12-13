package org.bon;

//TODO get rid of this
@SuppressWarnings("unchecked")
public interface Cast {
    default <T> T cast() {
        return (T) this;
    }
}

