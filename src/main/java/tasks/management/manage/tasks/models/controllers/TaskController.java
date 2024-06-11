package tasks.management.manage.tasks.models.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;


import tasks.management.manage.tasks.models.Task;
import tasks.management.manage.tasks.services.TaskService;

@Controller
@RequestMapping("tasks")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	 @GetMapping("/all")
	    public String getAllTasks(Model model) {
		 List<Task> tasks = taskService.getAllTasks();
		 model.addAttribute("tasks", tasks);
		 return "tasks.html";
	    }

	 @GetMapping("/{id}")
	    public ResponseEntity<Task> getTaskById(@PathVariable Integer id) {
	        Optional<Task> task = taskService.getTaskById(id);
	        return task.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }
	 
	  @PostMapping("/create_task")
	    public Task createTask(@RequestBody Task task) {
	        return taskService.addTask(task);
	    }
	  
	   @PutMapping("/update/{id}")
	    public ResponseEntity<Task> updateTask(@PathVariable Integer id, @RequestBody Task taskDetails) {
	        Task updatedTask = taskService.updateTask(id, taskDetails);
	        if (updatedTask != null) {
	            return ResponseEntity.ok(updatedTask);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	  
	  @PostMapping("/delete/{id}")
	    public ResponseEntity<Void> deleteTask(@PathVariable Integer id) {
	        taskService.deleteTask(id);
	        return ResponseEntity.noContent().build();
	    }
}
