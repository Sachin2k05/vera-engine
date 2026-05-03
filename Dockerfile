FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY . .

# ✅ ADD THIS LINE (IMPORTANT FIX)
RUN chmod +x mvnw

RUN ./mvnw clean package -DskipTests

CMD ["java", "-jar", "target/demo-0.0.1-SNAPSHOT.jar"]