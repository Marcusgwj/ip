public class EventCommand extends Command {
    private TaskList taskList;
    private String[] inputArr;

    public EventCommand(TaskList taskList, String[] inputArr) {
        this.taskList = taskList;
        this.inputArr = inputArr;
    }

    @Override
    public String action() throws DukeException{
        if (this.inputArr.length < 2) {
            throw new DukeException("The description of an event cannot be empty.");
        }
        String[] descriptionDate = this.inputArr[1].split(" /at ", 2);
        if (descriptionDate.length < 2) {
            throw new DukeException("The date of an event cannot be empty.");
        }
        String description = descriptionDate[0];
        String date = descriptionDate[1];
        Event event = new Event(description, date);
        this.taskList.addTask(event);
        return ("Got it. I've added this task: " + "\n"
                + event + "\n"
                + "Now you have " + this.taskList.getSize() + " tasks in the list." + "\n");
    }
}