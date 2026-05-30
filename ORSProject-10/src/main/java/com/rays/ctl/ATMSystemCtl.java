package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.ATMSystemDTO;
import com.rays.form.ATMSystemForm;
import com.rays.service.ATMSystemServiceInt;

@RestController
@RequestMapping(value = "ATMSystem")
public class ATMSystemCtl extends BaseCtl<ATMSystemDTO, ATMSystemForm, ATMSystemServiceInt>  {

}
