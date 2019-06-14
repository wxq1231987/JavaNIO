package chapter2.filechannel.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Truncate {

    public static void main(String[] args) throws IOException {
        /*
         * 验证正常截取文件
         */
        ByteBuffer buffer = ByteBuffer.wrap("123456".getBytes());
        FileOutputStream fos = new FileOutputStream(new File("D:\\test14.txt"));
        FileChannel channel = fos.getChannel();
        channel.write(buffer);
        System.out.println("A position=" + channel.position() + ", size="
                + channel.size());
        channel.truncate(3);
        System.out.println("B position=" + channel.position() + ", size="
                + channel.size());
        channel.position(4);
        System.out.println("C position=" + channel.position() + ", size="
               + channel.size());
        buffer.rewind();
        channel.write(buffer, 2);
        System.out.println("D position=" + channel.position() + ", size="
                + channel.size());
        /* channel.position(6);
        channel.truncate(5);
        System.out.println("C position=" + channel.position() + ", size="
                + channel.size());*/
        channel.close();
        fos.close();
    }

}
