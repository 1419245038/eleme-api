package com.example.elemeapi.controller;

import com.example.elemeapi.service.CosCredentialService;
import com.example.elemeapi.utils.COSUtils;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.model.COSObjectInputStream;
import com.tencent.cloud.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/cos")
public class CosController {

    @Autowired
    private CosCredentialService cosCredentialService;

    @GetMapping(value = "/download")
    public void download(@RequestParam("key") String key, HttpServletResponse response) throws IOException {
        //输出流，通过输出流将文件写回浏览器
        ServletOutputStream outputStream = response.getOutputStream();
        Response credential = cosCredentialService.getCredential();
        COSClient cosClient = COSUtils.createCOSClient(credential);
        COSObjectInputStream cosObjectInputStream = COSUtils.getCOSObjectInputStream(cosClient, key);
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = cosObjectInputStream.read(bytes)) != -1){
            outputStream.write(bytes,0,len);
            outputStream.flush();
        }
        //关闭资源
        outputStream.close();
        cosObjectInputStream.close();
        cosClient.shutdown();
    }
}
