package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Post;

import java.util.List;

/**
 * 投稿リポジトリ
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    /**
     * 削除されていない投稿一覧を取得します。
     * @return 投稿一覧
     */
    @Query("select p from Post p where p.deleted = false")
    public List<Post> findAllPosts();
}
