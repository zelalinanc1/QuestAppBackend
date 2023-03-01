package com.project.questapp.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.questapp.entities.Comment;
public interface CommentRepository extends JpaRepository<Comment,Integer> {

	List<Comment> findByUserIdAndPostId(Integer userId, Integer postId);

	List<Comment> findByUserId(Integer userId);

	List<Comment> findByPostId(Integer postId);
	
	@Query(value = "select 'commented on', c.post_id, u.avatar, u.user_name from "
			+ "comments c left join users u on u.id = c.user_id "
			+ "where c.post_id in :postIds ", nativeQuery = true)
	List<Object> findUserCommentsByPostId(@Param("postIds") List<Integer> postIds);

}
