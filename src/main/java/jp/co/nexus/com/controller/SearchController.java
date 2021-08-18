package jp.co.nexus.com.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.co.nexus.com.service.ComicSearchService;


/**
* TopController.java
* comic_libraryの漫画検索画面機能に関するアプリケーション制御を行うクラス
*
* @author 山﨑 柊吾
*
*/
@Controller
@RequestMapping("/comic")
public class SearchController {

	@Autowired
	ComicSearchService comicSearchService;

	@GetMapping("/search")
	public String search(RedirectAttributes attr) {

		// 画面遷移先を漫画検索画面に指定
		String res = "com/search";






		return res;
	}

	@PostMapping("/search")
	public String search(@RequestParam(name = "comicName") String comicName,
			@RequestParam(name = "authorName") String authorName,
			@RequestParam(name = "publisherName") String publisherName,
			@RequestParam(name = "button") String button,
			RedirectAttributes attr) {

//		// 漫画名タブ選択時
//		if(button.equals("comicNameTab")) {

			// 取得するリストの変数を定義
			List<Map<String, Object>> list = new ArrayList<>();

			// データを取得
			list = comicSearchService.comicNameSearch(comicName);

			// 取得したリストを保存
			attr.addFlashAttribute("comic_list", list);

			// 漫画検索画面にリダイレクト
			return "redirect:/comic/search";
//		}

	}


}
