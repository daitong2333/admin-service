package com.youlai.boot.modules.Grouting.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.core.security.util.SecurityUtils;
import com.youlai.boot.modules.Grouting.mapper.GroutingRecordMapper;
import com.youlai.boot.modules.Grouting.model.GroutingRecord;
import com.youlai.boot.modules.Grouting.model.query.QueryByConditions;
import com.youlai.boot.modules.Grouting.service.GroutingRecordService;
import com.youlai.boot.system.model.bo.UserBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroutingRecordServiceImpl extends ServiceImpl<GroutingRecordMapper, GroutingRecord> implements GroutingRecordService {

    @Autowired
     private GroutingRecordMapper groutingRecordMapper;
    @Override
    public List<GroutingRecord> queryByConditions(QueryByConditions queryByConditions) {
        return groutingRecordMapper.selectByConditions(queryByConditions);
    }

    @Override
    public  IPage<GroutingRecord> getGroutingPageList(QueryByConditions queryByConditions){
        // 参数构建
        int pageNum = queryByConditions.getPageNum();
        int pageSize = queryByConditions.getPageSize();
        Page<GroutingRecord> page = new Page<>(pageNum, pageSize);

        // 查询数据
        return groutingRecordMapper.selectByConditionsPage(page, queryByConditions);
    }


}
