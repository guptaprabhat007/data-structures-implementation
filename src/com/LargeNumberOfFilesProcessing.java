package com;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class LargeNumberOfFilesProcessing {

    /**
     * https://www.amitph.com/java-read-write-large-files-efficiently/
     */
    private void copyUsingChannel() throws IOException {

        try {
            String source = "C://folder/read.txt";
            String target = "C://folder/write.txt";
            FileChannel inputChannel = new FileInputStream(source).getChannel();
            FileChannel outputChannel = new FileOutputStream(target).getChannel();

            ByteBuffer buffer = ByteBuffer.allocateDirect(4 * 1024);
            while (inputChannel.read(buffer) != -1) {
                buffer.flip();
                outputChannel.write(buffer);
                buffer.clear();
            }
        } catch (Exception e) {

        }
    }
}
