package jp.co.nexus.com.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.nexus.com.service.ListService;

/**
* ListController.java
* comic_libraryの漫画一覧機能に関するアプリケーション制御を行うクラス
*
* @author 山﨑 柊吾
*
*/
@Controller
@RequestMapping("/comic")
public class ListController {

	@Autowired
	ListService listService;

	@GetMapping("/list")
	public String comicList(Model model) {

		// 画面遷移先を漫画一覧画面に指定
		String res = "com/list";
		
		// 50音の配列を定義
		List<String> syllabary = new ArrayList<String>(Arrays.asList("ア", "イ", "ウ", "エ", "オ",
				"カ", "キ", "ク", "ケ", "コ", "サ", "シ", "ス", "セ", "ソ", "タ", "チ", "ツ", "テ", "ト",
				"ナ", "ニ", "ヌ", "ネ", "ノ", "ハ", "ヒ", "フ", "ヘ", "ホ", "マ", "ミ", "ム", "メ", "モ",
				"ヤ", "ユ", "ヨ", "ラ", "リ", "ル", "レ", "ロ", "ワ", "ヲ", "ン"));

		// DBより漫画一覧をアイウエオ順に取得
		List<List<Map<String, Object>>> l_list = listService.searchRuby();

		// 取得したリストデータを保存
		model.addAttribute("l_list", l_list);
		
		// 50音の配列データを保存
		model.addAttribute("syllabary", syllabary);

		return res;
	}

}
