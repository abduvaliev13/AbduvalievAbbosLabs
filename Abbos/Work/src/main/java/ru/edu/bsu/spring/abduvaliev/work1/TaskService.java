package ru.edu.bsu.spring.abduvaliev.work1;
public class TaskService {
    @Tx
    public void executeStatement(Task input) {
        System.out.println("Credit: ");
        Task output = new Task (input);
        System.out.println("Input: " + output);
        try {

            output.change(new Task(28, "Student", Boolean.TRUE, "Passed"));//ввод данных
        } catch (Exception e) {
            e.printStackTrace();
            output = input;
        }
        System.out.println("Output: " + output);
    }
}
