//jdbcTemplate을 이용한 DAO
package com.test.app.product.impl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.test.app.product.ProductVO;


public class ProductDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	

//  상품테이블(상품번호, 상품분류, 이미지 절대경로, 브랜드, 상품명, 가격, 할인율, 원산지, 유통기한, 판매량, 재고량)
//  상품등록 시 입력받는 것들 = 이미지(파일 업로드), 분류, 브랜드, 상품명, 가격, 상세정보, 원산지, 유통기한, 재고량}
	private	String sql_insertP = "INSERT INTO product(pno, pcode, pimg_src, pbrand, pname, pprice, pdetail, porigin, pperiod, pstock) " + 
			"VALUES(LPAD(PROD_SEQ.NEXTVAL, 3, 0), ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private	String sql_updateP = "UPDATE product SET pcode=?, pimg_src=?, pbrand=?, pname=?, pprice=?, pdetail=?, porigin=?, pperiod=?, pstock=? WHERE pno=?"; 
	private	String sql_deleteP = "DELETE FROM product WHERE pno = ?";
	
	private	String sql_selectOne = "SELECT * FROM product WHERE pno = ?";
	private	String sql_selectAll = "SELECT * FROM product ORDER BY pno DESC";    
	private String sql_selectTOP = "SELECT * FROM product ORDER BY psales DESC"; // 판매인기순
	private	String sql_selectAllHP = "SELECT * FROM product ORDER BY pprice DESC"; // 높은 가격순
	private	String sql_selectAllLP = "SELECT * FROM product ORDER BY pprice"; // 낮은 가격순
	private	String sql_selectAlmostSoldOut = "SELECT * FROM product ORDER BY pstock"; // 매진임박순
	
	private String sql_filterPcode = "SELECT * FROM product WHERE pcode = ?"; // 상품분류 기반 필터 {VITA, LACT, EYES}
	private String sql_searchPname = "SELECT * FROM product WHERE pname LIKE '%'||?||'%'"; // 상품명 기반 검색 쿼리
	
	private String sql_selectTOP6 = "SELECT * FROM (SELECT * FROM product ORDER BY psales DESC) WHERE ROWNUM <= 6"; // 판매인기순 TOP6
	private	String sql_selectAllHP6 = "SELECT * FROM (SELECT * FROM product ORDER BY pprice DESC) WHERE ROWNUM <=6"; // 높은 가격순 TOP6
	private	String sql_selectAllLP6 = "SELECT * FROM (SELECT * FROM product ORDER BY pprice) WHERE ROWNUM <=6"; // 낮은 가격순 TOP6
	private	String sql_selectAlmostSoldOut6 = "SELECT * FROM (SELECT * FROM product ORDER BY pstock) WHERE ROWNUM <=6"; // 매진임박순 TOP6

	
	private String sql_selectTOPPcode = "SELECT * FROM product WHERE pcode = ? ORDER BY psales DESC"; // 판매인기순 
	private	String sql_selectAllHPPcode = "SELECT * FROM product WHERE pcode = ? ORDER BY pprice DESC"; // 높은 가격순
	private	String sql_selectAllLPPcode = "SELECT * FROM product WHERE pcode = ? ORDER BY pprice"; // 낮은 가격순
	private	String sql_selectAlmostSoldOutPcode = "SELECT * FROM product WHERE pcode = ? ORDER BY pstock"; // 매진임박순
	
	

	
	// 상품등록
	public void insertProduct(ProductVO vo)  { 
		//System.out.println("상품 추가 DAO");
		jdbcTemplate.update(sql_insertP, vo.getPcode(),vo.getPimg_src(),vo.getPbrand(),vo.getPname(), vo.getPprice(),vo.getPdetail(),vo.getPorigin(), vo.getPperiod(), vo.getPstock());
		
	}
	
	// 상품수정
	public void updateProduct(ProductVO vo) {
		//System.out.println("상품수정DAO");
		jdbcTemplate.update(sql_updateP, vo.getPcode(),vo.getPimg_src(),vo.getPbrand(),vo.getPname(), vo.getPprice(),vo.getPdetail(),vo.getPorigin(), vo.getPperiod(), vo.getPstock(),vo.getPno());
	}
	
	// 상품리스트 조회
	public ArrayList<ProductVO> selectAll() {
		//System.out.println("Product selectAll수행중");
		return (ArrayList<ProductVO>) jdbcTemplate.query(sql_selectAll, new ProductRowMapper());
	}
	
	// 판매량
	public ArrayList<ProductVO> selectAllTOP() {
		//System.out.println("Product selectAllTOP수행중");
		return (ArrayList<ProductVO>) jdbcTemplate.query(sql_selectTOP, new ProductRowMapper());
	}
	
	// 판매량 TOP6
	public ArrayList<ProductVO> selectAllTOP6() {
		//System.out.println("Product selectAllTOP6수행중");
		return (ArrayList<ProductVO>) jdbcTemplate.query(sql_selectTOP6, new ProductRowMapper());
	}
	
	// 높은 가격순 
	public ArrayList<ProductVO> selectAllHigh() {
		//System.out.println("Product selectAllHigh수행중");
		return (ArrayList<ProductVO>) jdbcTemplate.query(sql_selectAllHP, new ProductRowMapper());
	}
	
	// 높은 가격순  TOP6
	public ArrayList<ProductVO> selectAllHigh6() {
		//System.out.println("Product selectAllHigh6수행중");
		return (ArrayList<ProductVO>) jdbcTemplate.query(sql_selectAllHP6, new ProductRowMapper());
	}
	
	// 낮은 가격순
	public ArrayList<ProductVO> selectAllLow() {
		//System.out.println("Product selectAllLow수행중");
		return (ArrayList<ProductVO>) jdbcTemplate.query(sql_selectAllLP, new ProductRowMapper());
	}
	
	// 낮은 가격순 TOP6
	public ArrayList<ProductVO> selectAllLow6() {
		//System.out.println("Product selectAllLow6수행중");
		return (ArrayList<ProductVO>) jdbcTemplate.query(sql_selectAllLP6, new ProductRowMapper());
	}
	
	// 매진임박순
	public ArrayList<ProductVO> selectAlmostSoldOut() {
		//System.out.println("Product selectAlmostSoldOut수행중");
		return (ArrayList<ProductVO>) jdbcTemplate.query(sql_selectAlmostSoldOut, new ProductRowMapper());
	}
	
	// 매진임박순 TOP6
	public ArrayList<ProductVO> selectAlmostSoldOut6() {
		//System.out.println("Product selectAlmostSoldOut6수행중");
		return (ArrayList<ProductVO>) jdbcTemplate.query(sql_selectAlmostSoldOut6, new ProductRowMapper());
	}
	
	// 상품 본문조회
	public ProductVO selectOne(ProductVO vo) {
		//System.out.println("Product selectOne수행중");
		Object[] obj = {vo.getPno()};
		return jdbcTemplate.queryForObject(sql_selectOne,obj,new ProductRowMapper());
	}
  
	//  상품삭제
	public boolean deleteProduct(ProductVO vo) {
		//System.out.println("ProductVO deleteNotice수행중");
		int cnt = jdbcTemplate.update(sql_deleteP,vo.getPno());
		if(cnt == 1) {
			return true;
		}
		return false;
	}

	// 상품분류 필터  메서드
	public ArrayList<ProductVO> filterProductCode(ProductVO vo) { 
		//System.out.println("Product filterProductCode수행중");
		Object[] obj = {vo.getPcode()};
		return (ArrayList<ProductVO>) jdbcTemplate.query(sql_filterPcode,obj, new ProductRowMapper());
	}
	
	// 상품명 검색  메서드
	public ArrayList<ProductVO> searchProductName(ProductVO vo) { 
		//System.out.println("Product filterProductCode수행중");
		Object[] obj = {vo.getSearchword()};
		return (ArrayList<ProductVO>) jdbcTemplate.query(sql_searchPname,obj, new ProductRowMapper());
	}

	// pcode 분류
	public ArrayList<ProductVO> selectTOPPcode(ProductVO vo) {
		//System.out.println("Product selectTOPPcode수행중");
		Object[] obj = {vo.getPcode()};
		return (ArrayList<ProductVO>) jdbcTemplate.query(sql_selectTOPPcode,obj, new ProductRowMapper());
	}
	
	public ArrayList<ProductVO> selectAllHPPcode(ProductVO vo) {
		//System.out.println("Product selectAllHPPcode수행중");
		Object[] obj = {vo.getPcode()};
		return (ArrayList<ProductVO>) jdbcTemplate.query(sql_selectAllHPPcode,obj, new ProductRowMapper());
	}
	
	
	public ArrayList<ProductVO> selectAllLPPcode(ProductVO vo) {
		//System.out.println("Product selectAllLPPcode수행중");
		Object[] obj = {vo.getPcode()};
		return (ArrayList<ProductVO>) jdbcTemplate.query(sql_selectAllLPPcode,obj, new ProductRowMapper());
	}
	
	
	public ArrayList<ProductVO> selectAlmostSoldOutPcode(ProductVO vo) {
		//System.out.println("Product selectAlmostSoldOutPcode수행중");
		Object[] obj = {vo.getPcode()};
		return (ArrayList<ProductVO>) jdbcTemplate.query(sql_selectAlmostSoldOutPcode,obj, new ProductRowMapper());
	}
	
	
}


class ProductRowMapper implements RowMapper<ProductVO>{

	@Override
	public ProductVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductVO data=new ProductVO();
		
		data.setPno(rs.getString("pno"));
		data.setPcode(rs.getString("pcode"));
		data.setPimg_src(rs.getString("pimg_src"));
		data.setPbrand(rs.getString("pbrand"));
		data.setPname(rs.getString("pname"));
		data.setPprice(rs.getInt("pprice"));
		data.setPdiscount(rs.getString("pdiscount"));
		data.setPdetail(rs.getString("pdetail"));
		data.setPorigin(rs.getString("porigin"));
		data.setPperiod(rs.getString("pperiod"));
		data.setPsales(rs.getInt("psales"));
		data.setPstock(rs.getInt("pstock"));
		
		return data;
	}
	
}