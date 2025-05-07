package com.youlai.boot.core.mqtt;

import com.youlai.boot.modules.Grouting.model.GroutingRecord;
import com.youlai.boot.modules.Grouting.service.GroutingRecordService;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.mqttv5.client.MqttClient;
import org.eclipse.paho.mqttv5.common.MqttException;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Slf4j
@Component
public class MqttSubscriptionInitializer implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    private MqttService mqttService;

    @Autowired
    private GroutingRecordService groutingRecordService;

    @Value("${mqtt.default-topic}")
    private String defaultTopic;
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        try {
            mqttService.subscribe(defaultTopic,0, new MqttService.CustomMessageListener(groutingRecordService));
            log.info("MQTT订阅初始化成功");
//            logger.info("成功订阅主题: {}");
//            // 订阅所有配置的主题
//            properties.getTopics().forEach(topic -> {
//                try {
//                    mqttClient.subscribe(topic, 1); // QoS 1
//                    log.info("成功订阅主题: {}", topic);
//                } catch (MqttException e) {
//                    log.error("订阅主题失败: {}", topic, e);
//                }
//            });
        } catch (Exception e) {
//            log.error("MQTT订阅初始化失败", e);
        }
    }
}
