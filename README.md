# OSS_dev_competition, 공개SW 개발자 대회

### Description 
- QR코드를 이용한 간편 결제부터, 신원 인증까지 QR코드의 활용은 더 증가하는 추세임.
- 그런데 QR코드는 `큐싱` 이라고 하여 보안관련 이슈가 있음. 
- 따라서 QR코드가 갖는 데이터를 암호화 하는 라이브러리를 생성함으로써 IT 산업 전반의 보안과 신뢰성을 향상시키는 공개SW를 개발하고자함
- 해당 레파지토리는 그러한 `secureQR` 라이브러리를 적용한 하나의 예시로서, REST API 서버의 역할을 수행함.



#### Metohd : `POST` , `/addCrypto` 
- 서버에 해시함수 방식, 암호화/복호화 방식에 대해 설정하는 API 요청
해당 API를 아무나 요청하면 안되기 떄문에 현재는 HTTP BODY 에 "token" : "value" 형식으로 접근하도록 설정되어있음.
서비스에 적합하게 JWT 적용, 또는 Spring Security 적용등이 가능

#### Method : `POST` , `/generator` 
- 클라이언트로부터 `secureQR`이미지 생성 요청을 처리하는 API 예제로서, byte[] 또는 File 객체를 반환할 수 있음. 
![공소 레포트 준비](https://user-images.githubusercontent.com/54317409/132018326-60096090-bdde-44c1-9fa8-66027785dc24.png)

#### Method : `POST`, `/authQR`
- 안드로이드 앱 클라이언트가 특정 QR 이미지를 읽은 데이터를 HTTP BODY에 담아 보내면,
- 해당 서버에서 본 프로젝트에서 제공하는 `secureQR` 인지 아닌지를 판단하고,
- `secureQR`이라면 QR코드의 데이터를 복호화하여 응답하는 API 요청

(그림 추가 예정)
