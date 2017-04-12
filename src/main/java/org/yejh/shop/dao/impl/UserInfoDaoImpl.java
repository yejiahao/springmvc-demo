package org.yejh.shop.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
import org.yejh.shop.dao.UserInfoDao;
import org.yejh.shop.dao.mapping.UserInfoMapper;
import org.yejh.shop.entity.UserInfo;

@Repository("userInfoDao")
public class UserInfoDaoImpl implements UserInfoDao {
	@Autowired
	private UserInfoMapper mapper;

	@Override
	public UserInfo getById(Integer id) throws Exception {
		final String SQL_GET = "SELECT * FROM user_info WHERE id= ?";
		// UserInfo userInfo = jdbcTemplate.queryForObject(SQL_GET, new
		// UserInfo(), new Object[] { id });
		UserInfo userInfo = new UserInfo();
		return userInfo;
	}

	@Override
	public List<UserInfo> findAll() throws Exception {
		List<UserInfo> userInfoList = mapper.getUserInfoList();
		return userInfoList;
	}

	@Override
	public Integer save(UserInfo userInfo) throws Exception {
		final String SQL_SAVE = "INSERT INTO user_info(uname, unumber, uregister_time) "
				+ "values(:uname, :unumber, :uregister_time)";
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("uname", userInfo.getuName());
		paramSource.addValue("unumber", userInfo.getuNumber());
		paramSource.addValue("uregister_time", userInfo.getuRegisterTime());
		// Integer count = namedParameterJdbcTemplate.update(SQL_SAVE,
		// paramSource);
		Integer count = 1;
		return count;
	}
}
