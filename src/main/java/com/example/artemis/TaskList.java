package com.example.artemis;

import java.util.ArrayList;

/**
 * Represents a list of tasks in the Artemis application.
 */
public class TaskList {
    private ArrayList<Task> tasks;

    /**
     * Constructs an empty TaskList.
     */
    public TaskList() {
        tasks = new ArrayList<>();
    }

    /**
     * Constructs a TaskList with the specified list of tasks.
     *
     * @param tasks The list of tasks to initialize the TaskList.
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Adds a task to the TaskList.
     *
     * @param task The task to be added.
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Deletes a task from the TaskList based on the specified index.
     *
     * @param index The index of the task to be deleted.
     */
    public void deleteTask(int index) {
        assert index >= 0 : "Index must be non-negative";
        assert index < tasks.size() : "Index must be within the bounds of the list";
        tasks.remove(index);
    }

    /**
     * Retrieves the list of tasks from the TaskList.
     *
     * @return The list of tasks in the TaskList.
     */
    public ArrayList<Task> getTasks() {
        return tasks;
    }
}
