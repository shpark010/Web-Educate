package com.jquery.ajax.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jquery.ajax.dto.CommentDTO;
import com.jquery.ajax.utils.ConnectionHelper;

public class CommentDAO {	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	// 댓글전체조회
	public List<CommentDTO> selectReply(int board_id) {
		List<CommentDTO> commentlist = new ArrayList<>();
		try {
			conn = ConnectionHelper.getConnection("oracle");
			String sql = "select reply_id, reply_content from reply where board_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CommentDTO dto = new CommentDTO();
				dto.setBoard_id(board_id);
				dto.setReply_id(rs.getInt("reply_id"));
				dto.setReply_content(rs.getString("reply_content"));
				commentlist.add(dto);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionHelper.close(rs);
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		
		return commentlist;
	}
	
	// 입력
	
	// 수정
	
	// 삭제
}