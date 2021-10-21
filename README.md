# secureQR-server-example
`secureQR-module` 라이브러리를 적용한 보안 QR api 서버 적용 예시

<!--OSS_dev_competition, 공개SW 개발자 대회-->

### Description 
<!--- QR코드를 이용한 간편 결제부터, 신원 인증까지 QR코드의 활용은 더 증가하는 추세임.-->
<!--- 그런데 QR코드는 `큐싱` 이라고 하여 보안관련 이슈가 있음. --->
<!--- 따라서 QR코드가 갖는 데이터를 암호화 하는 라이브러리를 생성함으로써 IT 산업 전반의 보안과 신뢰성을 향상시키는 공개SW를 개발하고자함--->
- 앞서 개발한 <a href="https://github.com/SoTree17/secureQR-module"> `secureQR-module` </a> 라이브러리를 적용한 REST API 서버로의 적용 예시
- 암호화 QR의 `암호화 방식 추가`, `암호화 QR 생성`, `암호화 QR 인증 및 결과 반환`의 역할을 수행하는 예시를 작성함. 

### Implementing Environment
- 다음과 같은 개발 환경에 `secureQR-module` 라이브러리 적용함.<br/>
 &nbsp;&nbsp;&nbsp;&nbsp;개발 언어 : ![JAVA11](http://img.shields.io/badge/-Java11-006cb7?style=flat&logo=Java) & ![JAVA](http://img.shields.io/badge/-Javascript-006cb7?style=flat&logo=Javascript)<br/>
  &nbsp;&nbsp;&nbsp;&nbsp;개발 환경 :  ![Springboot](http://img.shields.io/badge/-Springboot2.5.4-000000?style=flat&logo=springboot) & ![Springboot](http://img.shields.io/badge/-Gradle7.1.1-006cb7?style=flat&logo=gradle)

<br/>
- 이외에도 자바를 사용하는 서버라면 라이브러리를 추가함으로써 적용이 가능

 
## Build
### how to install?
1. 프로젝트를 [다운](https://github.com/SoTree17/secureQR-server-example/archive/refs/heads/main.zip)받고 IntelliJ 프로젝트로 로드합니다.  
2. InteliJ의 Gradle탭에서 Build 합니다.
3. <code>secureQR/src/main/java/com/secureQR/SecureQrApplication.java</code> 를 실행합니다.

### how to run on server? 
- 리눅스 기반 서버 환경에서 해당 레파지토리의 파일을 실행한다고 가정
- 현재 아마존 웹 호스팅 AWS에서 AMI2 가상 머신을 활용
1. 자바와 GIT 설치
```
sudo yum install java-11-openjdk-devel
sudo yum install git
```
2. 해당 서버의 시간대를 서비스 환경에 맞게 설정
```
sudo rm /etc/localtime
sudo ln –s /usr/share/zoneinfo/Asia/Seoul /etc/localtime
```
3. 해당 레파지토리를 다운받을 디렉토리 생성
```
mkdir ~/app && mkdir ~/app/QrServer
```
4. 해당 디렉토리로 이동
``` 
cd ~/app/QrServer
```
5. `git clone` 명령어를 통해 해당 레파지토리 주소를 이용하여 다운 받음
```
git clone https://github.com/SoTree17/secureQR-server-example.git
```
6. `gradle` bootjar 도구를 통해 jar파일로 생성
```
./gradlew bootjar 
```
 &nbsp; - `./gradlew` 권한 오류시 아래 명령어 입력
```
chmod +x ./gradlew
```

7. 빌드된 실행파일 경로로 이동 후, 실행
```
cd build/libs
nohup java -Djava.net.preferIPv4Stack=true -jar secureQR-0.0.1-SNAPSHOT.jar & 
java -jar secureQR-0.0.1-SNAPSHOT.jar 
```
- 백그라운드로 계속 실행할 때, nohup 명령어 이용하여 실행
- 일반적으로 테스트할때, java 명령어 이용하여 실행

8. 실행 종료시
```
 CURRENT_PID=$(pgrep -f ${PROJECT_NAME}.*.jar)
 kill -TERM CURRENT_PID
```

## API
### Method : `POST` , `/addCrypto` 
- 서버에 해시함수 방식, 암호화/복호화 방식에 대해 설정하는 API 요청
해당 API를 아무나 요청하면 안되기 때문에 현재는 HTTP BODY 에 "token" : "value" 형식으로 접근하도록 설정되어있음.

☁️ 서비스에 적합하게 JWT 적용, 또는 Spring Security 적용등이 가능

### Method : `POST` , `/generator` 
- 클라이언트로부터 `secureQR`이미지 생성 요청을 처리하는 API 예제로서, byte[] 또는 File 객체를 반환할 수 있음. 
![공소 레포트 준비](https://user-images.githubusercontent.com/54317409/132018326-60096090-bdde-44c1-9fa8-66027785dc24.png)

### Method : `POST`, `/authQR`
- 안드로이드 앱 클라이언트가 특정 QR 이미지를 읽은 데이터를 HTTP BODY에 담아 보내면,
- 해당 서버에서 본 프로젝트에서 제공하는 `secureQR` 인지 아닌지를 판단하고,
- `secureQR`이라면 QR코드의 데이터를 복호화하여 응답하는 API 요청

(그림 추가 예정)
