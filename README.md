# Security Management Microservice

This is a Spring Boot microservice for Security Management, using an H2 in-memory database. It exposes endpoints to fetch roles, channels, audit levels, and permissions, with scheduled caching for fast responses.

## Features
- Spring Boot REST API
- H2 in-memory database with sample data
- Lombok for boilerplate code
- Log4j2 for comprehensive logging
- Scheduled cache refresh every 5 minutes
- Endpoints for roles, channels, audit levels, and permissions

## Setup
1. **Clone the repository**
2. **Build and run the project:**

   **Development (default):**
   ```bash
   mvn spring-boot:run
   ```

   **UAT Environment:**
   ```bash
   mvn spring-boot:run -Dspring.profiles.active=uat
   ```

   **Production Environment:**
   ```bash
   mvn spring-boot:run -Dspring.profiles.active=prod
   ```

3. **Access H2 Console (DEV/UAT only):**
   - URL: `http://localhost:8080/h2-console`
   - JDBC URL: `jdbc:h2:mem:securitydb` (DEV) or `jdbc:h2:file:./data/securitydb-uat` (UAT)
   - User: `sa`, Password: `password`

## API Endpoints
All endpoints are prefixed with `/api/security`.

### 1. Get Roles
- **GET** `/api/security/getRoles`
- **Response:**
  ```json
  [
    {"roleId":"ADMIN","roleNm":"Administrator","adGrp":"AD_ADMIN","recOrd":1,"defaultFlag":null},
    ...
  ]
  ```

### 2. Get Channels
- **GET** `/api/security/getChannels`
- **Response:**
  ```json
  [
    {"chanId":"WEB","chanNm":"Web Channel","adGrp":"AD_WEB","recOrd":1,"defaultFlag":null},
    ...
  ]
  ```

### 3. Get Audit Levels
- **GET** `/api/security/getAuditLevels`
- **Response:**
  ```json
  [
    {"audLvlId":"AL1","audLvlNm":"Audit Level 1", ... , "defaultFlag":null},
    ...
  ]
  ```

### 4. Get Permissions
- **POST** `/api/security/getPermission`
- **Request Body:**
  ```json
  {"roleId": "ADMIN", "permsCategoryName": "Category1"}
  ```
- **Response:**
  ```json
  [
    {"permsId":"PERM1","permsNm":"Permission 1","adGrp":"AD_PERM1","defaultFlag":null},
    ...
  ]
  ```

## Environment-Specific Logging Configuration

The application supports three different environments with tailored logging configurations for optimal performance and debugging capabilities.

### Development (dev)
- **Log Level**: DEBUG
- **Console Output**: Colored, detailed logging with timestamps and thread information
- **File Logs**: `logs/security-management-dev.log`
- **Features**: 
  - Full SQL logging with parameter binding
  - Spring Framework debug logs
  - Hibernate debug logs
  - Detailed application logs
  - Colored console output for better readability
  - In-memory database for quick development cycles

### UAT (uat)
- **Log Level**: INFO
- **Console Output**: Standard logging format
- **File Logs**: `logs/security-management-uat.log`
- **Features**: 
  - Moderate logging for testing and validation
  - SQL queries logged to file only (not console)
  - Spring Framework info logs
  - Application business logic logs
  - File-based database for data persistence
  - Larger log file size (50MB) with extended retention

### Production (prod)
- **Log Level**: WARN/ERROR
- **Console Output**: Only ERROR level messages
- **File Logs**: 
  - `logs/security-management-prod.log` (main application logs)
  - `logs/security-management-prod-error.log` (error logs only)
  - `logs/security-management-prod-performance.log` (performance monitoring)
- **Features**: 
  - Minimal logging for optimal performance
  - Separate performance monitoring logs
  - No SQL logging to reduce overhead
  - H2 console disabled for security
  - Large log file size (100MB) with extended retention (30 files)
  - Database validation mode (no schema changes)

### Log File Management
- **Rotation**: Daily rotation with size-based triggers
- **Compression**: Old log files are automatically compressed (.gz)
- **Retention**: 
  - DEV: 10 files, 10MB each
  - UAT: 20 files, 50MB each  
  - PROD: 30 files, 100MB each
- **Location**: All logs are stored in the `logs/` directory

## Notes
- The cache is refreshed every 5 minutes by a scheduler.
- The H2 database is in-memory (DEV) or file-based (UAT/PROD).
- All queries filter out deprecated records as per requirements.
- Logs are written to the `logs` directory with automatic rotation.
- Use `-Dspring.profiles.active=dev|uat|prod` to switch environments.

## License
MIT 