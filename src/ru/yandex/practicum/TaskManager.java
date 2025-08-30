package ru.yandex.practicum;

import java.util.HashMap;
import java.util.Map;

public class TaskManager {
    private final HashMap<Integer, Task> taskList;
    private final HashMap<Integer, Subtask> subtaskList;
    private final HashMap<Integer, Epic> epicList;
    private int counterId;

    public TaskManager() {
        this.taskList = new HashMap<>();
        this.subtaskList = new HashMap<>();
        this.epicList = new HashMap<>();
        this.counterId = 0;
    }

    public Map<Integer, Task> getTaskList() {
        return taskList;
    }

    public Map<Integer, Subtask> getSubtaskList() {
        return subtaskList;
    }

    public Map<Integer, Epic> getEpicList() {
        return epicList;
    }

    public void createTask(Task task) {
        if (task != null) {
            counterId++;
            task.setId(counterId);
            taskList.put(task.getId(), task);
        }
    }

    public void removeTaskById(int id) {
        taskList.remove(id);
    }

    public Task getTaskById(int id) {
        return taskList.get(id);
    }

    public void updateTask(Task newTask) {
        for (Task task : taskList.values()) {
            if (newTask.equals(task)) {
                taskList.replace(newTask.getId(), task, newTask);
            }
        }
    }

    public void removeAllTasks() {
        taskList.clear();
    }

}
