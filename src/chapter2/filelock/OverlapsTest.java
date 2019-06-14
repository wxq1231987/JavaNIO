package chapter2.filelock;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class OverlapsTest {

    public static void main(String[] args) throws IOException {
        File file = new File("D:\\test15.txt");
        RandomAccessFile fileA = new RandomAccessFile(file, "rw");
        FileChannel channelA = fileA.getChannel();
        FileLock lock = channelA.lock(1, 10, true);
        System.out.println(lock.overlaps(1, 3));
        System.out.println(lock.overlaps(11, 15));
        channelA.close();
    }

}
