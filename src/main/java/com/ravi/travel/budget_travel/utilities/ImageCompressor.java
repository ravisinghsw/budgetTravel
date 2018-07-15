package com.ravi.travel.budget_travel.utilities;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Iterator;

public class ImageCompressor {


    public static void main(String[] args) throws Exception {
        File input = new File("D:\\project\\drifters-diary\\src\\assets\\images\\carousel\\adult-book-business.jpg");
        BufferedImage image = ImageIO.read(input);

        File compressedImageFile = new File("D:\\project\\drifters-diary\\src\\assets\\images\\carousel\\adult-book-business.jpg");
        OutputStream os =new FileOutputStream(compressedImageFile);

        Iterator<ImageWriter> writers =  ImageIO.getImageWritersByFormatName("jpg");
        ImageWriter writer = (ImageWriter) writers.next();

        ImageOutputStream ios = ImageIO.createImageOutputStream(os);
        writer.setOutput(ios);

        ImageWriteParam param = writer.getDefaultWriteParam();

        param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        param.setCompressionQuality(0.15f);
        writer.write(null, new IIOImage(image, null, null), param);

        os.close();
        ios.close();
        writer.dispose();
    }
}
