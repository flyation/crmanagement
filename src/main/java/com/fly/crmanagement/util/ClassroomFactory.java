package com.fly.crmanagement.util;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fly.crmanagement.dao.ClassroomMapper;
import com.fly.crmanagement.dao.ScheduleMapper;
import com.fly.crmanagement.entity.Classroom;
import com.fly.crmanagement.entity.Schedule;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;

@RestController
@CrossOrigin
@RequestMapping("/classroomFactory")
public class ClassroomFactory {

    @Resource
    private ClassroomMapper classroomMapper;

    @Resource
    private ScheduleMapper scheduleMapper;

    /**
     * 添加教室
     * @param num
     * @return
     */
    @PutMapping("/{num}")
    public String save(@PathVariable("num") int num) {
        Classroom classroom = new Classroom();
        for (int i = 0; i < num; i++) {
            classroom.setBuilding(randomBuilding());
            classroom.setName(randomName(classroom));
            classroom.setFloor(new Random().nextInt(6) + 1);
            classroom.setCapacity(new Random().nextInt(2) == 1 ? 100 : 200);
            classroom.setRepair(new Random().nextInt(2));
            classroom.setType(randomType());
            classroomMapper.insert(classroom);
        }
        return LocalTime.now() + "：成功添加教室" + num + "条数据";
    }

    /**
     * 添加日程
     * @return
     */
    @PostMapping("/add")
    public String addSchedule() {
        List<Classroom> classrooms = classroomMapper.selectList(null);
        int count = 0;
        for (Classroom classroom : classrooms) {
            Schedule scheduleNew = new Schedule();
            scheduleNew.setCid(classroom.getId());
            scheduleNew.setName(classroom.getName());
            scheduleNew.setBuilding(classroom.getBuilding());
            scheduleNew.setFloor(classroom.getFloor());
            scheduleNew.setType(classroom.getType());
            scheduleNew.setCapacity(classroom.getCapacity());
//            scheduleNew.setDate(LocalDate.of(2020, 3, 7));
            scheduleNew.setCourse1(new Random().nextInt(2));
            scheduleNew.setCourse2(new Random().nextInt(2));
            scheduleNew.setCourse3(new Random().nextInt(2));
            scheduleNew.setCourse4(new Random().nextInt(2));
            scheduleMapper.insert(scheduleNew);
            count++;
        }
        return LocalTime.now() + "：成功创建日程" + count + "条数据";
    }

    @GetMapping("/test")
    public void test() {
        Classroom classroom = new Classroom();
        classroom.setType("明");
        classroomMapper.insert(classroom);
    }

    public String randomBuilding() {
        String[] buildings = {"明德楼", "文德楼"};
        return buildings[new Random().nextInt(2)];
    }

    public String randomType() {
        String[] types = {"普通教室", "多媒体教室"};
        return types[new Random().nextInt(2)];
    }

    public String randomName(Classroom classroom) {
        StringBuilder firstName = new StringBuilder(classroom.getBuilding().substring(0, 1));
        StringBuilder midName = new StringBuilder(new Random().nextInt(2) == 1 ? "S" : "N");
        StringBuilder lastName = new StringBuilder("" + (new Random().nextInt(7) + 1) + (new Random().nextInt(6) + 10));
        return new String(firstName.append(midName).append(lastName));
    }
}
