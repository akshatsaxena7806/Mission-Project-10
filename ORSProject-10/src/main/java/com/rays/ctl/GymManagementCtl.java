package com.rays.ctl;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.AchievementBadgeDTO;
import com.rays.dto.GymManagementDTO;
import com.rays.form.GymManagementForm;
import com.rays.service.GymManagementServiceInt;


@RestController
@RequestMapping(value = "GymManagement")
public class GymManagementCtl extends BaseCtl<GymManagementDTO, GymManagementForm, GymManagementServiceInt> {

	
	@GetMapping("preload")
	public ORSResponse preload () {
		
		ORSResponse res = new ORSResponse(true);
		
		GymManagementDTO dto = new GymManagementDTO();
		
		System.out.println("=======>" + dto.toString());
		
		try {
			List<DropdownList> gymManagement = service.search(dto, userContext);
		res.addResult("gymManagement", gymManagement);
		
		}catch (Exception e) {
			res.addMessage(e.getMessage());
			res.setSuccess(false);
			e.printStackTrace();
		}
		
		
		
		return res;
		
	}
}
