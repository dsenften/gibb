package llqa.domain;


import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends AbstractEntity implements Cloneable {

   public enum State {
      DEACTIVATED,
      ACTIVATED
   }

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSeqGenerator")
   @SequenceGenerator(name = "userSeqGenerator", sequenceName = "sq_users", allocationSize = 1)
   private Long id;

   @Column(nullable = false)
   private String username;

   @Column(name = "passhash", nullable = false)
   private String password;

   @Column(nullable = false)
   private String realname;

   private String comment;

   @Column(nullable = false)
   @Enumerated
   private State status;

   @OneToMany(fetch = FetchType.LAZY)
   @JoinColumn(name = "userId", referencedColumnName = "id", updatable = false, insertable = false)
   private Collection<UserPrivilege> userPrivilege;

   @Builder(builderMethodName = "userBuilder")
   private User(Long id, String username, String password, String realname, String comment, State status,
         Collection<UserPrivilege> userPrivilege, String createdBy, Timestamp updatedAt, Timestamp createdAt,
         String updatedBy) {
      this.id = id;
      this.username = username;
      this.password = password;
      this.realname = realname;
      this.comment = comment;
      this.status = status;
      this.userPrivilege = userPrivilege;

      this.setCreatedBy(createdBy);
      this.setUpdatedAt(updatedAt);
      this.setCreatedAt(createdAt);
      this.setUpdatedBy(updatedBy);
   }

   @Override
   public User clone() throws CloneNotSupportedException {
      User clonedUser = (User) super.clone();

      clonedUser.setUsername(this.getUsername());
      clonedUser.setPassword(this.getPassword());
      clonedUser.setRealname(this.getRealname());
      clonedUser.setComment(this.getComment());
      clonedUser.setStatus(this.getStatus());
      clonedUser.setUserPrivilege(this.getUserPrivilege()
                                      .stream()
                                      .map(p -> {
                                         try {
                                            return p.clone();
                                         } catch (CloneNotSupportedException e) {
                                            return null;
                                         }
                                      })
                                      .filter(Objects::nonNull)
                                      .collect(Collectors.toList()));

      return clonedUser;
   }
}