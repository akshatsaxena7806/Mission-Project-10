package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.BusReservationDTO;
import com.rays.form.BusReservationForm;
import com.rays.service.BusReservationServiceInt;


@RestController
@RequestMapping(value = "BusReservation")
public class BusReservationCtl extends BaseCtl<BusReservationDTO, BusReservationForm, BusReservationServiceInt> {

}
