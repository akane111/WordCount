import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class test1 {
    @Test
    public void test2() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String gaoge = bCryptPasswordEncoder.encode("gaoge");
        System.out.println(gaoge);
        boolean gaoge1 = bCryptPasswordEncoder.matches("gaoge", gaoge);
        System.out.println(gaoge1);
    }

    @Test
    public void test3() {
        byte[] b = Base64.getDecoder().decode("eyJhbGciOiJIUzUxMiJ9");

        String s = new String(b);
        System.out.println(s);
    }

    @Test
    public void test4() {
        Date date = new Date();
        System.out.println(date);
    }

    @Test
    public void test5() {
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJuaWNrbmFtZSI6IumrmOatjDIyNzc3Nzc3Iiwic3ViIjoiZ2FvZ2UiLCJhdmF0YXIiOiJmMzgwMTJhMTEwMGI0ZjIxYWU2MzEyMzgxOGU2MDY4ZC5qcGciLCJyb2xlIjpbeyJhdXRob3JpdHkiOiJ1c2VyIn0seyJhdXRob3JpdHkiOiJleHBlcnQifSx7ImF1dGhvcml0eSI6ImFkbWluIn1dLCJleHAiOjE2Mjk5Nzg0NjMsImlhdCI6MTYyOTk0MjQ2Mzc5MX0.Pl57ol1tWt6JqrcyMONE0GHg_uqY67pa8ON8Wly1IXZxkKcjJU0Hcl0QUIMRA0Z5swlQxapgQUJWbmKis4ktxg";
        Claims gaoge = Jwts.parser().setSigningKey("gaoge").parseClaimsJws(token).getBody();
        System.out.println(gaoge);
    }

    @Test
    public void test6() {
        Properties properties = new Properties();
        properties.setProperty("gaoge", "gaoge");
        Object gaoge = properties.get("gaoge");
        System.out.println(gaoge);
    }

    @Test
    public void test7() {
        String gaoge = "gaoge";
        String gaoge1 = "gaoge1";
        String gaoge2 = "gaogeg";
        String gaoge3 = "高歌";
        int length1 = gaoge.length();
        System.out.println(length1);

        int length2 = gaoge1.length();
        System.out.println(length2);

        int length3 = gaoge2.length();
        System.out.println(length3);
        int length4 = gaoge3.length();
        System.out.println(length4);
    }

    @Test
    public void test8() {
        String str = "1234567";
        String regex = "\\d+";
        System.out.println(str.matches(regex));
        String str1 = "1234567abc";
        String regex1 = "\\w{8,9}";

        System.out.println(str1.matches(regex1));
    }
    @Test
    public void test9(){
        double d1=0.03D;
        double d2=0.02D;
       double d3=d2- d1;
        BigDecimal bigDecimal = new BigDecimal("0.03");
        BigDecimal bigDecimal1 = new BigDecimal("0.02");
        BigDecimal add = bigDecimal.add(bigDecimal1);
        System.out.println(d3);
        System.out.println(add);
    }
    @Test
    public void test10() throws NoSuchAlgorithmException {
        try {
            byte[] md5s = MessageDigest.getInstance("md5").digest("gaoge".getBytes("utf-8"));
            String s = new String(md5s);
            System.out.println(s);
        }catch (Exception e){
            e.getMessage();
        }
    }
    @Test
    public void test11()  {
        ArrayList<Integer> integers = new ArrayList<>();
        Integer[] gaoge = new Integer[]{};
        integers.add(1);
        integers.add(2);
        integers.add(3);
        for (Integer integer:integers){
            System.out.println(integer);
        }
        Iterator<Integer> iterator = integers.iterator();
        if (iterator.hasNext()){
            Integer next = iterator.next();
            iterator.remove();
        }
        while (iterator.hasNext()){
            System.out.println( iterator.next());
//            iterator.remove();
        }


        Integer[] integers1 = integers.toArray(gaoge);
        List<Integer> list1 = Arrays.asList(integers1);
//        list1.add(9);
        for (Integer integer:list1){
            System.out.println(list1);
        }
        for (Integer integer:integers1){
            System.out.println(integer);
        }
        List<Integer> list = integers.subList(0, 3);
        for (Integer integer:list){
            System.out.println(list);
        }

    }

}

