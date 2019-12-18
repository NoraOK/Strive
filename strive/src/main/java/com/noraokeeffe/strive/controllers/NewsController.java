package com.noraokeeffe.strive.controllers;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.noraokeeffe.strive.services.NewsService;

@Controller
public class NewsController {
	private final NewsService newsService;

	public NewsController(NewsService newsService) {
		this.newsService = newsService;
	}
	
	@RequestMapping("/feed")
	public String newsFeed(Model model) throws IOException {
		model.addAttribute("articles", newsService.getNews().getAsJsonArray().iterator());
		return "strive/feed.jsp";
	}
}
