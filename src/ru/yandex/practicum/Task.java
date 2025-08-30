package ru.yandex.practicum;

public class Task {
    protected static int counter = 0;
    protected String title;
    protected String description;
    protected int id;
    protected TaskStatus status;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.status = TaskStatus.NEW;
        this.id = ++counter;
    }

    public Task(String title) {
        this.title = title;
        this.status = TaskStatus.NEW;
        this.id = ++counter;
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
        return Integer.hashCode(this.id);
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
