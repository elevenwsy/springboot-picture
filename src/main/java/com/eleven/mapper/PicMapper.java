package com.eleven.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.eleven.pojo.Picture;

@Mapper
public interface PicMapper {

	void add(Picture pic);

	List<Picture> selectPic();

}
