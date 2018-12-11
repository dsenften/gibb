package llqa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Immutable
@Table(name = "user_privileges_view")
public class UserPrivilege implements Cloneable {

   @Id
   Long id;

   @Enumerated(EnumType.STRING)
   @Column(name = "code", nullable = false)
   private PrivilegeCode privilegeCode;

   @Column(nullable = false)
   private Long userId;

   @Override
   public UserPrivilege clone() throws CloneNotSupportedException {
      UserPrivilege clonedUserPrivilege = (UserPrivilege) super.clone();

      clonedUserPrivilege.setPrivilegeCode(this.getPrivilegeCode());
      clonedUserPrivilege.setUserId(this.getUserId());

      return clonedUserPrivilege;
   }
}