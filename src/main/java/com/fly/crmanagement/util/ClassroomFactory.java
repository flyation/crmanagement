package com.fly.crmanagement.util;

import com.fly.crmanagement.dao.ClassroomFactoryMapper;
import com.fly.crmanagement.entity.Classroom;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Random;

@RestController
@CrossOrigin
@RequestMapping("/classroomFactory/{num}")
public class ClassroomFactory {

    @Resource
    private ClassroomFactoryMapper classroomFactoryMapper;

    @PutMapping
    public String save(@PathVariable("num") int num) {
        Classroom classroom = new Classroom();
        for (int i = 0; i < num; i++) {
            classroom.setBuilding(randomBuilding());
            classroom.setName(randomName(classroom));
            classroom.setFloor(new Random().nextInt(6) + 1);
            classroom.setCapacity(new Random().nextInt(2) == 1 ? 100 : 200);
            classroom.setRepair(new Random().nextInt(2));
            classroom.setType(new Random().nextInt(3));
            classroomFactoryMapper.insert(classroom);
        }
        return LocalTime.now() + "：成功添加"+ num + "条数据";
    }

    public String randomBuilding() {
        String[] buildings = {"明德楼", "文德楼"};
        return buildings[new Random().nextInt(2)];
    }

    public String randomName(Classroom classroom) {
        StringBuilder firstName = new StringBuilder(classroom.getBuilding().substring(0,1));
        StringBuilder midName = new StringBuilder(new Random().nextInt(2) == 1 ? "S" : "N");
        StringBuilder lastName = new StringBuilder("" + (new Random().nextInt(7) + 1) + (new Random().nextInt(6) + 10));
        return new String(firstName.append(midName).append(lastName));
    }
}
