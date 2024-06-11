package tasks.management.manage.tasks.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import tasks.management.manage.tasks.models.Task;
import tasks.management.manage.tasks.repository.TasksInterface;

@Service
@Data
public class TaskService {
	
	int id;
	String task_title;
	String task_content;
	
	@Autowired
	private TasksInterface tasks_interface;
	
	  public List<Task> getAllTasks() {
	        return tasks_interface.findAll();
	    }
	  
	  public Optional<Task> getTaskById(Integer id) {
	        return tasks_interface.findById(id);
	    }
	  
	   public Task addTask(Task task) {
	        return tasks_interface.save(task);
	    }
	   
	   public Task updateTask(Integer id, Task taskDetails) {
	        Optional<Task> task = tasks_interface.findById(id);

	        if (task.isPresent()) {
	            Task updatedTask = task.get();
	            updatedTask.setTask_title(taskDetails.getTask_title());
	            updatedTask.setTask_content(taskDetails.getTask_content());
	            return tasks_interface.save(updatedTask);
	        } else {
	            // Handle the case where the task is not found
	            return null;
	        }
	    }
	   
	   public void deleteTask(Integer id) {
		   tasks_interface.deleteById(id);
	    }
}
	 
