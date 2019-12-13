package org.bon.jvm.instructions.types;

/**
 * Tommi
 * Date: 13/12/2019
 * Time: 21.58
 */

public interface JumpInstruction {
    int getJumpOffset();

    int getJumpTarget();

    void setJumpTarget(int target);

    int getOffset();
}
