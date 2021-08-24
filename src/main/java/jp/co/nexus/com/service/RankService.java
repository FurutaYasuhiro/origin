package jp.co.nexus.com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.nexus.com.repository.RankDao;

/**
 * RankService.java
 * 漫画人気ランキングで表示する漫画データを
 * RankDaoクラスからRankControllerクラスに提供する
 *
 * @author 山﨑 柊吾
 *
 */
@Service
public class RankService {

	@Autowired
	RankDao rankDao;

	/**
	 * RankDaoクラスより評価が高い30件の漫画データを取得し
	 * 1〜10位、11〜20位、21〜30位のリストにそれぞれ分割する
	 *
	 * @return list List<List>データ [[1〜10位], [11〜20位], [21〜30位]]
	 */
	public List<List<Map<String, Object>>> comicRank() {

		// データを返すList<List<Map<String, Object>>>型の変数を定義
		List<List<Map<String, Object>>> l_list = new ArrayList<List<Map<String, Object>>>();

		// 1〜10位、11〜20位、21〜30位のデータを格納するList型変数を定義
		List<Map<String, Object>> top_list;
		List<Map<String, Object>> mid_list;
		List<Map<String, Object>> bot_list;

		// Daoファイルより評価が高い上位30件の漫画データを取得
		List<Map<String, Object>> list = rankDao.comicRank();

		// 1〜10位、11〜20位、21〜30位に分割
		top_list = list.subList(0, 10);
		mid_list = list.subList(10, 20);
		bot_list = list.subList(20, 30);

		// l_listにデータを格納
		l_list.add(top_list);
		l_list.add(mid_list);
		l_list.add(bot_list);

		// l_listデータを返す
		return l_list;
	}
}
