package com.youlai.boot.modules.Grouting.model;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.youlai.boot.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@TableName("grouting_records") // 替换为你的实际表名
public class GroutingRecord  {

    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    private String shieldMachineNo;          // 盾构机号
    private String equipmentNo;              // 设备号
    private String projectSection;           // 工程标段(XX线)
    private String phase;                    // 期
    private String bidSection;               // 标段
    private String intervalName;             // 区间
    private String constructionUnit;         // 施工单位
    private String constructionTeam;         // 施工队
    private String pileNo;                   // 桩号
    private String ringNo;                   // 环号
    private String slurryRatio;              // 浆液配比
    private Integer timeInterval;            // 时间间隔(min)
    private BigDecimal pressureLimit;        // 压力上限(Bar)
    private BigDecimal endPressure;          // 结束压力(Bar)
    private BigDecimal groutingLimit;        // 注浆量上限(M3)
    private Integer groutingHoles;           // 注浆孔数
    private String inspectionBatchNo;        // 检验批号(单元号)
    private Integer totalRings;              // 检验批(单元号)总环数
    private Integer totalInspectionBatches;  // 总(单元)检验批数
    private Date intervalStartTime;          // 间隔开始时间
    private BigDecimal advanceDistance;     // 掘进进尺(mm)

    // 注浆数据(1-6孔)
    private BigDecimal groutingFlow1;        // 注浆流量1(L/min)
    private BigDecimal cumulativeInjection1; // 累计注入量1(L)
    private BigDecimal pressure1;            // 压力1(Bar)

    private BigDecimal groutingFlow2;        // 注浆流量2(L/min)
    private BigDecimal cumulativeInjection2; // 累计注入量2(L)
    private BigDecimal pressure2;            // 压力2(Bar)

    private BigDecimal groutingFlow3;        // 注浆流量3(L/min)
    private BigDecimal cumulativeInjection3; // 累计注入量3(L)
    private BigDecimal pressure3;            // 压力3(Bar)

    private BigDecimal groutingFlow4;        // 注浆流量4(L/min)
    private BigDecimal cumulativeInjection4; // 累计注入量4(L)
    private BigDecimal pressure4;            // 压力4(Bar)

    private BigDecimal groutingFlow5;        // 注浆流量5(L/min)
    private BigDecimal cumulativeInjection5; // 累计注入量5(L)
    private BigDecimal pressure5;            // 压力5(Bar)

    private BigDecimal groutingFlow6;        // 注浆流量6(L/min)
    private BigDecimal cumulativeInjection6; // 累计注入量6(L)
    private BigDecimal pressure6;            // 压力6(Bar)

    // 材料消耗
    private BigDecimal totalMaterialConsumption;      // 累计材料消耗(L)
    private BigDecimal totalMaterialConsumptionKg;    // 累计材料消耗(kg)
    private BigDecimal totalCementConsumption;       // 累计水泥消耗(KG)
    private BigDecimal totalBentoniteConsumption;    // 累计膨润土消耗(KG)

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
}