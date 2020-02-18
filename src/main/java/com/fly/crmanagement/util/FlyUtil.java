package com.fly.crmanagement.util;

import com.fly.crmanagement.entity.Record;
import com.fly.crmanagement.entity.Schedule;
import com.fly.crmanagement.entity.User;
import com.fly.crmanagement.entity.UserDTO;
import jdk.nashorn.internal.runtime.events.RecompilationEvent;

import java.util.ArrayList;

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

    //撤销预约时
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
        return;
    }
}
