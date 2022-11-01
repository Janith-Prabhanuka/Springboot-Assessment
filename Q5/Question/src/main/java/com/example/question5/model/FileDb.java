package com.example.question5.model;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "Files")
public class FileDb {

  @Id
  private String id;

  private String name;

  private String type;

  @CreationTimestamp
  private Timestamp date;

  @Lob
  private byte[] uploadImageData;

  public FileDb() {

  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Timestamp getDate() {
    return date;
  }

  public void setDate(Timestamp date) {
    this.date = date;
  }

  public byte[] getUploadImageData() {
    return uploadImageData;
  }

  public void setUploadImageData(byte[] uploadImageData) {
    this.uploadImageData = uploadImageData;
  }
}
