package com.test.app.product;


import java.util.List;


public interface ProductService {

	
	public void insertProduct(ProductVO vo);
	
	// 상품수정
	public void updateProduct(ProductVO vo) ;
  
	// 상품리스트 조회
	public List<ProductVO> selectAll() ;	
	// 판매량
	public List<ProductVO> selectAllTOP();
			
	
	// 판매량 TOP6
	public List<ProductVO> selectAllTOP6();
	
	// 높은 가격순 
	public List<ProductVO> selectAllHigh() ;
	
	// 높은 가격순  TOP6
	public List<ProductVO> selectAllHigh6() ;
	
	
	// 낮은 가격순
	public List<ProductVO> selectAllLow() ;
	
	// 낮은 가격순 TOP6
	public List<ProductVO> selectAllLow6() ;
	
	// 매진임박순
	public List<ProductVO> selectAlmostSoldOut() ;
	// 매진임박순 TOP6
	public List<ProductVO> selectAlmostSoldOut6() ;
	
	// 상품 본문조회
	public ProductVO selectOne(ProductVO vo);
  
	//  상품삭제
	public boolean deleteProduct(ProductVO vo) ;

	// 상품분류 필터  메서드
	public List<ProductVO> filterProductCode(ProductVO vo);
	
	// 상품명 검색  메서드
	public List<ProductVO> searchProductName(ProductVO vo);
	
	// pcode 분류
	public List<ProductVO> selectTOPPcode(ProductVO vo);
	public List<ProductVO> selectAllHPPcode(ProductVO vo);
	
	public List<ProductVO> selectAllLPPcode(ProductVO vo);
	public List<ProductVO> selectAlmostSoldOutPcode(ProductVO vo);
}
