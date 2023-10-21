package com.example.elemeapi.service.impl;

import com.example.elemeapi.service.CosCredentialService;
import com.tencent.cloud.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CosCredentialServiceImplTest {

    @Autowired
    private CosCredentialService cosCredentialService;

    @Test
    public void getCredential() throws IOException {
        Response credential = cosCredentialService.getCredential();
        System.out.println(credential.credentials.tmpSecretId);
        System.out.println(credential.credentials.tmpSecretKey);
        System.out.println(credential.credentials.sessionToken);
    }
}