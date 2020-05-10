package com.fly.crmanagement.util;

import com.fly.crmanagement.entity.*;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

public class FlyUtil {

    public static UserDTO User2UserDTO (User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setName(user.getName());
        userDTO.setAvatar(user.getAvatar());
        userDTO.setToken(user.getToken());

        ArrayList<String> roles = new ArrayList<>();
        roles.add(user.getRole());
        userDTO.setRoles(roles);

        return userDTO;
    }

    //审核通过时
    public static void Record2Schedule (Record record, Schedule schedule) {
        if (record.getCourse1()) {
            schedule.setCourse1(true);
        }
        if (record.getCourse2()) {
            schedule.setCourse2(true);
        }
        if (record.getCourse3()) {
            schedule.setCourse3(true);
        }
        if (record.getCourse4()) {
            schedule.setCourse4(true);
        }
        return;
    }

    // 撤销预约时（预约座位）
    public static void Record2ScheduleBySeat (Record record, Schedule schedule) {
        if (record.getCourse1()) {
            schedule.setNumber1(schedule.getNumber1() + 1);
        }
        if (record.getCourse2()) {
            schedule.setNumber2(schedule.getNumber2() + 1);
        }
        if (record.getCourse3()) {
            schedule.setNumber3(schedule.getNumber3() + 1);
        }
        if (record.getCourse4()) {
            schedule.setNumber4(schedule.getNumber4() + 1);
        }
    }

    //撤销预约时（预约教室）
    public static void Record2ScheduleCancel (Record record, Schedule schedule) {
        if (record.getCourse1()) {
            schedule.setCourse1(false);
        }
        if (record.getCourse2()) {
            schedule.setCourse2(false);
        }
        if (record.getCourse3()) {
            schedule.setCourse3(false);
        }
        if (record.getCourse4()) {
            schedule.setCourse4(false);
        }
    }

    //撤销预约时（预约座位）
    public static void Record2ScheduleCancelBySeat (Record record, Schedule schedule) {
        if (record.getCourse1()) {
            schedule.setNumber1(schedule.getNumber1() - 1);
        }
        if (record.getCourse2()) {
            schedule.setNumber2(schedule.getNumber2() - 1);
        }
        if (record.getCourse3()) {
            schedule.setNumber3(schedule.getNumber3() - 1);
        }
        if (record.getCourse4()) {
            schedule.setNumber4(schedule.getNumber4() - 1);
        }
    }

    //转换教室类的excel表映射实体和数据库映射实体
    public static Classroom ClassroomExcel2Classroom (ClassroomExcel excel) {
        Classroom classroom = new Classroom();
        classroom.setName(excel.getName());
        classroom.setBuilding(excel.getBuilding());
        classroom.setFloor(excel.getFloor());
        classroom.setCapacity(excel.getCapacity());
        classroom.setType(excel.getType());
        classroom.setRepair(excel.getRepair());
        return classroom;
    }

    public static Schedule ScheduleExcel2Schedule(ScheduleExcel excel) {
        Schedule schedule = new Schedule();
        schedule.setCid(excel.getCid());
        schedule.setDate(LocalDate.parse(excel.getDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        schedule.setCourse1(!StringUtils.isEmpty(excel.getCourse1()));
        schedule.setCourse2(!StringUtils.isEmpty(excel.getCourse2()));
        schedule.setCourse3(!StringUtils.isEmpty(excel.getCourse3()));
        schedule.setCourse4(!StringUtils.isEmpty(excel.getCourse4()));
        return schedule;
    }

    /**
     * 发放身份码（四位随机数字）
     * @param
     * @return
     */
    public static String randomIDCodeOf4 () {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int number = random.nextInt(10);
            sb.append(number);
        }
        return sb.toString();
    }
}
