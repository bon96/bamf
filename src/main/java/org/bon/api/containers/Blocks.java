package org.bon.api.containers;

import org.bon.api.Block;
import org.bon.jvm.instructions.types.JumpInstruction;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Tommi
 * Date: 21/12/2019
 * Time: 18.06
 */

public class Blocks extends ArrayList<Block> {

    public Blocks() {
    }

    public Blocks(Collection<? extends Block> c) {
        super(c);
    }

    public Block getBlock(JumpInstruction ins) {
        for (Block block : this) {
            if (block.get(0).getOffset() == ins.getOffset() + ins.getJumpOffset()) {
                return block;
            }
        }
        return null;
    }


}
