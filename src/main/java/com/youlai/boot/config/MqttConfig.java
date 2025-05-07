package com.youlai.boot.config;

import org.eclipse.paho.mqttv5.client.MqttClient;
import org.eclipse.paho.mqttv5.client.MqttConnectionOptions;
import org.eclipse.paho.mqttv5.client.persist.MemoryPersistence;
import org.eclipse.paho.mqttv5.common.MqttException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqttConfig {

    @Value("${mqtt.broker-url}")
    private String brokerUrl;

    @Value("${mqtt.client-id}")
    private String clientId;

    @Value("${mqtt.username}")
    private String username;

    @Value("${mqtt.password}")
    private String password;

    @Bean
    public MqttClient mqttClient() throws MqttException {
        // 创建 MQTT 5.0 客户端
        MqttClient mqttClient = new MqttClient(brokerUrl, clientId, new MemoryPersistence());

        // 设置连接选项
        MqttConnectionOptions options = new MqttConnectionOptions();
        options.setUserName(username);
        options.setPassword(password.getBytes());
        options.setAutomaticReconnect(true); // 自动重连
        options.setCleanStart(true);        // 清除会话
//        options.setMqttVersion(MqttConnectionOptions.MQTT_VERSION_5); // 使用 MQTT 5.0

        // 连接到 MQTT 服务器
        mqttClient.connect(options);
//        IMqttToken token = mqttClient.connectWithResult(options);
        System.out.println("MQTT 5.0 Connected to broker: " + brokerUrl);
        // 设置连接丢失监听器
//        mqttClient.setCallback(new MyDemo1MqttV5Client.MqttCallbackAdapter());
        return mqttClient;
    }

}