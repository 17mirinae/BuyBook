package com.graduate.Service;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.graduate.DAO.*;
import com.graduate.DTO.*;

@Service
public class CommentService {
	private CommentDAO commentDAO;

	@Autowired
	public CommentService(CommentDAO _commentDAO) {
		this.commentDAO = _commentDAO;
	}

	public void insertComment(CommentDTO commentDTO) {
		// 댓글 업로드
		commentDAO.insertComment(commentDTO);
	}

	public void deleteComment(int inputCommentNo, int inputCommentBoardNo) {
		// 댓글 삭제
		commentDAO.deleteComment(inputCommentNo, inputCommentBoardNo);
	}
}
