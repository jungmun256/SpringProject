package com.test.app.product;

import org.springframework.web.multipart.MultipartFile;

public class ProductVO {
	private String pno;
	private String pcode;
	private String pimg_src;
	private String pbrand;
	private String pname;
	private int pprice;
	private String pdiscount;
	private String pdetail;
	private String porigin;
	private String pperiod;
	private int psales;
	private int pstock;

	private MultipartFile file;
	private String searchword;

	public String getSearchword() {
		return searchword;
	}

	public void setSearchword(String searchword) {
		this.searchword = searchword;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getPno() {
		return pno;
	}

	public void setPno(String pno) {
		this.pno = pno;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getPimg_src() {
		return pimg_src;
	}

	public void setPimg_src(String pimg_src) {
		this.pimg_src = pimg_src;
	}

	public String getPbrand() {
		return pbrand;
	}

	public void setPbrand(String pbrand) {
		this.pbrand = pbrand;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPprice() {
		return pprice;
	}

	public void setPprice(int pprice) {
		this.pprice = pprice;
	}

	public String getPdiscount() {
		return pdiscount;
	}

	public void setPdiscount(String pdiscount) {
		this.pdiscount = pdiscount;
	}

	public String getPdetail() {
		return pdetail;
	}

	public void setPdetail(String pdetail) {
		this.pdetail = pdetail;
	}

	public String getPorigin() {
		return porigin;
	}

	public void setPorigin(String porigin) {
		this.porigin = porigin;
	}

	public String getPperiod() {
		return pperiod;
	}

	public void setPperiod(String pperiod) {
		this.pperiod = pperiod;
	}

	public int getPsales() {
		return psales;
	}

	public void setPsales(int psales) {
		this.psales = psales;
	}

	public int getPstock() {
		return pstock;
	}

	public void setPstock(int pstock) {
		this.pstock = pstock;
	}

	@Override
	public String toString() {
		return "ProductVO [pno=" + pno + ", pcode=" + pcode + ", pimg_src=" + pimg_src + ", pbrand=" + pbrand
				+ ", pname=" + pname + ", pprice=" + pprice + ", pdiscount=" + pdiscount + ", pdetail=" + pdetail
				+ ", porigin=" + porigin + ", pperiod=" + pperiod + ", psales=" + psales + ", pstock=" + pstock
				+ ", file=" + file + ", searchword=" + searchword + "]";
	}

	
}