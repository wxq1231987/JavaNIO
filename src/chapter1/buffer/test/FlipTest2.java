package chapter1.buffer.test;

import java.nio.CharBuffer;

public class FlipTest2 {

    public static void main(String[] args) {
        CharBuffer buffer = CharBuffer.allocate(20);
        System.out.println("A position=" + buffer.position() + ", limit="
                + buffer.limit());
        buffer.put("我正在练习NIO与Socket");
        System.out.println("B position=" + buffer.position() + ", limit="
                + buffer.limit());
        buffer.position(0);
        System.out.println("C position=" + buffer.position() + ", limit="
                + buffer.limit());
        for (int i = 0; i < buffer.limit(); i++) {
            System.out.print(buffer.get() + " ");
        }
        System.out.println("*************");
        System.out.println("D position=" + buffer.position() + ", limit="
                + buffer.limit());
        buffer.clear();
        System.out.println("E position=" + buffer.position() + ", limit="
                + buffer.limit());
        buffer.put("现在才学习到第1章");
        System.out.println("F position=" + buffer.position() + ", limit="
                + buffer.limit());
        buffer.flip();
        System.out.println("G position=" + buffer.position() + ", limit="
                + buffer.limit());
        for (int i = 0; i < buffer.limit(); i++) {
            System.out.print(buffer.get() + " ");
        }
    }

}
