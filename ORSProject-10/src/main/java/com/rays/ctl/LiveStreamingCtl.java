package com.rays.ctl;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.ARObjectDTO;
import com.rays.dto.LiveStreamingDTO;
import com.rays.form.LiveStreamingForm;
import com.rays.service.LiveStreamingServiceInt;

@RestController
@RequestMapping(value = "LiveStreaming")
public class LiveStreamingCtl extends BaseCtl<LiveStreamingDTO, LiveStreamingForm, LiveStreamingServiceInt>{

	
	
	
	@GetMapping("preload")
	public ORSResponse preload () {
		
		ORSResponse res = new ORSResponse(true);
		
		LiveStreamingDTO dto = new LiveStreamingDTO();
		
		System.out.println("==================>" + dto.toString());
		
		try {
			List<DropdownList> liveStreaming = service.search(dto, userContext);
		    res.addResult("liveStreaming", liveStreaming);
		
		}catch (Exception e) {
			res.addMessage(e.getMessage());
			res.setSuccess(false);
			e.printStackTrace();
		}
		
		
		
		return res;
		
	}
}
