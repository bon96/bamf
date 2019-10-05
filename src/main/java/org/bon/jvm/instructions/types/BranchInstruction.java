package org.bon.jvm.instructions.types;

/**
 * Tommi
 * Date: 29/09/2019
 * Time: 17.36
 */

public interface BranchInstruction {
    int getJumpOffset();

    int getJumpTarget();

    void setJumpTarget(int target);

    int getOffset();
}
