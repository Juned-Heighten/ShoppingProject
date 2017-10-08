package com.heighten.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.h.dto.Product;

public class ProductValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors err) {
		Product p=(Product)target;
		// check whether file has been selected or not
		if(p.getFile()==null||
			p.getFile().getOriginalFilename().equals(""))
		{
			err.rejectValue("file", null,"Please select an image file to upload");
			return;
		}
		if(!(p.getFile().getContentType().equals("image/jpeg")||
		     p.getFile().getContentType().equals("image/jpg")||
		     p.getFile().getContentType().equals("image/gif")))
		{
			err.rejectValue("file",null,"Please select an image file to upload");
			return;
		}
		
	}

}
