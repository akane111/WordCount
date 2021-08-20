import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Base64;
import java.util.Date;
import java.util.Properties;

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
    @Test
    public void test5(){
        String token="eyJhbGciOiJIUzUxMiJ9.eyJuaWNrbmFtZSI6Imdhb2dlIiwic3ViIjoiZ2FvZ2UiLCJleHAiOjE2MjkzNTk1NTIsImlhdCI6MTYyOTM1NTk1MjgzMH0.EEe2d9D5s-HYa6Q_EVii1-1QJtGwOlAHUp1u6mPpGaJ2Ylug3ADRwjnTZVh3wtrZrFc4QEBEfeIXC6LYA1hSTA";
        Claims gaoge = Jwts.parser().setSigningKey("gaoge").parseClaimsJws(token).getBody();
        System.out.println(gaoge);
    }
    @Test
    public void test6(){
        Properties properties = new Properties();
        properties.setProperty("gaoge","gaoge");
        Object gaoge = properties.get("gaoge");
        System.out.println(gaoge);

    }
}
