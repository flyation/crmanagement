package com.fly.crmanagement;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
class CrmanagementApplicationTests {

    public static void main(String[] args) {
        JwtBuilder builder = Jwts.builder()
                .setId("888").setSubject("小白")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "crmanagement");
        System.out.println(builder.compact());
//        JwtUtil jwtUtil = new JwtUtil();
//        String jwt = jwtUtil.createJWT("123", "username", "admin");
//        System.out.println(jwt);
    }
}
