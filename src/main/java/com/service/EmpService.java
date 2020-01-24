package com.service;

import java.util.List;

import com.model.Emp;
/**
 *
 * @author admin
 */
public interface EmpService {

	public void addEmp(Emp emp);
	public void updateEmp(Emp emp);
	public List<Emp> listEmp();
	public Emp getEmpById(int id);
	public void removeEmp(int id);
	
}
