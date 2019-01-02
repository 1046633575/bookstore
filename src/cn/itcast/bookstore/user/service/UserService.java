package cn.itcast.bookstore.user.service;

import cn.itcast.bookstore.user.dao.UserDao;
import cn.itcast.bookstore.user.domain.User;

/**
 * User业务层
 * @author cxf
 *
 */
public class UserService {
	private UserDao userDao = new UserDao();
	
	/**
	 * 注册功能
	 * @param form
	 */
	public void regist(User form) throws UserException{
		
		// 校验用户名
		User user = userDao.findByUsername(form.getUsername());
		if(user != null) throw new UserException("用户名已被注册！");
		
		// 校验email
		user = userDao.findByEmail(form.getEmail());
		if(user != null) throw new UserException("Email已被注册！");
		
		// 插入用户到数据库
		userDao.add(form);
		
	}
	
	/**
	 * 激活功能
	 * @throws UserException 
	 */
	public void active(String code) throws UserException {
		/*
		 * 1. 使用code查询数据库，得到user
		 */
		User user = userDao.findByCode(code);
		/*
		 * 2. 如果user不存在，说明激活码错误
		 */
		if(user == null) throw new UserException("激活码无效！");
		/*
		 * 3. 校验用户的状态是否为未激活状态，如果已激活，说明是二次激活，抛出异常
		 */
		if(user.isState()) throw new UserException("您已经激活过了，不要重复激活！");
		
		/*
		 * 4. 修改用户的状态
		 */
		userDao.updateState(user.getUid(), true);
	}
	
	/**
	 * 登录功能
	 * @param form
	 * @return
	 * @throws UserException 
	 */
	public User login(User form) throws UserException {
		/*
		 * 1. 使用username查询，得到User
		 * 2. 如果user为null，抛出异常（用户名不存在）
		 * 3. 比较form和user的密码，若不同，抛出异常（密码错误）
		 * 4. 查看用户的状态，若为false，抛出异常（尚未激活）
		 * 5. 返回user
		 */
		User user = userDao.findByUsername(form.getUsername());
		if(user == null) throw new UserException("用户名不存在！");
		if(!user.getPassword().equals(form.getPassword()))
			throw new UserException("密码错误！");
		if(!user.isState()) throw new UserException("尚未激活！");
		
		return user;
	}
}
