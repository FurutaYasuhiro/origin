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
		
		// リクエストパラメータを保存
		attr.addFlashAttribute("comicName", comicName);
		attr.addFlashAttribute("authorName", authorName);
		attr.addFlashAttribute("publisherName", publisherName);

		// 取得するリストの変数を定義
		List<Map<String, Object>> list = new ArrayList<>();
		
		// エラーメッセージを格納する変数を定義
		String message = new String();

		// 漫画名タブ選択時
		if(button.equals("comicNameTab")) {
			
			// 漫画名が未入力もしくはカタカナ以外だった場合
			if(comicName.isBlank() || !comicName.matches("^[ァ-ヶー]*$")) {
				
				// 漫画名が未入力の場合
				if(comicName.isBlank()) {
					
					// エラーメッセージを代入
					message = "漫画名が未入力です。";
					
				// 漫画名がカタカナ以外だった場合
				} else {
					
					// エラーメッセージを代入
					message = "カタカナで漫画名を入力してください";
				}
				
				// エラーメッセージを保存
				attr.addFlashAttribute("message", message);
				
				// 漫画検索画面にリダイレクト
				return "redirect:/comic/search"; 
			}

			// データを取得
			list = comicSearchService.comicNameSearch(comicName);

		// 作者名タブ選択時
		} else if(button.equals("authorTab")) {
			
			// 作者名が未入力の場合
			if(authorName.isBlank()) {
				
				// エラーメッセージを代入
				message = "作者名が未入力です。";
				
				// エラーメッセージを保存
				attr.addFlashAttribute("message", message);
				
				// 漫画検索画面にリダイレクト
				return "redirect:/comic/search";
			}

			// データを取得
			list = comicSearchService.authorNameSearch(authorName);
			
		// 出版社タブ選択時	
		} else {
			
			// 出版社が未入力の場合
			if(publisherName.isBlank()) {
				
				// エラーメッセージを代入
				message = "出版社が未入力です。";
				
				// エラーメッセージを保存
				attr.addFlashAttribute("message", message);
				
				// 漫画検索画面にリダイレクト
				return "redirect:/comic/search";
			}
			
			// データを取得
			list = comicSearchService.publisherNameSearch(publisherName);
		}
		
		// 取得したリストを保存
		attr.addFlashAttribute("comic_list", list);
		
		// 検索結果が存在しなかった場合
		if(list.isEmpty()) {
			message = "該当する漫画はありません。";
			attr.addFlashAttribute("message", message);
		}
		
		// 漫画検索画面にリダイレクト
		return "redirect:/comic/search";

	}


}
