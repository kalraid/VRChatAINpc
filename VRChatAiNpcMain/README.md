	compile group: 'org.springframework.boot', name: 'spring-boot', version: '2.2.6.RELEASE'
	compile 'org.springframework.boot:spring-boot-starter-web'
	compile group: 'org.springframework.boot', name: 'spring-boot-autoconfigure', version: '2.2.5.RELEASE'
	implementation 'org.springframework.boot:spring-boot-starter-actuator'
	implementation 'org.springframework.boot:spring-boot-starter-amqp'
	implementation 'org.springframework.boot:spring-boot-starter-batch'
	implementation 'org.springframework.cloud:spring-cloud-starter-netflix-eureka-client'
	compileOnly 'org.projectlombok:lombok'
	developmentOnly 'org.springframework.boot:spring-boot-devtools'
	annotationProcessor 'org.springframework.boot:spring-boot-configuration-processor'
	annotationProcessor 'org.projectlombok:lombok'
	implementation 'org.springframework.boot:spring-boot-starter-jdbc'
	implementation 'org.mariadb.jdbc:mariadb-java-client'
	
	testCompile group: 'org.springframework.boot', name: 'spring-boot-starter-test', version: '2.2.5.RELEASE'
	testImplementation 'org.springframework.amqp:spring-rabbit-test'
	testImplementation 'org.springframework.batch:spring-batch-test'
	testImplementation 'org.springframework.restdocs:spring-restdocs-mockmvc'
    testImplementation('org.junit.jupiter:junit-jupiter-api:5.2.0')
    testCompile('org.junit.jupiter:junit-jupiter-params:5.2.0')
    testRuntime('org.junit.jupiter:junit-jupiter-engine:5.2.0')
