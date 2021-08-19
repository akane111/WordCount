import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Base64;
import java.util.Date;

public class test1 {
    @Test
    public void test2(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String gaoge = bCryptPasswordEncoder.encode("gaoge");
        System.out.println(gaoge);
        boolean gaoge1 = bCryptPasswordEncoder.matches("gaoge", gaoge);
        System.out.println(gaoge1);
    }
    @Test
    public void test3(){
        byte[] b = Base64.getDecoder().decode("eyJhbGciOiJIUzUxMiJ9");

        String s = new String(b);
        System.out.println(s);
    }
    @Test
    public void test4(){
        Date date = new Date();
        System.out.println(date);
    }
}
