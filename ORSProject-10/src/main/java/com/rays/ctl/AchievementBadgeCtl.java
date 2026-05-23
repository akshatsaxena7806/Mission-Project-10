package com.rays.ctl;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.ARObjectDTO;
import com.rays.dto.AchievementBadgeDTO;
import com.rays.form.AchievementBadgeForm;
import com.rays.service.AchievementBadgeServiceInt;


@RestController
@RequestMapping(value = "AchievementBadge")
public class AchievementBadgeCtl extends BaseCtl<AchievementBadgeDTO, AchievementBadgeForm, AchievementBadgeServiceInt> {

	

	@GetMapping("preload")
	public ORSResponse preload () {
		
		ORSResponse res = new ORSResponse(true);
		
		AchievementBadgeDTO dto = new AchievementBadgeDTO();
		
		System.out.println("=======>" + dto.toString());
		
		try {
			List<DropdownList> AchievementBadge = service.search(dto, userContext);
		res.addResult("AchievementBadge", AchievementBadge);
		
		}catch (Exception e) {
			res.addMessage(e.getMessage());
			res.setSuccess(false);
			e.printStackTrace();
		}
		
		
		
		return res;
		
	}
}
