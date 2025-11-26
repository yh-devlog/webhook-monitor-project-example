// WebhookEventRepository.java (CRUD 제공)
import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository를 상속받는 것만으로 CRUD 메서드(save, findById, findAll 등)가 자동 생성됨
public interface WebhookEventRepository extends JpaRepository<WebhookEvent, Long>{
}