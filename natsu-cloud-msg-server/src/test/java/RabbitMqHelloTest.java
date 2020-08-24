import com.natsucloud.service.MessageSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

public class RabbitMqHelloTest {


    @Test
    public void testMessageSend() throws InterruptedException {
        MessageSender messageSender = new MessageSender();
        messageSender.send();
        Thread.sleep(1000);
    }
}