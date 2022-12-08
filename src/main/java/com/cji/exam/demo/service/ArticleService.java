package com.cji.exam.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cji.exam.demo.repository.ArticleRepository;
import com.cji.exam.demo.util.Utility;
import com.cji.exam.demo.vo.Article;
import com.cji.exam.demo.vo.ResultData;

@Service
public class ArticleService {
	
private ArticleRepository articleRepository;
	
	@Autowired
	public ArticleService(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}

	public Article getArticle(int id) {
		return articleRepository.getArticle(id);
	}

	public void deleteArticle(int id) {
		articleRepository.deleteArticle(id);
	}

	public void modifyArticle(int id, String title, String body) {
		articleRepository.modifyArticle(id, title, body);
	}

	public List<Article> getArticles() {
		
		return articleRepository.getArticles();
	}

	public ResultData<Integer> writeArticle(int loginedMemberId, String title, String body) {
		articleRepository.writeArticle(loginedMemberId, title, body);
		int id =articleRepository.getLastInsertId();
		return ResultData.from("S-1", Utility.f("%d번 게시물이 생성되었습니다.", id),id);
	}
	
}