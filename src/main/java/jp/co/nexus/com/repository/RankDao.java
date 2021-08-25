package jp.co.nexus.com.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


/**
 * ListDao.java
 * 漫画人気ランキングで表示する漫画の情報をDBから検索し取得する
 *
 * @author 山﨑 柊吾
 * @version 21/08/23
 *
 */
@Repository
public class RankDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	/**
	 * 漫画人気ランキングに表示する漫画情報を評価の高い順(評価が同じ場合は評価人数が多い順、名前順)で30件取得する
	 * @return list Listデータ30件
	 */
	public List<Map<String, Object>> comicRank() {

		// SQL文作成
		String sql = "SELECT comic.comic_id, comic.name,author.author,art.art,publisher.name as publisher,sum_num,sum_eva FROM "
				+ "(SELECT comic_id,COUNT(*) AS sum_num FROM "
				+ "(SELECT comic.comic_id,user_evaluation.score FROM "
				+ "comic inner join user_evaluation on comic.comic_id = user_evaluation.comic_id UNION all "
				+ "SELECT  comic.comic_id,employee_evaluation.score FROM "
				+ "comic inner join employee_evaluation on comic.comic_id = employee_evaluation.comic_id) as a "
				+ "GROUP BY comic_id )AS num INNER JOIN "
				+ "(SELECT comic_id,round(AVG(a.score),1)AS sum_eva FROM "
				+ "(SELECT  comic.comic_id,user_evaluation.score FROM "
				+ "comic inner join user_evaluation on comic.comic_id = user_evaluation.comic_id UNION all "
				+ "SELECT  comic.comic_id,employee_evaluation.score FROM "
				+ "comic inner join employee_evaluation on comic.comic_id = employee_evaluation.comic_id) as a "
				+ "GROUP BY comic_id ) AS ave ON num.comic_id = ave.comic_id"
				+ " INNER JOIN comic ON ave.comic_id = comic.comic_id "
				+ "INNER JOIN author ON comic.author_id = author.author_id "
				+ "INNER JOIN publisher ON publisher.publisher_id = comic.publisher_id "
				+ "LEFT OUTER JOIN art ON art.art_id = comic.art_id "
				+ "ORDER BY sum_eva DESC,sum_num DESC ,comic.ruby ASC LIMIT 30";

		// クエリを実行
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);

		// 取得したデータを返す
		return list;
	}
}
