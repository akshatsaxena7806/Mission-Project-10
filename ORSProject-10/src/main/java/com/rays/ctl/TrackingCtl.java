package com.rays.ctl;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.AchievementBadgeDTO;
import com.rays.dto.TrackingDTO;
import com.rays.form.TrackingForm;
import com.rays.service.TrackingServiceInt;


@RestController
@RequestMapping(value = "Tracking")
public class TrackingCtl extends BaseCtl<TrackingDTO, TrackingForm, TrackingServiceInt> {

	
	@GetMapping("preload")
	public ORSResponse preload () {
		
		ORSResponse res = new ORSResponse(true);
		
		TrackingDTO dto = new TrackingDTO();
		
		System.out.println("=======>" + dto.toString());
		
		try {
			List<DropdownList> tracking = service.search(dto, userContext);
		res.addResult("tracking", tracking);
		
		}catch (Exception e) {
			res.addMessage(e.getMessage());
			res.setSuccess(false);
			e.printStackTrace();
		}
		
		
		
		return res;
		
	}
}
