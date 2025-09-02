package ru.yandex.practicum.kanban;

import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.HashMap;

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

    public List<Task> getTaskList() {
        return new ArrayList<>(taskList.values());
    }

    public List<Subtask> getSubtaskList() {
        return new ArrayList<>(subtaskList.values());
    }

    public List<Epic> getEpicList() {
        return new ArrayList<>(epicList.values());
    }

    public void createTask(Task task) {
        if (task != null) {
            task.setId(++counterId);
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

    public void createEpic(Epic epic) {
        if (epic != null) {
            epic.setId(++counterId);
            epicList.put(epic.getId(), epic);
        }
    }

    public void removeEpicById(int id) {
        if (epicList.containsKey(id)) {
            epicList.remove(id);
            for (Subtask subtask : subtaskList.values()) {
                if (subtask.getEpicId() == id) {
                    subtaskList.remove(subtask.getId());
                }
            }
        }
    }

    public Epic getEpicById(int id) {
        return epicList.get(id);
    }

    public void updateEpic(Epic newEpic) {
        for (Epic epic : epicList.values()) {
            if (newEpic.equals(epic)) {
                epicList.replace(newEpic.getId(), epic, newEpic);
            }
        }
    }

    public void removeAllEpics() {
        epicList.clear();
        subtaskList.clear();
    }

    public void createSubtask(Subtask subtask, int epicId) {
        if (subtask != null && epicList.containsKey(epicId)) {
            subtask.setId(++counterId);
            subtask.setEpicId(epicId);
            subtaskList.put(subtask.getId(), subtask);
        }
    }

    public void removeSubtaskById(int id) {
        if (subtaskList.containsKey(id)) {
            Subtask subtask = subtaskList.get(id);
            subtaskList.remove(id);
            calculateEpicStatus(subtask.getEpicId());
        }
    }

    public Subtask getSubtaskById(int id) { return subtaskList.get(id); }

    public void updateSubtask(Subtask newSubtask) {
        for (Subtask subtask : subtaskList.values()) {
            if (newSubtask.equals(subtask)) {
                subtaskList.replace(newSubtask.getId(), subtask, newSubtask);
            }
        }
        calculateEpicStatus(newSubtask.getEpicId());
    }

    public void removeAllSubtask() {
        subtaskList.clear();
        for (int epicId : epicList.keySet()) {
            calculateEpicStatus(epicId);
        }
    }

    public List<Subtask> getSubtasksByEpicId(int id) {
        if (epicList.containsKey(id)) {
            ArrayList<Subtask> subtasksByEpic = new ArrayList<>();
            for (Subtask subtask : subtaskList.values()) {
                if (subtask.getEpicId() == id) {
                    subtasksByEpic.add(subtask);
                }
            }
            return subtasksByEpic;
        }
        return Collections.emptyList();
    }

    private void calculateEpicStatus(int epicId) {
        ArrayList<TaskStatus> statuses = new ArrayList<>();
        Epic epic = epicList.get(epicId);
        for (Subtask subtask : subtaskList.values()) {
            if (subtask.getEpicId() == epicId) {
                statuses.add(subtask.getStatus());
            }
        }

        epic.calculateAndSetStatus(statuses);


    }

}
