package com.easynutrition.data.dao;

import org.springframework.stereotype.Repository;

import com.easynutrition.data.entity.DataEntityUser;

@Repository
public class DataDaoUser extends DataDaoAbstract<DataEntityUser> {

	public DataDaoUser() {
		super(DataEntityUser.class);
	}

}
