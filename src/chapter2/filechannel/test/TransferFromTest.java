package chapter2.filechannel.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class TransferFromTest {

    public static void main(String[] args) throws IOException {
        /**
         * 验证transferFrom(Channel, count, position)Count大于该文件的大小，则不传输数据
         */
       /* RandomAccessFile fileA = new RandomAccessFile("D:\\test15.txt", "rw");
        RandomAccessFile fileB = new RandomAccessFile("D:\\test16.txt", "rw");

        FileChannel channelA = fileA.getChannel();
        FileChannel channelB = fileB.getChannel();

        long readLength = channelA.transferFrom(channelB, 100, 2);

        channelA.close();
        channelB.close();
        fileA.close();
        fileB.close();*/
        /**
         * 验证正常传输数据transferFrom(Channel, position, count)
         */
        /*RandomAccessFile fileC = new RandomAccessFile("D:\\test15.txt", "rw");
        RandomAccessFile fileD = new RandomAccessFile("D:\\test16.txt", "rw");

        FileChannel channelC = fileC.getChannel();
        FileChannel channelD = fileD.getChannel();

        channelD.position(2);
        channelC.transferFrom(channelD, 0, 2);

        channelC.close();
        channelD.close();
        fileC.close();
        fileD.close();*/
        /**
         * 验证count大于remaining
         */
        /*RandomAccessFile fileE = new RandomAccessFile("D:\\test15.txt", "rw");
        RandomAccessFile fileF = new RandomAccessFile("D:\\test16.txt", "rw");

        FileChannel channelE = fileE.getChannel();
        FileChannel channelF = fileF.getChannel();

        channelF.position(2);
        long readLength = channelE.transferFrom(channelF, 1, 10);
        channelE.close();
        channelF.close();
        fileE.close();
        fileF.close();*/
    }

}
