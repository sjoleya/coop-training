package Worksheet.Q4_Thread_Pool_Image_Processor;

import java.util.concurrent.Callable;

public class ImageProcessor implements Callable<String> {
    private final int imageId;

    public ImageProcessor(int imageId) {
        this.imageId = imageId;
    }

    @Override
    public String call() throws InterruptedException {
        Thread.sleep(100); // Simulate processing time
        return "Image " + imageId + " processed by Thread: " + Thread.currentThread().getName();
    }
}
