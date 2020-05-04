package org.bon.jvm.instructions;

import org.bon.Cast;
import org.bon.jvm.Method;
import org.bon.jvm.constantpool.ConstPool;
import org.bon.jvm.execution.MethodContext;
import org.bon.jvm.execution.Stack;
import org.bon.jvm.instructions.types.JumpInstruction;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 18.26
 */

public abstract class Instruction implements Cast {
    public static final int AALOAD = 0x32;
    public static final int AASTORE = 0x53;
    public static final int ACONST_NULL = 0x01;
    public static final int ALOAD = 0x19;
    public static final int ALOAD_0 = 0x2a;
    public static final int ALOAD_1 = 0x2b;
    public static final int ALOAD_2 = 0x2c;
    public static final int ALOAD_3 = 0x2d;
    public static final int ANEWARRAY = 0xbd;
    public static final int ARETURN = 0xb0;
    public static final int ARRAYLENGTH = 0xbe;
    public static final int ASTORE = 0x3a;
    public static final int ASTORE_0 = 0x4b;
    public static final int ASTORE_1 = 0x4c;
    public static final int ASTORE_2 = 0x4d;
    public static final int ASTORE_3 = 0x4e;
    public static final int ATHROW = 0xbf;
    public static final int BALOAD = 0x33;
    public static final int BASTORE = 0x54;
    public static final int BIPUSH = 0x10;
    public static final int CALOAD = 0x34;
    public static final int CASTORE = 0x55;
    public static final int CHECKCAST = 0xc0;
    public static final int D2F = 0x90;
    public static final int D2I = 0x8e;
    public static final int D2L = 0x8f;
    public static final int DADD = 0x63;
    public static final int DALOAD = 0x31;
    public static final int DASTORE = 0x52;
    public static final int DCMPG = 0x98;
    public static final int DCMPL = 0x97;
    public static final int DCONST_0 = 0x0e;
    public static final int DCONST_1 = 0x0f;
    public static final int DDIV = 0x6f;
    public static final int DLOAD = 0x18;
    public static final int DLOAD_0 = 0x26;
    public static final int DLOAD_1 = 0x27;
    public static final int DLOAD_2 = 0x28;
    public static final int DLOAD_3 = 0x29;
    public static final int DMUL = 0x6b;
    public static final int DNEG = 0x77;
    public static final int DREM = 0x73;
    public static final int DRETURN = 0xaf;
    public static final int DSTORE = 0x39;
    public static final int DSTORE_0 = 0x47;
    public static final int DSTORE_1 = 0x48;
    public static final int DSTORE_2 = 0x49;
    public static final int DSTORE_3 = 0x4a;
    public static final int DSUB = 0x67;
    public static final int DUP = 0x59;
    public static final int DUP_X1 = 0x5a;
    public static final int DUP_X2 = 0x5b;
    public static final int DUP2 = 0x5c;
    public static final int DUP2_X1 = 0x5d;
    public static final int DUP2_X2 = 0x5e;
    public static final int F2D = 0x8d;
    public static final int F2I = 0x8b;
    public static final int F2L = 0x8c;
    public static final int FADD = 0x62;
    public static final int FALOAD = 0x30;
    public static final int FASTORE = 0x51;
    public static final int FCMPG = 0x96;
    public static final int FCMPL = 0x95;
    public static final int FCONST_0 = 0x0b;
    public static final int FCONST_1 = 0x0c;
    public static final int FCONST_2 = 0x0d;
    public static final int FDIV = 0x6e;
    public static final int FLOAD = 0x17;
    public static final int FLOAD_0 = 0x22;
    public static final int FLOAD_1 = 0x23;
    public static final int FLOAD_2 = 0x24;
    public static final int FLOAD_3 = 0x25;
    public static final int FMUL = 0x6a;
    public static final int FNEG = 0x76;
    public static final int FREM = 0x72;
    public static final int FRETURN = 0xae;
    public static final int FSTORE = 0x38;
    public static final int FSTORE_0 = 0x43;
    public static final int FSTORE_1 = 0x44;
    public static final int FSTORE_2 = 0x45;
    public static final int FSTORE_3 = 0x46;
    public static final int FSUB = 0x66;
    public static final int GETFIELD = 0xb4;
    public static final int GETSTATIC = 0xb2;
    public static final int GOTO = 0xa7;
    public static final int GOTO_W = 0xc8;
    public static final int I2B = 0x91;
    public static final int I2C = 0x92;
    public static final int I2D = 0x87;
    public static final int I2F = 0x86;
    public static final int I2L = 0x85;
    public static final int I2S = 0x93;
    public static final int IADD = 0x60;
    public static final int IALOAD = 0x2e;
    public static final int IAND = 0x7e;
    public static final int IASTORE = 0x4f;
    public static final int ICONST_M1 = 0x02;
    public static final int ICONST_0 = 0x03;
    public static final int ICONST_1 = 0x04;
    public static final int ICONST_2 = 0x05;
    public static final int ICONST_3 = 0x06;
    public static final int ICONST_4 = 0x07;
    public static final int ICONST_5 = 0x08;
    public static final int IDIV = 0x6c;
    public static final int IF_ACMPEQ = 0xa5;
    public static final int IF_ACMPNE = 0xa6;
    public static final int IF_ICMPEQ = 0x9f;
    public static final int IF_ICMPGE = 0xa2;
    public static final int IF_ICMPGT = 0xa3;
    public static final int IF_ICMPLE = 0xa4;
    public static final int IF_ICMPLT = 0xa1;
    public static final int IF_ICMPNE = 0xa0;
    public static final int IFEQ = 0x99;
    public static final int IFGE = 0x9c;
    public static final int IFGT = 0x9d;
    public static final int IFLE = 0x9e;
    public static final int IFLT = 0x9b;
    public static final int IFNE = 0x9a;
    public static final int IFNONNULL = 0xc7;
    public static final int IFNULL = 0xc6;
    public static final int IINC = 0x84;
    public static final int ILOAD = 0x15;
    public static final int ILOAD_0 = 0x1a;
    public static final int ILOAD_1 = 0x1b;
    public static final int ILOAD_2 = 0x1c;
    public static final int ILOAD_3 = 0x1d;
    public static final int IMUL = 0x68;
    public static final int INEG = 0x74;
    public static final int INSTANCEOF = 0xc1;
    public static final int INVOKEDYNAMIC = 0xba;
    public static final int INVOKEINTERFACE = 0xb9;
    public static final int INVOKESPECIAL = 0xb7;
    public static final int INVOKESTATIC = 0xb8;
    public static final int INVOKEVIRTUAL = 0xb6;
    public static final int IOR = 0x80;
    public static final int IREM = 0x70;
    public static final int IRETURN = 0xac;
    public static final int ISHL = 0x78;
    public static final int ISHR = 0x7a;
    public static final int ISTORE = 0x36;
    public static final int ISTORE_0 = 0x3b;
    public static final int ISTORE_1 = 0x3c;
    public static final int ISTORE_2 = 0x3d;
    public static final int ISTORE_3 = 0x3e;
    public static final int ISUB = 0x64;
    public static final int IUSHR = 0x7c;
    public static final int IXOR = 0x82;
    public static final int JSR = 0xa8;
    public static final int JSR_W = 0xc9;
    public static final int L2D = 0x8a;
    public static final int L2F = 0x89;
    public static final int L2I = 0x88;
    public static final int LADD = 0x61;
    public static final int LALOAD = 0x2f;
    public static final int LAND = 0x7f;
    public static final int LASTORE = 0x50;
    public static final int LCMP = 0x94;
    public static final int LCONST_0 = 0x09;
    public static final int LCONST_1 = 0x0a;
    public static final int LDC = 0x12;
    public static final int LDC_W = 0x13;
    public static final int LDC2_W = 0x14;
    public static final int LDIV = 0x6d;
    public static final int LLOAD = 0x16;
    public static final int LLOAD_0 = 0x1e;
    public static final int LLOAD_1 = 0x1f;
    public static final int LLOAD_2 = 0x20;
    public static final int LLOAD_3 = 0x21;
    public static final int LMUL = 0x69;
    public static final int LNEG = 0x75;
    public static final int LOR = 0x81;
    public static final int LREM = 0x71;
    public static final int LRETURN = 0xad;
    public static final int LSHL = 0x79;
    public static final int LSHR = 0x7b;
    public static final int LSTORE = 0x37;
    public static final int LSTORE_0 = 0x3f;
    public static final int LSTORE_1 = 0x40;
    public static final int LSTORE_2 = 0x41;
    public static final int LSTORE_3 = 0x42;
    public static final int LSUB = 0x65;
    public static final int LUSHR = 0x7d;
    public static final int LXOR = 0x83;
    public static final int MONITORENTER = 0xc2;
    public static final int MONITOREXIT = 0xc3;
    public static final int MULTIANEWARRAY = 0xc5;
    public static final int NEW = 0xbb;
    public static final int NEWARRAY = 0xbc;
    public static final int NOP = 0x00;
    public static final int POP = 0x57;
    public static final int POP2 = 0x58;
    public static final int PUTFIELD = 0xb5;
    public static final int PUTSTATIC = 0xb3;
    public static final int RET = 0xa9;
    public static final int RETURN = 0xb1;
    public static final int SALOAD = 0x35;
    public static final int SASTORE = 0x56;
    public static final int SIPUSH = 0x11;
    public static final int SWAP = 0x5f;
    public static final int LOOKUPSWITCH = 0xab;
    public static final int TABLESWITCH = 0xaa;
    public static final int WIDE = 0xc4;

