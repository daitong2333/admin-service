package com.youlai.boot.modules.Grouting.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "分页多条件查询对象")
@Data
public class QueryByConditions extends BasePageQuery {
    private String shieldMachineNo;
    private String equipmentNo;
    private String projectSection;
    private String phase;
    private String bidSection;
    private String intervalName;
    private String constructionUnit;
    private String constructionTeam;
    private String pileNo;
    private String ringNo;
    // 可以添加分页参数等其他查询条件
}
