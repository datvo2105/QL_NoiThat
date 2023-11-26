/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ql_noithat;

import com.mycompany.ql_noithat.DAL.RSAManager;
import com.mycompany.ql_noithat.GUI.ConnectDB;
import com.mycompany.ql_noithat.GUI.MainFrame;

public class QL_NoiThat {

    public static void main(String[] args) {
        try {
            new ConnectDB().setVisible(true);

            RSAManager rsaManager = new RSAManager(
                    "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQC+LGaKNpzPEjnYbuDz0zf6cbFlRcGeRj9h66T6TvTNKPjyTHKBToW5n0F82jxZqygwrbsOlltF+FdjfIyUZKG9OAx/QVuHS/u6O6o9ujq5wWJ25l4oaSqJlsAPtYx3lCSMkUv7Pa2O0iB8leCvSC4BoFyQmVqmBrbxcBGfEoXSQosw1zc717/m014lPUC4uDdK3NpZfrv1zYhDWasm9U9mcQRDFJ/W9hC/h037PPdmvDEp8AMtMM4GsGU/NC+BJc/VAh/KDP9v6bGvl+LRS8qdIWk/2gWqjMRFLhv97q78ONHm6P+t4nQIayE8hkUWQOBt0YpnLY1QsC1vHkjBS/SvAgMBAAECggEAEJSKwh0d0c3wfia4n87NWsf5I++6Ku72orZqn/+B8gsoR+kTXfkMc/u8YsLHhTfaHVhgQ9bRvAl5W61QYmBdsO4cj3xmxaaBxXcN54DU6DzB4BpDS6RToZhORBsGKqd0rPlpVaJx1Hm3Jwri19VkBsnw7Wh5Z0U+7lDg2xdrKcLIdn6+27YlKcsKuM/vJDgyUmIsJUGt89d3nkbc1KoOnZZb1muQ1liF9w9Iv55/2jj0x5lXNGVq8jxNlOTJdX3sVVbUI3WxhsPxE5s11h1VWfdTfpQVxiquDWOi3C4GdLYielvosSs4KXbD6Y7PkxitT+tU89IVk48S+i18Vcn3TQKBgQD0a61BfLLCyAtPGpQquBOwMgkkPOSJ/HAn790zDUko9o0VupkHafszZIGJ2//74fqwBXNtZW2TzXKFYQX3+PPwPSn1IKSNnowlGLFH+lujNMoCXim4of4ZfMFlW/3NzvWrnKirSNjseRhzqJSlEIL+pZgn95NsQuXVQ0XEYkWquwKBgQDHLtD22o5/zrc/0RxeF41RUG+Yt2BlkH2fJvPMby12ihJb7GYnIQOpf8uJnOiU040uaQnFFQ7ki31mMAUlaVKvVd8TKg+6CwGxrVtfd8KikvThcitJKVzuznjftfNre3Kpp4HpjLb4vYaxaqHn+yglJ6Y16rK7Gr1GbN1mbDLAnQKBgQDDVTY+KsDV53caPbyBs2CQpDwoCL4ABI1BbXFStmBsazVvUxOvGCSX+s+HdBlMnFlyyLhpifCbeUn3jAVwGjYhHVBlxTOctkN79hLf2hXYBX0XjVc8ZcGjbs9ECNN54db10hn94RbzTQecjvJURDDb/0ztS+82SvRQjhW4j2zrtwKBgG3he9HSfC4xoZIJD/cwUvt6vjWnY/xjm4mC+Zfb9V6hiMNBRJFtexG0uFowP3ZqxkXGGGeq2E5oTUNkVlJvKfgkDS4LVCW0ELkuA2xFKxB4tbLxQsPXl7b+HFx9ic3Pik/hYp+uyvmpxHZ3dt39BgaJOv4ffX4OoEALqo/oPI9ZAoGASqZ9mQXX7fpP5SDou9jU8ydkcAnqUv9YuvlttXquZbKqmlM2ns6cBzMT5t5TeZNMUe77wJ/zP0gCdr1xhiUvTnLUOzC3yJRmea5Qc881Od1hDbAsnBhYGiiL7k4ATidpZPuH9NS12T8zqeKRMI5F2REdw01hoj+0vTbWaIy8s10=",
                    "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvixmijaczxI52G7g89M3+nGxZUXBnkY/Yeuk+k70zSj48kxygU6FuZ9BfNo8WasoMK27DpZbRfhXY3yMlGShvTgMf0Fbh0v7ujuqPbo6ucFiduZeKGkqiZbAD7WMd5QkjJFL+z2tjtIgfJXgr0guAaBckJlapga28XARnxKF0kKLMNc3O9e/5tNeJT1AuLg3StzaWX679c2IQ1mrJvVPZnEEQxSf1vYQv4dN+zz3ZrwxKfADLTDOBrBlPzQvgSXP1QIfygz/b+mxr5fi0UvKnSFpP9oFqozERS4b/e6u/DjR5uj/reJ0CGshPIZFFkDgbdGKZy2NULAtbx5IwUv0rwIDAQAB");
            String userName = "exampleUser";

            System.out.println("Private key is : " + rsaManager.getPrivateKey());
            System.out.println("Public key is : " + rsaManager.getPublicKey());

            String encryptedText = rsaManager.encrypt(userName);
            System.out.println("Encrypted Text: " + rsaManager.encrypt(userName));

            // Decryption with the private key
            String decryptedUserName = rsaManager.decrypt(encryptedText);
            System.out.println("Decrypted User Name: " + decryptedUserName);

        } catch (Exception e) {

        }
    }
}
