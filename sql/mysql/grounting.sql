CREATE TABLE grouting_records (
                                     id CHAR(36) PRIMARY KEY DEFAULT (UUID()),
                                     shield_machine_no VARCHAR(50) COMMENT '盾构机号',
                                     equipment_no VARCHAR(50) COMMENT '设备号',
                                     project_section VARCHAR(100) COMMENT '工程标段(XX线)',
                                     phase VARCHAR(50) COMMENT '期',
                                     bid_section VARCHAR(50) COMMENT '标段',
                                     interval_name VARCHAR(100) COMMENT '区间',
                                     construction_unit VARCHAR(100) COMMENT '施工单位',
                                     construction_team VARCHAR(100) COMMENT '施工队',
                                     pile_no VARCHAR(50) COMMENT '桩号',
                                     ring_no VARCHAR(50) COMMENT '环号',
                                     slurry_ratio VARCHAR(50) COMMENT '浆液配比',
                                     time_interval INT COMMENT '时间间隔(min)',
                                     pressure_limit DECIMAL(10,2) COMMENT '压力上限(Bar)',
                                     end_pressure DECIMAL(10,2) COMMENT '结束压力(Bar)',
                                     grouting_limit DECIMAL(10,2) COMMENT '注浆量上限(M3)',
                                     grouting_holes INT COMMENT '注浆孔数',
                                     inspection_batch_no VARCHAR(50) COMMENT '检验批号(单元号)',
                                     total_rings INT COMMENT '检验批(单元号)总环数',
                                     total_inspection_batches INT COMMENT '总(单元)检验批数',
                                     interval_start_time DATETIME COMMENT '间隔开始时间',
                                     advance_distance DECIMAL(10,2) COMMENT '掘进进尺(mm)',

    -- 注浆数据(1-6孔)
                                     grouting_flow1 DECIMAL(10,2) COMMENT '注浆流量1(L/min)',
                                     cumulative_injection1 DECIMAL(10,2) COMMENT '累计注入量1(L)',
                                     pressure1 DECIMAL(10,2) COMMENT '压力1(Bar)',

                                     grouting_flow2 DECIMAL(10,2) COMMENT '注浆流量2(L/min)',
                                     cumulative_injection2 DECIMAL(10,2) COMMENT '累计注入量2(L)',
                                     pressure2 DECIMAL(10,2) COMMENT '压力2(Bar)',

                                     grouting_flow3 DECIMAL(10,2) COMMENT '注浆流量3(L/min)',
                                     cumulative_injection3 DECIMAL(10,2) COMMENT '累计注入量3(L)',
                                     pressure3 DECIMAL(10,2) COMMENT '压力3(Bar)',

                                     grouting_flow4 DECIMAL(10,2) COMMENT '注浆流量4(L/min)',
                                     cumulative_injection4 DECIMAL(10,2) COMMENT '累计注入量4(L)',
                                     pressure4 DECIMAL(10,2) COMMENT '压力4(Bar)',

                                     grouting_flow5 DECIMAL(10,2) COMMENT '注浆流量5(L/min)',
                                     cumulative_injection5 DECIMAL(10,2) COMMENT '累计注入量5(L)',
                                     pressure5 DECIMAL(10,2) COMMENT '压力5(Bar)',

                                     grouting_flow6 DECIMAL(10,2) COMMENT '注浆流量6(L/min)',
                                     cumulative_injection6 DECIMAL(10,2) COMMENT '累计注入量6(L)',
                                     pressure6 DECIMAL(10,2) COMMENT '压力6(Bar)',

    -- 材料消耗
                                     total_material_consumption DECIMAL(10,2) COMMENT '累计材料消耗(L)',
                                     total_material_consumption_kg DECIMAL(10,2) COMMENT '累计材料消耗(kg)',
                                     total_cement_consumption DECIMAL(10,2) COMMENT '累计水泥消耗(KG)',
                                     total_bentonite_consumption DECIMAL(10,2) COMMENT '累计膨润土消耗(KG)',

                                     create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',
                                     update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='盾构机记录表';