package shaomai.service.impl;

import shaomai.service.UploadService;
import shaomai.utils.TextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Service
public class UploadServiceImpl implements UploadService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 上传文件
     * @param file
     * @param title
     * @param author
     * @throws IOException
     */
    @Override
    public void uploadFile(MultipartFile file, String title, String author) throws IOException {
        String mdFilePath = saveFile(file);
        if (TextUtil.isEmpty(mdFilePath)) {
            // null或 ""
            throw new IOException("文件上传失败");
        } else {
            String head = parseFile(mdFilePath);
            int index = mdFilePath.indexOf("public");
            String relativePath = mdFilePath.substring(index + 6, mdFilePath.length());
            logger.info("解析后的内容: " + head);
            logger.info("相对路径：" + relativePath);
            // 存入数据库

            saveArtInfo(title, author, head, relativePath, System.currentTimeMillis());
        }
    }

    /**
     * 保存文件到 public 文件夹下
     * @param file
     * @return
     * @throws IOException
     */
    @Override
    public String saveFile(MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            File dir = new File(getClass().getResource("/").getPath() + "/public/arts");
            if (!dir.exists()) {
                logger.info("文件目录不存在，创建一个新的文件目录");
                dir.mkdirs();
            } else {
                logger.info("文件目录已经存在");
            }
            logger.info("public目录是：" + dir.getAbsolutePath());
            File outFile = new File(dir, file.getOriginalFilename());
            try {
                if (!outFile.exists()) {
                    outFile.createNewFile();
                }
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outFile));
                bos.write(file.getBytes());
                bos.flush();
                bos.close();

                return outFile.getAbsolutePath();

                // 文件上传成功
            } catch (IOException e) {
                e.printStackTrace();
                throw new IOException("文件上传失败");
            }
        } else {
            return null;
        }
    }

    /**
     * 解析 markdown 文件前面部分文字，去掉例如 #、*、 ``` 等 md 中的字符
     * @param filePath
     * @return
     * @throws IOException
     */
    @Override
    public String parseFile(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new IOException("文件上传失败");
        } else {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            byte[] head = new byte[2 * 200];
            int len = bis.read(head);
            if (len == 1) {
                return null;
            } else {
                return new String(head);
            }
        }

    }

    /**
     * 存储文章基本信息
     * @param title 标题
     * @param author 作者
     * @param head 文章概要内容
     * @param relativePath md 文件的相对路径
     * @param timestamp 时间戳
     */
    @Override
    public void saveArtInfo(String title, String author, String head, String relativePath, long timestamp) {

    }
}
