import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class test1 {
    @Test
    public void test2(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String gaoge = bCryptPasswordEncoder.encode("gaoge");
        System.out.println(gaoge);
        boolean gaoge1 = bCryptPasswordEncoder.matches("gaoge", gaoge);
        System.out.println(gaoge1);

    }
}
