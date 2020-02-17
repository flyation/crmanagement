package com.fly.crmanagement.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fly.crmanagement.dao.ReserveMapper;
import com.fly.crmanagement.entity.Record;
import com.fly.crmanagement.entity.RecordVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 审核预约service
 */
@Service
@Transactional
public class CheckService {

    @Resource
    private ReserveMapper reserveMapper;

    public IPage<RecordVO> getReserveList(int page, int size) {
        return reserveMapper.getReserveList(new Page(page, size));
    }

    public String check(int id, boolean flag) {
        QueryWrapper<Record> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        Record record = new Record();
        if (flag) {
            record.setCheckd("通过");
            reserveMapper.update(record, wrapper);
            return "已通过";
        } else {
            record.setCheckd("否决");
            reserveMapper.update(record, wrapper);
            return "已否决";
        }
    }
}
