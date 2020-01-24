package com.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.EmpDAO;
import com.model.Emp;
/**
 *
 * @author admin
 */
@Service
public class EmpServiceImpl implements EmpService {
	
	private EmpDAO EmpDAO;

	public void setEmpDAO(EmpDAO EmpDAO) {
		this.EmpDAO = EmpDAO;
	}

	@Override
	@Transactional
	public void addEmp(Emp e) {
		this.EmpDAO.addEmp(e);
	}

	@Override
	@Transactional
	public void updateEmp(Emp e) {
		this.EmpDAO.updateEmp(e);
	}

	@Override
	@Transactional
	public List<Emp> listEmp() {
		return this.EmpDAO.listEmp();
	}

	@Override
	@Transactional
	public Emp getEmpById(int id) {
		return this.EmpDAO.getEmpById(id);
	}

	@Override
	@Transactional
	public void removeEmp(int id) {
		this.EmpDAO.removeEmp(id);
	}

}
