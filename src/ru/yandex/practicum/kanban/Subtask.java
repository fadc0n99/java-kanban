package ru.yandex.practicum.kanban;

public class Subtask extends Task {
    private int epicId;

    public Subtask(String title, String description) {
        super(title, description);
    }

    public Subtask(String title) {
        super(title);
    }

    public int getEpicId() {
        return epicId;
    }

    public void setEpicId(int epicId) { this.epicId = epicId; }

    @Override
    public String toString() {
        String result = "Subtask{" +
                "title='" + title + "'";
        if (this.description != null) {
            result += ", description='" + description + "'";
        }
        result += ", id=" + id +
                ", epicId=" + epicId +
                ", status=" + status +
                '}';
        return result;
    }
}
