// WebhookEvent.java (DB 테이블 매핑)
import jakarta.persistence.*;

@Entity
@Table(name = "webhook_events")
public class WebhookEvent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String type; // 예를들어 gitHub의 'push', 'pull_request' 등
	
	@Column(columnDefinition = "TEXT")
	private String rawPayload; // 전체 JSON 본문을 String으로 저장
	
	// Getter, Setter, 생성자 등 생략
}