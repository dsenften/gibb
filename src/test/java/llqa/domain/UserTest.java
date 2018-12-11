package llqa.domain;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import javax.persistence.PersistenceException;
import llqa.repository.PersistenceEmbeddedTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

class UserTest extends PersistenceEmbeddedTest {

   private static final String USER_NAME = "John";
   private static final String USER_PASSHASH = "passhash";
   private static final String USER_REALNAME = "John Miller";
   private static final String USER_COMMENT = "a comment";
   private static final User.State USER_STATE = User.State.ACTIVATED;

   @Autowired
   private TestEntityManager testEntityManager;

   @Test
   void persistUserIfOkReturnIt() {
      // given
      User userToPersist = this.createUser();

      // when
      User persistedUser = this.testEntityManager.persistFlushFind(userToPersist);

      // then
      assertThat(persistedUser).isNotNull();
      assertThat(persistedUser.getId()).isNotNull();
      assertThat(persistedUser.getId()).isGreaterThan(0L);
      assertThat(persistedUser.getUsername()).isEqualTo(USER_NAME);
      assertThat(persistedUser.getPassword()).isEqualTo(USER_PASSHASH);
      assertThat(persistedUser.getRealname()).isEqualTo(USER_REALNAME);
      assertThat(persistedUser.getComment()).isEqualTo(USER_COMMENT);
      assertThat(persistedUser.getStatus()).isEqualTo(USER_STATE);
   }

   @Test
   void persistUserInvalidNameShouldFailAndThrowException() {
      // given
      User userToPersist = this.createUser();
      userToPersist.setUsername(null);

      // when
      assertThatThrownBy(() -> this.testEntityManager.persist(userToPersist))
            .isInstanceOf(PersistenceException.class)
            .hasMessageContaining("not-null property references a null or transient value")
            .hasMessageContaining("User.username");
   }

   @Test
   void persistInvalidPasshashShouldFailAndThrowException() {
      // given
      User userToPersist = this.createUser();
      userToPersist.setPassword(null);

      // when
      assertThatThrownBy(() -> this.testEntityManager.persist(userToPersist))
            .isInstanceOf(PersistenceException.class)
            .hasMessageContaining("not-null property references a null or transient value")
            .hasMessageContaining("User.password");
   }

   @Test
   void persistInvalidRealNameShouldFailAndThrowException() {
      // given
      User userToPersist = this.createUser();
      userToPersist.setRealname(null);

      // when
      assertThatThrownBy(() -> this.testEntityManager.persist(userToPersist))
            .isInstanceOf(PersistenceException.class)
            .hasMessageContaining("not-null property references a null or transient value")
            .hasMessageContaining("User.realname");
   }

   @Test
   void persistInvalidStateShouldFailAndThrowException() {
      // given
      User userToPersist = this.createUser();
      userToPersist.setStatus(null);

      // when
      assertThatThrownBy(() -> this.testEntityManager.persist(userToPersist))
            .isInstanceOf(PersistenceException.class)
            .hasMessageContaining("not-null property references a null or transient value")
            .hasMessageContaining("User.status");
   }

   @Test
   void persistEmptyCommentShouldNotFailAndPersist() {
      // given
      User userToPersist = this.createUser();
      userToPersist.setComment(null);

      // when
      User persistedUser = this.testEntityManager.persistFlushFind(userToPersist);

      // then
      assertThat(persistedUser).isNotNull();
      assertThat(persistedUser.getId()).isNotNull();
      assertThat(persistedUser.getId()).isGreaterThan(0L);
      assertThat(persistedUser.getUsername()).isEqualTo(USER_NAME);
      assertThat(persistedUser.getPassword()).isEqualTo(USER_PASSHASH);
      assertThat(persistedUser.getRealname()).isEqualTo(USER_REALNAME);
      assertThat(persistedUser.getComment()).isNull();
      assertThat(persistedUser.getStatus()).isEqualTo(USER_STATE);
   }

   private User createUser() {
      return User
            .userBuilder()
            .username(USER_NAME)
            .realname(USER_REALNAME)
            .password(USER_PASSHASH)
            .comment(USER_COMMENT)
            .status(USER_STATE)
            .createdAt(CURRENT_TIMESTAMP)
            .createdBy(USER_CREATE_BY)
            .updatedAt(CURRENT_TIMESTAMP)
            .updatedBy(USER_UPDATED_BY)
            .build();
   }
}