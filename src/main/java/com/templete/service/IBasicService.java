package com.templete.service;

import java.io.Serializable;

import com.templete.exception.SystemRunException;

public interface IBasicService<T, ID extends Serializable> {

	public Serializable save(T entity) throws SystemRunException;
}
