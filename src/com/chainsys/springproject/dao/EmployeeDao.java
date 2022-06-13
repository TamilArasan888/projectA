package com.chainsys.springproject.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class EmployeeDao {
	private Connection oracleConnection;
	// Init-method
		private void getConnection() {
			String drivername = "oracle.jdbc.OracleDriver";
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			String username = "system";
			String password = "Jeffrey888";
			try {
				Class.forName(drivername);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			try {
				oracleConnection = DriverManager.getConnection(dbUrl, username, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		public static java.sql.Date convertTosqlDate(java.util.Date date) {
			return  new java.sql.Date(date.getTime());
		}
		public static java.util.Date sqltoUtilconvert(java.sql.Date date){
			return new java.util.Date(date.getTime());
		}

	// To insert new row to the table employees
		public int insertEmployee(Employee newemp) {
			String insertquery = "insert into employees(EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,HIRE_DATE,JOB_ID,SALARY) values (?,?,?,?,?,?,?)";
			Connection mycon = oracleConnection;
			int rows = 0;
			PreparedStatement ps = null;
			try {
				ps = mycon.prepareStatement(insertquery);
				ps.setInt(1, newemp.getE_Id());
				ps.setString(2, newemp.getFirst_Name());
				ps.setString(3, newemp.getLast_Name());
				ps.setString(4, newemp.getEmail());
				// convert java.util.Date to java.sql.date
				ps.setDate(5, convertTosqlDate(newemp.getHire_Date()));
				ps.setString(6, newemp.getJob_ID());
				ps.setFloat(7, newemp.getSalary());

				rows = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace(); // TODO: ExceptionManager
			} finally {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace(); // TODO: ExceptionManager
				}
				try {
					mycon.close();
				} catch (SQLException e) {
					e.printStackTrace(); // TODO: ExceptionManager
				}
			}
			return rows;
		}

	// for updating all the columns of the table
		public int updateEmployee(Employee newemp) {
			String updatequery = "update employees set FIRST_NAME=?,LAST_NAME=?,EMAIL=?,HIRE_DATE=?,JOB_ID=?,SALARY=? where employee_id=?";
			Connection con = null;
			int rows = 0;
			PreparedStatement ps = null;
			try {
				con = oracleConnection;
				ps = con.prepareStatement(updatequery);
				ps.setString(1, newemp.getFirst_Name());
				ps.setInt(7, newemp.getE_Id());
				ps.setString(2, newemp.getLast_Name());
				ps.setString(3, newemp.getEmail());
				// convert java.util.Date to java.sql.date
				ps.setDate(4, convertTosqlDate(newemp.getHire_Date()));
				ps.setString(5, newemp.getJob_ID());
				ps.setFloat(6, newemp.getSalary());

				ps.executeUpdate();
				rows = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace(); // TODO: ExceptionManager
			} finally {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace(); // TODO: ExceptionManager
				}
			}

			return rows;
		}

		// to update only one column of the table
		public int updateEmployeeFirstName(int id, String fname) {
			String updatequery = "update employees set FIRST_NAME=? where employee_id=?";
			Connection con = null;
			int rows = 0;
			PreparedStatement ps = null;
			try {
				con = oracleConnection;
				ps = con.prepareStatement(updatequery);
				ps.setString(1, fname);
				ps.setInt(2, id);
				ps.executeUpdate();
				rows = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace(); // TODO: ExceptionManager
			} finally {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace(); // TODO: ExceptionManager
				}
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			return rows;
		}

		public int updateEmployeeSalary(int id, float salary) {
			String updatequery = "update employees set SALARY=? where employee_id=?";
			Connection con = null;
			int rows = 0;
			PreparedStatement ps = null;
			try {
				con = oracleConnection;
				ps = con.prepareStatement(updatequery);
				ps.setDouble(1, salary);
				ps.setInt(2, id);
				ps.executeUpdate();
				rows = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace(); // TODO: ExceptionManager
			} finally {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace(); // TODO: ExceptionManager
				}
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return rows;
		}

		public int deleteEmployee(int id) {
			Connection mycon = oracleConnection;
			PreparedStatement ps = null;
			int rows=0;

			try {
				ps = mycon.prepareStatement("delete from employees where EMPLOYEE_ID=?");
				ps.setInt(1, id);
				rows = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace(); // TODO: ExceptionManager
			} finally {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace(); // TODO: ExceptionManager
				}
			}
			return rows;
		}

		// To retrieve specific Employee data using employee_id
		public Employee getEmployeeById(int id) {
			Connection mycon = oracleConnection;
			PreparedStatement ps = null;
			ResultSet rs = null;
			Employee emp=null;
			try {
				ps = mycon.prepareStatement("select EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,HIRE_DATE,JOB_ID,SALARY  from Employees where employee_id = ? ");
				ps.setInt(1, id);
				rs = ps.executeQuery();
				emp = new Employee();
				if (rs.next()) {
					emp.setE_Id(rs.getInt(1));
					emp.setFirst_Name(rs.getString(2));
					emp.setLast_Name(rs.getString(3));
					emp.setEmail(rs.getString(4));
					java.util.Date date = new java.util.Date(rs.getDate(5).getTime());
					// date retrieved from the database will be of type java.sql.Date
					// (rs.getDate(5))
					// emp.setHire_date requires date of type java.util.Date
					// so we are converting sql Date to util Date
					// the constructor of java.util.Date requires a long value
					// so we use the getTime() which returns the sql date as a long value.
					emp.setHire_Date((Date) date);
					emp.setJob_ID(rs.getString(6));
					emp.setSalary(rs.getInt(7));
				}
			} catch (SQLException e) {
				e.printStackTrace(); // TODO: ExceptionManager
			} finally {
				try {
					rs.close();
				} catch (SQLException e1) {
					e1.printStackTrace(); // TODO: ExceptionManager
				}
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace(); // TODO: ExceptionManager
				}
			}
			return emp;

		}

		// To retrieve all employee data
		public List<Employee> getAllEmployee() {
			List<Employee> listOfEmployees = new ArrayList<Employee>();
			Employee emp = null;
			String selectquery = "select EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,HIRE_DATE,JOB_ID,SALARY  from EMPLOYEES ";
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				con = oracleConnection;
				ps = con.prepareStatement(selectquery);
				rs = ps.executeQuery();
				emp = new Employee();
				if (rs.next()) {
					emp.setE_Id(rs.getInt(1));
					emp.setFirst_Name(rs.getString(2));
					emp.setLast_Name(rs.getString(3));
					emp.setEmail(rs.getString(4));
					java.util.Date date = new java.util.Date(rs.getDate(5).getTime());
					emp.setHire_Date((Date) date);
					emp.setJob_ID(rs.getString(6));
					emp.setSalary(rs.getInt(7));
					listOfEmployees.add(emp);
				}
			} catch (SQLException e) {
				e.printStackTrace(); // TODO: ExceptionManager
			} finally {
				try {
					rs.close();
				} catch (SQLException e1) {
					e1.printStackTrace(); // TODO: ExceptionManager
				}
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace(); // TODO: ExceptionManager
				}
			}
			return listOfEmployees;
		}
		//destroy-method
		public void close() 
		{
			System.out.println("close");
			try {
				oracleConnection.close();
			} catch (SQLException e) {
				e.printStackTrace(); // TODO: ExceptionManager
			}
		}
	}


