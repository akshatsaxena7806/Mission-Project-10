package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.WeatherSystemDTO;
import com.rays.form.WeatherSystemForm;
import com.rays.service.WeatherSystemServiceInt;


@RestController
@RequestMapping(value = "WeatherSystem")
public class WeatherSystemCtl extends BaseCtl<WeatherSystemDTO, WeatherSystemForm, WeatherSystemServiceInt> {

}
