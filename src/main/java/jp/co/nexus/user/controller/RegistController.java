package jp.co.nexus.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



	/**
	* RegistController.java
	* comic_libraryの利用者登録画面機能に関するアプリケーション制御を行うクラス
	*
	* @author 古田 恭大
	*
	*/
	@Controller
	@RequestMapping("/user")
	public class RegistController {



		@GetMapping("/regist")
		public String reportList() {

			// 画面遷移先を利用者登録画面に指定
			String res = "user/regist";


			return res;
		}
}

