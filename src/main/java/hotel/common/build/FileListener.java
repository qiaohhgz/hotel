package hotel.common.build;

import org.apache.log4j.Logger;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: shiju
 * Date: 13-6-30
 * Time: 上午9:47
 * To change this template use File | Settings | File Templates.
 */
public class FileListener implements Runnable {
    private static final Logger log = Logger.getLogger(FileListener.class);
    private File file;
    private long lastModified;
    private long millis = 3000;
    private boolean isStop;

    public FileListener(File file) {
        this.file = file;
    }

    @Override
    public void run() {
        lastModified = file.lastModified();
        log.info("Start...");
        while (!isStop()) {
            try {
                if (!check(file)) {
                    setStop(true);
                    break;
                }
                Thread.sleep(millis);
                long lastDate = file.lastModified();
                if (lastDate != lastModified) {
                    lastModified = lastDate;
                    onChange(file);
                }
            } catch (InterruptedException e) {
                log.error(e);
                setStop(true);
            }
        }
        log.info("Stop");
    }

    public void onChange(File file) {
        System.out.println("file.lastModified() = " + file.lastModified());
    }

    public boolean check(File file) {
        if (file != null && file.exists() && file.isFile()) {
            return true;
        }
        log.info("File not found. " + file.getAbsolutePath());
        return false;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public long getMillis() {
        return millis;
    }

    public void setMillis(long millis) {
        this.millis = millis;
    }

    public boolean isStop() {
        return isStop;
    }

    public void setStop(boolean stop) {
        isStop = stop;
    }
}
