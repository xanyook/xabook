package org.xanyook.xabook.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.ColumnDefault;
import org.xanyook.xabook.model.util.enumeration.FileExtensionEnum;

@Entity
@Table( name = "IMAGE", uniqueConstraints = { @UniqueConstraint( columnNames = { "URI" } ) } )
@Access( AccessType.FIELD )
public class Image implements Serializable {

    private static final long serialVersionUID = -6757919448816719922L;

    @ColumnDefault( "NOW()" )
    @Column( name = "CREATION_DATE", insertable = false )
    @Temporal( TemporalType.TIMESTAMP )
    private Date              creationDate;

    @Enumerated( EnumType.STRING )
    @Column( name = "FILE_EXTENSION", nullable = false, length = 5 )
    private FileExtensionEnum fileExtension;

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "ID", nullable = false, scale = 10 )
    private Long              id;

    @ColumnDefault( "NOW()" )
    @Column( name = "LAST_MODIFICATION_DATE", insertable = false )
    @Temporal( TemporalType.TIMESTAMP )
    private Date              lastModificationDate;
    @Column( name = "SIZE", nullable = false, scale = 10 )
    private Integer           size;

    @Column( name = "URI", nullable = false, length = 200 )
    private String            uri;

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
