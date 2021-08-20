package jp.co.nexus.com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.nexus.com.repository.ListDao;

/**
 * ListService.java
 * 漫画一覧画面で表示する漫画情報を
 * ListDaoクラスからListControllerクラスに提供する
 *
 * @author 山﨑 柊吾
 *
 */
@Service
public class ListService {

	@Autowired
	ListDao listDao;

	/**
	 * 漫画一覧画面で表示する漫画情報を取得
	 * @param comic_name
	 * @return list 全件取得結果のList
	 */
	public List<List<Map<String, Object>>> searchRuby() {

		// データを取得
		List<List<Map<String, Object>>> l_list = listDao.searchRuby();

		// データを返す
		return l_list;
	}
}
