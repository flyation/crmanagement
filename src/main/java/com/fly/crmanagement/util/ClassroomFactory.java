package com.fly.crmanagement.util;

import com.fly.crmanagement.dao.ClassroomMapper;
import com.fly.crmanagement.dao.ScheduleMapper;
import com.fly.crmanagement.entity.Classroom;
import com.fly.crmanagement.entity.Schedule;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;

@RestController
@CrossOrigin
@RequestMapping("/factory")
public class ClassroomFactory {

    @Resource
    private ClassroomMapper classroomMapper;

    @Resource
    private ScheduleMapper scheduleMapper;

    /**
     * 添加教室
     */
    @GetMapping("/room")
    public String addClassroom() {
        int count = 0;  // 插入记录数
        Classroom classroom = null;
        String[] buildings = {"明德楼", "文德楼", "逸夫楼"}; //插入的教学楼集合
        // 外层for 教学楼
        for (int i = 0; i <buildings.length; i++) {
            // 中层for 楼层
            for (int j = 1; j <= 6; j++) {
                // 内层for N
                for (int k = 10; k <= 15; k++) {
                    classroom = new Classroom();
                    classroom.setBuilding(buildings[i]);
                    classroom.setName(classroom.getBuilding().substring(0, 1) + "N" + j + k);
                    classroom.setFloor(j);
                    classroom.setCapacity(randomCapacity());
                    classroom.setType(randomType());
                    classroom.setRepair(randomType());
                    classroomMapper.insert(classroom);
                    count++;
                }
                // 内层for S
                for (int k = 1; k < 10; k++) {
                    classroom = new Classroom();
                    classroom.setBuilding(buildings[i]);
                    classroom.setName(classroom.getBuilding().substring(0, 1) + "S" + j + 0 + k);
                    classroom.setFloor(j);
                    classroom.setCapacity(randomCapacity());
                    classroom.setType(randomType());
                    classroom.setRepair(randomType());
                    classroomMapper.insert(classroom);
                    count++;
                }
            }
        }
        return LocalTime.now() + "：成功添加教室" + count + "条数据";
    }

    /**
     * 添加日程
     */
    @GetMapping("/schedule")
    public String addScheduleWithPeriod() {
        int count = 0;

        List<Classroom> classrooms = classroomMapper.selectList(null);  // 所有教室
        LocalDate today = LocalDate.now();
        LocalDate targetDte = LocalDate.of(2020, 6, 1);
        while (today.isBefore(targetDte)) {
            for (Classroom classroom : classrooms) {
                Schedule schedule = new Schedule();
                schedule.setCid(classroom.getId());
                schedule.setDate(today);
                schedule.setCourse1(new Random().nextInt(2) == 1);
                schedule.setCourse2(new Random().nextInt(2) == 1);
                schedule.setCourse3(new Random().nextInt(2) == 1);
                schedule.setCourse4(new Random().nextInt(2) == 1);
                scheduleMapper.insert(schedule);
                count++;
            }
            today = today.plusDays(1);
        }

        return LocalTime.now() + "：成功创建日程" + count + "条数据";
    }

    public int randomCapacity() {
        double random = Math.random();
        // 保证random的范围为(0, 0.6)
        while (random < 0.1 || random >= 0.6) {
            random = Math.random();
        }
        int capacity = ((int) (random * 10)) * 100;
        return capacity;
    }

    public boolean randomType() {
        return new Random().nextInt(2) == 1;
    }

    public String randomName(Classroom classroom) {
        StringBuilder firstName = new StringBuilder(classroom.getBuilding().substring(0, 1));
        StringBuilder midName = new StringBuilder(new Random().nextInt(2) == 1 ? "S" : "N");
        StringBuilder lastName = new StringBuilder("" + (new Random().nextInt(7) + 1) + (new Random().nextInt(6) + 10));
        return new String(firstName.append(midName).append(lastName));
    }
}
