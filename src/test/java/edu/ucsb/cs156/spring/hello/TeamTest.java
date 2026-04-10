package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");
    }

    @Test
    public void getName_returns_correct_name() {
        assert (team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_returns_correct_bool_same_obj() {
        assert (team.equals(team));
    }

    @Test
    public void equals_returns_correct_bool_diff_class() {
        int other = 3;
        assertEquals(team.equals(other), false);
    }

    @Test
    public void equals_returns_correct_bool_same_class_diff_obj() {

        // Same Different

        Team reference = new Team("test-team");
        Team snsm = new Team("test-team");
        reference.addMember("Bob");
        snsm.addMember("Bob");
        assertEquals(reference.getName(), snsm.getName());
        assertEquals(reference.getMembers(), snsm.getMembers());
        assertTrue(reference.equals(snsm));

        // diff version
        snsm.addMember("Bib");
        assertEquals(reference.getName(), snsm.getName());
        assertNotEquals(reference.getMembers(), snsm.getMembers());
        assertFalse(reference.equals(snsm));

        // Different Different
        Team dndm = new Team("different-team");
        dndm.addMember("Not Bob");
        assertNotEquals(reference.getName(), dndm.getName());
        assertNotEquals(reference.getMembers(), dndm.getMembers());
        assertFalse(reference.equals(dndm));

        dndm.addMember("Bob");
        reference.addMember("Not Bob");
        assertNotEquals(reference.getName(), dndm.getName());
        assertNotEquals(reference.getMembers(), dndm.getMembers());
        assertFalse(reference.equals(dndm));

        // Same Different
        Team sndm = new Team("test-team");
        sndm.addMember("Not Bob");
        assertEquals(reference.getName(), sndm.getName());
        assertNotEquals(reference.getMembers(), sndm.getMembers());
        assertFalse(reference.equals(sndm));

        // Different Same
        Team dnsm = new Team("different-team");
        dnsm.addMember("Bob");
        dnsm.addMember("Not Bob");
        assertNotEquals(reference.getName(), dnsm.getName());
        assertEquals(reference.getMembers(), dnsm.getMembers());
        assertFalse(reference.equals(dnsm));

    }

    @Test
    public void test_hashCode() {
        // instantiate t as a Team object
        Team t = new Team("poop-team");
        int result = t.hashCode();
        int expectedResult = -1707745301;
        assertEquals(expectedResult, result);
    }
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
