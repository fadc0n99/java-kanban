package ru.yandex.practicum.kanban;

import java.util.ArrayList;
import java.util.List;

public class Epic extends Task {
    private final ArrayList<Integer> subtaskIdList;

    public Epic(String title, String description) {
        super(title, description);
        subtaskIdList = new ArrayList<>();
    }

    public Epic(String title) {
        super(title);
        subtaskIdList = new ArrayList<>();
    }

    @Override
    public void setStatus(TaskStatus status) {
        System.out.println("It is forbidden to change the epic status manually.");
    }

    public List<Integer> getSubtaskIdList() {
        return subtaskIdList;
    }

    public void addSubtaskId(int id) {
        if (!subtaskIdList.contains(id)) {
            subtaskIdList.add(id);
        }
    }

    public void removeSubtaskId(Integer id) {
        subtaskIdList.remove(id);
    }

    public void clearSubtaskIds() {
        subtaskIdList.clear();
    }

    public void calculateAndSetStatus(List<TaskStatus> statuses) {
        if (statuses.isEmpty() || statuses.stream().allMatch(status -> status == TaskStatus.NEW)) {
            this.status = TaskStatus.NEW;
        } else if (statuses.stream().allMatch(status -> status == TaskStatus.DONE)) {
            this.status = TaskStatus.DONE;
        } else {
            this.status = TaskStatus.IN_PROGRESS;
        }
    }

    @Override
    public String toString() {
        String result = "Epic{" +
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
