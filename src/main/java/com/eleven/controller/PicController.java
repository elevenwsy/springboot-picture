package com.eleven.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eleven.pojo.Picture;
import com.eleven.service.PicService;
import com.eleven.util.ImageUtil;
import com.eleven.util.UploadedImageFile;

@Controller
public class PicController {
	
	@Autowired
	private PicService picService;
	
		@RequestMapping("/list")
		public String picList(Model model) {
			List<Picture> pic =  picService.selectPic();
			model.addAttribute("pic", pic);
			return "pic_list";
		}
	 @RequestMapping("/img_add")
	    public String add(Picture pic, HttpSession session, UploadedImageFile uploadedImageFile) throws IOException {
	       //  userService.userList(page,rows,example);
		 	picService.add(pic);
	        File  imageFolder= new File(session.getServletContext().getRealPath("img"));
	        File file = new File(imageFolder,pic.getId()+".jpg");
	        if(!file.getParentFile().exists())
	            file.getParentFile().mkdirs();
	        uploadedImageFile.getImage().transferTo(file);
	        BufferedImage img = ImageUtil.change2jpg(file);
	        ImageIO.write(img, "jpg", file);
	        return "redirect:/list";
	    }
	
}
