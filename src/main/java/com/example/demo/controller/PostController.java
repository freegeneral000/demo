package com.example.demo.controller;

import com.example.demo.form.PostForm;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.BindParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * 投稿コントローラー
 */
@Controller
public class PostController {

    @Autowired
    PostService postService;

    /**
     * 最初のページを表示します。
     * @return 最初のページ
     */
    @GetMapping("/")
    public String index()  {
        return "index";
    }

    /**
     * ウェルカムページを表示します。
     * @return ウェルカムページ
     */
    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    /**
     * 投稿一覧画面を表示します。
     * @param model モデル
     * @return 投稿一覧画面
     */
    @GetMapping("/post/list")
    public String getAllPosts(Model model) {

        List<PostForm> postForms = postService.getAllPosts();

        model.addAttribute("postForms", postForms);

        return "post-list";
    }

    /**
     * 投稿作成画面を表示します。
     * @return 投稿作成画面
     */
    @GetMapping("/post/create")
    public String showPostCreateView() {
        return "post-create";
    }

    /**
     * 投稿を登録します。
     * @param postForm 投稿フォーム
     * @param result 入力チェック結果
     * @param model モデル
     * @param redirectAttributes リダイレクト先
     */
    @PostMapping("/post/create")
    public String createPost(
            @Validated PostForm postForm,
            BindingResult result,
            Model model,
            RedirectAttributes redirectAttributes) {

        postService.createPost(postForm);

        redirectAttributes.addFlashAttribute("message", "投稿を作成しました。");

        return "redirect:/post/list";
    }
}
