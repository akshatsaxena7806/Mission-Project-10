package com.rays.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.BusReservationDAOInt;
import com.rays.dto.BusReservationDTO;


@Service
@Transactional
public class BusReservationServiceImpl extends BaseServiceImpl<BusReservationDTO, BusReservationDAOInt> implements BusReservationServiceInt{

}
