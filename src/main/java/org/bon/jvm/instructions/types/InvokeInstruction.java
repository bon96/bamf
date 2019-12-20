package org.bon.jvm.instructions.types;

import org.bon.jvm.util.MethodDescriptor;

/**
 * Tommi
 * Date: 29/09/2019
 * Time: 17.53
 */

public interface InvokeInstruction {

    String getTargetClass();

    String getTarget();

    MethodDescriptor getTargetDescriptor();
}
