package com.jacksen.newsmodule.list;

import java.util.List;

/**
 * 新闻列表bean
 * <p>
 * Created by Admin on 2017/7/27.
 */

public class NewsListBean {

    private String data;
    private List<NewsDataBean> stories;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<NewsDataBean> getStories() {
        return stories;
    }

    public void setStories(List<NewsDataBean> stories) {
        this.stories = stories;
    }

    public static class NewsDataBean {
        private String id;
        private String type;
        private String title;
        private String ga_prefix;
        private String[] images;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String[] getImages() {
            return images;
        }

        public void setImages(String[] images) {
            this.images = images;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }
    }

}
