package chapter2.filechannel.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class ReadSpecPosReadLength {
    /**
     * 
     * @param args
     */
    private static FileInputStream fis;
    private static FileChannel channel;
    public static void main(String[] args) throws FileNotFoundException {
        fis = new FileInputStream(new File("D:\\test12.txt"));
        channel = fis.getChannel();

    }

}
