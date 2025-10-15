# ================================
# 1️⃣ Stage 1 - Build the JAR file
# ================================
FROM maven:3.9.6-eclipse-temurin-21 AS build

# Set working directory inside the container
WORKDIR /app

# Copy the pom.xml and download dependencies first (for faster builds)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the rest of the source code
COPY src ./src

# Build the application (creates a JAR file inside /app/target)
RUN mvn clean package -DskipTests

# ================================
# 2️⃣ Stage 2 - Run the application
# ================================
FROM eclipse-temurin:21-jdk

# Set working directory for runtime container
WORKDIR /app

# Copy the JAR file from the previous stage
COPY --from=build /app/target/automobile-backend-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080 (Render will map this automatically)
EXPOSE 8080


# Run the JAR file
CMD ["java", "-jar", "app.jar"]
