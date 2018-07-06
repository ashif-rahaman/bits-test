package com.job.practice.bits.dao;

import com.job.practice.bits.db.models.Employee;
import java.util.List;

/**
 *
 * @author ashif
 */
public interface EmployeeDAO {

    public int insert(Employee employee);

    public int update(Employee employee);

    public int delete(int id);

    public List<Employee> get();
}
