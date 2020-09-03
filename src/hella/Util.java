package hella;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Util {
    public static String picDir = "src/pic/";
    public static void makeDir(String dir) {
        File f = new File(dir);
        if (!f.exists()) {
            f.mkdirs();
        }
    }
    public static void downloadPic(String src, String fileName, String dir) {
        URL url = null;
        try {
            url = new URL(src);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        URLConnection uri = null;
        try {
            uri = url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStream is = null;
        try {
            is = uri.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (is != null) {
            OutputStream os = null;
            try {
                os = new FileOutputStream(new File(dir, fileName));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            byte[] buf = new byte[1024];
            int l = 0;
            try {
                while ((l = is.read(buf)) != -1) {
                    os.write(buf, 0, l);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (os != null) {
                    try {
                        os.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}