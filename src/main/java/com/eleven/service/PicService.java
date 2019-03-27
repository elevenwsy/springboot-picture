package com.eleven.service;

import java.util.List;

import com.eleven.pojo.Picture;

public interface PicService {

	void add(Picture pic);

	List<Picture> selectPic();

}
