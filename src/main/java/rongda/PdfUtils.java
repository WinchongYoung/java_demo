package rongda;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PdfUtils {

    /**
     * 合并PDF文件
     *
     * @param sourceFilePaths 需要合并的PDF文件路径列表
     * @param destFilePath    合并后的新文件
     */
    public static void mergePdfFile(List<String> sourceFilePaths, String destFilePath) {
        if (sourceFilePaths == null || sourceFilePaths.isEmpty() || destFilePath == null) {
            return;
        }

        Document document = null;
        PdfCopy copy = null;
        OutputStream os = null;
        try {
            // 创建合并后的新文件的目录
            Path dirPath = Paths.get(destFilePath.substring(0, destFilePath.lastIndexOf(File.separator)));
            Files.createDirectories(dirPath);

            os = new BufferedOutputStream(new FileOutputStream(new File(destFilePath)));
            document = new Document(new PdfReader(sourceFilePaths.get(0)).getPageSize(1));
            copy = new PdfCopy(document, os);
            document.open();
            for (String sourceFilePath : sourceFilePaths) {
                // 如果PDF文件不存在，则跳过
                if (!new File(sourceFilePath).exists()) {
                    continue;
                }

                // 读取需要合并的PDF文件
                PdfReader reader = new PdfReader(sourceFilePath);
                // 获取PDF文件总页数
                int n = reader.getNumberOfPages();
                for (int j = 1; j <= n; j++) {
                    document.newPage();
                    PdfImportedPage page = copy.getImportedPage(reader, j);
                    copy.addPage(page);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (copy != null) {
                try {
                    copy.close();
                } catch (Exception ex) {
                    /* ignore */
                }
            }
            if (document != null) {
                try {
                    document.close();
                } catch (Exception ex) {
                    /* ignore */
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (Exception ex) {
                    /* ignore */
                }
            }
        }
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>(){{
            add("C:\\Users\\Yang\\Desktop\\sample.pdf");
            add("C:\\Users\\Yang\\Desktop\\sample2.pdf");
        }};
        mergePdfFile(list, "C:\\Users\\Yang\\Desktop\\merge.pdf");

    }
}