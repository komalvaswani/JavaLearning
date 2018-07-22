package org.com.java.DAO;

import org.com.java.model.Task;

public class TaskRepositoryORMImpl implements TaskRepository {

	@Override
	public void save(Task task) {
		System.out.println("save through Hibernate ORM");
		
	}

	@Override
	public void add(Task task) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Task task) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int taskId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void count() {
		// TODO Auto-generated method stub
		
	}

}
