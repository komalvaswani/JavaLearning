//import java.util.Date;

import java.sql.Date;

import org.com.java.model.Task;
import org.com.java.service.TaskService;
import org.com.java.service.TaskServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

	public static void main(String[] args) {
		ApplicationContext container = new ClassPathXmlApplicationContext("Application_config.xml");
		//add new task
		Task task = new Task();
		task.setTaskName("Spring tutorial");
		task.setStartDate(new Date(2018,07,8));
		task.setEndDate(new Date(2018, 8, 15));
		task.setCreatedBy("Komal");
		task.setCreatedOn(new Date(2018, 07, 22));
		TaskServiceImpl taskImpl = (TaskServiceImpl) container.getBean(TaskService.class);
		taskImpl.addTask(task);
		((AbstractApplicationContext) container).close();

	}

}
