package chapter1.buffer.test;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public class AsCharBufferTest {

    public static void main(String[] args) throws UnsupportedEncodingException {
        byte[] array = "我是中国人".getBytes("UTF-16BE");
        System.out.println(Charset.defaultCharset().name());
        ByteBuffer buffer = ByteBuffer.wrap(array);
        System.out.println(buffer.getClass().getName());
        CharBuffer charBuffer = buffer.asCharBuffer();
        System.out.println(charBuffer.getClass().getName());

        System.out.println("ByteBuffer position" + buffer.position()
               + ", capacity=" + buffer.capacity() + ", limit=" + buffer.limit());
        System.out.println("CharBuffer position" + charBuffer.position()
        + ", capacity=" + charBuffer.capacity() + ", limit=" + charBuffer.limit());

        charBuffer.position(0);
        for (int i = 0; i < charBuffer.capacity(); i++) {
            System.out.print(charBuffer.get() + " ");
        }
    }

}
