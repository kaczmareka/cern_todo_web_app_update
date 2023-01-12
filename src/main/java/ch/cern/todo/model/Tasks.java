package ch.cern.todo.model;

import javax.persistence.*;

//responsible for creating and maintaining table tasks

@Entity
@Table(name = "tasks", indexes = @Index(columnList = "task_id"))
public class Tasks {

    @Id //this is a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long task_id;

    @Column(columnDefinition="VARCHAR2(100)", nullable = false, name = "task_name")
    private String task_name;

    @Column(columnDefinition="VARCHAR2(500)", name = "task_description")
    private String task_description;

    @Column(columnDefinition="TIMESTAMP", nullable = false, name = "deadline")
    private String deadline;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = true)
    private TaskCategories  task_category;

    public Tasks(String task_name, String task_description, String deadline){

        this.task_name=task_name;
        this.task_description=task_description;
        this.deadline=deadline;
    }

    public long getId(){
        return task_id;
    }
    public String getTaskName(){
        return task_name;
    }
    public void setTaskName(String task_name){
        this.task_name=task_name;
    }
    public String getTaskDescription(){
        return task_description;
    }
    public void setTaskDescription(String task_description){
        this.task_description = task_description;
    }
    public String getDeadline(){
        return deadline;
    }
    public void setDeadline(String deadline){
        this.deadline=deadline;
    }

    @Override
    public String toString(){
        return "Task [id="+task_id+", name="+task_name+", description="+task_description+"]";
    }

}
