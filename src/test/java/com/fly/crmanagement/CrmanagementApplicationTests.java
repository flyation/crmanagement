package com.fly.crmanagement;

import com.fly.crmanagement.dao.ClassroomMapper;
import com.fly.crmanagement.entity.Classroom;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class CrmanagementApplicationTests {

    @Resource
    private ClassroomMapper classroomMapper;

    @Test
    void contextLoads() {
        StringBuilder firstName = new StringBuilder("明德楼".substring(0,1));
        String s = new String(firstName);
        System.out.println("s = " + s);
    }

}
