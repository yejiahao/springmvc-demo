package org.yejh.shop.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.yejh.shop.dao.UserInfoDao;
import org.yejh.shop.entity.UserInfo;

@Repository("userInfoDao")
public class UserInfoDaoImpl implements UserInfoDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public UserInfo getById(Integer id) {
		final String SQL_GET = "SELECT * FROM user_info WHERE id= ?";
		UserInfo userInfo = jdbcTemplate.queryForObject(SQL_GET, new UserInfo(), new Object[] { id });
		return userInfo;
	}

	@Override
	public List<UserInfo> findAll() {
		final String SQL_GETList = "SELECT * FROM user_info";
		List<UserInfo> userInfoList = jdbcTemplate.query(SQL_GETList, new UserInfo());
		return userInfoList;
	}

	@Override
	public Integer save(UserInfo userInfo) {
		final String SQL_SAVE = "INSERT INTO user_info(uname, unumber, uregister_time) "
				+ "values(:uname, :unumber, :uregister_time)";
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("uname", userInfo.getuName());
		paramSource.addValue("unumber", userInfo.getuNumber());
		paramSource.addValue("uregister_time", userInfo.getuRegisterTime());
		Integer count = namedParameterJdbcTemplate.update(SQL_SAVE, paramSource);
		return count;
	}
}
