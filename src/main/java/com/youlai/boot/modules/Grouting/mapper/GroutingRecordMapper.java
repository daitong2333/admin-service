package com.youlai.boot.modules.Grouting.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.modules.Grouting.model.GroutingRecord;
import com.youlai.boot.modules.Grouting.model.query.QueryByConditions;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 会员数据访问层-业务模块演示
 *
 * @author haoxr
 * @since 2024/10/10
 */
@Mapper
public interface GroutingRecordMapper extends BaseMapper<GroutingRecord> {
    /**
     * 多条件组合查询
     * @param params 包含所有查询条件的Map
     * @return 符合条件的记录列表
     */
    List<GroutingRecord> selectByConditions(@Param("params") QueryByConditions params);

    /**
     * 多条件分页查询
     * @param page 分页对象
     * @param params 查询条件
     * @return 分页结果
     */
    IPage<GroutingRecord> selectByConditionsPage(IPage<GroutingRecord> page, @Param("params") QueryByConditions params);
}
