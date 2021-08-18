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
		String sql = "SELECT *, publisher.name as publisher FROM comic, author, publisher WHERE comic.author_id = author.author_id "
				+ "AND comic.publisher_id = publisher.publisher_id "
				+ "AND comic.ruby like ?";

		// ?の箇所を置換するデータの配列を定義
		Object[] param = { "%" + comic_name + "%" };

		// クエリを実行
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, param);

		// 取得したリストを返す
		return list;
	}
	
	/**
	 * 漫画検索画面で作者名タブ選択時
	 * @param author_name
	 * @return list 全件取得結果のList
	 */
	public List<Map<String, Object>> authorNameSearch(String author_name) {

		// SQL文作成
		String sql = "SELECT *, publisher.name as publisher FROM comic, author, publisher WHERE comic.author_id = author.author_id "
				+ "AND comic.publisher_id = publisher.publisher_id "
				+ "AND author.author like ?";

		// ?の箇所を置換するデータの配列を定義
		Object[] param = { "%" + author_name + "%" };

		// クエリを実行
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, param);

		// 取得したリストを返す
		return list;
	}
	
	/**
	 * 漫画検索画面で出版社タブ選択時
	 * @param publisher_name
	 * @return list 全件取得結果のList
	 */
	public List<Map<String, Object>> publisherNameSearch(String publisher_name) {

		// SQL文作成
		String sql = "SELECT *, publisher.name as publisher FROM comic, author, publisher WHERE comic.author_id = author.author_id "
				+ "AND comic.publisher_id = publisher.publisher_id "
				+ "AND publisher.name like ?";

		// ?の箇所を置換するデータの配列を定義
		Object[] param = { "%" + publisher_name + "%" };

		// クエリを実行
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, param);

		// 取得したリストを返す
		return list;
	}

	/**
	 *
	 * @param comic_id
	 * @return map 漫画の利用者・従業員合わせた評価人数を取得
	 */
	public Map<String, Object> evaluateCount(String comic_id) {

		// SQL文作成
		String sql = "SELECT COUNT(*) FROM "
				+ "(SELECT * FROM user_evaluation UNION ALL SELECT * FROM employee_evaluation) as user_employee"
				+ " WHERE comic_id = ? GROUP BY comic_id";

		// ?の箇所を置換するデータの配列を定義
		Object[] param = { comic_id };

		// クエリを実行
		Map<String, Object> map = jdbcTemplate.queryForMap(sql, param);

		// 取得したマップデータを返す
		return map;
	}

	/**
	 *
	 * @param comic_id
	 * @return map 漫画の利用者・従業員合わせた平均評価点数を取得
	 */
	public Map<String, Object> avgEvaluate(String comic_id) {

		// SQL文作成
		String sql = "SELECT AVG(score) FROM "
				+ "(SELECT * FROM user_evaluation UNION ALL SELECT * FROM employee_evaluation) as user_employee"
				+ " WHERE comic_id = ?";

		// ?の箇所を置換するデータの配列を定義
		Object[] param = { comic_id };

		// クエリを実行
		Map<String, Object> map = jdbcTemplate.queryForMap(sql, param);

		// 取得したマップデータを返す
		return map;
	}
}
