package org.example.test;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestReadDoc {
    public static void main(String[] args) throws Exception {
        Path path = Paths.get("/Users/yuhaisheng/Documents/工作/SmartKE_Workspace/file/国际视野：在线学习与翻转课堂.docx");
        File file = new File("/Users/yuhaisheng/Documents/工作/SmartKE_Workspace/file/国际视野：在线学习与翻转课堂.docx");

        // Test POI Read Word File
//        poiReadDoc(file);

        // Java Read Word File
        // TODO 乱码
        javaInputStream(path);

    }

    /**
     * POI导入
     * <dependency>
     *     <groupId>org.apache.poi</groupId>
     *     <artifactId>poi</artifactId>
     *     <version>3.17</version>
     * </dependency>
     * <dependency>
     *     <groupId>org.apache.poi</groupId>
     *     <artifactId>poi-ooxml</artifactId>
     *     <version>3.17</version>
     * </dependency>
     * @param file
     */
    private static void poiReadDoc(File file) throws IOException {
        InputStream is = new FileInputStream(file);
        XWPFDocument doc = new XWPFDocument(is);
        XWPFWordExtractor extractor = new XWPFWordExtractor(doc);
        String text = extractor.getText();
        System.out.println(text);
    }

    private static void javaInputStream(Path path) throws Exception {

        InputStream inputStream = Files.newInputStream(path);
        String fileCode = getFileCodeByInputStream(inputStream);
        System.out.println(fileCode);
        InputStreamReader reader = new InputStreamReader(new FileInputStream(path.toFile()), fileCode);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String lineTxt = null;
        while ((lineTxt = bufferedReader.readLine()) != null) {
            System.out.println(lineTxt);
        }
    }

    /**
     * <p>Description: 根据文件流获取文件编码 </p>
     *
     * @param inputStream 文件流
     * @return
     */
    public static String getFileCodeByInputStream(InputStream inputStream) throws Exception {
        int p = (inputStream.read() << 8) + inputStream.read();
        inputStream.close();
        String code = null;
        switch (p) {
            case 0xefbb:
                code = "UTF-8";
                break;
            case 0xfffe:
                code = "Unicode";
                break;
            case 0xfeff:
                code = "UTF-16BE";
                break;
            default:
                code = "GBK";
        }
        return code;
    }
}
