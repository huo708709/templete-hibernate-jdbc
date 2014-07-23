package com.templete.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.templete.exception.SystemRunException;

public abstract class AbstractDao<T, ID extends Serializable> {

	private Class<T> entityClass = null;
	
	@SuppressWarnings("unchecked")
	public AbstractDao() {
		Type genType = getClass().getGenericSuperclass();
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		entityClass = (Class<T>) params[0];
	}
	
	@Autowired
	private HibernateTemplate hibernateTemplate = null;
	
	@Autowired
	private JdbcTemplate jdbcTemplate = null;
	
	/*
	 * hibernate 部门================================================
	 */
	
	/**
	 * 更具ID查询实体
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public T getById(String id) throws SystemRunException {
		return this.hibernateTemplate.get(entityClass, id);
	}
	
	/**
	 * 加载所有实体
	 * @return
	 * @throws Exception
	 */
	public List<T> loadAll() throws SystemRunException {
		return this.hibernateTemplate.loadAll(entityClass);
	}
	
	/**
	 * 执行hql,返回实体集合
	 * @param hql
	 * @return
	 * @throws SystemRunException
	 */
	public List<T> find(String hql) throws SystemRunException {
		return this.find(hql, (Object[])null);
	}
	
	/**
	 * 执行hql,返回实体集合
	 * @param hql
	 * @param value
	 * @return
	 * @throws SystemRunException
	 */
	public List<T> find(String hql, Object value) throws SystemRunException {
		return this.find(hql, new Object[]{value});
	}
	
	/**
	 * 执行hql,返回实体集合
	 * @param hql
	 * @param values
	 * @return
	 * @throws SystemRunException
	 */
	@SuppressWarnings("unchecked")
	public List<T> find(String hql, Object... values) throws SystemRunException {
		return (List<T>) this.hibernateTemplate.find(hql, values);
	}
	
	/**
	 * 保存实体
	 * @param entity
	 * @return
	 * @throws SystemRunException
	 */
	public Serializable save(T entity) throws SystemRunException {
		Serializable ser = this.hibernateTemplate.save(entity);
		this.hibernateTemplate.flush();
		return ser;
	}
	
	/**
	 * 更新实体
	 * @param entity
	 * @throws SystemRunException
	 */
	public void update(T entity) throws SystemRunException {
		this.hibernateTemplate.update(entity);
		this.hibernateTemplate.flush();
	}
	
	/**
	 * 保存或者更新实体
	 * @param entity
	 * @throws SystemRunException
	 */
	public void saveOrUpdate(T entity) throws SystemRunException {
		this.hibernateTemplate.saveOrUpdate(entity);
		this.hibernateTemplate.flush();
	}
	
	/**
	 * 保存或者更新实体集合
	 * @param entities
	 * @throws SystemRunException
	 */
	public void saveOrUpdate(List<T> entities) throws SystemRunException {
		this.hibernateTemplate.saveOrUpdate(entities);
		this.hibernateTemplate.flush();
	}
	
	/**
	 * 删除实体
	 * @param entity
	 * @throws SystemRunException
	 */
	public void delete(T entity) throws SystemRunException {
		this.hibernateTemplate.delete(entity);
		this.hibernateTemplate.flush();
	}
	
	/**
	 * 根据ID删除实体
	 * @param id
	 * @return
	 * @throws SystemRunException
	 */
	public int deleteById(ID id) throws SystemRunException {
		final String hql = "delete from " + entityClass.getName();
		int count = this.hibernateTemplate.execute(new HibernateCallback<Integer>() {

			@Override
			public Integer doInHibernate(Session session) throws HibernateException {
				return session.createQuery(hql).executeUpdate();
			}
		});
		return count;
	}
	
	/**
	 * 删除所有
	 * @param entities
	 * @throws SystemRunException
	 */
	public void deleteAll(Collection<?> entities) throws SystemRunException {
		this.hibernateTemplate.deleteAll(entities);
	}
	
	/**
	 * 查询集合
	 * @param hql
	 * @param start
	 * @param limit
	 * @param params
	 * @return
	 * @throws SystemRunException
	 */
	public List<?> execute(final String hql, final int start, final int limit, final Object... params) throws SystemRunException {
		List<?> list = this.hibernateTemplate.execute(new HibernateCallback<List<?>>() {

			@Override
			public List<?> doInHibernate(Session session)
					throws HibernateException {
				Query query = session.createQuery(hql);
				query.setFirstResult(start);
				query.setMaxResults(limit);
				if (null != params) {
					for (int i = 0; i < params.length; i++) {
						query.setParameter(i, params[i]);
					}
				}
				return query.list();
			}
			
		});
		return list;
	}
}
