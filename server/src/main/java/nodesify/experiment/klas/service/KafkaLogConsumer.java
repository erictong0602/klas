package nodesify.experiment.klas.service;

import nodesify.experiment.klas.util.ESAPILoggingUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaLogConsumer {
    private static final Logger LOGGER = LogManager.getLogger(KafkaLogConsumer.class);

    @KafkaListener(topics = "log-events")
    public void listen(String message) {
        System.out.println(message);
    }
}