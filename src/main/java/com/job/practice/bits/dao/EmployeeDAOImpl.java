package com.job.practice.bits.dao;

import com.job.practice.bits.db.models.Employee;
import com.job.practice.bits.db.util.ConnectToDatabase;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ashif
 */
@Transactional
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private static final ConnectToDatabase connection = ConnectToDatabase.getDBConnection();

    @Override
    public int insert(Employee employee) {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {

            Date dob = null;
            String sql = "";
            if (!employee.getDob().isEmpty()) {
                dob = df.parse(employee.getDob());

                sql = "INSERT INTO employee_info (`name`, `pin`, `father_name`, `mother_name`, `dob`, `salary`) "
                        + "VALUES ('" + employee.getName() + "', '"
                        + employee.getPin() + "', '"
                        + employee.getFatherName() + "', '"
                        + employee.getMotherName() + "', '"
                        + df.format(dob) + "', '"
                        + employee.getSalary() + "');";
            } else {

                sql = "INSERT INTO employee_info (`name`, `pin`, `father_name`, `mother_name`, `salary`) "
                        + "VALUES ('" + employee.getName() + "', '"
                        + employee.getPin() + "', '"
                        + employee.getFatherName() + "', '"
                        + employee.getMotherName() + "', '"
                        + employee.getSalary() + "');";
            }
            connection.getResult(sql);
            return 1;

        } catch (ParseException | NumberFormatException ex) {

            System.out.println(ex.toString());

            return 0;
        }
    }

    @Override
    public int update(Employee employee) {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {

            Date dob = null;
            String sql = "";
            if (!employee.getDob().isEmpty()) {
                dob = df.parse(employee.getDob());

                sql = "UPDATE employee_info SET "
                        + "name='" + employee.getName()
                        + "', pin='" + employee.getPin()
                        + "', father_name='" + employee.getFatherName()
                        + "', mother_name='" + employee.getMotherName()
                        + "', dob='" + df.format(dob) + "', salary='"
                        + employee.getSalary() + "' WHERE id='" + employee.getId() + "'";
            } else {
                sql = "UPDATE employee_info SET "
                        + "name='" + employee.getName()
                        + "', pin='" + employee.getPin()
                        + "', father_name='" + employee.getFatherName()
                        + "', mother_name='" + employee.getMotherName()
                        + "', dob=NULL" + ", salary='"
                        + employee.getSalary() + "' WHERE id='" + employee.getId() + "'";
            }
            connection.getResult(sql);
            return 1;

        } catch (ParseException | NumberFormatException ex) {

            System.out.println(ex.toString());

            return 0;
        }
    }

    @Override
    public int delete(int id) {

        if (id > 0) {

            String sql = "DELETE FROM employee_info WHERE id='" + id + "'";
            connection.getResult(sql);
            return 1;
        }

        return 0;
    }

    @Override
    public List<Employee> get() {

        String sql = "SELECT * FROM employee_info ORDER BY salary";
        List<Employee> employees;

        try {

            ResultSet result = connection.getResult(sql);
            employees = new ArrayList<>();

            while (result.next()) {

                Employee employee = new Employee();
                employee.setId(result.getInt("id"));
                employee.setName(result.getString("name"));
                employee.setMotherName(result.getString("mother_name"));

                if (result.getString("father_name") != null) {

                    employee.setFatherName(result.getString("father_name"));
                }

                if (result.getDate("dob") != null) {
                    employee.setDob(result.getDate("dob").toString());
                }
                employee.setPin(result.getString("pin"));
                employee.setSalary(result.getDouble("salary"));

                employees.add(employee);
            }

            return employees;
        } catch (SQLException e) {

            System.out.println(e.toString());
        }

        return null;
    }
}
