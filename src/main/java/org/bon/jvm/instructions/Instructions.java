package org.bon.jvm.instructions;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.20
 */

public class Instructions {
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


    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {
        int opcode = in.readUnsignedByte();
        boolean isWide = (opcode == WIDE);

        if (isWide) {
            opcode = in.readUnsignedByte();
        }

        switch (opcode) {
            case 0x32:
                return Aaload.from(in, constPool);
            case 0x53:
                return Aastore.from(in, constPool);
            case 0x01:
                return Aconst_null.from(in, constPool);
            case 0x19:
                return Aload.from(in, constPool, isWide);
            case 0x2a:
                return Aload.from(in, constPool, 0);
            case 0x2b:
                return Aload.from(in, constPool, 1);
            case 0x2c:
                return Aload.from(in, constPool, 2);
            case 0x2d:
                return Aload.from(in, constPool, 3);
            case 0xbd:
                return Anewarray.from(in, constPool);
            case 0xb0:
                return Areturn.from(in, constPool);
            case 0xbe:
                return Arraylength.from(in, constPool);
            case 0x3a:
                return Astore.from(in, constPool, isWide);
            case 0x4b:
                return Astore.from(in, constPool, 0);
            case 0x4c:
                return Astore.from(in, constPool, 1);
            case 0x4d:
                return Astore.from(in, constPool, 2);
            case 0x4e:
                return Astore.from(in, constPool, 3);
            case 0xbf:
                return Athrow.from(in, constPool);
            case 0x33:
                return Baload.from(in, constPool);
            case 0x54:
                return Bastore.from(in, constPool);
            case 0x10:
                return Bipush.from(in, constPool);
            case 0x34:
                return Caload.from(in, constPool);
            case 0x55:
                return Castore.from(in, constPool);
            case 0xc0:
                return Checkcast.from(in, constPool);
            case 0x90:
                return D2f.from(in, constPool);
            case 0x8e:
                return D2i.from(in, constPool);
            case 0x8f:
                return D2l.from(in, constPool);
            case 0x63:
                return Dadd.from(in, constPool);
            case 0x31:
                return Daload.from(in, constPool);
            case 0x52:
                return Dastore.from(in, constPool);
            case 0x98:
                return Dcmpg.from(in, constPool);
            case 0x97:
                return Dcmpl.from(in, constPool);
            case 0x0e:
                return Dconst.from(in, constPool, 0);
            case 0x0f:
                return Dconst.from(in, constPool, 1);
            case 0x6f:
                return Ddiv.from(in, constPool);
            case 0x18:
                return Dload.from(in, constPool, isWide);
            case 0x26:
                return Dload.from(in, constPool, 0);
            case 0x27:
                return Dload.from(in, constPool, 1);
            case 0x28:
                return Dload.from(in, constPool, 2);
            case 0x29:
                return Dload.from(in, constPool, 3);
            case 0x6b:
                return Dmul.from(in, constPool);
            case 0x77:
                return Dneg.from(in, constPool);
            case 0x73:
                return Drem.from(in, constPool);
            case 0xaf:
                return Dreturn.from(in, constPool);
            case 0x39:
                return Dstore.from(in, constPool, isWide);
            case 0x47:
                return Dstore.from(in, constPool, 0);
            case 0x48:
                return Dstore.from(in, constPool, 1);
            case 0x49:
                return Dstore.from(in, constPool, 2);
            case 0x4a:
                return Dstore.from(in, constPool, 3);
            case 0x67:
                return Dsub.from(in, constPool);
            case 0x59:
                return Dup.from(in, constPool);
            case 0x5a:
                return Dup_x1.from(in, constPool);
            case 0x5b:
                return Dup_x2.from(in, constPool);
            case 0x5c:
                return Dup2.from(in, constPool);
            case 0x5d:
                return Dup2_x1.from(in, constPool);
            case 0x5e:
                return Dup2_x2.from(in, constPool);
            case 0x8d:
                return F2d.from(in, constPool);
            case 0x8b:
                return F2i.from(in, constPool);
            case 0x8c:
                return F2l.from(in, constPool);
            case 0x62:
                return Fadd.from(in, constPool);
            case 0x30:
                return Faload.from(in, constPool);
            case 0x51:
                return Fastore.from(in, constPool);
            case 0x96:
                return Fcmpg.from(in, constPool);
            case 0x95:
                return Fcmpl.from(in, constPool);
            case 0x0b:
                return Fconst.from(in, constPool, 0);
            case 0x0c:
                return Fconst.from(in, constPool, 1);
            case 0x0d:
                return Fconst.from(in, constPool, 2);
            case 0x6e:
                return Fdiv.from(in, constPool);
            case 0x17:
                return Fload.from(in, constPool, isWide);
            case 0x22:
                return Fload.from(in, constPool, 0);
            case 0x23:
                return Fload.from(in, constPool, 1);
            case 0x24:
                return Fload.from(in, constPool, 2);
            case 0x25:
                return Fload.from(in, constPool, 3);
            case 0x6a:
                return Fmul.from(in, constPool);
            case 0x76:
                return Fneg.from(in, constPool);
            case 0x72:
                return Frem.from(in, constPool);
            case 0xae:
                return Freturn.from(in, constPool);
            case 0x38:
                return Fstore.from(in, constPool, isWide);
            case 0x43:
                return Fstore.from(in, constPool, 0);
            case 0x44:
                return Fstore.from(in, constPool, 1);
            case 0x45:
                return Fstore.from(in, constPool, 2);
            case 0x46:
                return Fstore.from(in, constPool, 3);
            case 0x66:
                return Fsub.from(in, constPool);
            case 0xb4:
                return Getfield.from(in, constPool);
            case 0xb2:
                return Getstatic.from(in, constPool);
            case 0xa7:
                return Goto.from(in, constPool);
            case 0xc8:
                return Goto_w.from(in, constPool);
            case 0x91:
                return I2b.from(in, constPool);
            case 0x92:
                return I2c.from(in, constPool);
            case 0x87:
                return I2d.from(in, constPool);
            case 0x86:
                return I2f.from(in, constPool);
            case 0x85:
                return I2l.from(in, constPool);
            case 0x93:
                return I2s.from(in, constPool);
            case 0x60:
                return Iadd.from(in, constPool);
            case 0x2e:
                return Iaload.from(in, constPool);
            case 0x7e:
                return Iand.from(in, constPool);
            case 0x4f:
                return Iastore.from(in, constPool);
            case 0x02:
                return Iconst_m1.from(in, constPool);
            case 0x03:
                return Iconst.from(in, constPool, 0);
            case 0x04:
                return Iconst.from(in, constPool, 1);
            case 0x05:
                return Iconst.from(in, constPool, 2);
            case 0x06:
                return Iconst.from(in, constPool, 3);
            case 0x07:
                return Iconst.from(in, constPool, 4);
            case 0x08:
                return Iconst.from(in, constPool, 5);
            case 0x6c:
                return Idiv.from(in, constPool);
            case 0xa5:
                return If_acmpeq.from(in, constPool);
            case 0xa6:
                return If_acmpne.from(in, constPool);
            case 0x9f:
                return If_icmpeq.from(in, constPool);
            case 0xa2:
                return If_icmpge.from(in, constPool);
            case 0xa3:
                return If_icmpgt.from(in, constPool);
            case 0xa4:
                return If_icmple.from(in, constPool);
            case 0xa1:
                return If_icmplt.from(in, constPool);
            case 0xa0:
                return If_icmpne.from(in, constPool);
            case 0x99:
                return Ifeq.from(in, constPool);
            case 0x9c:
                return Ifge.from(in, constPool);
            case 0x9d:
                return Ifgt.from(in, constPool);
            case 0x9e:
                return Ifle.from(in, constPool);
            case 0x9b:
                return Iflt.from(in, constPool);
            case 0x9a:
                return Ifne.from(in, constPool);
            case 0xc7:
                return Ifnonnull.from(in, constPool);
            case 0xc6:
                return Ifnull.from(in, constPool);
            case 0x84:
                return Iinc.from(in, constPool, isWide);
            case 0x15:
                return Iload.from(in, constPool, isWide);
            case 0x1a:
                return Iload.from(in, constPool, 0);
            case 0x1b:
                return Iload.from(in, constPool, 1);
            case 0x1c:
                return Iload.from(in, constPool, 2);
            case 0x1d:
                return Iload.from(in, constPool, 3);
            case 0x68:
                return Imul.from(in, constPool);
            case 0x74:
                return Ineg.from(in, constPool);
            case 0xc1:
                return Instanceof.from(in, constPool);
            case 0xba:
                return Invokedynamic.from(in, constPool);
            case 0xb9:
                return Invokeinterface.from(in, constPool);
            case 0xb7:
                return Invokespecial.from(in, constPool);
            case 0xb8:
                return Invokestatic.from(in, constPool);
            case 0xb6:
                return Invokevirtual.from(in, constPool);
            case 0x80:
                return Ior.from(in, constPool);
            case 0x70:
                return Irem.from(in, constPool);
            case 0xac:
                return Ireturn.from(in, constPool);
            case 0x78:
                return Ishl.from(in, constPool);
            case 0x7a:
                return Ishr.from(in, constPool);
            case 0x36:
                return Istore.from(in, constPool, isWide);
            case 0x3b:
                return Istore.from(in, constPool, 0);
            case 0x3c:
                return Istore.from(in, constPool, 1);
            case 0x3d:
                return Istore.from(in, constPool, 2);
            case 0x3e:
                return Istore.from(in, constPool, 3);
            case 0x64:
                return Isub.from(in, constPool);
            case 0x7c:
                return Iushr.from(in, constPool);
            case 0x82:
                return Ixor.from(in, constPool);
            case 0xa8:
                return Jsr.from(in, constPool);
            case 0xc9:
                return Jsr_w.from(in, constPool);
            case 0x8a:
                return L2d.from(in, constPool);
            case 0x89:
                return L2f.from(in, constPool);
            case 0x88:
                return L2i.from(in, constPool);
            case 0x61:
                return Ladd.from(in, constPool);
            case 0x2f:
                return Laload.from(in, constPool);
            case 0x7f:
                return Land.from(in, constPool);
            case 0x50:
                return Lastore.from(in, constPool);
            case 0x94:
                return Lcmp.from(in, constPool);
            case 0x09:
                return Lconst.from(in, constPool, 0);
            case 0x0a:
                return Lconst.from(in, constPool, 1);
            case 0x12:
                return Ldc.from(in, constPool);
            case 0x13:
                return Ldc_w.from(in, constPool);
            case 0x14:
                return Ldc2_w.from(in, constPool);
            case 0x6d:
                return Ldiv.from(in, constPool);
            case 0x16:
                return Lload.from(in, constPool, isWide);
            case 0x1e:
                return Lload.from(in, constPool, 0);
            case 0x1f:
                return Lload.from(in, constPool, 1);
            case 0x20:
                return Lload.from(in, constPool, 2);
            case 0x21:
                return Lload.from(in, constPool, 3);
            case 0x69:
                return Lmul.from(in, constPool);
            case 0x75:
                return Lneg.from(in, constPool);
            case 0x81:
                return Lor.from(in, constPool);
            case 0x71:
                return Lrem.from(in, constPool);
            case 0xad:
                return Lreturn.from(in, constPool);
            case 0x79:
                return Lshl.from(in, constPool);
            case 0x7b:
                return Lshr.from(in, constPool);
            case 0x37:
                return Lstore.from(in, constPool, isWide);
            case 0x3f:
                return Lstore.from(in, constPool, 0);
            case 0x40:
                return Lstore.from(in, constPool, 1);
            case 0x41:
                return Lstore.from(in, constPool, 2);
            case 0x42:
                return Lstore.from(in, constPool, 3);
            case 0x65:
                return Lsub.from(in, constPool);
            case 0x7d:
                return Lushr.from(in, constPool);
            case 0x83:
                return Lxor.from(in, constPool);
            case 0xc2:
                return Monitorenter.from(in, constPool);
            case 0xc3:
                return Monitorexit.from(in, constPool);
            case 0xc5:
                return Multianewarray.from(in, constPool);
            case 0xbb:
                return New.from(in, constPool);
            case 0xbc:
                return Newarray.from(in, constPool);
            case 0x00:
                return Nop.from(in, constPool);
            case 0x57:
                return Pop.from(in, constPool);
            case 0x58:
                return Pop2.from(in, constPool);
            case 0xb5:
                return Putfield.from(in, constPool);
            case 0xb3:
                return Putstatic.from(in, constPool);
            case 0xa9:
                return Ret.from(in, constPool, isWide);
            case 0xb1:
                return Return.from(in, constPool);
            case 0x35:
                return Saload.from(in, constPool);
            case 0x56:
                return Sastore.from(in, constPool);
            case 0x11:
                return Sipush.from(in, constPool);
            case 0x5f:
                return Swap.from(in, constPool);
            case 0xab:
                return Lookupswitch.from(in, constPool);
            case 0xaa:
                return Tableswitch.from(in, constPool);
            default:
                throw new UnsupportedOperationException("Unsupported opcode " + opcode);
        }
    }
}
