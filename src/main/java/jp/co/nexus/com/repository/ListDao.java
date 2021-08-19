package jp.co.nexus.com.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * ListDao.java
 * 漫画一覧画面で表示する漫画の情報をDBから検索し取得する
 *
 * @author 山﨑 柊吾
 * @version 21/08/19
 *
 */
@Repository
public class ListDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

}
