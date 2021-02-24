package com.example.TaskManager.Controllers;

import com.example.TaskManager.entities.Task;
import com.example.TaskManager.exceptions.TaskNotFoundException;
import com.example.TaskManager.exceptions.UserNotFoundException;
import com.example.TaskManager.services.TaskService;
import com.example.TaskManager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Optional;

@Controller
@SessionAttributes("name")
public class TaskController {

    @Autowired
    TaskService taskService;
    @Autowired
    UserService userService;


    //GETMAPPING--------------------------------------------

    @RequestMapping(value = "/display-tasks", method = RequestMethod.GET)
    public String displayTasks(ModelMap model) {
        System.out.println("display tasks: get");
        String name = (String) model.get("name");
        Iterable<Task> tasks = taskService.GetAllTasks();
        for(Task task:tasks){
            System.out.println(task.toString());
        }
        model.put("tasks", taskService.GetAllTasks());
        return "display-tasks";
    }

    @RequestMapping(value = "/create-task", method = RequestMethod.GET)
    public String showCreateTask(ModelMap model){
        System.out.println("update tasks: get");
        return "display-task";
    }

    @RequestMapping(value = "/update-task", method = RequestMethod.GET)
    public String showUpdateTask(ModelMap model){
        System.out.println("update tasks: get");
        Integer id=(Integer)model.get("taskID");
        Optional<Task> task;
        try {
            task=taskService.getTaskByID(id);
        }catch (TaskNotFoundException e) {
            model.put("Error", "not-found-error");
        }
        return "create-task";
    }

    @RequestMapping
    public String showDeleteTask(ModelMap model){
        System.out.println("delete tasks: get");
        return "display-task";}

    //POSTMAPPING------------------------------------------------------

    @RequestMapping(value = "/delete-tasks", method = RequestMethod.POST)
    public String submitDeleteTask(ModelMap model, @RequestParam Integer id, @RequestParam String agree){
        System.out.println("delete tasks: post");
        int ID=id;
        if(agree.equals("yes")) {
            Optional<Task> oTask = taskService.getTaskByID(ID);
            if (oTask.isPresent()) {
                Task task = oTask.get();
                taskService.deleteTask(task);
            } else {
                model.put("Error", "not-found-error");
            }
        }
        return "delete-tasks";
    }


    @RequestMapping(value = "/create-tasks", method = RequestMethod.POST)
    public String submitCreateTask(ModelMap model, @RequestParam String name,
                                   @RequestParam Date startdate, @RequestParam Date enddate,
                                   @RequestParam String description, @RequestParam String email,
                                   @RequestParam String severity, @RequestParam String userName){
        System.out.println("create tasks: post");
        model.put("name", name);
        Task task=new Task();
        task.setName(name);
        task.setStartDate(startdate);
        task.setEndDate(enddate);
        task.setDescription(description);
        task.setEmail(email);
        task.setSeverity(severity);
        task.setUser(userService.getUserByName(userName));
        if(task.getUser()==null){
            throw new UserNotFoundException(userName);
        }
        taskService.addTask(task);
        return "create-task";
    }

    @RequestMapping(value = "/update-tasks", method = RequestMethod.POST)
    public String submitUpdateTask(ModelMap model, @RequestParam Integer taskID,
                                   @RequestParam String name, @RequestParam Date startdate,
                                   @RequestParam Date enddate, @RequestParam String description,
                                   @RequestParam String email, @RequestParam String severity,
                                   @RequestParam String userName){
        System.out.println("create tasks: post");
        try {
            taskService.getTaskByID(taskID);
            }catch (Exception e){
            throw new TaskNotFoundException(taskID);
        }
        model.put("name", name);
        Task task=new Task();
        task.setName(name);
        task.setStartDate(startdate);
        task.setEndDate(enddate);
        task.setDescription(description);
        task.setEmail(email);
        task.setSeverity(severity);
        task.setUser(userService.getUserByName(userName));
        if(task.getUser()==null){
            throw new UserNotFoundException(userName);
        }
        taskService.addTask(task);
        return "update-task";
    }

    @RequestMapping(value = "/display-tasks", method = RequestMethod.POST)
    public String submitDisplayTask(ModelMap model, @RequestParam String action){
        System.out.println("display tasks: post");
        if(action.equals("delete")){
            return "delete-tasks";
        }else if(action.equals("update")){
            return "update-tasks";
        }else {
            return "create-tasks";
        }

    }






}
