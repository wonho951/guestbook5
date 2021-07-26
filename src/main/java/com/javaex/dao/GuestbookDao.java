package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVo;

@Repository
public class GuestbookDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	//리스트 가져오기
	public List<GuestbookVo> getguestList(){
		//System.out.println("[GuesbookCOntroller.List]");
		
		//DB에 요청해서 리스트 가져와야함
		List<GuestbookVo> guestList = sqlSession.selectList("guestbook.selectList");
		
		//확인용
		//System.out.println("dao");
		//System.out.println(guestList);
		
		return guestList;
	}
	
	//등록
	public int guestInsert(GuestbookVo guestVo) {
		System.out.println("[GuesbookCOntroller.add]");
		System.out.println(guestVo);
		
		sqlSession.insert("guestbook.guestInsert", guestVo);
		
		return 1;
	}

	
	
	//삭제
	public GuestbookVo guestDelete(GuestbookVo guestVo) {
		System.out.println("[GuestbookController.delete]");
		System.out.println(guestVo);
		
		sqlSession.delete("guestbook.guestDelete", guestVo);
		
		System.out.println(guestVo);
		
		return guestVo;
	}
	
	
	//삭제2
	public int guestDelete2(int no, String name, String password, String content, String regDate) {
		System.out.println("Dao : " + no + ", " + name + ", " + password + ", " + content + ", " + regDate);
		
		Map<String, Object> guestMap = new HashMap<String,Object>();
		guestMap.put("no", no);
		guestMap.put("name", name);
		guestMap.put("password", password);
		guestMap.put("content", content);
		guestMap.put("sysdate", regDate);
		
		int count = sqlSession.delete("guestbook.guestDelete2", guestMap);
		System.out.println(count);
		
		return count;
	}
	
	
	
	/*
	// 등록
	public int guestInsert(GuestbookVo guestVo) {
		int count = 0;
		getConnection();

		try {

			// 3. SQL문 준비 / 바인딩 / 실행
			String query = ""; // 쿼리문 문자열만들기, ? 주의
			query += " INSERT INTO guestbook ";
			query += " VALUES (SEQ_GUESTBOOK_NO.nextval, ?, ?, ?, sysdate) ";
			// System.out.println(query);

			pstmt = conn.prepareStatement(query); // 쿼리로 만들기

			pstmt.setString(1, guestVo.getName()); // ?(물음표) 중 1번째, 순서중요
			pstmt.setString(2, guestVo.getPassword()); // ?(물음표) 중 2번째, 순서중요
			pstmt.setString(3, guestVo.getContent()); // ?(물음표) 중 3번째, 순서중요

			count = pstmt.executeUpdate(); // 쿼리문 실행

			// 4.결과처리
			// System.out.println("[" + count + "건 추가되었습니다.]");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		close();
		return count;
	}

	
	// 삭제
	public int guestDelete(GuestbookVo guestVo) {
		int count = 0;
		getConnection();

		try {
			// 3. SQL문 준비 / 바인딩 / 실행
			String query = ""; // 쿼리문 문자열만들기, ? 주의
			query += " delete from guestbook ";
			query += " where no = ? ";
			query += " and password = ? ";
			pstmt = conn.prepareStatement(query); // 쿼리로 만들기

			pstmt.setInt(1, guestVo.getNo());// ?(물음표) 중 1번째, 순서중요
			pstmt.setString(2, guestVo.getPassword());
			count = pstmt.executeUpdate(); // 쿼리문 실행

			// 4.결과처리
			// System.out.println(count + "건 삭제되었습니다.");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		close();
		return count;
	}
	
	//변수명 사용시 같은 이름 사용도 할 수 있고, 그게 가장 좋은 방법이면 사용하는게 좋다.
	
	
	
	
	//삭제하기 안좋은법(no하나만 가져와서 지울때)
	public int guestDelete(int no) {

		int count = -1;

		getConnection();

		try {
			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "";
			query += " DELETE FROM guestbook ";
			query += " WHERE guestbook_id = ? ";

			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, no);

			count = pstmt.executeUpdate();

			// 4.결과처리

		} catch (SQLException e) {
			e.printStackTrace();
		}

		close();

		return count;

	}*/
	

}
