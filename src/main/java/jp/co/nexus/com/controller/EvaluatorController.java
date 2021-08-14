package jp.co.nexus.com.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* TopController.java
* comic_libraryのtop画面機能に関するアプリケーション制御を行うクラス
*
* @author 古田 恭大
*
*/
@Controller
@RequestMapping("/comic")
public class EvaluatorController {



	@GetMapping("/evaluator")
	public String evaluator() {

		// 画面遷移先を漫画検索画面に指定
		String res = "com/evaluator";


		return res;
	}


}
