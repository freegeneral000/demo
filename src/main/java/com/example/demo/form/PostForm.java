package com.example.demo.form;

/**
 * 投稿フォーム
 */
public class PostForm {

    /** タイトル */
    private String title;

    /** 内容　*/
    private String content;

    /**
     * タイトルを取得します。
     * @return タイトル
     */
    public String getTitle() {
        return title;
    }

    /**
     * タイトルを設定します。
     * @param title タイトル
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 内容を取得します。
     * @return 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 内容を設定します。
     * @param content 内容
     */
    public void setContent(String content) {
        this.content = content;
    }
}
