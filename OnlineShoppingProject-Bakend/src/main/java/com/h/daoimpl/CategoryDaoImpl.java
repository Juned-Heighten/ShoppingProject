package com.h.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.h.dao.CategoryDao;
import com.h.dto.Category;
@Repository
public class CategoryDaoImpl implements CategoryDao {
	
	private static List<Category> categories=new ArrayList<>();
	static {
		Category c=new Category();
		c.setId(1);
		c.setName("Laptop");
		c.setDescriptsion("This is HP laptop");
		c.setImageUrl("CAT_1.png");
		categories.add(c);
		Category c1=new Category();
		c1.setId(1);
		c1.setName("TV");
		c1.setDescriptsion("This is HP TV");
		c1.setImageUrl("CAT_2.png");
		categories.add(c1);
		Category c2=new Category();
		c2.setId(1);
		c2.setName("Banana");
		c2.setDescriptsion("This is HP Banana");
		c2.setImageUrl("CAT_3.png");
		categories.add(c2);
		
		Category c3=new Category();
		c3.setId(1);
		c3.setName("Mango");
		c3.setDescriptsion("This is HP Banana");
		c3.setImageUrl("CAT_3.png");
		categories.add(c3);
		
	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}
	
	@Override
	public Category get(int id) {
		
		for(Category c:categories)
		{
			if(c.getId()==id)
				return c;
		}
		
		
		
		return null;
	}

}
