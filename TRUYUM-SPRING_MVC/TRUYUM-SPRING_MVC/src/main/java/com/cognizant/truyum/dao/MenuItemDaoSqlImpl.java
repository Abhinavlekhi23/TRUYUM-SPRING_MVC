package com.cognizant.truyum.dao;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cognizant.truyum.controller.MenuItemController;
import com.cognizant.truyum.model.MenuItem;

@Component("menuItemDao")
public class MenuItemDaoSqlImpl implements MenuItemDao{
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class);

	public List<MenuItem> getMenuItemListAdmin() throws ClassNotFoundException, SQLException {
		LOGGER.info("Start");
		Connection connection = ConnectionHandler.getConnection();
		ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();
		PreparedStatement preparedStatement = connection.prepareStatement("select * from menu_item;");
		ResultSet resultSet = preparedStatement.executeQuery();
		MenuItem menuItem = null;
		while (resultSet.next()) {
			menuItem = new MenuItem(resultSet.getLong(1), resultSet.getString(2), resultSet.getFloat(3),
					resultSet.getBoolean(4), resultSet.getDate(5), resultSet.getString(6), resultSet.getBoolean(7));
			menuItemList.add(menuItem);
		}
		LOGGER.info("End");
		return menuItemList;
	}

	public List<MenuItem> getMenuItemListCustomer() throws ClassNotFoundException, SQLException {
		LOGGER.info("Start");
		Connection connection = ConnectionHandler.getConnection();
		ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();
		PreparedStatement preparedStatement = connection
				.prepareStatement("select * from menu_item where active=1 and dateOfLaunch<=CURDATE();");
		ResultSet resultSet = preparedStatement.executeQuery();
		MenuItem menuItem = null;
		while (resultSet.next()) {
			menuItem = new MenuItem(resultSet.getLong(1), resultSet.getString(2), resultSet.getFloat(3),
					resultSet.getBoolean(4), resultSet.getDate(5), resultSet.getString(6), resultSet.getBoolean(7));
			menuItemList.add(menuItem);
		}
		LOGGER.info("End");
		return menuItemList;
	}

	public MenuItem getMenuItem(long menuItemId) throws ClassNotFoundException, SQLException {
		LOGGER.info("Start");
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("select * from menu_item where id='" + menuItemId + "';");
		ResultSet resultSet = preparedStatement.executeQuery();
		resultSet.next();
		MenuItem menuItem = new MenuItem(resultSet.getLong(1), resultSet.getString(2), resultSet.getFloat(3),
				resultSet.getBoolean(4), resultSet.getDate(5), resultSet.getString(6), resultSet.getBoolean(7));
		LOGGER.info("End");
		return menuItem;
	}

	public void modifyMenuItem(MenuItem menuItem) throws ClassNotFoundException, SQLException {
		LOGGER.info("Start");
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(
				"update menu_item set name=? , price=? , active=? , dateOfLaunch=? , category=? , freeDelivery=? where id=?;");
		preparedStatement.setString(1, menuItem.getName());
		preparedStatement.setFloat(2, menuItem.getPrice());
		preparedStatement.setBoolean(3, menuItem.isActive());
		preparedStatement.setDate(4, new Date(menuItem.getDateOfLaunch().getTime()));
		preparedStatement.setString(5, menuItem.getCategory());
		preparedStatement.setBoolean(6, menuItem.isFreeDelivery());
		preparedStatement.setLong(7, menuItem.getId());
		preparedStatement.executeUpdate();
		LOGGER.info("End");
	}

}
