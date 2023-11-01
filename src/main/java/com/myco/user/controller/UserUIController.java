package com.myco.user.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myco.user.model.User;
import com.myco.user.service.UserESService;
import com.myco.user.util.UserUtil;

@Controller
public class UserUIController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserUIController.class);

	@Autowired
	private UserESService userESService;

//	@Autowired
//	private UserUtil userUtil;

	@GetMapping("/")
	public String viewUserPage(Model model) throws IOException {
		LOGGER.info(">>>> viewUserPage() ");
		List<User> users = userESService.getAllDocuments();
		model.addAttribute("user", users);

		if (users.isEmpty()) {
			LOGGER.info("<<<< user list is empty <<<< navigating to error page ");
			return "error";
		}
		LOGGER.info("<<<< viewUserPage() <<<< user list : {} ", users);
		return "home";
	}

	@GetMapping("/navigateAddNewUser")
	public String navigateToNewUserPage(Model model) throws IOException {
		LOGGER.info(">>>> navigateToNewUserPage() ");
		return "newUser";
	}

	@PostMapping("/addNewUser")
	public String addNewUser(@ModelAttribute User user, Model model) throws IOException {
		LOGGER.info(">>>> addNewUser() , User : {} " , user);
		if (null == user.getCreated()) {
			user.setCreated(new Date());
		}
		user.setUpdate(new Date());
		String message = userESService.saveUser(user);
		if (null != message) {
			LOGGER.info("<<<< addNewUser(), message: {} ", message);
			model.addAttribute("message", message);
		} else {
			return "error";
		}
		return viewUserPage(model);
	}

	@GetMapping("/delete")
	public String deleteUser(@RequestParam("id") String id, Model model) throws IOException {
		LOGGER.info(">>>> deleteUser() , user id: {} ", id);
		String message = userESService.deleteUser(id);
		if (null != message) {
			LOGGER.info("<<<< deleteUser(), message: {} ", message);
			model.addAttribute("message", message);
		}
		return viewUserPage(model);
	}

	@GetMapping("/update")
	public String updateUser(@RequestParam("id") String id, Model model) throws IOException {
		LOGGER.info(">>>> updateUser() , user id: {} ", id);
		User user = userESService.updateUser(id);
		LOGGER.info("<<<< updateUser(), user: {} ", user);
		model.addAttribute("user", user);
		return "updateUser";
	}
}
