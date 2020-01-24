package com.mycompany.springmvcweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.Emp;
import com.service.EmpService;
/**
 *
 * @author admin
 */
@Controller
public class EmpController {
	
	private EmpService EmpService;
	
	@Autowired(required=true)
	@Qualifier(value="EmpService")
	public void setEmpService(EmpService empservice){
		this.EmpService = empservice;
	}
	
	@RequestMapping(value = "/emps", method = RequestMethod.GET)
	public String listEmps(Model model) {
		model.addAttribute("Emp", new Emp());
		model.addAttribute("listEmps", this.EmpService.listEmp());
		return "emp";
	}
	
	@RequestMapping(value= "/emp/add", method = RequestMethod.POST)
	public String addEmp(@ModelAttribute("Emp") Emp p){
		
		if(p.getId() == 0){
			//new Emp, add it
			this.EmpService.addEmp(p);
		}else{
			//existing Emp, call update
			this.EmpService.updateEmp(p);
		}
		
		return "redirect:/emp";
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removeEmp(@PathVariable("id") int id){
		
        this.EmpService.removeEmp(id);
        return "redirect:/emp";
    }
 
    @RequestMapping("/edit/{id}")
    public String editEmp(@PathVariable("id") int id, Model model){
        model.addAttribute("Emp", this.EmpService.getEmpById(id));
        model.addAttribute("listEmps", this.EmpService.listEmp ());
        return "emp";
    }
	
}
