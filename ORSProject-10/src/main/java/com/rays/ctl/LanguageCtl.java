package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.LanguageDTO;
import com.rays.form.LanguageForm;
import com.rays.service.LanguageServiceInt;


@RestController
@RequestMapping(value = "Language")
public class LanguageCtl extends BaseCtl<LanguageDTO, LanguageForm, LanguageServiceInt>{

}
