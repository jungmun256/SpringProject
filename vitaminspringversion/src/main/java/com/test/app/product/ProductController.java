package com.test.app.product;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.springframework.ui.Model;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

@Controller
@SessionAttributes("pdata")
public class ProductController {

	@Autowired
	ProductService ps;
	
	final String path ="/Users/jm/Web_3/springworkspace/vitaminproject2/src/main/webapp/getImg/";
	
	@RequestMapping("/product_manage.pro")
	public String productManage(Model model) {
		//System.out.println("상품관리페이지");
		model.addAttribute("pdatas", ps.selectAll());
		return "manage.jsp";
	}

	@RequestMapping(value="/product_insert.pro")
	public String productInsert(ProductVO vo) throws IllegalStateException, IOException {

		//System.out.println("상품 추가 확인"+vo);
		MultipartFile file = vo.getFile();

		if(!file.isEmpty()) {
			//업로드를 했다면,
			String fileName = file.getOriginalFilename();
			System.out.println("업로드 파일 이름 : "+fileName);
			
			file.transferTo(new File(path+fileName));
			vo.setPimg_src("getImg/"+fileName);
		}
		else {
			vo.setPimg_src("getImg/mutlivitamin.jpg");//디폴트로 출력할 이미지
		}
		//System.out.println("디폴트 이미지 추가된후" + vo);
		ps.insertProduct(vo);
		return "product_manage.pro";
	}


	@RequestMapping("/product_detail.pro")
	public String productDetail(ProductVO vo, Model model) {
		model.addAttribute("pdata", ps.selectOne(vo));
		return "shop_detail.jsp";
	}

	@RequestMapping("/product_modi.pro")
	public String productModipage(ProductVO vo,Model model){
		model.addAttribute("pdata", ps.selectOne(vo));
		return "product_modi.jsp";
	}

	@RequestMapping("/product_update.pro")
	public String productUpdate(@ModelAttribute("pdata") ProductVO vo, Model model) throws IllegalStateException, IOException  {
		//System.out.println("상품 수정");

		MultipartFile file = vo.getFile();

		if(!file.isEmpty()) {
			//업로드를 했다면,
			String fileName = file.getOriginalFilename();
			//System.out.println("상품 수정 업로드 파일 이름 : "+fileName);
			
			file.transferTo(new File(path+fileName));
			vo.setPimg_src("getImg/"+fileName);
		}
		else {
			vo.setPimg_src("getImg/mutlivitamin.jpg");//디폴트로 출력할 이미지
		}
		//System.out.println("상품 수정디폴트 이미지 추가된후" + vo);
		ps.updateProduct(vo);
		return "product_manage.pro";
	}

	@RequestMapping("/product_delete.pro")
	public String productDelete(ProductVO vo) {

		ps.deleteProduct(vo);
		return "product_manage.pro";


	}

	@RequestMapping("/product_search.pro")
	public String productSearch(ProductVO vo,Model model) {
		model.addAttribute("pdatas", ps.searchProductName(vo));
		return "shop_grid.jsp";
	}

	
	@RequestMapping("/product_filterselect.pro")
	public String productpcodeFilter(ProductVO vo, Model model) {

		if (vo.getPcode() == null) {
			model.addAttribute("pdatas", ps.selectAll());
		} else {

			model.addAttribute("pdatas", ps.filterProductCode(vo));
		}
		model.addAttribute("pcode", vo.getPcode());

		// shop_grid.jsp에서 가격순으로 보기를 누른 경우 정렬된 데이터들 가지고 바로 shop_grid 페이지로 이동
		return "shop_grid.jsp";
	}

	@RequestMapping("/product_cartin.pro")
	public String productCartin(ProductVO vo, HttpSession session, Model model) {

		// 장바구니 리스트를 준비
		ArrayList<ProductVO> cart_datas = (ArrayList<ProductVO>) session.getAttribute("cart_datas");
		ProductVO cart_data = ps.selectOne(vo);

		// 만약 장바구니에 아무 정보가 없을 시에 장바구니를 새로 생성
		if (session.getAttribute("cart_datas") == null) {
			cart_datas = new ArrayList<ProductVO>();
		}

		// 로그인이 되었을 시에 생성된 장바구니에 들어갈 데이터를 저장
		if (session.getAttribute("mid") != null) {
			cart_datas.add(cart_data);
			session.setAttribute("cart_datas", cart_datas);
			model.addAttribute("pno", vo.getPno());
			return "product_detail.pro";
		} else {
			return "login.jsp";
		}

	}

	@RequestMapping("/product_payment.pro")
	public String productPayment(HttpSession session) {
		session.removeAttribute("cart_datas");
		return "main.do";
	}

	@RequestMapping("/product_selectall.pro")
	public String productSelectall(ProductVO vo, Model model) {
		model.addAttribute("pdatas", ps.selectAll());
		model.addAttribute("pcode", vo.getPcode());
		// 전체상품 보기를 누른 경우 위 데이터들을 가지고 바로 shop_grid 페이지로 이동
		return "shop_grid.jsp";
	}

	@RequestMapping("/product_selectallhigh.pro")
	public String productSelectallhigh(ProductVO vo, Model model) {

		if (vo.getPcode() == null) {
			model.addAttribute("pdatas", ps.selectAllHigh());
			
		} else {
			model.addAttribute("pdatas", ps.selectAllHPPcode(vo));
		}
		model.addAttribute("pcode", vo.getPcode());
		return "shop_grid.jsp";
	}

	@RequestMapping("/product_selectalllow.pro")
	public String productSelectalllow(ProductVO vo, Model model) {

		if (vo.getPcode() == null) {
			model.addAttribute("pdatas", ps.selectAllLow());
		} else {

			model.addAttribute("pdatas", ps.selectAllLPPcode(vo));
		}
		model.addAttribute("pcode", vo.getPcode());

		// shop_grid.jsp에서 가격순으로 보기를 누른 경우 정렬된 데이터들 가지고 바로 shop_grid 페이지로 이동
		return "shop_grid.jsp";
	}

	@RequestMapping("/product_selectalltop.pro")
	public String productSelectalltop(ProductVO vo, Model model) {


		if (vo.getPcode() != null) {
			model.addAttribute("pdatas", ps.selectTOPPcode(vo));
		} else {
			model.addAttribute("pdatas", ps.selectAllTOP());
		}
		model.addAttribute("pcode", vo.getPcode());

		return "shop_grid.jsp";
	}

	@RequestMapping("/product_selectsoldout.pro")
	public String productselectAlmostsoldOut(ProductVO vo,Model model) {

		if (vo.getPcode() == null) {
			model.addAttribute("pdatas", ps.selectAlmostSoldOut());
		} else {
			model.addAttribute("pdatas", ps.selectAlmostSoldOutPcode(vo));
		}
		model.addAttribute("pcode", vo.getPcode());

		return "shop_grid.jsp";
	}

}
