package jp.co.nexus.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



	/**
	* LoginController.java
	* comic_libraryの利用者ログイン画面機能に関するアプリケーション制御を行うクラス
	*
	* @author 古田 恭大
	*
	*/
	@Controller
	@RequestMapping("/user")
	public class LoginController {



		@GetMapping("/login")
		public String login() {


			// 画面遷移先を利用者ログイン画面に指定
			String res = "user/login";


			return res;
		}
}

