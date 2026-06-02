package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.HospitalSystemDTO;
import com.rays.form.HospitalSystemForm;
import com.rays.service.HospitalSystemServiceInt;


@RestController
@RequestMapping(value = "HospitalSystem")
public class HospitalSystemCtl extends BaseCtl<HospitalSystemDTO, HospitalSystemForm, HospitalSystemServiceInt> {

}
