package jp.co.nexus.com.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* ListController.java
* comic_libraryの漫画一覧機能に関するアプリケーション制御を行うクラス
*
* @author 古田 恭大
*
*/
@Controller
@RequestMapping("/comic")
public class ListController {



	@GetMapping("/list")
	public String comicList() {

		// 画面遷移先を漫画一覧画面に指定
		String res = "com/list";


		return res;
	}


}
