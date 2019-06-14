package chapter2.filelock;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileLockTest {

    public static void main(String[] args) throws IOException {
        File file = new File("D:\\test15.txt");
        RandomAccessFile fileA = new RandomAccessFile(file, "rw");
        FileChannel channelA = fileA.getChannel();
        System.out.println("FileChannel:" + channelA.hashCode());
        FileLock lock = channelA.lock(1, 10, true);
        System.out.println("A position=" + lock.position() + ", size=" + lock.size()
               + ", isValid=" + lock.isValid() + ", isShared=" + lock.isShared()
               + ", channel().hashCode()=" + lock.channel().hashCode()
               + " acquiredBy().hashCode()=" + lock.acquiredBy().hashCode());
        lock.release();
        lock = channelA.lock(1, 10, false);
        System.out.println("B position=" + lock.position() + ", size=" + lock.size()
               + ", isValid=" + lock.isValid() + ", isShared=" + lock.isShared()
               + ", channel().hashCode()=" + lock.channel().hashCode()
               + ", acquiredBy().hashCode()=" + lock.acquiredBy().hashCode());
        lock.close();
        channelA.close();
        System.out.println("C position=" + lock.position() + ", size=" + lock.size()
        + ", isValid=" + lock.isValid() + ", isShared=" + lock.isShared()
        + ", channel().hashCode()=" + lock.channel().hashCode()
        + ", acquiredBy().hashCode()=" + lock.acquiredBy().hashCode());
    }

}
