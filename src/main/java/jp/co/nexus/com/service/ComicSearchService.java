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
	 * 漫画検索画面で漫画名タブ選択時
	 * @param comic_name
	 * @return list 全件取得結果のList
	 */
	public List<Map<String, Object>> comicNameSearch(String comic_name) {

		// データを取得
		List<Map<String, Object>> list = comicSearchDao.comicNameSearch(comic_name);

		// 取得したリストを返す
		return list;
	}
}
