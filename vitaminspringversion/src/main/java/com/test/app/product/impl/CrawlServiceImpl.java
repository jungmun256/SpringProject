package com.test.app.product.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.app.product.CrawlService;


@Service("crawlService")
public class CrawlServiceImpl implements CrawlService{

	@Autowired
	private CrawlDAO crawlDao;
	
	@Override
	public void insertCrawlDB() {
		try {
			crawlDao.insertCrawlDB();
		} catch (Exception e) {
			System.out.println("크롤링 예외 발생"+ e);
		}
	}

	@Override
	public void deleteVITA() {
		crawlDao.deleteVITA();
	}

}
