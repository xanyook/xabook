package org.xanyook.xabook.model;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.xanyook.xabook.model.util.FileExtensionEnum;

@Entity
@Table( name = "IMAGE", uniqueConstraints = { @UniqueConstraint( name = "UC_URI", columnNames = { "URI" } ) } )
@Access( AccessType.FIELD )
public class Image implements Serializable {

    private static final long serialVersionUID = -6757919448816719922L;

    @OneToOne( mappedBy = "image", optional = false )
    private Book              book;

    @Enumerated( EnumType.STRING )
    @Column( name = "FILE_EXTENSION", nullable = false, length = 5 )
    private FileExtensionEnum fileExtension;

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "ID", nullable = false, scale = 10 )
    private Long              id;

    @Column( name = "SIZE", nullable = false, scale = 10 )
    private Integer           size;

    @Column( name = "URI", nullable = false, length = 200 )
    private String            uri;

    public Book getBook() {
        return book;
    }

    public FileExtensionEnum getFileExtension() {
        return fileExtension;
    }

    public Long getId() {
        return id;
    }

    public Integer getSize() {
        return size;
    }

    public String getUri() {
        return uri;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setFileExtension(FileExtensionEnum fileExtension) {
        this.fileExtension = fileExtension;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
