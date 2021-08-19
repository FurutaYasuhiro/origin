package jp.co.nexus.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.nexus.com.repository.ListDao;

/**
 * ListService.java
 * 漫画一覧画面で表示する漫画情報を
 * ListDaoクラスからListControllerクラスに提供する
 *
 * @author 山﨑 柊吾
 *
 */
@Service
public class ListService {

	@Autowired
	ListDao listDao;

}
