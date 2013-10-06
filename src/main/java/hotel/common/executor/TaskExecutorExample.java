package hotel.common.executor;

import org.springframework.core.task.TaskExecutor;
/**
 * spring taskExecutor  class
 * @author dream
 * message  input  i =25 
 */
public class TaskExecutorExample {
	private class MessagePrinterTask implements Runnable {
       /**
        * 输出的信息message
        */
	    private String message;

	    public MessagePrinterTask(String message) {
	      this.message = message;
	    }

	    public void run() {
	      System.out.println(message);
	    }

	  }

	  private TaskExecutor taskExecutor;

	  public TaskExecutorExample(TaskExecutor taskExecutor) {
	    this.taskExecutor = taskExecutor;
	  }
    /**
     * pringMessages
     */
	  public void printMessages() {
	    for(int i = 0; i < 25; i++) {
	      taskExecutor.execute(new MessagePrinterTask("Message" + i));
	    }
	  }

}
