package dao;

import vo.User;

public interface IUserDAO {
	// 根据userName找user
	public User getByName(String userName);
	
}
