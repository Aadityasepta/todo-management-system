# 🚀 Quick Setup Guide - To-Do Management System

## Step-by-Step Setup Instructions

### Step 1: Database Setup

1. **Open HeidiSQL**
   - Start HeidiSQL application
   - Connect to your MySQL server (usually localhost)

2. **Create Database**
   - Click on "New" button or right-click and select "Create new" → "Database"
   - Name: `todo_management_db`
   - Charset: `utf8mb4`
   - Click OK

3. **Run SQL Script**
   - Open the file: `database_schema.sql`
   - Copy all content
   - Paste in HeidiSQL query window
   - Click "Execute" (F9)

### Step 2: Configure Application

1. **Update Database Password**
   - Open: `src/main/resources/application.properties`
   - Find line: `spring.datasource.password=`
   - Add your MySQL password (if any)
   
   Example:
   ```properties
   spring.datasource.password=mypassword
   ```

### Step 3: Build & Run

**Option A: Using Maven Command**

Open PowerShell in project folder and run:
```powershell
mvn clean install
mvn spring-boot:run
```

**Option B: Using IDE**
- Open project in IntelliJ IDEA / Eclipse / NetBeans
- Right-click on `TodoManagementSystemApplication.java`
- Select "Run"

### Step 4: Access Application

Open browser and go to:
```
http://localhost:8080
```

### Step 5: Test the Application

1. **Register New User**
   - Click "Register here"
   - Fill in:
     - Username: testuser
     - Email: test@example.com
     - Password: password123
   - Click "Register"

2. **Login**
   - Username: testuser
   - Password: password123
   - Click "Login"

3. **Create Tasks**
   - Add task title and description
   - Click "Add Task"

4. **Manage Tasks**
   - Filter: All / Pending / Done
   - Complete tasks
   - Delete tasks

## 📋 Checklist

Before running, ensure:
- [ ] Java 17+ installed (`java -version`)
- [ ] Maven installed (`mvn -version`)
- [ ] MySQL running
- [ ] Database created
- [ ] application.properties configured
- [ ] Project built successfully

## 🔧 Common Issues

### Issue: Port 8080 already in use
**Solution**: Change port in `application.properties`
```properties
server.port=8081
```

### Issue: Can't connect to database
**Solution**: 
- Check MySQL is running
- Verify username/password in `application.properties`
- Ensure database `todo_management_db` exists

### Issue: Build fails
**Solution**:
```powershell
mvn clean
mvn install -U
```

## 📧 Email Reminders (Optional)

If you want email reminders:

1. **For Gmail Users:**
   - Enable 2-Factor Authentication
   - Generate App Password: https://myaccount.google.com/apppasswords
   - Update `application.properties`:
   
   ```properties
   spring.mail.username=your-email@gmail.com
   spring.mail.password=your-16-digit-app-password
   ```

2. **Uncomment email configuration in application.properties**

## 🎉 You're Ready!

Your To-Do Management System is now ready to use!

---

**Need Help?** Check README.md for detailed documentation.
