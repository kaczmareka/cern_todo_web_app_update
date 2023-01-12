package ch.cern.todo.model;

import javax.persistence.*;

//responsible for creating and maintaining table task_categories

@Entity
@Table(name = "task_categories", indexes=@Index(columnList = "category_id, category_name"))
public class TaskCategories {

    @Id //this is a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long category_id;

    @Column(columnDefinition="VARCHAR2(100)",unique=true, nullable = false, name = "category_name")
    private String category_name;

    @Column(columnDefinition="VARCHAR2(500)",name = "category_description")
    private String category_description;

    public TaskCategories(String category_name, String category_description){
        this.category_name=category_name;
        this.category_description=category_description;
    }

    public long getId(){
        return category_id;
    }
    public String getCategoryName(){
        return category_name;
    }
    public void setCategoryName(String category_name){
        this.category_name=category_name;
    }
    public String getCategoryDescription(){
        return category_description;
    }
    public void setCategoryDescription(String category_description){
        this.category_description = category_description;
    }

    @Override
    public String toString(){
        return "Category [id="+category_id+", name="+category_name+", description="+category_description+"]";
    }

}
