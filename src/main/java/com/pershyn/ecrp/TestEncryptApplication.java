package com.pershyn.ecrp;

import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestEncryptApplication implements CommandLineRunner {

    @Value("${app.password}")
    private String string;
    private String str = "SomeSecretCombination";

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


    }
}
