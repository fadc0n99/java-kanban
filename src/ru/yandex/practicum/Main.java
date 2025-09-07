package ru.yandex.practicum;

import ru.yandex.practicum.kanban.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        System.out.println("TaskManager готов к работе! " + taskManager);

        /*
            Тестируем обычные задачи
        */
        Task task = new Task("Доделать проект");
        Task task1 = new Task("Купить хлеб");
        taskManager.createTask(task);
        taskManager.createTask(task1);

        List<Task> listTask = taskManager.getTaskList();
        for (Task t : listTask) {
            System.out.println(t);
        }
        System.out.println();

        task.setStatus(TaskStatus.IN_PROGRESS);
        taskManager.updateTask(task);

        listTask = taskManager.getTaskList();
        for (Task t : listTask) {
            System.out.println(t);
        }
        System.out.println();

        System.out.println(taskManager.getTaskById(1));
        taskManager.removeTaskById(1);
        System.out.println(taskManager.getTaskById(1));
        taskManager.removeAllTasks();
        listTask = taskManager.getTaskList();
        for (Task t : listTask) {
            System.out.println(t);
        }
        System.out.println();

        /*
            Тестируем эпики и подзадачи
        */
        Epic epic = new Epic("Приготовить ужин");
        Subtask subtask = new Subtask("Купить продукты");
        subtask.setStatus(TaskStatus.IN_PROGRESS);
        Subtask subtask1 = new Subtask("Помыть посуду");

        taskManager.createEpic(epic);
        taskManager.createSubtask(subtask, 3);
        taskManager.createSubtask(subtask1, 3);

        Epic epic2 = new Epic("Эпик");
        Subtask subtask3 = new Subtask("Подзадача", "Задача эпика");
        taskManager.createEpic(epic2);
        subtask3.setStatus(TaskStatus.DONE);
        taskManager.createSubtask(subtask3, 6);

        List<Subtask> subtaskList = taskManager.getSubtaskList();
        List<Epic> epicList = taskManager.getEpicList();

        System.out.println();
        for (Epic e : epicList) {
            System.out.println(e);
        }
        for (Subtask s : subtaskList) {
            System.out.println(s);
        }
        System.out.println();

        taskManager.removeEpicById(6);
        subtaskList = taskManager.getSubtaskList();
        epicList = taskManager.getEpicList();

        System.out.println();
        for (Epic e : epicList) {
            System.out.println(e);
        }
        for (Subtask s : subtaskList) {
            System.out.println(s);
        }
        System.out.println();

        Subtask st = taskManager.getSubtaskById(4);
        st.setTitle("Купить молоко");
        taskManager.updateSubtask(st);
        taskManager.removeSubtaskById(5);

        List<Subtask> listSubtask = taskManager.getSubtasksByEpicId(3);

        System.out.println();
        for (Subtask s : listSubtask) {
            System.out.println(s);
        }

        System.out.println();
        System.out.println("Список всех задач после удаления");
        taskManager.removeAllTasks();
        taskManager.removeAllSubtask();
        taskManager.removeAllEpics();

        listSubtask = taskManager.getSubtasksByEpicId(3);
        System.out.println(listSubtask.size());



    }
}
