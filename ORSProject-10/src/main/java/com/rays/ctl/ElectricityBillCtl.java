package com.rays.ctl;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.ARObjectDTO;
import com.rays.dto.ElectricityBillDTO;
import com.rays.form.ElectricityBillForm;
import com.rays.service.ElectricityBillServiceInt;


@RestController
@RequestMapping(value ="ElectricityBill")
public class ElectricityBillCtl extends BaseCtl<ElectricityBillDTO, ElectricityBillForm, ElectricityBillServiceInt> {

	
	@GetMapping("preload")
	public ORSResponse preload () {
		
		ORSResponse res = new ORSResponse(true);
		
		ElectricityBillDTO dto = new ElectricityBillDTO();
		
		System.out.println("=======>" + dto.toString());
		
		try {
			List<DropdownList> electricityBill = service.search(dto, userContext);
		res.addResult("electricityBill", electricityBill );
		
		}catch (Exception e) {
			res.addMessage(e.getMessage());
			res.setSuccess(false);
			e.printStackTrace();
		}
		
		
		
		return res;
		
	}
}
