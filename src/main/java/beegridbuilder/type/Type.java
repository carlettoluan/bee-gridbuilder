package beegridbuilder.type;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Type {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idType;
  private String description;
  private String color;

  public Long getIdType() {
    return idType;
 }

 public void setIdType(Long idType) {
  this.idType = idType;
}
public String getDescription() {
  return description;
}
public void setDescription(String description) {
  this.description = description;
}
public String getColor() {
  return color;
}
public void setColor(String color) {
  this.color = color;
}


}
