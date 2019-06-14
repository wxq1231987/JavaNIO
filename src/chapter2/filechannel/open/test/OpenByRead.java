package chapter2.filechannel.open.test;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class OpenByRead {

    public static void main(String[] args) throws IOException {
        File file = new File("D:\\test21.txt");
        Path path = file.toPath();
        FileChannel channel = FileChannel.open(path, StandardOpenOption.READ);
        byte[] array = new byte[(int) file.length()];
        ByteBuffer buffer = ByteBuffer.wrap(array);
        channel.read(buffer);
        channel.close();
        array = buffer.array();
        for (int i = 0;i < array.length;i++) {
            System.out.print((char) array[i]);
        }
    }

}
