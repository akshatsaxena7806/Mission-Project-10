package com.rays.ctl;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.ARObjectDTO;
import com.rays.dto.EmployeeDTO;
import com.rays.form.EmployeeForm;
import com.rays.service.EmployeeServiceInt;


@RestController
@RequestMapping(value = "Employee")
public class EmployeeCtl extends BaseCtl<EmployeeDTO, EmployeeForm, EmployeeServiceInt> {

	@GetMapping("preload")
	public ORSResponse preload () {
		
		ORSResponse res = new ORSResponse(true);
		
		EmployeeDTO dto = new EmployeeDTO();
		
		System.out.println("=========================>" + dto.toString());
		
		try {
			List<DropdownList> employee = service.search(dto, userContext);
		res.addResult("employee", employee);
		
		}catch (Exception e) {
			res.addMessage(e.getMessage());
			res.setSuccess(false);
			e.printStackTrace();
		}
		
		
		
		return res;
		
	}
}