    private Method owner;
    private int offset;
    private boolean isJumpTarget;

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public boolean isJumpTarget() {
        return isJumpTarget;
    }

    public void setJumpTarget(boolean jumpTarget) {
        isJumpTarget = jumpTarget;
    }

    public Method getOwner() {
        return owner;
    }

    void setOwner(Method owner) {
        this.owner = owner;
    }

    public abstract void execute(MethodContext context, Stack stack);

    public abstract String getName();

    public static List<Instruction> instructionsFrom(DataInputStream in, ConstPool constPool, Method method) throws IOException {
        int size = in.readInt();
        int start = in.available();
        int end = start - size;

        List<Instruction> instructions = new ArrayList<>();
        while (in.available() > end) {
            int opcodeOffset = start - in.available();

            int opcode = in.readUnsignedByte();
            boolean isWide = (opcode == WIDE);
            if (isWide) {
                opcode = in.readUnsignedByte();
            }

            int offset = start - in.available();
            switch (opcode) {
                case 0x32:
                    instructions.add(Aaload.from(in, constPool));
                    break;
                case 0x53:
                    instructions.add(Aastore.from(in, constPool));
                    break;
                case 0x01:
                    instructions.add(Aconst_null.from(in, constPool));
                    break;
                case 0x19:
                    instructions.add(Aload.from(in, constPool, isWide));
                    break;
                case 0x2a:
                    instructions.add(Aload.from(in, constPool, 0));
                    break;
                case 0x2b:
                    instructions.add(Aload.from(in, constPool, 1));
                    break;
                case 0x2c:
                    instructions.add(Aload.from(in, constPool, 2));
                    break;
                case 0x2d:
                    instructions.add(Aload.from(in, constPool, 3));
                    break;
                case 0xbd:
                    instructions.add(Anewarray.from(in, constPool));
                    break;
                case 0xb0:
                    instructions.add(Areturn.from(in, constPool));
                    break;
                case 0xbe:
                    instructions.add(Arraylength.from(in, constPool));
                    break;
                case 0x3a:
                    instructions.add(Astore.from(in, constPool, isWide));
                    break;
                case 0x4b:
                    instructions.add(Astore.from(in, constPool, 0));
                    break;
                case 0x4c:
                    instructions.add(Astore.from(in, constPool, 1));
                    break;
                case 0x4d:
                    instructions.add(Astore.from(in, constPool, 2));
                    break;
                case 0x4e:
                    instructions.add(Astore.from(in, constPool, 3));
                    break;
                case 0xbf:
                    instructions.add(Athrow.from(in, constPool));
                    break;
                case 0x33:
                    instructions.add(Baload.from(in, constPool));
                    break;
                case 0x54:
                    instructions.add(Bastore.from(in, constPool));
                    break;
                case 0x10:
                    instructions.add(Bipush.from(in, constPool));
                    break;
                case 0x34:
                    instructions.add(Caload.from(in, constPool));
                    break;
                case 0x55:
                    instructions.add(Castore.from(in, constPool));
                    break;
                case 0xc0:
                    instructions.add(Checkcast.from(in, constPool));
                    break;
                case 0x90:
                    instructions.add(D2f.from(in, constPool));
                    break;
                case 0x8e:
                    instructions.add(D2i.from(in, constPool));
                    break;
                case 0x8f:
                    instructions.add(D2l.from(in, constPool));
                    break;
                case 0x63:
                    instructions.add(Dadd.from(in, constPool));
                    break;
                case 0x31:
                    instructions.add(Daload.from(in, constPool));
                    break;
                case 0x52:
                    instructions.add(Dastore.from(in, constPool));
                    break;
                case 0x98:
                    instructions.add(Dcmpg.from(in, constPool));
                    break;
                case 0x97:
                    instructions.add(Dcmpl.from(in, constPool));
                    break;
                case 0x0e:
                    instructions.add(Dconst.from(in, constPool, 0));
                    break;
                case 0x0f:
                    instructions.add(Dconst.from(in, constPool, 1));
                    break;
                case 0x6f:
                    instructions.add(Ddiv.from(in, constPool));
                    break;
                case 0x18:
                    instructions.add(Dload.from(in, constPool, isWide));
                    break;
                case 0x26:
                    instructions.add(Dload.from(in, constPool, 0));
                    break;
                case 0x27:
                    instructions.add(Dload.from(in, constPool, 1));
                    break;
                case 0x28:
                    instructions.add(Dload.from(in, constPool, 2));
                    break;
                case 0x29:
                    instructions.add(Dload.from(in, constPool, 3));
                    break;
                case 0x6b:
                    instructions.add(Dmul.from(in, constPool));
                    break;
                case 0x77:
                    instructions.add(Dneg.from(in, constPool));
                    break;
                case 0x73:
                    instructions.add(Drem.from(in, constPool));
                    break;
                case 0xaf:
                    instructions.add(Dreturn.from(in, constPool));
                    break;
                case 0x39:
                    instructions.add(Dstore.from(in, constPool, isWide));
                    break;
                case 0x47:
                    instructions.add(Dstore.from(in, constPool, 0));
                    break;
                case 0x48:
                    instructions.add(Dstore.from(in, constPool, 1));
                    break;
                case 0x49:
                    instructions.add(Dstore.from(in, constPool, 2));
                    break;
                case 0x4a:
                    instructions.add(Dstore.from(in, constPool, 3));
                    break;
                case 0x67:
                    instructions.add(Dsub.from(in, constPool));
                    break;
                case 0x59:
                    instructions.add(Dup.from(in, constPool));
                    break;
                case 0x5a:
                    instructions.add(Dup_x1.from(in, constPool));
                    break;
                case 0x5b:
                    instructions.add(Dup_x2.from(in, constPool));
                    break;
                case 0x5c:
                    instructions.add(Dup2.from(in, constPool));
                    break;
                case 0x5d:
                    instructions.add(Dup2_x1.from(in, constPool));
                    break;
                case 0x5e:
                    instructions.add(Dup2_x2.from(in, constPool));
                    break;
                case 0x8d:
                    instructions.add(F2d.from(in, constPool));
                    break;
                case 0x8b:
                    instructions.add(F2i.from(in, constPool));
                    break;
                case 0x8c:
                    instructions.add(F2l.from(in, constPool));
                    break;
                case 0x62:
                    instructions.add(Fadd.from(in, constPool));
                    break;
                case 0x30:
                    instructions.add(Faload.from(in, constPool));
                    break;
                case 0x51:
                    instructions.add(Fastore.from(in, constPool));
                    break;
                case 0x96:
                    instructions.add(Fcmpg.from(in, constPool));
                    break;
                case 0x95:
                    instructions.add(Fcmpl.from(in, constPool));
                    break;
                case 0x0b:
                    instructions.add(Fconst.from(in, constPool, 0));
                    break;
                case 0x0c:
                    instructions.add(Fconst.from(in, constPool, 1));
                    break;
                case 0x0d:
                    instructions.add(Fconst.from(in, constPool, 2));
                    break;
                case 0x6e:
                    instructions.add(Fdiv.from(in, constPool));
                    break;
                case 0x17:
                    instructions.add(Fload.from(in, constPool, isWide));
                    break;
                case 0x22:
                    instructions.add(Fload.from(in, constPool, 0));
                    break;
                case 0x23:
                    instructions.add(Fload.from(in, constPool, 1));
                    break;
                case 0x24:
                    instructions.add(Fload.from(in, constPool, 2));
                    break;
                case 0x25:
                    instructions.add(Fload.from(in, constPool, 3));
                    break;
                case 0x6a:
                    instructions.add(Fmul.from(in, constPool));
                    break;
                case 0x76:
                    instructions.add(Fneg.from(in, constPool));
                    break;
                case 0x72:
                    instructions.add(Frem.from(in, constPool));
                    break;
                case 0xae:
                    instructions.add(Freturn.from(in, constPool));
                    break;
                case 0x38:
                    instructions.add(Fstore.from(in, constPool, isWide));
                    break;
                case 0x43:
                    instructions.add(Fstore.from(in, constPool, 0));
                    break;
                case 0x44:
                    instructions.add(Fstore.from(in, constPool, 1));
                    break;
                case 0x45:
                    instructions.add(Fstore.from(in, constPool, 2));
                    break;
                case 0x46:
                    instructions.add(Fstore.from(in, constPool, 3));
                    break;
                case 0x66:
                    instructions.add(Fsub.from(in, constPool));
                    break;
                case 0xb4:
                    instructions.add(Getfield.from(in, constPool));
                    break;
                case 0xb2:
                    instructions.add(Getstatic.from(in, constPool));
                    break;
                case 0xa7:
                    instructions.add(Goto.from(in, constPool));
                    break;
                case 0xc8:
                    instructions.add(Goto_w.from(in, constPool));
                    break;
                case 0x91:
                    instructions.add(I2b.from(in, constPool));
                    break;
                case 0x92:
                    instructions.add(I2c.from(in, constPool));
                    break;
                case 0x87:
                    instructions.add(I2d.from(in, constPool));
                    break;
                case 0x86:
                    instructions.add(I2f.from(in, constPool));
                    break;
                case 0x85:
                    instructions.add(I2l.from(in, constPool));
                    break;
                case 0x93:
                    instructions.add(I2s.from(in, constPool));
                    break;
                case 0x60:
                    instructions.add(Iadd.from(in, constPool));
                    break;
                case 0x2e:
                    instructions.add(Iaload.from(in, constPool));
                    break;
                case 0x7e:
                    instructions.add(Iand.from(in, constPool));
                    break;
                case 0x4f:
                    instructions.add(Iastore.from(in, constPool));
                    break;
                case 0x02:
                    instructions.add(Iconst_m1.from(in, constPool));
                    break;
                case 0x03:
                    instructions.add(Iconst.from(in, constPool, 0));
                    break;
                case 0x04:
                    instructions.add(Iconst.from(in, constPool, 1));
                    break;
                case 0x05:
                    instructions.add(Iconst.from(in, constPool, 2));
                    break;
                case 0x06:
                    instructions.add(Iconst.from(in, constPool, 3));
                    break;
                case 0x07:
                    instructions.add(Iconst.from(in, constPool, 4));
                    break;
                case 0x08:
                    instructions.add(Iconst.from(in, constPool, 5));
                    break;
                case 0x6c:
                    instructions.add(Idiv.from(in, constPool));
                    break;
                case 0xa5:
                    instructions.add(If_acmpeq.from(in, constPool));
                    break;
                case 0xa6:
                    instructions.add(If_acmpne.from(in, constPool));
                    break;
                case 0x9f:
                    instructions.add(If_icmpeq.from(in, constPool));
                    break;
                case 0xa2:
                    instructions.add(If_icmpge.from(in, constPool));
                    break;
                case 0xa3:
                    instructions.add(If_icmpgt.from(in, constPool));
                    break;
                case 0xa4:
                    instructions.add(If_icmple.from(in, constPool));
                    break;
                case 0xa1:
                    instructions.add(If_icmplt.from(in, constPool));
                    break;
                case 0xa0:
                    instructions.add(If_icmpne.from(in, constPool));
                    break;
                case 0x99:
                    instructions.add(Ifeq.from(in, constPool));
                    break;
                case 0x9c:
                    instructions.add(Ifge.from(in, constPool));
                    break;
                case 0x9d:
                    instructions.add(Ifgt.from(in, constPool));
                    break;
                case 0x9e:
                    instructions.add(Ifle.from(in, constPool));
                    break;
                case 0x9b:
                    instructions.add(Iflt.from(in, constPool));
                    break;
                case 0x9a:
                    instructions.add(Ifne.from(in, constPool));
                    break;
                case 0xc7:
                    instructions.add(Ifnonnull.from(in, constPool));
                    break;
                case 0xc6:
                    instructions.add(Ifnull.from(in, constPool));
                    break;
                case 0x84:
                    instructions.add(Iinc.from(in, constPool, isWide));
                    break;
                case 0x15:
                    instructions.add(Iload.from(in, constPool, isWide));
                    break;
                case 0x1a:
                    instructions.add(Iload.from(in, constPool, 0));
                    break;
                case 0x1b:
                    instructions.add(Iload.from(in, constPool, 1));
                    break;
                case 0x1c:
                    instructions.add(Iload.from(in, constPool, 2));
                    break;
                case 0x1d:
                    instructions.add(Iload.from(in, constPool, 3));
                    break;
                case 0x68:
                    instructions.add(Imul.from(in, constPool));
                    break;
                case 0x74:
                    instructions.add(Ineg.from(in, constPool));
                    break;
                case 0xc1:
                    instructions.add(Instanceof.from(in, constPool));
                    break;
                case 0xba:
                    instructions.add(Invokedynamic.from(in, constPool));
                    break;
                case 0xb9:
                    instructions.add(Invokeinterface.from(in, constPool));
                    break;
                case 0xb7:
                    instructions.add(Invokespecial.from(in, constPool));
                    break;
                case 0xb8:
                    instructions.add(Invokestatic.from(in, constPool));
                    break;
                case 0xb6:
                    instructions.add(Invokevirtual.from(in, constPool));
                    break;
                case 0x80:
                    instructions.add(Ior.from(in, constPool));
                    break;
                case 0x70:
                    instructions.add(Irem.from(in, constPool));
                    break;
                case 0xac:
                    instructions.add(Ireturn.from(in, constPool));
                    break;
                case 0x78:
                    instructions.add(Ishl.from(in, constPool));
                    break;
                case 0x7a:
                    instructions.add(Ishr.from(in, constPool));
                    break;
                case 0x36:
                    instructions.add(Istore.from(in, constPool, isWide));
                    break;
                case 0x3b:
                    instructions.add(Istore.from(in, constPool, 0));
                    break;
                case 0x3c:
                    instructions.add(Istore.from(in, constPool, 1));
                    break;
                case 0x3d:
                    instructions.add(Istore.from(in, constPool, 2));
                    break;
                case 0x3e:
                    instructions.add(Istore.from(in, constPool, 3));
                    break;
                case 0x64:
                    instructions.add(Isub.from(in, constPool));
                    break;
                case 0x7c:
                    instructions.add(Iushr.from(in, constPool));
                    break;
                case 0x82:
                    instructions.add(Ixor.from(in, constPool));
                    break;
                case 0xa8:
                    instructions.add(Jsr.from(in, constPool));
                    break;
                case 0xc9:
                    instructions.add(Jsr_w.from(in, constPool));
                    break;
                case 0x8a:
                    instructions.add(L2d.from(in, constPool));
                    break;
                case 0x89:
                    instructions.add(L2f.from(in, constPool));
                    break;
                case 0x88:
                    instructions.add(L2i.from(in, constPool));
                    break;
                case 0x61:
                    instructions.add(Ladd.from(in, constPool));
                    break;
                case 0x2f:
                    instructions.add(Laload.from(in, constPool));
                    break;
                case 0x7f:
                    instructions.add(Land.from(in, constPool));
                    break;
                case 0x50:
                    instructions.add(Lastore.from(in, constPool));
                    break;
                case 0x94:
                    instructions.add(Lcmp.from(in, constPool));
                    break;
                case 0x09:
                    instructions.add(Lconst.from(in, constPool, 0));
                    break;
                case 0x0a:
                    instructions.add(Lconst.from(in, constPool, 1));
                    break;
                case 0x12:
                    instructions.add(Ldc.from(in, constPool));
                    break;
                case 0x13:
                    instructions.add(Ldc_w.from(in, constPool));
                    break;
                case 0x14:
                    instructions.add(Ldc2_w.from(in, constPool));
                    break;
                case 0x6d:
                    instructions.add(Ldiv.from(in, constPool));
                    break;
                case 0x16:
                    instructions.add(Lload.from(in, constPool, isWide));
                    break;
                case 0x1e:
                    instructions.add(Lload.from(in, constPool, 0));
                    break;
                case 0x1f:
                    instructions.add(Lload.from(in, constPool, 1));
                    break;
                case 0x20:
                    instructions.add(Lload.from(in, constPool, 2));
                    break;
                case 0x21:
                    instructions.add(Lload.from(in, constPool, 3));
                    break;
                case 0x69:
                    instructions.add(Lmul.from(in, constPool));
                    break;
                case 0x75:
                    instructions.add(Lneg.from(in, constPool));
                    break;
                case 0x81:
                    instructions.add(Lor.from(in, constPool));
                    break;
                case 0x71:
                    instructions.add(Lrem.from(in, constPool));
                    break;
                case 0xad:
                    instructions.add(Lreturn.from(in, constPool));
                    break;
                case 0x79:
                    instructions.add(Lshl.from(in, constPool));
                    break;
                case 0x7b:
                    instructions.add(Lshr.from(in, constPool));
                    break;
                case 0x37:
                    instructions.add(Lstore.from(in, constPool, isWide));
                    break;
                case 0x3f:
                    instructions.add(Lstore.from(in, constPool, 0));
                    break;
                case 0x40:
                    instructions.add(Lstore.from(in, constPool, 1));
                    break;
                case 0x41:
                    instructions.add(Lstore.from(in, constPool, 2));
                    break;
                case 0x42:
                    instructions.add(Lstore.from(in, constPool, 3));
                    break;
                case 0x65:
                    instructions.add(Lsub.from(in, constPool));
                    break;
                case 0x7d:
                    instructions.add(Lushr.from(in, constPool));
                    break;
                case 0x83:
                    instructions.add(Lxor.from(in, constPool));
                    break;
                case 0xc2:
                    instructions.add(Monitorenter.from(in, constPool));
                    break;
                case 0xc3:
                    instructions.add(Monitorexit.from(in, constPool));
                    break;
                case 0xc5:
                    instructions.add(Multianewarray.from(in, constPool));
                    break;
                case 0xbb:
                    instructions.add(New.from(in, constPool));
                    break;
                case 0xbc:
                    instructions.add(Newarray.from(in, constPool));
                    break;
                case 0x00:
                    instructions.add(Nop.from(in, constPool));
                    break;
                case 0x57:
                    instructions.add(Pop.from(in, constPool));
                    break;
                case 0x58:
                    instructions.add(Pop2.from(in, constPool));
                    break;
                case 0xb5:
                    instructions.add(Putfield.from(in, constPool));
                    break;
                case 0xb3:
                    instructions.add(Putstatic.from(in, constPool));
                    break;
                case 0xa9:
                    instructions.add(Ret.from(in, constPool, isWide));
                    break;
                case 0xb1:
                    instructions.add(Return.from(in, constPool));
                    break;
                case 0x35:
                    instructions.add(Saload.from(in, constPool));
                    break;
                case 0x56:
                    instructions.add(Sastore.from(in, constPool));
                    break;
                case 0x11:
                    instructions.add(Sipush.from(in, constPool));
                    break;
                case 0x5f:
                    instructions.add(Swap.from(in, constPool));
                    break;
                case 0xab:
                    instructions.add(Lookupswitch.from(in, constPool, offset));
                    break;
                case 0xaa:
                    instructions.add(Tableswitch.from(in, constPool, offset));
                    break;
                default:
                    throw new UnsupportedOperationException("Unsupported opcode " + opcode);
            }
            instructions.get(instructions.size() - 1).setOffset(opcodeOffset);
            instructions.get(instructions.size() - 1).setOwner(method);
        }

        main:
        for (Instruction instruction : instructions) {
            if (instruction instanceof JumpInstruction) {
                JumpInstruction branchIns = instruction.cast();
                for (int i = 0; i < instructions.size(); i++) {
                    Instruction ins = instructions.get(i);
                    if (ins.getOffset() == branchIns.getOffset() + branchIns.getJumpOffset()) {
                        ins.setJumpTarget(true);
                        branchIns.setJumpTarget(i);
                        continue main;
                    }
                }
                throw new IOException("Invalid JumpInstruction jump offset " +
                        (branchIns.getOffset() + branchIns.getJumpOffset()) + " / " + size);
            }
        }

        return instructions;
    }
}
