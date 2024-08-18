package nodesify.experiment.klas.runner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class KafkaRunner implements CommandLineRunner {
    private static final Logger LOGGER = LogManager.getLogger(KafkaRunner.class);

    private static final String MSG_TEST_DEFAULT = "Testing Message!";

    @Override
    public void run(String... args) throws Exception {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        Random random = new Random();
        Runnable logTask = () -> {
            int randomNumber = 1 + random.nextInt(5);
            switch (randomNumber) {
                case 1 -> LOGGER.trace(MSG_TEST_DEFAULT);
                case 2 -> LOGGER.debug(MSG_TEST_DEFAULT);
                case 3 -> LOGGER.info(MSG_TEST_DEFAULT);
                case 4 -> LOGGER.warn(MSG_TEST_DEFAULT);
                case 5 -> LOGGER.error(MSG_TEST_DEFAULT);
                default -> LOGGER.fatal(MSG_TEST_DEFAULT);
            }
        };

        scheduler.scheduleAtFixedRate(logTask, 0, 2, TimeUnit.SECONDS);

        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
