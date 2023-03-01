package com.project.questapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.questapp.entities.Post;

public interface PostRepository  extends JpaRepository<Post,Integer> {

	List<Post> findByUserId(Integer userId);
	
	@Query(value = "select id from posts where user_id = :userId order by create_date desc   ", nativeQuery = true)
	List<Integer> findTopByUserId(@Param("userId") Integer userId);

}
