package org.example;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.crypto.digest.MD5;

import java.security.PrivateKey;

import static cn.hutool.crypto.Padding.PKCS1Padding;

/**
 * @author wangjl
 * @date 2023/12/26
 */
public class SafeKeyCreate {
    public static void createSafeKey() {
        String value1 = "LS0tLS1CRUdJTiBSU0EgUFVCTElDIEtFWS0tLS0tCk1FZ0NRUUN5UllTYzVCTnNuZDUybVhmN2JoN01GTFpqK1lRRGhYQ3NXa0R4TUgxTzZVMVVSYUxVcHRucllMUjAKamdva0IyNzhGc2c1Vi8vVS81MW5ZeFhuWjc1ZEFnTUJBQUU9Ci0tLS0tRU5EIFJTQSBQVUJMSUMgS0VZLS0tLS0=";
        String value2 = "RA4dNEyq";
        String safeKeyHope = "lDu0ZG3BxhFxJ767vQq2W1M4RKRNexCbcFZpMKIi/HiOModw3AcxhgClS7pYSqiWd7fwFK0n57WlA03qkUwCv2I0800VrAO4rqryvVXuqI6AN1HAg8LyI9rBSwD7HQOODqhfBZ6XjDvlwOg80fCoDxHuIXPv6UBRwCGAsXF6C1c=";

        // 将 res1.value1 进行 Base64 解码
        byte[] keyBytes = Base64.decode(value1);
        System.out.println("keyBytes is: "+ keyBytes.toString());
        RSA rsa = new RSA(keyBytes.toString(), null);

// 获取密码和 res1.value2
        String password = "123456Aa";

// 将密码和 value2 拼接，并使用 RSA 加密
        String dataToEncrypt = password + ":" + value2;
        byte[] encryptedBytes = rsa.encrypt(dataToEncrypt.getBytes(), KeyType.PublicKey);

// 将加密结果进行 Base64 编码
        String encryptedResult = Base64.encode(encryptedBytes);
        System.out.println(encryptedResult);
    }

    public static void md5() {
        String sessionId = "8ae6c4d0-91bd-11ee-b1fa-dbb97f0e8935";
        String loginToken = "3865746dba59804455ec90bd72246287";

        String s = DigestUtil.md5Hex(Base64.encode(sessionId + loginToken));
        System.out.println(s);
    }

    public static void main(String[] args) {
//        createSafeKey();
        md5();

    }
}
