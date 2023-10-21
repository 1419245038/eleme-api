package com.example.elemeapi.service;

import com.tencent.cloud.Response;

import java.io.IOException;

/**
 * 获取腾讯云COS临时秘钥
 */
public interface CosCredentialService {

    Response getCredential() throws IOException;
}
