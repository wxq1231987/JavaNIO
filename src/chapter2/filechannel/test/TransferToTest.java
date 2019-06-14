package chapter2.filechannel.test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class TransferToTest {

    public static void main(String[] args) throws IOException {
        /**
         * 验证当truncate的第一个参数大于文件的大小，不传输数据
         */
        /*RandomAccessFile src = new RandomAccessFile("D:\\test13.txt", "rw");
        RandomAccessFile dst = new RandomAccessFile("D:\\test14.txt", "rw");

        FileChannel channel1 = src.getChannel();
        FileChannel channel2 = dst.getChannel();

        channel2.position(8);
        channel1.transferTo(1000, 100, channel2);
        channel1.close();
        channel2.close();

        src.close();
        dst.close();*/
        /**
         * 验证正常传输数据
         */
        /*RandomAccessFile fileA = new RandomAccessFile("D:\\test15.txt", "rw");
        RandomAccessFile fileB = new RandomAccessFile("D:\\test16.txt", "rw");

        FileChannel channelA = fileA.getChannel();
        FileChannel channelB = fileB.getChannel();

        channelB.position(9);
        channelA.transferTo(0, 5, channelB);

        channelA.close();
        channelB.close();
        fileA.close();
        fileB.close();*/
        /**
         * 验证count大于size-position,此方法不改变通道的位置，只改变方法参数中通道的位置
         */
        RandomAccessFile fileC = new RandomAccessFile("D:\\test17.txt", "rw");
        RandomAccessFile fileD = new RandomAccessFile("D:\\test18.txt", "rw");

        FileChannel channelC = fileC.getChannel();
        FileChannel channelD = fileD.getChannel();

        channelC.transferTo(2, 8, channelD);
        System.out.println("C position=" + channelC.position() + ", D position=" + channelD.position());

        channelC.close();
        channelD.close();
        fileC.close();
        fileD.close();
    }

}
