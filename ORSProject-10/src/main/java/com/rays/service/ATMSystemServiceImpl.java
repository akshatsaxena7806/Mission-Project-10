package com.rays.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.ATMSystemDAOInt;
import com.rays.dto.ATMSystemDTO;

@Service
@Transactional
public class ATMSystemServiceImpl extends BaseServiceImpl<ATMSystemDTO, ATMSystemDAOInt> implements ATMSystemServiceInt {

}
