import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.autoconfigure.AutoConfiguredOpenTelemetrySdk;
import io.opentelemetry.instrumentation.log4j.appender.v2_17.OpenTelemetryAppender;

public class Example {
    private static final Logger logger = LogManager.getLogger(Example.class);

    public static void main(String[] args) throws java.lang.InterruptedException {
        OpenTelemetrySdk openTelemetry = AutoConfiguredOpenTelemetrySdk.initialize().getOpenTelemetrySdk();
        OpenTelemetryAppender.install(openTelemetry);

        logger.info("My test log");

        // openTelemetry.shutdown();  // Fixes the problem

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            openTelemetry.shutdown();
        }));
    }
}