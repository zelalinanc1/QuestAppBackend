package com.project.questapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.questapp.entities.Comment;
import com.project.questapp.requests.CommentCreateRequest;
import com.project.questapp.requests.CommentUpdateRequest;
import com.project.questapp.services.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {
	
	private CommentService commentService;

	public CommentController(CommentService commentService) {
		super();
		this.commentService = commentService;
	}
	
	@GetMapping
	public List<Comment> getAllComment(@RequestParam Optional<Integer> userId,@RequestParam Optional<Integer> postId){
		return commentService.getAllCommentsWithParam(userId,postId);
	}
	
	@GetMapping("/{commentId}")
	public Comment getOneComment(@PathVariable Integer commentId) {
		
		return commentService.getOneCommentById(commentId);
	}
	
	@PostMapping
	public Comment createOneComment(@RequestBody CommentCreateRequest request) {
		return commentService.createOneComment(request);
		
	}
	
	@PutMapping("/{commentId}")
	public Comment updateOneComment(@PathVariable Integer commentId, @RequestBody CommentUpdateRequest request) {
		
		return commentService.updateOneCommentById(commentId,request);
	}
	
	@DeleteMapping("/{commentId}")
	public void deleteOneComment(@PathVariable Integer commentId) {
		
		 commentService.deleteOneCommentById(commentId);
	}
	
	
	

}
