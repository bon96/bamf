package org.bon.api.containers;

import org.bon.api.Field;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Tommi
 * Date: 21/12/2019
 * Time: 18.06
 */

public class Fields extends ArrayList<Field> {

    public Fields() {
    }

    public Fields(Collection<? extends Field> c) {
        super(c);
    }
}
