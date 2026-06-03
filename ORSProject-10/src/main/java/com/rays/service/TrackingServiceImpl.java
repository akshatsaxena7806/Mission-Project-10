package com.rays.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.TrackingDAOInt;
import com.rays.dto.TrackingDTO;



@Service
@Transactional
public class TrackingServiceImpl extends BaseServiceImpl<TrackingDTO, TrackingDAOInt> implements TrackingServiceInt{

}
