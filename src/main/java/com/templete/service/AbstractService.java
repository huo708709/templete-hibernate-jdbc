package com.templete.service;

import java.io.Serializable;

import com.templete.dao.AbstractDao;
import com.templete.exception.SystemRunException;

public abstract class AbstractService<T, ID extends Serializable> implements IBasicService<T, ID> {

	protected AbstractDao<T, ID> abstractDao;
	
	public void setAbstractDao(AbstractDao<T, ID> abstractDao) {
		this.abstractDao = abstractDao;
	}

	@Override
	public Serializable save(T entity) throws SystemRunException {
		return abstractDao.save(entity);
	}
}
