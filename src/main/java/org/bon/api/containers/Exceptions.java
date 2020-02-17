package org.bon.api.containers;

import org.bon.api.Exception;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Tommi
 * Date: 21/12/2019
 * Time: 18.29
 */

public class Exceptions extends ArrayList<Exception> {

    public Exceptions() {
    }

    public Exceptions(Collection<? extends Exception> c) {
        super(c);
    }
}
