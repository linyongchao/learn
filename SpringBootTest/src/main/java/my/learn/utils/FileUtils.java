package my.learn.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Base64;

public class FileUtils {

    /**
     * 文件转base64
     *
     * @param path
     * @return
     * @author lin
     * @date 2019/10/13 14:14
     **/
    public static String toBase64(String path) throws Exception {
        File file = new File(path);
        if (!file.exists()) {
            return null;
        }
        InputStream inputStream = new FileInputStream(file);
        byte[] data = new byte[inputStream.available()];
        inputStream.read(data);
        inputStream.close();
        return Base64.getEncoder().encodeToString(data);
    }
}
