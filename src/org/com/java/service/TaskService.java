package org.com.java.service;

import org.com.java.model.Task;

public interface TaskService {
	
	public void addTask(Task task);
	public void updateTask(Task task);
	public void deleteTask(int taskId);
	public void totalTaskCount();

}
