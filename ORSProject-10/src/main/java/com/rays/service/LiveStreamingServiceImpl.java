package com.rays.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.LiveStreamingDAOInt;
import com.rays.dto.LiveStreamingDTO;


@Service
@Transactional
public class LiveStreamingServiceImpl extends BaseServiceImpl<LiveStreamingDTO, LiveStreamingDAOInt> implements LiveStreamingServiceInt {

}
