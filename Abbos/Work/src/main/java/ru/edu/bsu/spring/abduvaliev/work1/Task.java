package ru.edu.bsu.spring.abduvaliev.work1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Task {
    private int ID;
    private String name;
    private Boolean status;
    private String comments;

    /*
    public int getID() {
        return ID;
    }
    public String getName() {
        return name;
    }
    public Boolean getStatus() {
        return status;
    }
    public String getComments() {
        return comments;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }
        public void change(Task task) {
    }
    public Task(Task input) {}*/
    public Task(Task task) {
        this.ID = task.getID();
        this.name = task.getName();
        this.status = task.getStatus();
        this.comments = task.getComments();
    }
    public void change(Task task) {
        this.ID = task.getID();
        this.name = task.getName();
        this.status = task.getStatus();
        this.comments = task.getComments();
    }
}



