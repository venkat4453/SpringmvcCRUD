package com.dao;

import com.model.Emp;
import java.util.List;
/**
 *
 * @author admin
 */
public interface EmpDAO {

	public void addEmp(Emp empdata);
	public void updateEmp(Emp empdata);
	public List<Emp> listEmp();
	public Emp getEmpById(int id);
	public void removeEmp(int id);
}
