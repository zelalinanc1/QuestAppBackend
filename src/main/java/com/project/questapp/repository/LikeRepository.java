package com.project.questapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.questapp.entities.Like;

public interface LikeRepository extends JpaRepository<Like,Integer> {

	List<Like> findByUserIdAndPostId(Integer userId, Integer postId);

	List<Like> findByUserId(Integer userId);

	List<Like> findByPostId(Integer postId);

	@Query(value = 	"select 'liked', l.post_id, u.avatar, u.user_name from "
			+ "p_like l left join user u on u.id = l.user_id "
			+ "where l.post_id in :postIds limit 5", nativeQuery = true)
	List<Object> findUserLikesByPostId(@Param("postIds") List<Integer> postIds);
}
