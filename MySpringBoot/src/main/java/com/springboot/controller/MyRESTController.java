package com.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.application.MyConstants;
import com.springboot.model.Employee;
import com.springboot.services.EmployeeService;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = MyConstants.API_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class MyRESTController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MyRESTController.class);
	
	@Autowired
	EmployeeService employeeService;
	
	@ApiOperation(value = MyConstants.GET_EMP_API_DOC_VALUE, nickname = MyConstants.GET_EMP_API_DOC_VALUE, notes = MyConstants.GET_EMP_API_DOC_NOTES)
	@RequestMapping(value = MyConstants.EMP_ENDPOINT + "/{name}", method = RequestMethod.GET)
	@ResponseBody
	public HttpEntity<Employee> getEmployeeDetails(@PathVariable String name) {
		HttpStatus httpStatus = HttpStatus.OK;
		Employee retrievedEmployee = null;
		try {
			retrievedEmployee = employeeService.findEmployeeByName(name);
			LOGGER.info("Employee Retrieved :: " + retrievedEmployee.getName());
		}
		catch (Exception ex) {
			LOGGER.info("Error while retrieving Employee :: " + ex);
			httpStatus = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<>(retrievedEmployee, httpStatus);
	}
	
	@ApiOperation(value = MyConstants.ADD_EMP_API_DOC_VALUE, nickname = MyConstants.ADD_EMP_API_DOC_VALUE, notes = MyConstants.ADD_EMP_API_DOC_NOTES)
	@RequestMapping(value = MyConstants.EMP_ENDPOINT, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpEntity<Employee> registerEmployee(@RequestBody Employee employee) {
		HttpStatus httpStatus = HttpStatus.OK;
		Employee addedEmployee = null;
		try {
			addedEmployee = employeeService.addEmployee(employee);
			LOGGER.info("Employee Added :: " + addedEmployee.getName());
		}
		catch (Exception ex) {
			LOGGER.info("Error while adding Employee :: " + ex);
			httpStatus = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<Employee>(addedEmployee, httpStatus);
	}

	@ApiOperation(value = MyConstants.DEL_EMP_API_DOC_VALUE, nickname = MyConstants.DEL_EMP_API_DOC_VALUE, notes = MyConstants.DEL_EMP_API_DOC_NOTES)
	@RequestMapping(value = MyConstants.EMP_ENDPOINT + "/{name}", method = RequestMethod.DELETE)
	@ResponseBody
	public HttpEntity<Void> deleteEmployee(@PathVariable String name) {
		HttpStatus httpStatus = HttpStatus.OK;
		try {
			employeeService.deleteEmployee(name);
			LOGGER.info("Employee Added :: " + name);
		}
		catch (Exception ex) {
			LOGGER.info("Error while deleting Employee :: " + ex);
			httpStatus = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<>(httpStatus);
	}
	
    @ApiOperation(value = MyConstants.UPD_EMP_API_DOC_VALUE, nickname = MyConstants.UPD_EMP_API_DOC_VALUE, notes = MyConstants.UPD_EMP_API_DOC_NOTES)
    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public HttpEntity<Void> updateEmployee(@RequestBody Employee employee) {
		HttpStatus httpStatus = HttpStatus.OK;
		try {
			boolean isUpdated = employeeService.update(employee);
			if(isUpdated) {
				LOGGER.info("Employee Updated :: " + employee.getName());
			}
			else {
				LOGGER.info("Employee Added :: " + employee.getName());
			}
		}
		catch (Exception ex) {
			LOGGER.info("Error while updating Employee :: " + ex);
			httpStatus = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<>(httpStatus);
    }

}
