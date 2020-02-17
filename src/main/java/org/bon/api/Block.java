package org.bon.api;

import org.bon.api.containers.Blocks;
import org.bon.jvm.instructions.Athrow;
import org.bon.jvm.instructions.Instruction;
import org.bon.jvm.instructions.types.JumpInstruction;
import org.bon.jvm.instructions.types.ReturnInstruction;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Tommi
 * Date: 21/12/2019
 * Time: 18.07
 */

public class Block implements Iterable<Instruction> {

    private ArrayList<Instruction> instructions;
    private Blocks blocks;

    public Block(Blocks blocks) {
        this.blocks = blocks;
        instructions = new ArrayList<>();
    }

    public Block(Collection<? extends Instruction> c, Blocks blocks) {
        instructions = new ArrayList<>(c);
        this.blocks = blocks;
    }

    public ArrayList<Instruction> getInstructions() {
        return instructions;
    }

    public List<Block> getTargetOf() {
        List<Block> blocks = new ArrayList<>();
        for (Block block : this.blocks) {
            if (block.getTarget() != null) {
                if (block.getTarget().equals(this)) {
                    blocks.add(block);
                }
            }
        }
        return blocks;
    }

    public Block getTarget() {
        Instruction last = get(size() - 1);
        if (last instanceof ReturnInstruction || last instanceof Athrow) {
            return null;
        }

        if (last instanceof JumpInstruction) {
            Block block = blocks.getBlock(last.cast());
            if (block != null) {
                return block;
            }

            throw new IllegalArgumentException("Jump instruction target is not a beginning of a block " + last);
        }

        if (blocks.indexOf(this) + 1 >= blocks.size()) {
            for (Block block : blocks) {
                for (Instruction instruction : block) {
                    System.out.println(instruction);
                }
            }
        }

        return blocks.get(blocks.indexOf(this) + 1);
    }

    public int size() {
        return getInstructions().size();
    }

    public boolean isEmpty() {
        return getInstructions().isEmpty();
    }

    public boolean contains(Object o) {
        return getInstructions().contains(o);
    }

    public int indexOf(Object o) {
        return getInstructions().indexOf(o);
    }

    public Instruction get(int index) {
        return getInstructions().get(index);
    }

    public Instruction set(int index, Instruction element) {
        return getInstructions().set(index, element);
    }

    public boolean add(Instruction instruction) {
        return getInstructions().add(instruction);
    }

    public void add(int index, Instruction element) {
        getInstructions().add(index, element);
    }

    public Instruction remove(int index) {
        return getInstructions().remove(index);
    }

    public boolean remove(Object o) {
        return getInstructions().remove(o);
    }

    public void clear() {
        getInstructions().clear();
    }

    public boolean addAll(Collection<? extends Instruction> c) {
        return getInstructions().addAll(c);
    }

    public boolean addAll(int index, Collection<? extends Instruction> c) {
        return getInstructions().addAll(index, c);
    }

    public boolean removeAll(Collection<?> c) {
        return getInstructions().removeAll(c);
    }

    @Override
    public Iterator<Instruction> iterator() {
        return getInstructions().iterator();
    }

    public void forEach(Consumer<? super Instruction> action) {
        getInstructions().forEach(action);
    }

    public boolean removeIf(Predicate<? super Instruction> filter) {
        return getInstructions().removeIf(filter);
    }

    public void sort(Comparator<? super Instruction> c) {
        getInstructions().sort(c);
    }

    public boolean containsAll(Collection<?> c) {
        return getInstructions().containsAll(c);
    }

    public Stream<Instruction> stream() {
        return getInstructions().stream();
    }

    @Override
    public int hashCode() {
        return getInstructions().hashCode();
    }

    //TODO edit this to be more robust
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Block block = (Block) o;

        if (block.isEmpty() && this.isEmpty()) {
            return true;
        }

        return Objects.equals(get(0).getOffset(), block.get(0).getOffset()) &&
                Objects.equals(get(0), block.get(0)) &&
                Objects.equals(get(size() - 1).getOffset(), block.get(block.size() - 1).getOffset()) &&
                Objects.equals(get(size() - 1), block.get(block.size() - 1));
    }
}
