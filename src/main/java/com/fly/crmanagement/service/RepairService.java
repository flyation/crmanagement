package com.fly.crmanagement.service;

import com.fly.crmanagement.dao.RepairMapper;
import com.fly.crmanagement.entity.Repair;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 报修信息service
 */
@Service
@Transactional
public class RepairService {

    @Resource
    private RepairMapper repairMapper;

    public void insertRepair(Repair repair) {
        repair.setId(null);
        repairMapper.insert(repair);
    }

    public List<Repair> findAll() {
        return repairMapper.selectList(null);
    }
}
