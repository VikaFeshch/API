package image;

import org.junit.Test;

import java.io.*;
import java.net.URL;

public class ImageDownload {

    public static void domnloadIm(String imUrl, String name) throws IOException {
        URL url = new URL(imUrl);
        InputStream in = new BufferedInputStream(url.openStream());
        OutputStream out = new BufferedOutputStream(new FileOutputStream("src/main/java/image/images/"+name+".jpg"));
        for (int i; (i=in.read())!=-1;){
            out.write(i);
        }
        in.close();;
        out.close();
    }
}
