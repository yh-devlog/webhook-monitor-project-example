import React, {useState, useEffect} from 'react';
import axios from 'axios'; //API 통신 라이브러리 (npm install axios)

function WebhookList(){
	// 1. 상태 정의
	const [events, setEvents] = useState([]); 
	
	// 2. 컴포넌트가 처음 렌더링될 때 실행될 효과정의
	useEffect(() => {
		const fetchEvents = async () => {
			try{
				//백엔드 API 호출 (Spring Boot의 GET Api)
				const response = await axios.get('/api/events');
				//3. 응단 데이터를 상태에 저장하여 화면 업데이트
				setEvents(response.data); 
			}catch (error){
				console.log("이벤트 불러오기 실패: ", error);
			}
		};
		
		fetchEvents(); //함수 실
		
	}, []); // 의존생 배열이 비어있으면  ('[]'), 컴포넌트 마운트 시 한 번만 실행됨.
	
	return(
		<div>
			<h2>웹훅 이벤트 목록</h2>
			<ul>
				{events.map(event => ( // 상태(events)를 기반으로 목록 렌더링
					<li key={event.id}>
						**ID:** {event.id} | **타입:** {event.type}
					</li>
				))}
			</ul>
		</div>
	);
}

export default WebhookList;