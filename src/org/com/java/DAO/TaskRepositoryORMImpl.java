package org.com.java.DAO;

import org.com.java.model.Task;

public class TaskRepositoryORMImpl implements TaskRepository {

	@Override
	public void save(Task task) {
		System.out.println("save through Hibernate ORM");
		
	}

}
