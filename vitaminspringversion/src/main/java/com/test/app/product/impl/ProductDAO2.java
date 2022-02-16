//mybatis를 이용한 DAO
package com.test.app.product.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.test.app.product.ProductVO;

@Repository("productDAO")
public class ProductDAO2 {

	@Autowired
	private SqlSessionTemplate mybatis;

	public void insertProduct(ProductVO vo) {
		//System.out.println("상품 추가 DAO");
		mybatis.insert("ProductDAO.insertProduct", vo);
	}

	// 상품수정
	public void updateProduct(ProductVO vo) {
		//System.out.println("상품수정DAO");
		mybatis.update("ProductDAO.updateProduct", vo);
	}

//  상품삭제
	public boolean deleteProduct(ProductVO vo) {
		//System.out.println("ProductVO deleteNotice수행중");
		int cnt = mybatis.delete("ProductDAO.deleteProduct", vo);
		if (cnt == 1) {
			return true;
		}
		return false;
	}

	// 상품 본문조회
	public ProductVO selectOne(ProductVO vo) {
		//System.out.println("Product selectOne수행중");
		return mybatis.selectOne("ProductDAO.selectOne", vo);
	}

	// 상품리스트 조회
	public List<ProductVO> selectAll() {
		//System.out.println("Product selectAll수행중");
		return mybatis.selectList("ProductDAO.selectAll");
	}

	// 판매량
	public List<ProductVO> selectAllTOP() {
		//System.out.println("Product selectAllTOP수행중");
		return mybatis.selectList("ProductDAO.selectTOP");
	}

	// 판매량 TOP6
	public List<ProductVO> selectAllTOP6() {
		//System.out.println("Product selectAllTOP6수행중");
		return mybatis.selectList("ProductDAO.selectTOP6");
	}

	// 높은 가격순
	public List<ProductVO> selectAllHigh() {
		//System.out.println("Product selectAllHigh수행중");
		return mybatis.selectList("ProductDAO.selectAllHP");
	}

	// 높은 가격순 TOP6
	public List<ProductVO> selectAllHigh6() {
		//System.out.println("Product selectAllHigh6수행중");
		return mybatis.selectList("ProductDAO.selectAllHP6");
	}

	// 낮은 가격순
	public List<ProductVO> selectAllLow() {
		//System.out.println("Product selectAllLow수행중");
		return mybatis.selectList("ProductDAO.selectAllLP");
	}

	// 낮은 가격순 TOP6
	public List<ProductVO> selectAllLow6() {
		//System.out.println("Product selectAllLow6수행중");
		return mybatis.selectList("ProductDAO.selectAllLP6");
	}

	// 매진임박순
	public List<ProductVO> selectAlmostSoldOut() {
		//System.out.println("Product selectAlmostSoldOut수행중");
		return mybatis.selectList("ProductDAO.selectAlmostSoldOut");
	}

	// 매진임박순 TOP6
	public List<ProductVO> selectAlmostSoldOut6() {
		//System.out.println("Product selectAlmostSoldOut6수행중");
		return mybatis.selectList("ProductDAO.selectAlmostSoldOut6");
	}

	// 상품명 검색 메서드
	public List<ProductVO> searchProductName(ProductVO vo) {
		//System.out.println("Product searchPro수행중");
		return mybatis.selectList("ProductDAO.searchPname", vo);
	}

	// 상품분류 필터 메서드
	public List<ProductVO> filterProductCode(ProductVO vo) {
		//System.out.println("Product filterProductCode수행중");
		return mybatis.selectList("ProductDAO.filterPcode", vo);
	}

	// pcode 분류
	public List<ProductVO> selectTOPPcode(ProductVO vo) {
		//System.out.println("Product selectTOPPcode수행중");
		return mybatis.selectList("ProductDAO.selectTOPPcode", vo);
	}

	public List<ProductVO> selectAllHPPcode(ProductVO vo) {
		//System.out.println("Product selectAllHPPcode수행중");
		return mybatis.selectList("ProductDAO.selectAllHPPcode", vo);
	}

	public List<ProductVO> selectAllLPPcode(ProductVO vo) {
		//System.out.println("Product selectAllLPPcode수행중");
		return mybatis.selectList("ProductDAO.selectAllLPPcode", vo);
	}

	public List<ProductVO> selectAlmostSoldOutPcode(ProductVO vo) {
		//System.out.println("Product selectAlmostSoldOutPcode수행중");
		return mybatis.selectList("ProductDAO.selectAlmostSoldOutPcode", vo);
	}

}
