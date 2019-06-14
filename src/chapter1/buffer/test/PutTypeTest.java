package chapter1.buffer.test;

import java.nio.ByteBuffer;

public class PutTypeTest {
    /**
     * putType()测试
     * @param args
     */
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(100);
        buffer.putChar('a');
        buffer.putChar(2, 'b');
        System.out.println("A position =" + buffer.position());

        buffer.position(4);
        buffer.putDouble(1.1);
        buffer.putDouble(12, 1.2);

        buffer.position(20);
        buffer.putFloat(2.1f);
        buffer.putFloat(24, 2.2f);

        buffer.position(28);
        buffer.putInt(31);
        buffer.putInt(32, 32);

        buffer.position(36);
        buffer.putLong(41l);
        buffer.putLong(44, 42l);

        buffer.position(52);
        buffer.putShort((short) 51);
        buffer.putShort(54, (short) 52);

        buffer.position(0);
    }

}
