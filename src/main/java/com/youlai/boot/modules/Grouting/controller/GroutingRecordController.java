package com.youlai.boot.modules.Grouting.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.youlai.boot.common.result.PageResult;
import com.youlai.boot.modules.Grouting.model.GroutingRecord;
import com.youlai.boot.modules.Grouting.model.query.QueryByConditions;
import com.youlai.boot.modules.Grouting.service.GroutingRecordService;
import com.youlai.boot.system.model.vo.UserPageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * 会员控制层-业务模块演示
 *
 * @author haoxr
 * @since 2024/10/10
 */
@RestController
@RequestMapping("/api/grouting-records")
public class GroutingRecordController {
    @Autowired
    private GroutingRecordService groutingRecordService;

    @PostMapping
    public GroutingRecord create(@RequestBody GroutingRecord record) {
        if(record.getId() == null){
            record.setId(UUID.randomUUID().toString());
        }
        groutingRecordService.save(record);
        return record;
    }
    @GetMapping("/{id}")
    public GroutingRecord getById(@PathVariable Long id) {
        return groutingRecordService.getById(id);
    }

    @GetMapping("/queryByConditions")
    public List<GroutingRecord> queryByConditions(QueryByConditions queryByConditions){
        return groutingRecordService.queryByConditions(queryByConditions);
    }

    @GetMapping("/getGroutingPageList")
    public PageResult<GroutingRecord> getGroutingPageList(QueryByConditions queryByConditions) {
        IPage<GroutingRecord> result  = groutingRecordService.getGroutingPageList(queryByConditions);
        return PageResult.success(result);
    }
}
