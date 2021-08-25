package jp.co.nexus.com.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.nexus.com.service.RankService;
/**
* RankController.java
* comic_libraryの人気漫画ランキング画面機能に関するアプリケーション制御を行うクラス
*
* @author 山﨑 柊吾
*
*/
@Controller
@RequestMapping("/comic")
public class RankController {

	@Autowired
	RankService rankService;

	@GetMapping("/rank")
	public String rank(Model model) {

		// 画面遷移先を人気漫画ランキング画面に指定
		String res = "com/rank";

		// Top30の漫画データを取得
		List<List<Map<String, Object>>> l_list = rankService.comicRank();

		// Listデータを1〜10位、11〜20位、21〜30位でそれぞれ保存
		model.addAttribute("top_list", l_list.get(0));
		model.addAttribute("mid_list", l_list.get(1));
		model.addAttribute("bot_list", l_list.get(2));

		return res;
	}


}
