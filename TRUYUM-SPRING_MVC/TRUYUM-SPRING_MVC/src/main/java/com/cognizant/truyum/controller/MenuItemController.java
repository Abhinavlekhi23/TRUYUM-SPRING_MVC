package com.cognizant.truyum.controller;

import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cognizant.truyum.dao.MenuItemDaoSqlImpl;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;

@Controller
public class MenuItemController {
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class);
	@Autowired
	private MenuItemService menuItemService;

	@GetMapping("/show-menu-list-admin")
	public String showMenuItemListAdmin(ModelMap model) throws Exception {
		LOGGER.info("Start");
		List<MenuItem> menuItemList = menuItemService.getMenuListAdmin();
		model.put("menuItemList", menuItemList);
		LOGGER.info("End");
		return "menu-item-list-admin";
	}
	@GetMapping("/show-menu-list-customer")
	public String showMenuItemListCustomer(ModelMap model) throws Exception{
		LOGGER.info("Start");
		List<MenuItem> menuItemList = menuItemService.getMenuListCustomer();
		model.put("menuItemList", menuItemList);
		LOGGER.info("End");
		return "menu-item-list-customer";
	}
	@GetMapping("/show-edit-menu-item")
	public String showEditMenuItem(ModelMap model, @RequestParam("menuItemId") long id) throws ClassNotFoundException, SQLException {
		LOGGER.info("Start");
		MenuItem item = menuItemService.getMenuItem(id);
		model.put("menuItem", item);
		LOGGER.info("End");
		return "edit-menu-item";		
	}
	@PostMapping("/edit-menu-item")
	@ResponseBody
	public String editMenuItem(@Valid @RequestAttribute MenuItem item, BindingResult bindingResult) {
		LOGGER.info("Start");
		if(bindingResult.hasErrors()) {
			System.out.println(bindingResult.getFieldErrors());
		}
		System.out.println(item.getName());
		LOGGER.info("End");
		return "NULL";
	}
}
