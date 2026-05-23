package com.rays.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.WeatherSystemDAOInt;
import com.rays.dto.WeatherSystemDTO;


@Service
@Transactional
public class WeatherSystemServiceImpl extends BaseServiceImpl<WeatherSystemDTO, WeatherSystemDAOInt> implements WeatherSystemServiceInt {

}
