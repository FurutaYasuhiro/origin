package jp.co.nexus.com.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public String comicList() {

		// 画面遷移先を漫画一覧画面に指定
		String res = "com/list";

		// DBより漫画一覧をアイウエオ順に取得
		List<List<Map<String, Object>>> l_list = listService.searchRuby();
		
		System.out.println(l_list);

		return res;
	}

}
