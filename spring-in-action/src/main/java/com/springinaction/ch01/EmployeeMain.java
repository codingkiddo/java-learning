package com.springinaction.ch01;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeMain {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/spring/employees-database.xml");
		
		EmployeeDAO employeeDAO = applicationContext.getBean("employeeDao", EmployeeDAO.class);
		employeeDAO.getById(1);
		
		int id = 1;
		JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
		String query = "select id, name, role from Employee where id = ?";
		Employee employee = jdbcTemplate.queryForObject(query, new Object[] {id}, new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee employee = new Employee();
				employee.setId(rs.getInt("id"));
				employee.setName(rs.getString("name"));
				employee.setRole(rs.getString("role"));
				return employee;
			}
			
		});
		System.out.println("employee found using template -> " + employee);
		((ClassPathXmlApplicationContext)applicationContext).close();
		
	}

}
