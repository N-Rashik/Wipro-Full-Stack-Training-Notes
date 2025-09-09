package com.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.model.Task;
import com.company.model.User;
import com.company.service.TaskService;
import com.company.service.UserServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	@Autowired
	private TaskService taskService;//used to manage tasks
	@Autowired 
	private UserServiceImpl userService;//used to manage user authentication and registration
	 //Handles GET requets to home page
	@GetMapping("/") // Handle requests to the home page
	    public String showHomePage() {
	        return "home";  // This will load home.html from templates folder
	    }
	 //Handles GET request for /log shows the login page
	 @GetMapping("/log")
	 public String showLoginPage() {
	     return "login";  // Loads login.html
	 }
	 //handles POST requests when login form is submitted.
	 @PostMapping("/authenticate")
	 public String AuthenticateUser(@RequestParam("username") String username,
	                                @RequestParam("pword") String password,
	                                Model model, HttpServletRequest req) {
	     
	     User u = new User(username, password);
	     if (userService.findUser(u)) {
	         HttpSession session = req.getSession();
	         session.setAttribute("username", username);
	         return "redirect:/service";  // Redirect to success page
	     }
	     model.addAttribute("message", "Invalid Username/Password");
	     return "display";  // Show error page if login fails
	 }
	 
	 //Page shown after login
	    @GetMapping("/service")
	    public String showServicePage(HttpServletRequest req, Model model) {
	        HttpSession session = req.getSession(false);
	        if (session != null && session.getAttribute("username") != null) {
	            model.addAttribute("username", session.getAttribute("username"));
	            return "service";  // Show service.html
	        }
	        return "redirect:/log";  // Redirect to login if session doesn't exist
	    }
	    //loads page with all tasks
	@GetMapping("/addtask")
	public String index(Model model)
	{
		model.addAttribute("tasks",taskService.getAllTasks());
		return "index"; 
	}
	//shows the form to add new task
	@GetMapping("/add")
	public String addTaskForm(Model model)
	{
		model.addAttribute("task",new Task());
		System.out.println("Add Task");
		return "add"; 
	}
	//handles form submission for adding a task
	@PostMapping("/save")
	public String saveTask(@ModelAttribute Task task)
	{
		taskService.saveTask(task);
		return "redirect:/addtask";
	}
	//Shows the registration page for new users
	 @GetMapping("/register")
	    public String showRegisterPage() {
	        return "register";  // Load register.html
	    }
	    @PostMapping("/register")
	    public String registerUser(@RequestParam("username") String username,
	                               @RequestParam("password") String password,
	                               Model model) {
	        User user = new User(username, password);
	        String result = userService.registerUser(user);
	        if (result.equals("User registered successfully!")) {
	            return "redirect:/log";  // Redirect to login page
	        } else {
	            model.addAttribute("message", result);
	            return "register";  // Stay on register page if username exists
	        }
	    }
}