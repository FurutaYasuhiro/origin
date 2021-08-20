package jp.co.nexus.com.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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

	/**
	 * 漫画一覧画面に表示する漫画情報(振り仮名)を取得する
	 * @param comic_name
	 * @return list 全件取得結果のList
	 */
	public List<List<Map<String, Object>>> searchRuby() {

		// 50音の配列を定義
		List<String> syllabary = new ArrayList<String>(Arrays.asList("ア", "イ", "ウ", "エ", "オ",
				"カ", "キ", "ク", "ケ", "コ", "サ", "シ", "ス", "セ", "ソ", "タ", "チ", "ツ", "テ", "ト",
				"ナ", "ニ", "ヌ", "ネ", "ノ", "ハ", "ヒ", "フ", "ヘ", "ホ", "マ", "ミ", "ム", "メ", "モ",
				"ヤ", "ユ", "ヨ", "ラ", "リ", "ル", "レ", "ロ", "ワ", "ヲ", "ン"));

		// データを格納する変数を定義
		List<List<Map<String, Object>>> l_list = new ArrayList<>();

		// それぞれの文字から始まる漫画をアイウエオ順に取得
		for(int i = 0; i < syllabary.size(); i++ ) {
			// SQL文作成
			String sql = "SELECT ruby FROM comic WHERE ruby LIKE ? ORDER BY ruby ASC";

			// ?の箇所を置換するデータの配列を定義
			Object[] param = { syllabary.get(i) + "%" };

			// クエリを実行
			l_list.add(jdbcTemplate.queryForList(sql, param));
		}

		// 取得したデータを返す
		return l_list;

	}
}
