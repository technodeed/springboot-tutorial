package com.springboot.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.demo.bean.UserBean;
import com.springboot.demo.util.SbUtils;

@Service
public class UserDaoService {
	
	private static List<UserBean> users = new ArrayList<>();
	
	static {
		System.out.println("In static ***");
		users.add(new UserBean(123, "Erick", "Nieva", new Date()));//SbUtils.createDate(1977, 10, 25).getTime()));
		users.add(new UserBean(124, "Sid", "Reddy", SbUtils.createDate(1987, 11, 13).getTime()));
		users.add(new UserBean(125, "Darin", "Triplett", SbUtils.createDate(1969, 03, 21).getTime()));
	}
	
	public List<UserBean> retrieveAllUsers() {
		System.out.println("In UserDaoService and retrieveAllUsers***");
		return users;
	}
	
	public UserBean retrieveUser(Integer userId) {
		
		System.out.println("In UserDaoService and retrieveUser***");
		UserBean user = null;
		for(UserBean userBean: users) {
			if(userBean.getUserId().equals(userId)) {
				user = userBean;
				break;
			}
		}
		return user;
	}
	
	public UserBean saveUser(UserBean userBean) {
		System.out.println("In UserDaoService and saveUser***");
		if(userBean.getUserId() == null) {
			userBean.setUserId(123 + users.size()+1);
		}
		users.add(userBean);
		return userBean;
	}
	
	public UserBean deleteUserById(Integer userId) {
		
		System.out.println("In UserDaoService and deleteUserById***");
		Iterator<UserBean> it = users.iterator();
		while(it.hasNext()) {
			UserBean userBean = it.next();
			if(userBean.getUserId().equals(userId)) {
				it.remove();
				return userBean;
			}
		}
		return null;
	}

}
