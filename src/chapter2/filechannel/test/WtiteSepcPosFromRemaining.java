package chapter2.filechannel.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class WtiteSepcPosFromRemaining {

    /**
     * 验证write(ByteBuffer, long)是将ByteBuffer中remaing写入通道
     * @param args
     */
    private static FileOutputStream fos;
    private static FileChannel channel;
    public static void main(String[] args) throws IOException {
        fos = new FileOutputStream(new File("D:\\test13.txt"));
        channel = fos.getChannel();
        ByteBuffer buffer = ByteBuffer.wrap("abcdef".getBytes());
        buffer.position(2);
        buffer.limit(5);
        channel.write(buffer, 0);
        channel.close();
        fos.close();
    }

}
