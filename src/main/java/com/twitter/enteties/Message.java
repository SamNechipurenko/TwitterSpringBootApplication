package com.twitter.enteties;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "messages")
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "message")
    private String message;


    @Generated(GenerationTime.ALWAYS)
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date = new java.sql.Date(new java.util.Date().getTime());

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Comment.class)
    @JoinColumn(name ="messageId",referencedColumnName = "id")
    private List<Comment> commentsCollection;


    public Message() {
    }

    public Message(Long id) {
        this.id = id;
    }

    public Message(Long id, String message, Date date) {
        this.id = id;
        this.message = message;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @XmlTransient
    public Collection<Comment> getCommentsCollection() {
        return commentsCollection;
    }

    public void setCommentsCollection(List<Comment> commentsCollection) {
        this.commentsCollection = commentsCollection;
    }


}

