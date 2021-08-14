package jp.co.nexus.com.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* ComicDetailController.java
* comic_libraryの漫画詳細情報画面機能に関するアプリケーション制御を行うクラス
*
* @author 古田 恭大
*
*/
@Controller
@RequestMapping("/comic")
public class ComicDetailController {



	@GetMapping("/comic_detail")
	public String comic_detail() {

		// 画面遷移先を漫画詳細情報画面に指定
		String res = "com/comic_detail";


		return res;
	}


}
