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

    public Collection<Issue> findAll() {
        return issues;
    }

    public Collection<Issue> findOpened() {
        issues.removeIf(el -> !el.isOpened());
        return issues;
    }

    public Collection<Issue> findClosed() {
        issues.removeIf(el -> el.isOpened());
        return issues;
    }

    public Collection<Issue> findByAuthor(String author) {
        Collection<Issue> result = new ArrayList<>();
        for (Issue issue : issues) {
            if (author.equals(issue.getAuthor())) {
                result.add(issue);
            }
        }
        return result;
    }

    public Collection<Issue> findByLabel(Set<String> label) {
        Collection<Issue> result = new ArrayList<>();
        for (Issue issue : issues) {
            if (label.equals(issue.getLabel())) {
                result.add(issue);
            }
        }
        return result;
    }

    public Collection<Issue> findByAssignee(String assignee) {
        Collection<Issue> result = new ArrayList<>();
        for (Issue issue : issues) {
            if (assignee.equals(issue.getAssignee())) {
                result.add(issue);
            }
        }
        return result;
    }


}
