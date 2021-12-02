package ru.netology.domain;

import java.util.Collections;
import java.util.Set;

public class Issue {
    private int id;
    private String name;
    private boolean isOpened;
    private int date;
    private Set<String> author;
    private Set<String> label;
    private Set<String> assignee;
    private int commentsCount;

    public Issue() {
    }

    public Issue(int id, String name, boolean isOpened, int date, Set<String> author, Set<String> label, Set<String> assignee, int commentsCount) {
        this.id = id;
        this.name = name;
        this.isOpened = isOpened;
        this.date = date;
        this.author = author;
        this.label = label;
        this.assignee = assignee;
        this.commentsCount = commentsCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOpened() {
        return isOpened;
    }

    public void setOpened(boolean opened) {
        isOpened = opened;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public Set<String> getAuthor() {
        return author;
    }

    public void setAuthor(Set<String> author) {
        this.author = author;
    }

    public Set<String> getLabel() {
        return label;
    }

    public void setLabel(Set<String> label) {
        this.label = label;
    }

    public Set<String> getAssignee() {
        return assignee;
    }

    public void setAssignee(Set<String> assignee) {
        this.assignee = assignee;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }
}
