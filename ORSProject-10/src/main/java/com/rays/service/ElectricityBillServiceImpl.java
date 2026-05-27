package com.rays.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.ElectricityBillDAOInt;
import com.rays.dto.ElectricityBillDTO;

@Service
@Transactional
public class ElectricityBillServiceImpl extends BaseServiceImpl<ElectricityBillDTO, ElectricityBillDAOInt> implements ElectricityBillServiceInt{

}
