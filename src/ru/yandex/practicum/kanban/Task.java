package ru.yandex.practicum.kanban;

public class Task {
    protected String title;
    protected String description;
    protected int id;
    protected TaskStatus status;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.status = TaskStatus.NEW;
    }

    public Task(String title) {
        this.title = title;
        this.status = TaskStatus.NEW;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return this.id == task.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    @Override
    public String toString() {
        String result = "Task{" +
                "title='" + title + "'";
        if (this.description != null) {
            result += ", description='" + description + "'";
        }
        result += ", id=" + id +
                ", status=" + status +
                '}';
        return result;
    }
}
