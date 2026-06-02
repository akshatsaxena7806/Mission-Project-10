package com.rays.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.BrokerDAOInt;
import com.rays.dto.BrokerDTO;


@Service
@Transactional
public class BrokerServiceImpl extends BaseServiceImpl<BrokerDTO, BrokerDAOInt> implements BrokerServiceInt {

}
