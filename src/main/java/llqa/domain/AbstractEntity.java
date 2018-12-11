package llqa.domain;


import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@NoArgsConstructor
public abstract class AbstractEntity implements Cloneable {

   @CreatedBy
   @Column(name="created_by", nullable = false, updatable = false)
   private String createdBy;

   @LastModifiedDate
   @Column(name="updated_at")
   private Timestamp updatedAt;

   @CreatedDate
   @Column(name="created_at", updatable = false)
   private Timestamp createdAt;

   @LastModifiedBy
   @Column(name="updated_by", nullable = false)
   private String updatedBy;

   public abstract void setId(Long id);

   public abstract Long getId();

   public AbstractEntity(AbstractEntity src) {
      this.setId(src.getId());
      this.setCreatedBy(src.getCreatedBy());
      this.setCreatedAt(src.getCreatedAt());
      this.setUpdatedBy(src.getUpdatedBy());
      this.setUpdatedAt(src.getUpdatedAt());
   }

   @Override
   public AbstractEntity clone() throws CloneNotSupportedException {
      AbstractEntity clonedAbstractEntity = (AbstractEntity) super.clone();

      clonedAbstractEntity.setId(this.getId());
      clonedAbstractEntity.setCreatedBy(this.getCreatedBy());
      clonedAbstractEntity.setCreatedAt(this.getCreatedAt());
      clonedAbstractEntity.setUpdatedBy(this.getUpdatedBy());
      clonedAbstractEntity.setUpdatedAt(this.getUpdatedAt());

      return clonedAbstractEntity;
   }
}