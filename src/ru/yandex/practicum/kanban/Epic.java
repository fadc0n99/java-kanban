package ru.yandex.practicum.kanban;

import java.util.List;

public class Epic extends Task {

    public Epic(String title, String description) {
        super(title, description);
    }

    public Epic(String title) {
        super(title);
    }

    @Override
    public void setStatus(TaskStatus status) {
        System.out.println("It is forbidden to change the epic status manually.");
    }

    public void calculateAndSetStatus(List<TaskStatus> statuses) {
        if (statuses.isEmpty()) {
            this.status = TaskStatus.DONE;
        } else {
            for (TaskStatus subtaskStatus : statuses) {
                if (subtaskStatus == TaskStatus.IN_PROGRESS) {
                    this.status = TaskStatus.IN_PROGRESS;
                    break;
                }
            }
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
