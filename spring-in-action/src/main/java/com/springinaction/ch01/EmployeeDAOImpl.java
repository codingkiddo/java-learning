package com.springinaction.ch01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

public class EmployeeDAOImpl implements EmployeeDAO {

	private DataSource dataSource;

	public EmployeeDAOImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void save(Employee employee) {
	}

	@Override
	public Employee getById(int id) {
		String query = "select id, name, role from Employee where id = ?";
		Employee employee = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				employee = new Employee();
				employee.setId(id);
				employee.setName(resultSet.getString("name"));
				employee.setRole(resultSet.getString("role"));
				System.out.println("Employee Found::" + employee);
			} else {
				System.out.println("No Employee found with id=" + id);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return employee;
	}

	@Override
	public void update(Employee employee) {
	}

	@Override
	public void deleteById(int id) {
	}

	@Override
	public List<Employee> getAll() {
		return null;
	}

}
