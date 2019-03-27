package com.eleven.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eleven.mapper.PicMapper;
import com.eleven.pojo.Picture;
import com.eleven.service.PicService;

@Service
public class PicServiceImpl implements PicService{

	@Autowired
	private PicMapper picMapper;
	@Override
	public void add(Picture pic) {
		// TODO Auto-generated method stub
		picMapper.add(pic);
	}
	@Override
	public List<Picture> selectPic() {
		// TODO Auto-generated method stub
		return picMapper.selectPic();
	}

}
