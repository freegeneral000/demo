package com.example.demo.controller;

import com.example.demo.form.LeaderBoardDtoForm;
import com.example.demo.form.PostForm;
import com.example.demo.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * サンプルコントローラー
 */
@Controller
public class SampleController {

    @Autowired
    SampleService sampleService;

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
     * Thymeleafのデモページを表示します。
     * @param model モデル
     * @return Thymeleafのデモページ
     */
    @GetMapping("/demo")
    public String demo(Model model) {

        Integer number = 1;
        String string = "文字列";

        model.addAttribute("num", number);
        model.addAttribute("str", string);
        model.addAttribute("sample", "サンプル文字列");

        return "demo";
    }

    /**
     * 投稿一覧画面を表示します。
     * @param model モデル
     * @return 投稿一覧画面
     */
    @GetMapping("/post/list")
    public String getAllPosts(Model model) {

        List<PostForm> postForms = sampleService.getAllPosts();

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

        sampleService.createPost(postForm);

        redirectAttributes.addFlashAttribute("message", "投稿を作成しました。");

        return "redirect:/post/list";
    }

    /**
     * リーダーボードページを表示します。
     * @param model モデル
     * @return リーダーボードページ
     */
    @GetMapping("/valorant/leaderboard")
    public String showLeaderboard(Model model) {

        LeaderBoardDtoForm leaderBoardDtoForm = sampleService.getLeaderboard();

        model.addAttribute("leaderBoardDtoForm", leaderBoardDtoForm);

        return "leaderboard";
    }
}
