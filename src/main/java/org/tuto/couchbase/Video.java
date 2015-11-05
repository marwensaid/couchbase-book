package org.tuto.couchbase;


public class Video {
    private String id;
    private String title;
    private String date;
    private String link;
    private String source;

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", source='" + source + '\'' +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", publisher='" + link + '\'' +
                '}';
    }


    public String getId() {

        return id;
    }

    public String getSource() {
        return source;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getLink() {
        return link;
    }

    public Video setId(String id) {
        this.id = id;
        return this;
    }

    public Video setSource(String source) {
        this.source = source;
        return this;
    }

    public Video setTitle(String title) {
        this.title = title;
        return this;
    }

    public Video setDate(String date) {
        this.date = date;
        return this;
    }

    public Video setLink(String link) {
        this.link = link;
        return this;
    }
}
