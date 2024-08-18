package nodesify.experiment.klas.util;

import org.owasp.esapi.ESAPI;
import org.owasp.esapi.Encoder;

public class ESAPILoggingUtil {
    private static final Encoder encoder = ESAPI.encoder();

    public static String sanitizeForLogging(String input) {
        return encoder.encodeForHTML(input);
    }
}
