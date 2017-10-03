package com.h.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.h.dao.CategoryDao;
import com.h.dto.Category;

@Repository("catDao")
@Transactional
public class CategoryDaoImpl implements CategoryDao {
	private static String FETCH_ALL_CAT="FROM Category  WHERE active= :active";
	@Autowired
	private SessionFactory sf;

	
	
	@Override
	public List<Category> list() {
		Query q=sf.getCurrentSession().createQuery(FETCH_ALL_CAT);
		q.setParameter("active", true);
		System.out.println("List()"+q.getResultList().size());
		return q.getResultList();
	}  

	@Override
	public Category get(int id) {

		return sf.getCurrentSession().get(Category.class, Integer.valueOf(id));
	} 

	@Override
	
	public boolean add(Category c) {
		try {
			sf.getCurrentSession().persist(c);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category c) {
		    c.setActive(false);
		return update(c);
	}

	@Override
	public boolean update(Category c) {
		try {
			sf.getCurrentSession().update(c);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	

}
   