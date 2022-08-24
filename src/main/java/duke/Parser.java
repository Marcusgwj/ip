package duke;

import duke.command.*;
import duke.exception.DukeException;
import duke.task.TaskList;


public class Parser {

    public Command parseCommand(String userInput, TaskList taskList) {
        try {
            String [] inputArr = userInput.split(" ", 2);
            CommandType command = CommandType.parse(inputArr[0]);
            switch (command) {
            case BYE:
                return new ExitCommand();
            case LIST:
                return new ListCommand(taskList);
            case MARK:
                return new MarkCommand(taskList, inputArr);
            case UNMARK:
                return new UnmarkCommand(taskList, inputArr);
            case TODO:
                return new ToDoCommand(taskList, inputArr);
            case EVENT:
                return new EventCommand(taskList, inputArr);
            case DEADLINE:
                return new DeadlineCommand(taskList, inputArr);
            case DELETE:
                return new DeleteCommand(taskList, inputArr);
            case FIND:
                return new FindCommand(taskList, inputArr);
            }
        } catch (DukeException e) {
            return new InvalidCommand(e.getMessage());
        }
        return new InvalidCommand("Invalid command.");
    }
}

