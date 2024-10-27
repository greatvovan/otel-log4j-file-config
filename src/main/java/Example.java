import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.common.CompletableResultCode;   // Succeeds!
import io.opentelemetry.sdk.autoconfigure.AutoConfiguredOpenTelemetrySdk;

public class Example {
    public static void main(String[] args) throws java.lang.InterruptedException {
        OpenTelemetrySdk openTelemetry = AutoConfiguredOpenTelemetrySdk.initialize().getOpenTelemetrySdk();

        // openTelemetry.shutdown();  // Fixes tthe problem
    }
}