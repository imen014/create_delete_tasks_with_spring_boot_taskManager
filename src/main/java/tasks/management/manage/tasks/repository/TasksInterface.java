package tasks.management.manage.tasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tasks.management.manage.tasks.models.Task;

public interface TasksInterface extends JpaRepository<Task, Integer> {

}
