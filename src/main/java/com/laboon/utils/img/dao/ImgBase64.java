package com.laboon.utils.img.dao;

import lombok.Data;

import javax.persistence.Id;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Base64;

@Data
public class ImgBase64 {


    private String imgid;

    private String imgsrc;

}
