package jp.co.nexus.com.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* TopController.java
* comic_libraryの人気漫画ランキング画面機能に関するアプリケーション制御を行うクラス
*
* @author 古田 恭大
*
*/
@Controller
@RequestMapping("/comic")
public class RankController {



	@GetMapping("/rank")
	public String rank() {

		// 画面遷移先を人気漫画ランキング画面に指定
		String res = "com/rank";


		return res;
	}


}
