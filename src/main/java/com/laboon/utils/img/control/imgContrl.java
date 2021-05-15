package com.laboon.utils.img.control;
import com.laboon.utils.img.dao.ImgBase64;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Base64;

public class imgContrl {

    /**
     * base64转换成图片
     *
     * @param base64Str
     */
    public void base642Img(String imgName,String base64Str) {

        final Base64.Decoder decoder = Base64.getDecoder();
        final Base64.Encoder encoder = Base64.getEncoder();
        //基本路径
        String inBasePath = "S:\\SpringWorkspace\\forum_img_path\\";
        String outBasePath = "S:\\SpringWorkspace\\forum_img_path\\";

        System.out.println("获得base64码，开始转换成图片");
        try {
            //解码
            byte[] data = decoder.decode(base64Str);
            //调整异常数据
            for (int i = 0; i < data.length; ++i) {
                if (data[i] < 0) {
                    data[i] += 256;
                }
            }
            String outPath = outBasePath + imgName + ".jpg";
            OutputStream out = new FileOutputStream(outPath);
            out.write(data);
            out.flush();
            out.close();
            System.out.println("转换成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
