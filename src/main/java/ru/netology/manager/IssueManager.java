package ru.netology.manager;

import ru.netology.domain.Issue;
import ru.netology.repository.IssueRepository;

import java.util.Collection;
import java.util.Set;

public class IssueManager {
    private IssueRepository repository = new IssueRepository();

    public IssueManager() {
    }

    public IssueManager(IssueRepository repository) {
        this.repository = repository;
    }

    public void add(Issue issue) {
        repository.save(issue);
    }

    public Collection<Issue> findOpened() {
        return repository.findOpened();

    }

    public Collection<Issue> findClosed() {
        return repository.findClosed();
    }

    public Collection<Issue> findByAuthor(Set<String> author) {
        return repository.findByAuthor(author);
    }

    public Collection<Issue> findByLabel(Set<String> label) {
        return repository.findByLabel(label);
    }

    public Collection<Issue> findByAssignee(Set<String> assignee) {
        return repository.findByAssignee(assignee);
    }

    public void openById(int id) {
        repository.openById(id);
    }

    public void closeById(int id) {
        repository.closeById(id);
    }
}
