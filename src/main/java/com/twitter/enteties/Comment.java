package com.twitter.enteties;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "comments", catalog = "twitter", schema = "")
@XmlRootElement
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "comment_id")
    private Long commentId;

    @Basic(optional = false)
    @Lob
    @Column(name = "comment")
    private String comment;

    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date = new java.sql.Date(new java.util.Date().getTime());

    @JoinColumn(name = "message_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Message messageId;

    public Comment() {
    }

    public Comment(Long commentId) {
        this.commentId = commentId;
    }

    public Comment(Long commentId, String comment, Date date) {
        this.commentId = commentId;
        this.comment = comment;
        this.date = date;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Message getMessageId() {
        return messageId;
    }

    public void setMessageId(Message messageId) {
        this.messageId = messageId;
    }

}
