package com.heighten.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {
	//private static final Logger logger=LoggerFactory.getLogger(FileUploadUtility.class);
	private static final String ABS_PATH="E:\\Development\\NEW\\ShoppingProject\\OnlineShopping-backend\\src\\main\\webapp\\assets\\images\\";
	private static String REAL_PATH="";
	public static void upload(HttpServletRequest req, MultipartFile file, String code) {
		
		//get Real Path
		REAL_PATH=req.getSession().getServletContext().getRealPath("/asstes/images/");
		/**
		 * To Make Sure All the Directory is Exists
		 * If Not create
		 */
		if(!new File(ABS_PATH).exists())
		{
			// Create the directory Structure
			new File(ABS_PATH).mkdirs();
		}
		
		
		if(!new File(REAL_PATH).exists())
		{
			// Create the directory Structure
			new File(REAL_PATH).mkdirs();
		}
		
		try {
			//save inside server where app deployed
			file.transferTo(new File(REAL_PATH+code+".jpg"));
			//save inside prject directory
			file.transferTo(new File(ABS_PATH+code+".jpg"));
		}catch(IOException e)
		{
			
		}
		
	}
	
	

}
