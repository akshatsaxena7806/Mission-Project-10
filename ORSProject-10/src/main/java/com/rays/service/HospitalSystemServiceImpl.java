package com.rays.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.HospitalSystemDAOInt;
import com.rays.dto.HospitalSystemDTO;


@Service
@Transactional
public class HospitalSystemServiceImpl extends BaseServiceImpl<HospitalSystemDTO, HospitalSystemDAOInt> implements HospitalSystemServiceInt {

}
