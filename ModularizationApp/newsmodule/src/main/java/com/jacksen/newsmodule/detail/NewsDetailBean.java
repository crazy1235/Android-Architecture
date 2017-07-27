package com.jacksen.newsmodule.detail;

import java.util.List;

/**
 * 一则新闻bean
 * <p>
 * Created by jacksen on 2017/7/27.
 */

public class NewsDetailBean {
    private String id;

    private String title;

    private String image;

    private String body;

    private String image_source;

    private String share_url;

    private String type;

    private String ga_prefix;

    private List<String> recommenders;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getImage_source() {
        return image_source;
    }

    public void setImage_source(String image_source) {
        this.image_source = image_source;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGa_prefix() {
        return ga_prefix;
    }

    public void setGa_prefix(String ga_prefix) {
        this.ga_prefix = ga_prefix;
    }

    public List<String> getRecommenders() {
        return recommenders;
    }

    public void setRecommenders(List<String> recommenders) {
        this.recommenders = recommenders;
    }
}
