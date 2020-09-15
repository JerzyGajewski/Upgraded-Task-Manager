import Dao.TasksDao;
import Dao.UserDao;
import Entity.Tasks;
import Entity.User;

import java.util.*;

public class test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, choose option");
        System.out.println("'new' - create new user");
        System.out.println("'login - login into account");
        System.out.println("'exit' - close app");
        System.out.println("Your choise:");
        while (scanner.hasNext()) {
        String userChoise = scanner.nextLine();
            switch (userChoise.toLowerCase()) {
                case "new":
                    System.out.println("creating new account");
                    UserDao.createNewUser();
                    User user = new User();
                    System.out.println("Enter user name:");
                    user.setUserName(scanner.nextLine());
                    System.out.println("enter email:");
                    user.setEmail(scanner.nextLine());
                    System.out.println("enter passsword");
                    user.setPassword(scanner.nextLine());
                    UserDao.addNewUser(user);
                    System.out.println("Finished creating");
                    System.exit(0);
                    break;
                case "login":
                    System.out.println("enter username:");
                    String name = scanner.nextLine();
                    System.out.println("enter password:");
                    String password = scanner.nextLine();
                    User user1 = UserDao.getByUserName(name);
                    if ( user1 != null && password.equals(user1.getPassword())){
                        System.out.println("Hello " + user1.getUserName());
                        System.out.println("What you would like to do?");
                        System.out.println("1 - create new task");
                        System.out.println("2 - show all tasks");
                        System.out.println("3 - delete task");
                        System.out.println("4 - delete all tasks");
                        System.out.println("5 - options");
                        System.out.println("6 - logout");
                        String choise = scanner.nextLine();
                        switch (choise.toLowerCase()){
                            case "1":
                                System.out.println("creating new task");
                                TasksDao.createNewTask();
                                Tasks tasks = new Tasks();
                                System.out.println("Enter description:");
                                tasks.setDescription(scanner.nextLine());
                                System.out.println("is it important: (true/false)");
                                tasks.setImportant(scanner.nextLine());
                                TasksDao.addNewTask(tasks);
                                System.out.println("Finished creating");
                                break;
                            case "2":
                                List<Tasks> list = TasksDao.showAllTasks();
                                Iterator<Tasks> it = list.iterator();
                                while (it.hasNext()){
                                    Tasks task = it.next();
                                    System.out.println(task.getId() + ". " +task.getDescription() +" "+ task.getImportant());
                                }
                                break;
                            case "3":
                                System.out.println("Select task to remove: ");
                                int taskId = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println("Are you sure to delete task " + taskId +" ?");
                                String answer = scanner.nextLine();
                                switch(answer.toLowerCase()){
                                    case "yes":
                                    TasksDao.deleteTask(taskId);
                                    System.out.println("Task deleted");
                                    break;
                                    case "no":
                                        break;
                                    default:
                                        System.out.println("Type yes/no");
                                }
                                break;
                            case "4":
                                System.out.println("Are you sure to delete all tasks?");
                                String answer2 = scanner.nextLine();
                                switch(answer2.toLowerCase()){
                                    case "yes":
                                        TasksDao.deleteAllTasks();
                                        System.out.println("Task deleted");
                                        break;
                                    case "no":
                                        break;
                                    default:
                                        System.out.println("Type yes/no");
                                }
                                break;
                            case "5":
                                System.out.println("Options:");
                                System.out.println("1 - edit user");
                                System.out.println("2 - delete account");
                                int respond = scanner.nextInt();
                                scanner.nextLine();
                                switch (respond){
                                    case 1:

                                    case 2:
                                        System.out.println("Are you sure?");
                                        String answer3 = scanner.nextLine();
                                        if(answer3.toLowerCase().equals("yes")){

                                        }

                                }
                                break;
                            case "6":
                                break;
                            default:
                                System.out.println("wrong commend, try again!");



                        }
                    }else {
                        System.out.println("Wrong login or password, try again");
                    }
                    break;
                case "exit":
                    System.out.println("Bye Bye");
                    System.exit(0);
                    break;
                default:
                    System.out.println("wrong commend, try again");
                    System.out.println("Write");

            }
        }
    }
}
