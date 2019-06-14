package chapter1.buffer.test;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class AsCharBufferTest2 {

    public static void main(String[] args) throws UnsupportedEncodingException {
        byte[] array = "我是中国人".getBytes("utf-16BE");
        ByteBuffer byteBuffer = ByteBuffer.wrap(array);
        CharBuffer charBuffer = byteBuffer.asCharBuffer();
        byteBuffer.put(2, "为".getBytes("utf-16BE")[0]);
        byteBuffer.put(3, "为".getBytes("utf-16BE")[1]);
        charBuffer.clear();
        for (int i = 0; i < charBuffer.limit(); i++) {
            System.out.print(charBuffer.get() + " ");
        }
    }

}
