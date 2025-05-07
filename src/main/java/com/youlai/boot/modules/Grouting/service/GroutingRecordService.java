package com.youlai.boot.modules.Grouting.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.youlai.boot.modules.Grouting.model.GroutingRecord;
import com.youlai.boot.modules.Grouting.model.query.QueryByConditions;
import com.youlai.boot.system.model.query.UserPageQuery;
import com.youlai.boot.system.model.vo.UserPageVO;

import java.util.List;
import java.util.Map;

/**
 * 会员管理服务类-业务模块演示
 *
 * @author haoxr
 * @since 2024/10/10
 */

public interface GroutingRecordService extends IService<GroutingRecord> {

    List<GroutingRecord> queryByConditions(QueryByConditions queryByConditions);


    IPage<GroutingRecord> getGroutingPageList(QueryByConditions queryByConditions);
}
