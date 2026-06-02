package com.rays.ctl;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.ARObjectDTO;
import com.rays.dto.BrokerDTO;
import com.rays.form.BrokerForm;
import com.rays.service.BrokerServiceInt;


@RestController
@RequestMapping(value = "Broker")
public class BrokerCtl extends BaseCtl<BrokerDTO, BrokerForm, BrokerServiceInt> {

	
	@GetMapping("preload")
	public ORSResponse preload () {
		
		ORSResponse res = new ORSResponse(true);
		
		BrokerDTO dto = new BrokerDTO ();
		
		System.out.println("=======>" + dto.toString());
		
		try {
			List<DropdownList> Broker= service.search(dto, userContext);
		res.addResult("Broker", Broker);
		
		}catch (Exception e) {
			res.addMessage(e.getMessage());
			res.setSuccess(false);
			e.printStackTrace();
		}
		
		
		
		return res;
		
	}
	
}
