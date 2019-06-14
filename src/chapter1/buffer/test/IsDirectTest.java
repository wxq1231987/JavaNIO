package chapter1.buffer.test;

import java.nio.ByteBuffer;

public class IsDirectTest {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocateDirect(100);
        System.out.println("Is direct " + buffer.isDirect());
    }

}
