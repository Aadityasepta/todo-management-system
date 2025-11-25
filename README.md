# To-Do Management System

A full-stack web application built with **Java Spring Boot**, **Thymeleaf**, **MySQL** for managing personal tasks with user authentication and authorization.

## 🚀 Features

- **User Authentication & Authorization**
  - User registration with email and username validation
  - Secure login with Spring Security
  - Password encryption using BCrypt
  - Session-based authentication

- **Task Management**
  - Create new tasks with title and description
  - View all tasks in a dashboard
  - Mark tasks as completed or pending
  - Delete tasks
  - Filter tasks by status (All, Pending, Completed)

- **Modern UI**
  - Responsive design
  - Clean and intuitive interface
  - Beautiful gradient themes
  - Mobile-friendly

- **Bonus Features**
  - Email reminders for pending tasks (optional)
  - Scheduled task to check reminders daily

## 🛠️ Tech Stack

- **Backend**: Java 17, Spring Boot 3.2.0
- **Frontend**: Thymeleaf, HTML5, CSS3, JavaScript
- **Database**: MySQL 8.0+
- **Security**: Spring Security 6
- **Build Tool**: Maven
- **Email**: Spring Boot Mail Starter (optional)

## 📋 Prerequisites

Before running this application, make sure you have:

- Java 17 or higher installed
- MySQL 8.0 or higher installed
- Maven 3.6+ installed
- HeidiSQL or any MySQL client (optional)

## 🔧 Installation & Setup

### 1. Clone the Repository

```bash
git clone <repository-url>
cd todo-management-system
```

### 2. Database Setup

**Option A: Using HeidiSQL or MySQL Workbench**
- Open HeidiSQL/MySQL Workbench
- Connect to your MySQL server
- Run the SQL script: `database_schema.sql`

**Option B: Using Command Line**

```bash
mysql -u root -p
```

Then run:
```sql
CREATE DATABASE todo_management_db;
```

### 3. Configure Database Connection

Open `src/main/resources/application.properties` and update:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/todo_management_db
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
```

### 4. Build the Project

```bash
mvn clean install
```

### 5. Run the Application

```bash
mvn spring-boot:run
```

Or run the main class:
```bash
java -jar target/todo-management-system-1.0.0.jar
```

### 6. Access the Application

Open your browser and navigate to:
```
http://localhost:8080
```

## 📖 Usage

### Registration
1. Go to http://localhost:8080/register
2. Fill in username, email, and password
3. Click "Register"

### Login
1. Go to http://localhost:8080/login
2. Enter your username and password
3. Click "Login"

### Dashboard
After login, you'll be redirected to the dashboard where you can:
- Add new tasks
- View all your tasks
- Filter tasks by status (All/Pending/Done)
- Mark tasks as complete
- Delete tasks

## 📧 Email Reminders Setup (Optional)

To enable email reminders:

1. Open `application.properties`
2. Uncomment and configure the email settings:

```properties
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your-email@gmail.com
spring.mail.password=your-app-password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

**For Gmail:**
- Enable 2-factor authentication
- Generate an App Password
- Use the App Password in the configuration

## 🗂️ Project Structure

```
todo-management-system/
├── src/
│   ├── main/
│   │   ├── java/com/todoapp/
│   │   │   ├── config/
│   │   │   │   └── SecurityConfig.java
│   │   │   ├── controller/
│   │   │   │   ├── AuthController.java
│   │   │   │   └── TaskController.java
│   │   │   ├── entity/
│   │   │   │   ├── User.java
│   │   │   │   └── Task.java
│   │   │   ├── repository/
│   │   │   │   ├── UserRepository.java
│   │   │   │   └── TaskRepository.java
│   │   │   ├── service/
│   │   │   │   ├── UserService.java
│   │   │   │   ├── TaskService.java
│   │   │   │   └── EmailService.java
│   │   │   └── TodoManagementSystemApplication.java
│   │   └── resources/
│   │       ├── static/css/
│   │       │   └── style.css
│   │       ├── templates/
│   │       │   ├── register.html
│   │       │   ├── login.html
│   │       │   └── dashboard.html
│   │       └── application.properties
├── database_schema.sql
├── pom.xml
└── README.md
```

## 🔐 Security Features

- Password encryption using BCrypt
- CSRF protection enabled
- Session-based authentication
- Role-based access control
- XSS protection

## 🎨 Screenshots

### Login Page
Clean and modern login interface

### Dashboard
Intuitive dashboard with task management features

## 🐛 Troubleshooting

### Database Connection Issues
- Ensure MySQL is running
- Check database credentials in `application.properties`
- Verify database exists: `todo_management_db`

### Port Already in Use
Change the port in `application.properties`:
```properties
server.port=8081
```

### Email Not Working
- Check SMTP settings
- Ensure less secure app access is enabled (for Gmail)
- Verify firewall settings.

## 👨‍💻 Author

Aaditya Septa


**Happy Task Management! 📝✅**
