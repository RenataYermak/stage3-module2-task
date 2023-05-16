package com.mjc.school.repository.model;

import java.time.LocalDateTime;

public class NewsModel implements BaseEntity<Long> {

    private Long id;
    private String title;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdateDate;
    private Long authorId;

    public NewsModel(){
    }

    public NewsModel(Long id, String title, String content, LocalDateTime createDate, LocalDateTime lastUpdateDate, Long authorId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
        this.authorId = authorId;
    }

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }

    public LocalDateTime getCreateDate() {
        return this.createDate;
    }

    public LocalDateTime getLastUpdateDate() {
        return this.lastUpdateDate;
    }

    public Long getAuthorId() {
        return this.authorId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof NewsModel)) return false;
        final NewsModel other = (NewsModel) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$title = this.getTitle();
        final Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title)) return false;
        final Object this$content = this.getContent();
        final Object other$content = other.getContent();
        if (this$content == null ? other$content != null : !this$content.equals(other$content)) return false;
        final Object this$createDate = this.getCreateDate();
        final Object other$createDate = other.getCreateDate();
        if (this$createDate == null ? other$createDate != null : !this$createDate.equals(other$createDate))
            return false;
        final Object this$lastUpdateDate = this.getLastUpdateDate();
        final Object other$lastUpdateDate = other.getLastUpdateDate();
        if (this$lastUpdateDate == null ? other$lastUpdateDate != null : !this$lastUpdateDate.equals(other$lastUpdateDate))
            return false;
        final Object this$authorId = this.getAuthorId();
        final Object other$authorId = other.getAuthorId();
        if (this$authorId == null ? other$authorId != null : !this$authorId.equals(other$authorId)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof NewsModel;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $title = this.getTitle();
        result = result * PRIME + ($title == null ? 43 : $title.hashCode());
        final Object $content = this.getContent();
        result = result * PRIME + ($content == null ? 43 : $content.hashCode());
        final Object $createDate = this.getCreateDate();
        result = result * PRIME + ($createDate == null ? 43 : $createDate.hashCode());
        final Object $lastUpdateDate = this.getLastUpdateDate();
        result = result * PRIME + ($lastUpdateDate == null ? 43 : $lastUpdateDate.hashCode());
        final Object $authorId = this.getAuthorId();
        result = result * PRIME + ($authorId == null ? 43 : $authorId.hashCode());
        return result;
    }
}
