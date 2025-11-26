import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class WebhookContoller {

	private final WebhookEventRepository repository;
	
	//생성자 주입
	public WebhookController(WebhookEventRepository repository){
		this.repository = repository;
	}

	//실제로는 Service 등을 이용해 처리하지만, 여기서는 간단히 로그 출력
	@PostMapping("/webhook")
	public String receiveWebhook(@RequestBody Map<String, Object> payload){
			// 1. JSON Map을 String으로 변환 (전체 페이로드를 저장하기 위해)
			String payloadString = payload.toString();
			
			// 2. JPA 엔티티 객체 생성
			WebhookEvent event = new WebhookEvent();
			event.setType((String) patload.get("hook_id")); // 임시필드
			event.setRawPayload(payloadString);
			
			// 2. Repository를 사용하여 DB에 저장
			repository.save(event);
		
		return "Webhook received and saved successfully";
	}
}