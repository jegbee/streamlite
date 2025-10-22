# Streamlite Application 🚀

A **Spring Boot-based web application** demonstrating a full **DevOps CI/CD pipeline** setup using **GitHub, Jenkins, SonarQube, and Linux (Ubuntu)** for continuous integration, code quality assurance, and automated deployment.

---

## 📖 Overview

The **Streamlite** project serves as a practical implementation of a **modern DevOps workflow**, integrating version control, automated builds, static code analysis, and deployment.  
It aims to simulate a real-world enterprise-grade pipeline with the following key technologies:

- **GitHub** – Source code management (Version control)
- **Jenkins** – Continuous Integration (CI) and Continuous Deployment (CD)
- **SonarQube** – Code quality and static analysis
- **Spring Boot (Java 17)** – Backend application
- **Ubuntu Linux Server** – Deployment environment

---

## ⚙️ Architecture

```plaintext
             ┌────────────────────┐
             │     Developer      │
             │  (Code Commit)     │
             └────────┬───────────┘
                      │ Push Code
                      ▼
              ┌──────────────────┐
              │     GitHub       │
              │  (Source Repo)   │
              └────────┬─────────┘
                       │ Webhook Trigger
                       ▼
           ┌──────────────────────────┐
           │        Jenkins CI/CD      │
           │  Build → Test → Analyze   │
           └──────────┬───────────────┘
                      │
                      ▼
           ┌────────────────────────┐
           │       SonarQube        │
           │ Static Code Analysis   │
           └──────────┬─────────────┘
                      │ Quality Gate Passed
                      ▼
           ┌────────────────────────┐
           │   Deployment Server    │
           │  (Ubuntu + Java 17)    │
           └────────────────────────┘
```

---

## 🧩 Project Structure

```
streamlite/
│
├── src/
│   ├── main/java/com/streamlite/
│   │   ├── controller/
│   │   │   └── HomeController.java
│   │   ├── model/
│   │   ├── service/
│   │   └── StreamliteApplication.java
│   │
│   └── main/resources/
│       ├── static/
│       ├── templates/
│       │   └── index.html
│       └── application.properties
│
├── target/                      # Compiled output
├── Jenkinsfile                  # CI/CD pipeline definition
├── sonar-project.properties      # SonarQube configuration
├── pom.xml                       # Maven build configuration
└── README.md
```

---

## 🔧 Technologies Used

| Tool | Purpose |
|------|----------|
| **Spring Boot (Java 17)** | Web application framework |
| **Maven** | Build automation tool |
| **Git & GitHub** | Version control and collaboration |
| **Jenkins** | CI/CD automation |
| **SonarQube** | Code quality analysis |
| **Linux (Ubuntu)** | Hosting and runtime environment |
| **cURL / Nginx (optional)** | Testing and reverse proxy setup |

---

## 🧠 Key Features

- Automated build and deployment via **Jenkins Pipeline**
- Real-time code quality scanning using **SonarQube**
- Environment-specific configuration for **port and service management**
- Integration of **GitHub triggers** for continuous delivery
- Basic Spring Boot MVC architecture (controller, view, model)

---

## 🧪 Jenkins Pipeline (Jenkinsfile)

```groovy
pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/jegbee/streamlite.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Code Analysis') {
            steps {
                sh 'mvn sonar:sonar -Dsonar.projectKey=streamlite -Dsonar.host.url=http://localhost:9000 -Dsonar.login=<your-token>'
            }
        }

        stage('Deploy') {
            steps {
                sh 'nohup java -jar target/streamlite-1.0.0.jar --server.port=8081 &'
            }
        }
    }

    post {
        success {
            echo '✅ Build and Deployment Successful!'
        }
        failure {
            echo '❌ Build Failed! Check Jenkins logs.'
        }
    }
}
```

---

## 🖥️ Running the Application Manually

```bash
# Clone the repository
git clone https://github.com/jegbee/streamlite.git
cd streamlite

# Build and package the app
mvn clean package

# Run the JAR file
java -jar target/streamlite-1.0.0.jar --server.port=8081
```

Then visit: 👉 **http://localhost:8081**

---

## 📊 SonarQube Analysis

After each Jenkins build, SonarQube analyzes the source code for:
- Bugs and vulnerabilities  
- Code smells and duplications  
- Maintainability and test coverage metrics  

Dashboard accessible at:  
➡️ **http://<server-ip>:9000**

---

## 🚀 Deployment Notes

- Jenkins runs on port **8080**  
- Streamlite app runs on port **8081**  
- SonarQube runs on port **9000**  
- Ensure each service uses a **unique port** to avoid conflicts.

---

## 🧰 Future Improvements

- Add frontend UI and authentication  
- Dockerize the full stack for containerized deployment  
- Implement automated tests and artifact versioning  
- Integrate with Kubernetes or AWS EC2 for production-grade CI/CD

---

## 👤 Author

**Jegede Joshua Oluwatimilehin**  
🎓 student of lagos state university  
💻 Passionate about Software Engineering & DevOps  
📍 Nigeria  
🔗 [GitHub Profile](https://github.com/jegbee)

---

## 🪪 License

feel free to use, modify, and share.

---

> _"Streamlite demonstrates how code, automation, and quality assurance come together to form a reliable DevOps pipeline."_


This is also my first project by the way. Its a mini one that does not involve all the major parts in automation, just github jenjins maven sonarqube is being used here.
