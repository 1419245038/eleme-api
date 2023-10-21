package com.example.elemeapi.service.impl;

import com.example.elemeapi.service.CosCredentialService;
import com.tencent.cloud.CosStsClient;
import com.tencent.cloud.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.TreeMap;

/**
 * 获取腾讯云COS临时访问秘钥
 */
@Service
public class CosCredentialServiceImpl implements CosCredentialService {

    @Value("${myqcloud.cos.tmpSecretId}")
    private String secretId;

    @Value("${myqcloud.cos.tmpSecretKey}")
    private String secretKey;

    @Value("${myqcloud.cos.durationSeconds}")
    private Integer durationSeconds;

    @Value("${myqcloud.cos.region}")
    private String region;

    @Value("${myqcloud.cos.bucket}")
    private String bucket;


    @Override
    public Response getCredential() throws IOException {
        TreeMap<String, Object> config = new TreeMap<>();
        config.put("secretId", secretId);
        config.put("secretKey", secretKey);
        config.put("durationSeconds", durationSeconds);
        config.put("bucket", bucket);
        config.put("region", region);
        config.put("allowPrefixes", new String[] {"*"});
        config.put("allowActions", new String[] {"name/cos:GetObject"});
        return CosStsClient.getCredential(config);
    }
}
