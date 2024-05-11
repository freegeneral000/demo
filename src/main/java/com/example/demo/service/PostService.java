package com.example.demo.service;

import com.example.demo.form.PostForm;
import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 投稿サービス
 */
@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    /**
     * 投稿一覧を取得します。
     * @return 投稿フォーム一覧
     */
    public List<PostForm> getAllPosts() {
        // データベースから投稿一覧を取得する
        List<Post> posts = postRepository.findAllPosts();

        // 投稿一覧から投稿フォーム一覧を作成する
        return posts.stream()
                .map(this::convertPostToPostForm)
                .collect(Collectors.toList());
    }

    /**
     * 投稿を作成します。
     * @param postForm 投稿フォーム
     */
    public void createPost(PostForm postForm) {
        Post post = convertPostFormToPost(postForm);

        postRepository.save(post);
    }

    /**
     * 投稿を投稿フォームに変換します。
     * @param post 投稿
     * @return 投稿フォーム
     */
    private PostForm convertPostToPostForm(Post post) {
        PostForm postForm = new PostForm();
        postForm.setTitle(post.getTitle());
        postForm.setContent(post.getContent());

        return postForm;
    }

    /**
     * 投稿フォームを投稿に変換します。
     * @param postForm 投稿フォーム
     * @return 投稿
     */
    private Post convertPostFormToPost(PostForm postForm) {
        Post post = new Post();
        post.setTitle(postForm.getTitle());
        post.setContent(postForm.getContent());
        post.setDeleted(false);

        return post;
    }
}
