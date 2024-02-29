package Task12;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.handler.annotation.Header;

@MessagingGateway(defaultRequestChannel = "textInputChanel")
public class FileGateway {
    void writeToFile(@Header(FileHeaders.FILENAME) String filename, String data);
}
}
