package com.test.app.product.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.app.product.ProductService;
import com.test.app.product.ProductVO;

@Service("productService")
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDAO2 productDao;
	
	@Override
	public void insertProduct(ProductVO vo) {
		productDao.insertProduct(vo);
	}

	@Override
	public void updateProduct(ProductVO vo) {
		productDao.updateProduct(vo);
	}

	@Override
	public List<ProductVO> selectAll() {
		return productDao.selectAll();
	}

	@Override
	public List<ProductVO> selectAllTOP() {
		return productDao.selectAllTOP();
	}

	@Override
	public List<ProductVO> selectAllTOP6() {
		return productDao.selectAllTOP6();
	}

	@Override
	public List<ProductVO> selectAllHigh() {
		return productDao.selectAllHigh();
	}

	@Override
	public List<ProductVO> selectAllHigh6() {
		return productDao.selectAllHigh6();
	}

	@Override
	public List<ProductVO> selectAllLow() {
		return productDao.selectAllLow();
	}

	@Override
	public List<ProductVO> selectAllLow6() {
		return productDao.selectAllLow6();
	}

	@Override
	public List<ProductVO> selectAlmostSoldOut() {
		return productDao.selectAlmostSoldOut();
	}

	@Override
	public List<ProductVO> selectAlmostSoldOut6() {
		return productDao.selectAlmostSoldOut6();
	}

	@Override
	public ProductVO selectOne(ProductVO vo) {
		return productDao.selectOne(vo);
	}

	@Override
	public boolean deleteProduct(ProductVO vo) {
		return productDao.deleteProduct(vo);
	}

	@Override
	public List<ProductVO> filterProductCode(ProductVO vo) {
		return productDao.filterProductCode(vo);
	}

	@Override
	public List<ProductVO> searchProductName(ProductVO vo) {
		return productDao.searchProductName(vo);
	}

	@Override
	public List<ProductVO> selectTOPPcode(ProductVO vo) {
		return productDao.selectTOPPcode(vo);
	}

	@Override
	public List<ProductVO> selectAllHPPcode(ProductVO vo) {
		return productDao.selectAllHPPcode(vo);
	}

	@Override
	public List<ProductVO> selectAllLPPcode(ProductVO vo) {
		return productDao.selectAllLPPcode(vo);
	}

	@Override
	public List<ProductVO> selectAlmostSoldOutPcode(ProductVO vo) {
		return productDao.selectAlmostSoldOutPcode(vo);
	}

}
