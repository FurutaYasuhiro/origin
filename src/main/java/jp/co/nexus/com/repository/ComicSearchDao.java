package jp.co.nexus.com.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * ComicSerchDao.java
 * 漫画検索画面での各タブ選択時に応じて漫画の情報をSQLよりDBから検索し取得する
 *
 * @author 山﨑 柊吾
 * @version 21/08/17
 *
 */
@Repository
public class ComicSearchDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	/**
	 * 漫画検索画面で漫画名タブ選択時
	 * @param comic_name
	 * @return list 全件取得結果のList
	 */
	public List<Map<String, Object>> comicNameSearch(String comic_name) {

		// SQL文作成
		String sql = "SELECT * FROM comic, author, publisher WHERE comic.author_id = author.author_id "
				+ "AND comic.publisher_id = publisher.publisher_id "
				+ "AND comic.ruby like ?";

		// ?の箇所を置換するデータの配列を定義
		Object[] param = { "%" + comic_name + "%" };

		// クエリを実行
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, param);

		// 取得したリストを返す
		return list;
	}
}
