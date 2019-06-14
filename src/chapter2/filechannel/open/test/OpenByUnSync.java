package chapter2.filechannel.open.test;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class OpenByUnSync {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\test25.txt");
        Path path = file.toPath();
        FileChannel channel = FileChannel.open(path, StandardOpenOption.CREATE_NEW,
                StandardOpenOption.WRITE);
        long beginTime = System.currentTimeMillis();
        for (int i = 0;i < 200;i++) {
            channel.write(ByteBuffer.wrap("abc".getBytes()));
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - beginTime);
        channel.close();
    }
}
