package com.example.elemeapi.utils;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicSessionCredentials;
import com.qcloud.cos.model.COSObject;
import com.qcloud.cos.model.COSObjectInputStream;
import com.qcloud.cos.model.GetObjectRequest;
import com.qcloud.cos.region.Region;
import com.tencent.cloud.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;


/**
 * 腾讯云COS对象存储工具类
 */
@Component
public class COSUtils {


    private static String region;


    private static String bucket;

    @Value("${myqcloud.cos.region}")
    public void setRegion(String region) {
        COSUtils.region = region;
    }

    @Value("${myqcloud.cos.bucket}")
    public void setBucket(String bucket) {
        COSUtils.bucket = bucket;
    }

    public static COSClient createCOSClient(Response response) throws IOException {
        // 1 传入获取到的临时密钥 (tmpSecretId, tmpSecretKey, sessionToken)
        String tmpSecretId = response.credentials.tmpSecretId;
        String tmpSecretKey = response.credentials.tmpSecretKey;
        String sessionToken = response.credentials.sessionToken;
        BasicSessionCredentials cred = new BasicSessionCredentials(tmpSecretId, tmpSecretKey, sessionToken);
        // 2 设置 bucket 的地域
        Region bucketRegion = new Region(region);
        ClientConfig clientConfig = new ClientConfig(bucketRegion);
        // 3 生成 cos 客户端
        return new COSClient(cred, clientConfig);
    }

    public static COSObjectInputStream getCOSObjectInputStream(COSClient cosClient,String key) throws IOException {
        COSObjectInputStream cosObjectInput;
        GetObjectRequest getObjectRequest = new GetObjectRequest(bucket, key);
        COSObject cosObject = cosClient.getObject(getObjectRequest);
        cosObjectInput = cosObject.getObjectContent();
        return cosObjectInput;
    }

}
