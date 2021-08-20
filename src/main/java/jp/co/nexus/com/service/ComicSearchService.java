package jp.co.nexus.com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.nexus.com.repository.ComicSearchDao;

/**
 * ComicSearchService.java
 * 漫画検索画面で検索した漫画データを
 * ComicSearchDaoクラスからSearchControllerクラスに提供する
 *
 * @author 山﨑 柊吾
 *
 */
@Service
public class ComicSearchService {

	@Autowired
	ComicSearchDao comicSearchDao;

	/**
	 * 漫画検索画面で漫画名タブ選択
	 * @param comic_name
	 * @return list 全件取得結果のList
	 */
	public List<Map<String, Object>> comicNameSearch(String comic_name) {

		// データを取得
		List<Map<String, Object>> list = comicSearchDao.comicNameSearch(comic_name);

		// 検索結果のリストに評価人数と平均評価点数を追加
		list = addEvaluate(list);

		// 取得したリストを返す
		return list;
	}

	/**
	 * 漫画検索画面で作者名タブ選択時
	 * @param author_name
	 * @return list 全件取得結果のList
	 */
	public List<Map<String, Object>> authorNameSearch(String author_name) {

		// データを取得
		List<Map<String, Object>> list = comicSearchDao.authorNameSearch(author_name);

		// 検索結果のリストに評価人数と平均評価点数を追加
		list = addEvaluate(list);

		// 取得したリストを返す
		return list;
	}

	/**
	 * 漫画検索画面で出版社タブ選択時
	 * @param publisher_name
	 * @return list 全件取得結果のList
	 */
	public List<Map<String, Object>> publisherNameSearch(String publisher_name) {

		// データを取得
		List<Map<String, Object>> list = comicSearchDao.publisherNameSearch(publisher_name);

		// 検索結果のリストに評価人数と平均評価点数を追加
		list = addEvaluate(list);

		// 取得したリストを返す
		return list;
	}


	// 検索結果のリストに各漫画の評価人数と平均評価点数を追加するメソッド
	public List<Map<String, Object>> addEvaluate(List<Map<String, Object>> list) {

		// 検索結果の各漫画の評価人数と平均評価点数を取得
		for(Map<String, Object> map : list) {

			// リストのcomic_idを取得しString変換
			String comic_id = map.get("comic_id").toString();

			// 漫画の評価人数を取得
			Map<String, Object> evaluateCount = comicSearchDao.evaluateCount(comic_id);

			// 漫画の平均評価点数を取得
			Map<String, Object> avgEvaluate = comicSearchDao.avgEvaluate(comic_id);

			// 検索結果の各リストに評価人数と平均評価点数を追加
			map.put("evaluateCount", evaluateCount.get("COUNT(*)"));
			map.put("avgEvaluate", avgEvaluate.get("AVG(score)"));
		}

		// 追加したリストを返す
		return list;
	}
}
