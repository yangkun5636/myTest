package cn.ben.test.kafka;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.CreateTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.KafkaFuture;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

/**
 * @TIME 2018/6/27 11:13
 * @User yangkun
 * @DESCRIPTION
 */
public class KafkaTest {
    private static String TOPIC = "demo";

    @Test
    public void createTopic() {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "127.0.0.1:9092");
        AdminClient client = AdminClient.create(properties);
        List<NewTopic> topics = new ArrayList<NewTopic>();
        NewTopic newTopic = new NewTopic(TOPIC, 1, (short) 1);
        topics.add(newTopic);
        CreateTopicsResult result = client.createTopics(topics);
        try {
            KafkaFuture<Void> all = result.all();
            all.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sendMsg() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "127.0.0.1:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<String, String>(props);
        for (int i = 0; i < 100; i++) {
            ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC, Integer.toString(i), Integer.toString(i));
            producer.send(record);
        }
        producer.close();
    }

    @Test
    public void consumerMsg() throws InterruptedException {
        Properties props = new Properties();
        //定义kakfa 服务的地址
        props.put("bootstrap.servers", "127.0.0.1:9092");
        //制定consumer group
        props.put("group.id", "test");
        //是否自动确认offset
        props.put("enable.auto.commit", "true");
        //自动确认offset的时间间隔
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        //key的序列化类
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        //value的序列化类
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        //定义consumer
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
        //消费者订阅的topic, 可同时订阅多个
        consumer.subscribe(Arrays.asList(TOPIC));
//        consumer.subscribe(Arrays.asList(topic), new ConsumerRebalanceListener() {
//            public void onPartitionsRevoked(Collection<TopicPartition> collection) {
//            }
//
//            public void onPartitionsAssigned(Collection<TopicPartition> collection) {
//                //将偏移设置到最开始
//                consumer.seekToBeginning(collection);
//            }
//        });
//        final int max = 100;
//        List<ConsumerRecord<String, String>> list = new ArrayList<>();
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
                Thread.sleep(100);
                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
//                list.add(record);
            }
//            if (list.size() >= max) {
//                consumer.commitSync();
//                list.clear();
//            }
        }
    }
}

/**
 * ADVERTISED_HOST=localhost
 * ADVERTISED_PORT=9092
 */