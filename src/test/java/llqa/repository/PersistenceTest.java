package llqa.repository;

import static llqa.JUnitTags.PERSISTENCE_TEST;

import java.sql.Timestamp;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DataJpaTest
@ExtendWith(SpringExtension.class)
@EnableJpaRepositories(basePackages = "llqa.repository")
@Tag(PERSISTENCE_TEST)
public abstract class PersistenceTest {

   protected static final String USER_CREATE_BY = "test";
   protected static final String USER_UPDATED_BY = "test";
   protected static final Timestamp CURRENT_TIMESTAMP = new Timestamp(System.currentTimeMillis());
}