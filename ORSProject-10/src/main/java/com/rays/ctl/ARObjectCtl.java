package com.rays.ctl;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.ARObjectDTO;
import com.rays.dto.RoleDTO;
import com.rays.form.ARObjectForm;
import com.rays.service.ARObjectServiceInt;

@RestController
@RequestMapping(value = "ARObject")
public class ARObjectCtl extends BaseCtl<ARObjectDTO, ARObjectForm, ARObjectServiceInt> {

	@GetMapping("preload")
	public ORSResponse preload () {
		
		ORSResponse res = new ORSResponse(true);
		
		ARObjectDTO dto = new ARObjectDTO();
		
		System.out.println("=========================>" + dto.toString());
		
		try {
			List<DropdownList> arObject = service.search(dto, userContext);
		res.addResult("arObject", arObject);
		
		}catch (Exception e) {
			res.addMessage(e.getMessage());
			res.setSuccess(false);
			e.printStackTrace();
		}
		
		
		
		return res;
		
	}
	
}
