package org.bon.jvm.instructions;

import org.bon.Cast;
import org.bon.api.Method;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 18.26
 */

public abstract class Instruction implements Cast {

    private Method owner;

    public Method getOwner() {
        return owner;
    }

    public void setOwner(Method owner) {
        this.owner = owner;
    }

    public abstract String getName();

    public static Instruction from(int b) {
        switch (b) {
            case 0x32:
                return new Aaload();
            case 0x53:
                return new Aastore();
            case 0x01:
                return new Aconst_null();
            case 0x19:
                return new Aload(420);
            case 0x2a:
                return new Aload(0);
            case 0x2b:
                return new Aload(1);
            case 0x2c:
                return new Aload(2);
            case 0x2d:
                return new Aload(3);
            case 0xbd:
                return new Anewarray();
            case 0xb0:
                return new Areturn();
            case 0xbe:
                return new Arraylength();
            case 0x3a:
                return new Astore(420);
            case 0x4b:
                return new Astore(0);
            case 0x4c:
                return new Astore(1);
            case 0x4d:
                return new Astore(2);
            case 0x4e:
                return new Astore(3);
            case 0xbf:
                return new Athrow();
            case 0x33:
                return new Baload();
            case 0x54:
                return new Bastore();
            case 0x10:
                return new Bipush();
            case 0x34:
                return new Caload();
            case 0x55:
                return new Castore();
            case 0xc0:
                return new Checkcast();
            case 0x90:
                return new D2f();
            case 0x8e:
                return new D2i();
            case 0x8f:
                return new D2l();
            case 0x63:
                return new Dadd();
            case 0x31:
                return new Daload();
            case 0x52:
                return new Dastore();
            case 0x98:
                return new Dcmpg();
            case 0x97:
                return new Dcmpl();
            case 0x0e:
                return new Dconst(0);
            case 0x0f:
                return new Dconst(1);
            case 0x6f:
                return new Ddiv();
            case 0x18:
                return new Dload(420);
            case 0x26:
                return new Dload(0);
            case 0x27:
                return new Dload(1);
            case 0x28:
                return new Dload(2);
            case 0x29:
                return new Dload(3);
            case 0x6b:
                return new Dmul();
            case 0x77:
                return new Dneg();
            case 0x73:
                return new Drem();
            case 0xaf:
                return new Dreturn();
            case 0x39:
                return new Dstore(420);
            case 0x47:
                return new Dstore(0);
            case 0x48:
                return new Dstore(1);
            case 0x49:
                return new Dstore(2);
            case 0x4a:
                return new Dstore(3);
            case 0x67:
                return new Dsub();
            case 0x59:
                return new Dup();
            case 0x5a:
                return new Dup_x1();
            case 0x5b:
                return new Dup_x2();
            case 0x5c:
                return new Dup2();
            case 0x5d:
                return new Dup2_x1();
            case 0x5e:
                return new Dup2_x2();
            case 0x8d:
                return new F2d();
            case 0x8b:
                return new F2i();
            case 0x8c:
                return new F2l();
            case 0x62:
                return new Fadd();
            case 0x30:
                return new Faload();
            case 0x51:
                return new Fastore();
            case 0x96:
                return new Fcmpg();
            case 0x95:
                return new Fcmpl();
            case 0x0b:
                return new Fconst(0);
            case 0x0c:
                return new Fconst(1);
            case 0x0d:
                return new Fconst(2);
            case 0x6e:
                return new Fdiv();
            case 0x17:
                return new Fload(420);
            case 0x22:
                return new Fload(0);
            case 0x23:
                return new Fload(1);
            case 0x24:
                return new Fload(2);
            case 0x25:
                return new Fload(3);
            case 0x6a:
                return new Fmul();
            case 0x76:
                return new Fneg();
            case 0x72:
                return new Frem();
            case 0xae:
                return new Freturn();
            case 0x38:
                return new Fstore(420);
            case 0x43:
                return new Fstore(0);
            case 0x44:
                return new Fstore(1);
            case 0x45:
                return new Fstore(2);
            case 0x46:
                return new Fstore(3);
            case 0x66:
                return new Fsub();
            case 0xb4:
                return new Getfield();
            case 0xb2:
                return new Getstatic();
            case 0xa7:
                return new Goto();
            case 0xc8:
                return new Goto_w();
            case 0x91:
                return new I2b();
            case 0x92:
                return new I2c();
            case 0x87:
                return new I2d();
            case 0x86:
                return new I2f();
            case 0x85:
                return new I2l();
            case 0x93:
                return new I2s();
            case 0x60:
                return new Iadd();
            case 0x2e:
                return new Iaload();
            case 0x7e:
                return new Iand();
            case 0x4f:
                return new Iastore();
            case 0x02:
                return new Iconst_m1();
            case 0x03:
                return new Iconst(0);
            case 0x04:
                return new Iconst(1);
            case 0x05:
                return new Iconst(2);
            case 0x06:
                return new Iconst(3);
            case 0x07:
                return new Iconst(4);
            case 0x08:
                return new Iconst(5);
            case 0x6c:
                return new Idiv();
            case 0xa5:
                return new If_acmpeq();
            case 0xa6:
                return new If_acmpne();
            case 0x9f:
                return new If_icmpeq();
            case 0xa2:
                return new If_icmpge();
            case 0xa3:
                return new If_icmpgt();
            case 0xa4:
                return new If_icmple();
            case 0xa1:
                return new If_icmplt();
            case 0xa0:
                return new If_icmpne();
            case 0x99:
                return new Ifeq();
            case 0x9c:
                return new Ifge();
            case 0x9d:
                return new Ifgt();
            case 0x9e:
                return new Ifle();
            case 0x9b:
                return new Iflt();
            case 0x9a:
                return new Ifne();
            case 0xc7:
                return new Ifnonnull();
            case 0xc6:
                return new Ifnull();
            case 0x84:
                return new Iinc();
            case 0x15:
                return new Iload(420);
            case 0x1a:
                return new Iload(0);
            case 0x1b:
                return new Iload(1);
            case 0x1c:
                return new Iload(2);
            case 0x1d:
                return new Iload(3);
            case 0x68:
                return new Imul();
            case 0x74:
                return new Ineg();
            case 0xc1:
                return new Instanceof();
            case 0xba:
                return new Invokedynamic();
            case 0xb9:
                return new Invokeinterface();
            case 0xb7:
                return new Invokespecial();
            case 0xb8:
                return new Invokestatic();
            case 0xb6:
                return new Invokevirtual();
            case 0x80:
                return new Ior();
            case 0x70:
                return new Irem();
            case 0xac:
                return new Ireturn();
            case 0x78:
                return new Ishl();
            case 0x7a:
                return new Ishr();
            case 0x36:
                return new Istore(420);
            case 0x3b:
                return new Istore(0);
            case 0x3c:
                return new Istore(1);
            case 0x3d:
                return new Istore(2);
            case 0x3e:
                return new Istore(3);
            case 0x64:
                return new Isub();
            case 0x7c:
                return new Iushr();
            case 0x82:
                return new Ixor();
            case 0xa8:
                return new Jsr();
            case 0xc9:
                return new Jsr_w();
            case 0x8a:
                return new L2d();
            case 0x89:
                return new L2f();
            case 0x88:
                return new L2i();
            case 0x61:
                return new Ladd();
            case 0x2f:
                return new Laload();
            case 0x7f:
                return new Land();
            case 0x50:
                return new Lastore();
            case 0x94:
                return new Lcmp();
            case 0x09:
                return new Lconst(0);
            case 0x0a:
                return new Lconst(1);
            case 0x12:
                return new Ldc();
            case 0x13:
                return new Ldc_w();
            case 0x14:
                return new Ldc2_w();
            case 0x6d:
                return new Ldiv();
            case 0x16:
                return new Lload(420);
            case 0x1e:
                return new Lload(0);
            case 0x1f:
                return new Lload(1);
            case 0x20:
                return new Lload(2);
            case 0x21:
                return new Lload(3);
            case 0x69:
                return new Lmul();
            case 0x75:
                return new Lneg();
            case 0x81:
                return new Lor();
            case 0x71:
                return new Lrem();
            case 0xad:
                return new Lreturn();
            case 0x79:
                return new Lshl();
            case 0x7b:
                return new Lshr();
            case 0x37:
                return new Lstore(420);
            case 0x3f:
                return new Lstore(0);
            case 0x40:
                return new Lstore(1);
            case 0x41:
                return new Lstore(2);
            case 0x42:
                return new Lstore(3);
            case 0x65:
                return new Lsub();
            case 0x7d:
                return new Lushr();
            case 0x83:
                return new Lxor();
            case 0xc2:
                return new Monitorenter();
            case 0xc3:
                return new Monitorexit();
            case 0xc5:
                return new Multianewarray();
            case 0xbb:
                return new New();
            case 0xbc:
                return new Newarray();
            case 0x00:
                return new Nop();
            case 0x57:
                return new Pop();
            case 0x58:
                return new Pop2();
            case 0xb5:
                return new Putfield();
            case 0xb3:
                return new Putstatic();
            case 0xa9:
                return new Ret();
            case 0xb1:
                return new Return();
            case 0x35:
                return new Saload();
            case 0x56:
                return new Sastore();
            case 0x11:
                return new Sipush();
            case 0x5f:
                return new Swap();
            case 0xab:
                return new Lookupswitch();
            case 0xaa:
                return new Tableswitch();
            case 0xc4:
                return new Wide();
            default:
                throw new UnsupportedOperationException("Unsupported opcode " + b);
        }
    }
}
