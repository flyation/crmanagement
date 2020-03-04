package com.fly.crmanagement.controller;

import com.fly.crmanagement.entity.Classroom;
import com.fly.crmanagement.entity.ClassroomExcel;
import com.fly.crmanagement.service.RoomIService;
import com.fly.crmanagement.util.EasyExcelUtil;
import com.fly.crmanagement.util.FlyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 上传模块
 */
@RestController
@CrossOrigin
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    RoomIService roomIService;

    @PostMapping("/classroom")
    public void uploadClassroom(@RequestParam("file") MultipartFile excelFile) {
        System.out.println(excelFile.getOriginalFilename());
//        if (!excelFile.isEmpty()) {
//            File file = new File("C:\\Users\\fly\\Documents\\MyUpload", excelFile.getOriginalFilename());
//            try {
//                excelFile.transferTo(file);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        List<Object> list = null;
        try {
            list = EasyExcelUtil.readExcel(excelFile, new ClassroomExcel(),1,1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Classroom> classrooms = new ArrayList<>();
        if(list != null && list.size() > 0){
            for(Object o : list){
                classrooms.add(FlyUtil.ClassroomExcel2Classroom((ClassroomExcel) o));
            }
        }
        roomIService.saveBatch(classrooms);
    }
}
