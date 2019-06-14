package chapter1.buffer.test;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;

public class AsTypeBufferTest {

    public static void main(String[] args) {
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(32);
        byteBuffer1.putDouble(1.1D);
        byteBuffer1.putDouble(1.2D);
        byteBuffer1.putDouble(1.3D);
        byteBuffer1.putDouble(1.4D);
        byteBuffer1.flip();
        DoubleBuffer doubleBuffer = byteBuffer1.asDoubleBuffer();
        for (int i = 0;i < doubleBuffer.capacity();i++) {
            System.out.print(doubleBuffer.get(i) + " ");
        }
        System.out.println();

        ByteBuffer byteBuffer2 = ByteBuffer.allocate(16);
        byteBuffer2.putFloat(2.1F);
        byteBuffer2.putFloat(2.2F);
        byteBuffer2.putFloat(2.3F);
        byteBuffer2.putFloat(2.4F);
        byteBuffer2.flip();
        FloatBuffer floatBuffer = byteBuffer2.asFloatBuffer();
        for (int i = 0;i < floatBuffer.capacity();i++) {
            System.out.print(floatBuffer.get(i) + " ");
        }
    }

}
