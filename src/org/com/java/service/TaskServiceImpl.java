package org.com.java.service;

import org.com.java.DAO.TaskRepository;
import org.com.java.DAO.TaskRepositoryImpl;
import org.com.java.model.Task;

public class TaskServiceImpl implements TaskService {
	
	private TaskRepository taskRepository;
	
	public TaskServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public TaskServiceImpl(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	@Override
	public void addTask(Task task) {
		//taskRepository.save(task);
		taskRepository.add(task);
		
	}

	@Override
	public void updateTask(Task task) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTask(int taskId) {
		// TODO Auto-generated method stub
		
	}

	/*public TaskRepository getTaskRepo() {
		return taskRepo;
	}

	public void setTaskRepo(TaskRepository taskRepo) {
		this.taskRepo = taskRepo;
	}*/

}
