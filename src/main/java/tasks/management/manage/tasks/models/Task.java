package tasks.management.manage.tasks.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tasks")
public class Task {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	String task_title;
	String task_content;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTask_title() {
		return task_title;
	}
	public void setTask_title(String task_title) {
		this.task_title = task_title;
	}
	public String getTask_content() {
		return task_content;
	}
	public void setTask_content(String task_content) {
		this.task_content = task_content;
	}
	

}
