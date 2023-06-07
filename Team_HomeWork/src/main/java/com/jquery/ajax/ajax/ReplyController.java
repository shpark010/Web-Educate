package com.jquery.ajax.ajax;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jquery.ajax.action.Action;
import com.jquery.ajax.action.ActionForward;
import com.jquery.ajax.dao.CommentDAO;
import com.jquery.ajax.dto.CommentDTO;

import net.sf.json.JSONArray;

@WebServlet("*.reply")
public class ReplyController extends HttpServlet {
	CommentDAO dao = new CommentDAO();
	
    public ReplyController() {}

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       	String requestURI = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String urlcommand = requestURI.substring(contextPath.length());
    	
    	System.out.println("urlcommand : " + urlcommand);
    	
    	Action action = null;
    	ActionForward forward = null;
    	
    	if(urlcommand.equals("/select.reply")) {
    		System.out.println("시작");
    		int board_id = Integer.parseInt(request.getParameter("board_id"));
    		List<CommentDTO> replylist = dao.selectReply(board_id);
    		JSONArray commentlist = JSONArray.fromObject(replylist);
    		response.setContentType("application/json");
    		response.setCharacterEncoding("UTF-8");
            response.getWriter().write(commentlist.toString());
    	}
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
}