package com.pershyn.ecrp;

import com.pershyn.ecrp.model.AES;
import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestEncryptApplication implements CommandLineRunner {

    @Value("${app.password}")
    private String string;

    @Value("${app.password2}")
    private String string2;


    private String str = "SomeSecretCombination";

//    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    BasicTextEncryptor textEncryptor = new BasicTextEncryptor();



    public static void main(String[] args) {
        SpringApplication.run(TestEncryptApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println(string);

        textEncryptor.setPassword(str);

        String str3 = textEncryptor.decrypt(string);

        System.out.println("\ndecrypted password: "+str3);



        System.out.println("Example 2:");

        String encryptedString = AES.encrypt(string2, "secretKey") ;
        String decryptedString = AES.decrypt(encryptedString, "secretKey") ;

        System.out.println(string2);
        System.out.println(encryptedString);
        System.out.println(decryptedString);




    }
}
