package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class IssueManagerTest {
    IssueManager manager = new IssueManager();
    Issue issue1 = new Issue(1, "Bug1", true, 1, "Erwin", Set.of("Java"), "Eren", 10);
    Issue issue2 = new Issue(2, "Bug2", true, 1, "Erwin", Set.of("Python"), "Levi", 50);
    Issue issue3 = new Issue(3, "Bug3", false, 1, "Levi", Set.of("Python"), "Mikasa", 1);
    Issue issue4 = new Issue(4, "Bug4", false, 1, "Armin", Set.of("JavaScript"), "Eren", 15);

    @BeforeEach
    public void setUp() {
        manager.add(issue1);
        manager.add(issue2);
        manager.add(issue3);
        manager.add(issue4);
    }

    @Test
    void shouldFindOpened() {
        Collection<Issue> expected = List.of(issue1, issue2);
        Collection<Issue> actual = manager.findOpened();
        assertEquals(expected, actual);

    }

    @Test
    void shouldFindClosed() {
        Collection<Issue> expected = List.of(issue3, issue4);
        Collection<Issue> actual = manager.findClosed();
        assertEquals(expected, actual);
    }

    @Test
    void findByAuthor() {
        Collection<Issue> expected = List.of(issue1, issue2);
        Collection<Issue> actual = manager.findByAuthor("Erwin");
        assertEquals(expected, actual);
    }

    @Test
    void findByLabel() {
        Collection<Issue> expected = List.of(issue2, issue3);
        Collection<Issue> actual = manager.findByLabel(Set.of("Python"));
        assertEquals(expected, actual);
    }

    @Test
    void findByAssignee() {
        Collection<Issue> expected = List.of(issue1, issue4);
        Collection<Issue> actual = manager.findByAssignee("Eren");
        assertEquals(expected, actual);
    }

    @Test
    void openById() {
        manager.openById(3);
        Collection<Issue> expected = List.of(issue1, issue2, issue3);
        Collection<Issue> actual = manager.findOpened();
        assertEquals(expected, actual);
    }

    @Test
    void closeById() {
        manager.closeById(2);
        Collection<Issue> expected = List.of(issue2, issue3, issue4);
        Collection<Issue> actual = manager.findClosed();
        assertEquals(expected, actual);
    }
}