package chapter2.filechannel.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ReadSpecPosToRemaining {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(new File("D:\\test12.txt"));
        FileChannel channel = fis.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(5);
        buffer.position(2);
        channel.read(buffer, 0);
        channel.close();
        fis.close();
        buffer.rewind();
        for (int i = 0;i < buffer.limit();i++) {
            System.out.print((char) buffer.get());
        }
    }
}
