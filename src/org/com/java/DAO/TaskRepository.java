package org.com.java.DAO;

import org.com.java.model.Task;

public interface TaskRepository {
	
	public void save(Task task);
	public void add(Task task);
	public void update(Task task);
	public void delete(int taskId);

}
