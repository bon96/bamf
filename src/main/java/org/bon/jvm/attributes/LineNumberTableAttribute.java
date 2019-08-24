package org.bon.jvm.attributes;

import org.bon.jvm.constantpool.ConstPool;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.7.12
 */

public class LineNumberTableAttribute extends Attribute {

    private List<LineNumber> lineNumbers = new ArrayList<>();

    public LineNumberTableAttribute(ByteBuffer byteBuffer, ConstPool constPool) {
        super(byteBuffer, constPool);

        int tableLength = byteBuffer.getShort();
        for (int i = 0; i < tableLength; i++) {
            lineNumbers.add(new LineNumber(byteBuffer.getShort(), byteBuffer.getShort()));
        }
    }

    public List<LineNumber> getLineNumbers() {
        return lineNumbers;
    }

    public static class LineNumber {
        private int startPc;
        private int lineNumber;

        public LineNumber(int startPc, int lineNumber) {
            this.startPc = startPc;
            this.lineNumber = lineNumber;
        }

        public int getStartPc() {
            return startPc;
        }

        public int getLineNumber() {
            return lineNumber;
        }

        @Override
        public String toString() {
            return "LineNumber{" +
                    "startPc=" + startPc +
                    ", lineNumber=" + lineNumber +
                    '}';
        }
    }
}
