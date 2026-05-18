package com.rays.ctl;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.ARObjectDTO;
import com.rays.dto.GenderDTO;
import com.rays.form.GenderForm;
import com.rays.service.GenderServiceInt;

@RestController
@RequestMapping(value = "Gender")
public class GenderCtl extends BaseCtl<GenderDTO, GenderForm, GenderServiceInt> {

	
	
	@GetMapping("preload")
	public ORSResponse preload () {
		
		ORSResponse res = new ORSResponse(true);
		
		GenderDTO dto = new GenderDTO();
		
		System.out.println("=========================>" + dto.toString());
		
		try {
			List<DropdownList> gender = service.search(dto, userContext);
		res.addResult("gender", gender);
		
		}catch (Exception e) {
			res.addMessage(e.getMessage());
			res.setSuccess(false);
			e.printStackTrace();
		}
		
		
		
		return res;
	}
}
