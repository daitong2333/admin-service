package com.youlai.boot.core.mqtt;

import cn.hutool.json.JSON;
import com.youlai.boot.modules.Grouting.model.GroutingRecord;
import com.youlai.boot.modules.Grouting.service.GroutingRecordService;
import org.eclipse.paho.mqttv5.client.IMqttMessageListener;
import org.eclipse.paho.mqttv5.client.IMqttToken;
import org.eclipse.paho.mqttv5.client.MqttClient;
import org.eclipse.paho.mqttv5.client.MqttConnectionOptions;
import org.eclipse.paho.mqttv5.common.MqttException;
import org.eclipse.paho.mqttv5.common.MqttMessage;
import org.eclipse.paho.mqttv5.common.MqttSubscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import cn.hutool.json.JSONUtil;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class MqttService {

    @Autowired
    private MqttClient mqttClient;

//    @Autowired
//    private GroutingRecordService groutingRecordService;

    @Value("${mqtt.default-topic}")
    private String defaultTopic;

    // 发布消息
    public void publish(String topic, String payload) throws MqttException {
        MqttMessage message = new MqttMessage(payload.getBytes());
        mqttClient.publish(topic, message);
        System.out.println("Message published to topic: " + topic);
    }


    public static class CustomMessageListener implements IMqttMessageListener {

        private  GroutingRecordService groutingRecordService;
        public CustomMessageListener(GroutingRecordService groutingRecordService) {
            this.groutingRecordService = groutingRecordService;
        }
        @Override
        public void messageArrived(String topic, MqttMessage message) throws Exception {
            String payload = new String(message.getPayload());
            GroutingRecord groutingRecord = JSONUtil.toBean(payload, GroutingRecord.class);
            groutingRecord.setId(UUID.randomUUID().toString());
            groutingRecordService.save(groutingRecord);
            System.out.println("Received message: " + groutingRecord + " from topic: " + topic);
        }
    }

    // 订阅主题
    public void subscribe(String topic) throws MqttException {
        if (!mqttClient.isConnected()) {
            mqttClient.connect(); // 确保客户端已连接
        }
//        mqttClient.subscribe(topic, 0, new CustomMessageListener());
        System.out.println("Subscribed to topic: " + topic);
    }
    public IMqttToken subscribe(String topicFilter, int qos, IMqttMessageListener messageListener) throws MqttException {
        if (!mqttClient.isConnected()) {
            mqttClient.connect(); // 确保客户端已连接
        }
        MqttSubscription[] subscriptions = new MqttSubscription[1];
        subscriptions[0] = new MqttSubscription(topicFilter, qos);
        IMqttMessageListener[] messageListeners = {messageListener};
        return mqttClient.subscribe(subscriptions,messageListeners);
    }
}