package com.h.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.h.dao.ProductDao;
import com.h.dto.Product;

@Repository
@Transactional
public class ProductDaoimpl implements ProductDao {
	private static final String ACTIVE_PRODUCTS = "from Product where isActive=:active";
	private static final String ACTIVE_PRODUCTS_BY_CAT_ID = "from Product where isActive=:active and categoryId=:catid";
	private static final String LATEST_ACTIVE_PRODUCTS = "from Product where isActive=:active";
	@Autowired
	SessionFactory sf;

	@Override
	public Product get(int pid) {

		return sf.getCurrentSession().get(Product.class, Integer.valueOf(pid));
	}

	@Override
	public List<Product> list() {

		return sf.getCurrentSession().createQuery("from Product").getResultList();

	}

	@Override
	public boolean delete(Product p) {
		p.setActive(false);
		return this.update(p);
	}

	@Override
	public boolean update(Product p) {
		try {
			sf.getCurrentSession().update(p);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean add(Product p) {
		try {
			sf.getCurrentSession().persist(p);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Product> listActiveProducts() {

		return sf.getCurrentSession().createQuery(ACTIVE_PRODUCTS).setParameter("active", true).getResultList();
	}

	@Override
	public List<Product> listActiveProductByCategory(int cid) {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().createQuery(ACTIVE_PRODUCTS_BY_CAT_ID).setParameter("active", true)
				.setParameter("catid", cid).getResultList();
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {

		return sf.getCurrentSession().createQuery(LATEST_ACTIVE_PRODUCTS).setParameter("active", true).setFirstResult(0)
				.setMaxResults(count).getResultList();

	}

}
