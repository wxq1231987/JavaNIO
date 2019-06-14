package chapter2.filechannel.open.test;

import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class OpenByCreateAndWrite {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\test21.txt");
        Path path = file.toPath();
        FileChannel channel = FileChannel.open(path, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        channel.close();
    }
}
