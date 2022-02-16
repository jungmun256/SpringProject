//jdbcTemplate을 이용한 DAO
package com.test.app.product.impl;

import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("crawlDAO")
public class CrawlDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// 비타민
	public void insertCrawlDB() throws Exception {

		String sql_InsertVITA = "INSERT INTO product(pno, pcode, pimg_src, pbrand, pname, pprice, pdiscount, porigin, pperiod, psales, pstock) "
				+ "VALUES(LPAD(PROD_SEQ.NEXTVAL, 3, 0), 'VITA'," + "?,"
				+ "DECODE(ROUND(DBMS_RANDOM.VALUE(1, 5)), 1, '네이처메이드', 2, '네추럴라이즈', 3, '한미헬스케어', 4, '어피어', 5, '라이프익스텐션'),"
				+ "?," + "?," + "'0%',"
				+ "DECODE(ROUND(DBMS_RANDOM.VALUE(1, 7)),1, '국내산', 2, '중국산', 3, '미국산', 4, '대만산', 5, '일본산', 6, '독일산', 7, '파푸아뉴기니산'),"
				+ "DECODE(ROUND(DBMS_RANDOM.VALUE(1, 7)),1,'2022년 4월',2,'2022년 9월',3,'2022년 12월',4,'2023년 5월',5,'2023년 7월',6,'2023년 11월',7,'유통기한만료'),"
				+ "ROUND(DBMS_RANDOM.VALUE(1, 200)), ROUND(DBMS_RANDOM.VALUE(1, 200)))";
		String sql_InsertLACT = "INSERT INTO product(pno, pcode, pimg_src, pbrand, pname, pprice, pdiscount, porigin, pperiod, psales, pstock) "
				+ "VALUES(LPAD(PROD_SEQ.NEXTVAL, 3, 0), 'LACT', " + "?, "
				+ "DECODE(ROUND(DBMS_RANDOM.VALUE(1, 5)), 1, '엔젯오리진', 2, '닥터브라이언', 3, '라플레', 4, '어피어', 5, '라이프익스텐션'), "
				+ "?, " + "?, " + "'0%',"
				+ "DECODE(ROUND(DBMS_RANDOM.VALUE(1, 7)),1, '국내산', 2, '중국산', 3, '미국산', 4, '대만산', 5, '일본산', 6, '독일산', 7, '파푸아뉴기니산'),"
				+ "DECODE(ROUND(DBMS_RANDOM.VALUE(1, 7)),1,'2022년 4월',2,'2022년 9월',3,'2022년 12월',4,'2023년 5월',5,'2023년 7월',6,'2023년 11월',7,'유통기한만료'),"
				+ "ROUND(DBMS_RANDOM.VALUE(1, 200)), ROUND(DBMS_RANDOM.VALUE(1, 200)))";
		String sql_InsertEYES = "INSERT INTO product(pno, pcode, pimg_src, pbrand, pname, pprice, pdiscount, porigin, pperiod, psales, pstock) "
				+ "VALUES(LPAD(PROD_SEQ.NEXTVAL, 3, 0), 'EYES', " + "?, "
				+ "DECODE(ROUND(DBMS_RANDOM.VALUE(1, 5)), 1, '닥터브라이언', 2, '네추럴라이즈', 3, '한미헬스케어', 4, '어피어', 5, '라이프익스텐션'), "
				+ "?, " + "?, " + "'0%',"
				+ "DECODE(ROUND(DBMS_RANDOM.VALUE(1, 7)),1, '국내산', 2, '중국산', 3, '미국산', 4, '대만산', 5, '일본산', 6, '독일산', 7, '파푸아뉴기니산'),"
				+ "DECODE(ROUND(DBMS_RANDOM.VALUE(1, 7)),1,'2022년 4월',2,'2022년 9월',3,'2022년 12월',4,'2023년 5월',5,'2023년 7월',6,'2023년 11월',7,'유통기한만료'),"
				+ "ROUND(DBMS_RANDOM.VALUE(1, 200)), ROUND(DBMS_RANDOM.VALUE(1, 200)))";
		// 상품별로 순차적으로 url을 수정한다.
		String url1 = "https://www.uppear.co.kr/goods/goods_list.php?page=1&cateCd=003005&sort=&pageNum=40"; // 종합비타민
		String url2 = "https://www.uppear.co.kr/goods/goods_list.php?cateCd=003001"; // 유산균
		String url3 = "https://www.uppear.co.kr/goods/goods_list.php?cateCd=003015"; // 눈건강

		String sql_Insert[] = { sql_InsertVITA, sql_InsertLACT, sql_InsertEYES };
		String url[] = { url1, url2, url3 };

		int result = 0;
		for (int i = 0; i < 3; i++) {
			Document doc = Jsoup.connect(url[i]).get(); // url의 HTML 코드를 가져온다.
			Elements ele = doc.select("div.goods_list_cont"); // 그 중 div의 item_cont 클래스 태그로 둘러쌓인 부분을 가져온다.
			Iterator<Element> itr_img_src1 = ele.select("div.item_photo_box > a > img").iterator(); // 정상
			Iterator<Element> itr_name1 = ele.select("strong.item_name").iterator(); // 정상
			Iterator<Element> itr_price1 = ele.select("strong.item_price").iterator(); // 정상

			while (itr_name1.hasNext()) {
				System.out.println("crawling");
				jdbcTemplate.update(sql_Insert[i], itr_img_src1.next().attr("abs:src"), itr_name1.next().text(),Integer.parseInt(itr_price1.next().text().replaceAll("[,원]", "")));

				result++;
			}
		}
		System.out.println("크롤링 데이터 수 : " + result);

	}

	public void deleteVITA() {
		System.out.println("크롤링 데이터 삭제");
		String sql_deleteVITA = "truncate table product";
		jdbcTemplate.update(sql_deleteVITA);
	}

}