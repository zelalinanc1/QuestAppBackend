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

import com.project.questapp.entities.Post;
import com.project.questapp.requests.PostCreateRequest;
import com.project.questapp.requests.PostUpdateRequest;
import com.project.questapp.responses.PostResponse;
import com.project.questapp.services.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {

		private PostService postService;

		public PostController(PostService postService) {
			super();
			this.postService = postService;
		}
		
		@GetMapping
		public List<PostResponse> getAllPosts(@RequestParam Optional<Integer> userId) {
			
			return postService.getAllPosts(userId);
		}
		
		@GetMapping("/{postId}")
		public Post getOnePost(@PathVariable Integer postId) {
			return postService.getOnePostById(postId);
		}
		
//		@GetMapping("/{postId}")
//		public PostResponse getOnePostByIdWithLikes(@PathVariable Integer postId) {
//			return postService.getOnePostByIdWithLikes(postId);
//		}
		
		@PostMapping
		public Post createOnePost(@RequestBody PostCreateRequest newPostRequest) {
			return postService.createOnePost(newPostRequest);
		}
		
		@PutMapping("/{postId}")
		public Post updateOnePost(@PathVariable Integer postId,@RequestBody PostUpdateRequest updatePost) {
			return postService.updateOnePostById(postId,updatePost);
			
		}
		
		@DeleteMapping("/{postId}")
		public void deleteOnePost(@PathVariable Integer postId) {
			postService.deleteOnePostById(postId);
		}
		
}
