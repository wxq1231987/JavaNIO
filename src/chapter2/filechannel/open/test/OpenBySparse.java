package chapter2.filechannel.open.test;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class OpenBySparse {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\test24.txt");
        Path path = file.toPath();
        FileChannel channel = FileChannel.open(path, //StandardOpenOption.SPARSE,
                StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE);
        channel.position(Integer.MAX_VALUE);
        channel.write(ByteBuffer.wrap("a".getBytes()));
        channel.close();
    }
}
