package ru.netology.repository;

import ru.netology.domain.Issue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class IssueRepository {
    public Collection<Issue> issues = new ArrayList<>();

    public void save(Issue issue) {
        issues.add(issue);
    }

    public Collection<Issue> findOpened() {
        issues.removeIf(el -> !el.isOpened());
        return issues;
    }

    public Collection<Issue> findClosed() {
        issues.removeIf(el -> el.isOpened());
        return issues;
    }

    public Collection<Issue> findByAuthor(Set<String> author) {
        issues.removeIf(el -> !issues.contains(el.getAuthor()));
        return issues;
    }

    public Collection<Issue> findByLabel(Set<String> label) {
        issues.removeIf(el -> !issues.contains(el.getLabel()));
        return issues;
    }

    public Collection<Issue> findByAssignee(Set<String> assignee) {
        issues.removeIf(el -> !issues.contains(el.getAssignee()));
        return issues;
    }

    public void openById(int id) {
        for (Issue issue : issues) {
            if (issue.getId() == id) {
                issue.setOpened(true);
            }
        }
    }

    public void closeById(int id) {
        for (Issue issue : issues) {
            if (issue.getId() == id) {
                issue.setOpened(false);
            }
        }
    }
}
