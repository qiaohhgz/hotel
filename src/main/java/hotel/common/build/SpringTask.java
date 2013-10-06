package hotel.common.build;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: shiju
 * Date: 13-6-30
 * Time: 上午10:21
 * To change this template use File | Settings | File Templates.
 */
@Component
public class SpringTask{
    private static final Logger log = Logger.getLogger(SpringTask.class);

    @Scheduled(cron = "0/1 * *  * * ? ")   //每1秒执行一次
    public void run() {
        log.info(new Date().toLocaleString());
    }
}
