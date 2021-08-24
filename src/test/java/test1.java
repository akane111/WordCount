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
        String token="eyJhbGciOiJIUzUxMiJ9.eyJuaWNrbmFtZSI6Imdhb2dlZ2UiLCJzdWIiOiJnYW9nZSIsImF2YXRhciI6ImZhZTc1NWU0MmJiODQwNmE5MDdhODlhNTUxNjNkN2U4LmpwZyIsInJvbGUiOlt7ImF1dGhvcml0eSI6InVzZXIifSx7ImF1dGhvcml0eSI6ImV4cGVydCJ9LHsiYXV0aG9yaXR5IjoiYWRtaW4ifV0sImV4cCI6MTYyOTcyNDUzMiwiaWF0IjoxNjI5Njg4NTMyNDAyfQ.iHLBCHKSWBHfClLiENlhMhZzAJgaVaeKCQUBJv4NW3jERbJ01pqEr_CuD66c49WHJGxkxXcs4LoWr9EpGJrtEg";
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
