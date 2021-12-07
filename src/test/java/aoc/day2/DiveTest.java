package aoc.day2;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class DiveTest {

    private Dive dive;

    @Before
    public void init() {
        dive = new Dive();
    }

    @Test
    public void test_parse_command() {
        String command = "forward 7";
        Dive.Command cmd = dive.parseCommand(command);
        assertNotNull(cmd);
        assertEquals("forward", cmd.getCommandName());
        assertEquals(Integer.valueOf(7), (Integer) cmd.getCommandValue());
    }

    @Test
    public void test_process_command_day1() {
        Position position = new Dive.Day1Position();
        Dive.Command command = new Dive.Command("forward", 7);

        dive.processCommand(command, position);
        assertEquals(7, position.getHorizontalPosition());
        assertEquals(0, position.getDepth());

        command = new Dive.Command("forward", 3);
        dive.processCommand(command, position);
        assertEquals(10, position.getHorizontalPosition());
        assertEquals(0, position.getDepth());

        command = new Dive.Command("down", 5);
        dive.processCommand(command, position);
        assertEquals(10, position.getHorizontalPosition());
        assertEquals(5, position.getDepth());

        command = new Dive.Command("up", 2);
        dive.processCommand(command, position);
        assertEquals(10, position.getHorizontalPosition());
        assertEquals(3, position.getDepth());
    }

    @Test
    public void test_process_list_of_commands_day1() {
        Position position = new Dive.Day1Position();
        List<String> commands = Arrays.asList(
            "forward 5",
            "down 5",
            "forward 8",
            "up 3",
            "down 8",
            "forward 2");

        dive.processCommands(commands, position);

        assertEquals(15, position.getHorizontalPosition());
        assertEquals(10, position.getDepth());
    }

    @Test
    public void test_process_list_of_commands_day2() {
        Position position = new Dive.Day2Position();
        List<String> commands = Arrays.asList(
            "forward 5",
            "down 5",
            "forward 8",
            "up 3",
            "down 8",
            "forward 2");

        dive.processCommands(commands, position);

        assertEquals(15, position.getHorizontalPosition());
        assertEquals(60, position.getDepth());
    }
}
