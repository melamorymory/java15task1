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
    Issue issue1 = new Issue(1, "Bug1", true, 1, Set.of("Erwin"), Set.of("Java"), Set.of("Eren"), 10);
    Issue issue2 = new Issue(2, "Bug2", true, 1, Set.of("Erwin"), Set.of("Python"), Set.of("Levi"), 50);
    Issue issue3 = new Issue(3, "Bug3", false, 1, Set.of("Levi"), Set.of("Python"), Set.of("Mikasa"), 1);
    Issue issue4 = new Issue(4, "Bug4", false, 1, Set.of("Armin"), Set.of("JavaScript"), Set.of("Eren"), 15);

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
        assertEquals(actual, expected);

    }

    @Test
    void shouldFindClosed() {
        Collection<Issue> expected = List.of(issue3, issue4);
        Collection<Issue> actual = manager.findClosed();
        assertEquals(actual, expected);
    }

    @Test
    void findByAuthor() {
        Collection<Issue> expected = List.of(issue1, issue2);
        Collection<Issue> actual = manager.findByAuthor(Set.of("Erwin"));
        assertEquals(actual, expected);
    }

    @Test
    void findByLabel() {
    }

    @Test
    void findByAssignee() {
    }

    @Test
    void openById() {
        manager.openById(3);
        Collection<Issue> expected = List.of(issue1, issue2, issue3);
        Collection<Issue> actual = manager.findOpened();
        assertEquals(actual, expected);
    }

    @Test
    void closeById() {
        manager.closeById(2);
        Collection<Issue> expected = List.of(issue2, issue3, issue4);
        Collection<Issue> actual = manager.findClosed();
        assertEquals(actual, expected);
    }
}