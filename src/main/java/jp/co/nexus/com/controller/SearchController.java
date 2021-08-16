package jp.co.nexus.com.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* TopController.java
* comic_libraryの漫画検索画面機能に関するアプリケーション制御を行うクラス
*
* @author 山﨑 柊吾1
*
*/
@Controller
@RequestMapping("/comic")
public class SearchController {



	@GetMapping("/search")
	public String search() {

		// 画面遷移先を漫画検索画面に指定
		String res = "com/search";


		return res;
	}


}
