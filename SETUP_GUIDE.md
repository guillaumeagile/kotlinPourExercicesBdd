# Project Setup Guide

Complete guide for setting up and running this Kotlin project on Windows, macOS, and Linux.

## System Requirements

### Minimum Requirements
- **JVM**: Java 21 LTS (OpenJDK or Oracle JDK)
- **Gradle**: 8.12+
- **Kotlin**: 2.1.0
- **Git**: Latest version

### Recommended
- **IDE**: IntelliJ IDEA (Community or Ultimate)
- **RAM**: 4GB minimum (8GB+ recommended)
- **Disk Space**: 2GB for dependencies

---

## 1. Install Java Development Kit (JDK)

### macOS

#### Using Homebrew (Recommended)
```bash
brew install openjdk@21
```

#### Manual Installation
1. Download from [Oracle JDK 21](https://www.oracle.com/java/technologies/downloads/#java21) or [OpenJDK 21](https://jdk.java.net/21/)
2. Extract and set `JAVA_HOME`:
```bash
export JAVA_HOME=/path/to/jdk-21
export PATH=$JAVA_HOME/bin:$PATH
```

#### Verify Installation
```bash
java -version
javac -version
```

---

### Windows

#### Using Chocolatey (Recommended)
```powershell
choco install openjdk21
```

#### Manual Installation
1. Download from [Oracle JDK 21](https://www.oracle.com/java/technologies/downloads/#java21)
2. Run the installer
3. Set environment variables:
   - `JAVA_HOME`: `C:\Program Files\Java\jdk-21` (or your installation path)
   - Add `%JAVA_HOME%\bin` to `PATH`

#### Verify Installation
```powershell
java -version
javac -version
```

---

### Linux (Ubuntu/Debian)

#### Using APT (Recommended)
```bash
sudo apt update
sudo apt install openjdk-21-jdk
```

#### Using SNAP
```bash
sudo snap install openjdk --classic
```

#### Manual Installation
1. Download from [OpenJDK 21](https://jdk.java.net/21/)
2. Extract:
```bash
tar -xzf openjdk-21_linux-x64_bin.tar.gz
sudo mv jdk-21 /usr/local/
```
3. Set environment variables:
```bash
export JAVA_HOME=/usr/local/jdk-21
export PATH=$JAVA_HOME/bin:$PATH
```

#### Verify Installation
```bash
java -version
javac -version
```

---

## 2. Install Gradle

### macOS

#### Using Homebrew
```bash
brew install gradle
```

#### Manual Installation
1. Download from [Gradle 8.12](https://gradle.org/releases/)
2. Extract and add to PATH:
```bash
export GRADLE_HOME=/path/to/gradle-8.12
export PATH=$GRADLE_HOME/bin:$PATH
```

---

### Windows

#### Using Chocolatey
```powershell
choco install gradle
```

#### Manual Installation
1. Download from [Gradle 8.12](https://gradle.org/releases/)
2. Extract to `C:\gradle`
3. Add `C:\gradle\bin` to `PATH`

---

### Linux

#### Using Package Manager (Ubuntu/Debian)
```bash
sudo apt install gradle
```

#### Manual Installation
```bash
wget https://services.gradle.org/distributions/gradle-8.12-bin.zip
unzip gradle-8.12-bin.zip
sudo mv gradle-8.12 /opt/
export PATH=/opt/gradle-8.12/bin:$PATH
```

---

### Verify Gradle Installation
```bash
gradle --version
```

---

## 3. Clone and Setup Project

### All Platforms

```bash
# Clone the repository
git clone <repository-url>
cd KotlinSimplePourIBlasquez

# Verify Gradle wrapper (uses project's Gradle 8.12)
./gradlew --version  # macOS/Linux
gradlew --version   # Windows
```

---

## 4. Build and Run Project

### Build
```bash
./gradlew build      # macOS/Linux
gradlew build        # Windows
```

### Run Tests
```bash
./gradlew test       # macOS/Linux
gradlew test         # Windows
```

### Run Application
```bash
./gradlew run        # macOS/Linux
gradlew run          # Windows
```

### Clean Build
```bash
./gradlew clean build  # macOS/Linux
gradlew clean build    # Windows
```

---

## 5. Project Dependencies

### Core Dependencies
| Dependency | Version | Purpose |
|-----------|---------|---------|
| Kotlin | 2.1.0 | Language |
| Kotlinx Coroutines | 1.8.1 | Async/concurrency |
| Kotlinx DateTime | 0.6.2 | Date/time utilities |
| Arrow-kt | 1.2.5 | Functional programming |

### Testing Dependencies
| Dependency | Version | Purpose |
|-----------|---------|---------|
| JUnit Jupiter | 5.11.3 | Testing framework |
| KoTest | 5.10.0 | BDD testing library |

### Build Tools
| Tool | Version |
|------|---------|
| Gradle | 8.12 |
| JVM | 21 LTS |

---

## 6. IDE Setup

### IntelliJ IDEA

1. **Open Project**
   - File → Open → Select project directory
   - Trust the project when prompted

2. **Configure JDK**
   - File → Project Structure → Project
   - Set Project SDK to JDK 21
   - Set Project language level to Kotlin 2.1

3. **Enable Gradle Wrapper** (Important)
   - File → Settings → Build, Execution, Deployment → Gradle
   - Set **Gradle** to "Gradle wrapper"
   - Set **Gradle JVM** to "Project SDK" (JDK 21)
   - Click Apply and OK

4. **Update Gradle Wrapper** (If Prompted)
   - IntelliJ may prompt you to update the Gradle wrapper
   - Accept the update to sync with Gradle 8.12
   - After update: File → Invalidate Caches and restart IntelliJ

5. **Run Tests**
   - Right-click test file → Run
   - Or use Gradle tool window

**Note**: IntelliJ bundles Gradle 7.3 by default, which is incompatible with Kotlin 2.1.0. Using the Gradle wrapper ensures you use Gradle 8.12 as specified in the project.

### VS Code

1. **Install Extensions**
   - Kotlin Language
   - Gradle for Java
   - Test Explorer UI

2. **Configure Settings** (`.vscode/settings.json`)
```json
{
  "java.home": "/path/to/jdk-21",
  "gradle.javaHome": "/path/to/jdk-21",
  "[kotlin]": {
    "editor.formatOnSave": true
  }
}
```

3. **Run Tests**
   - Open Test Explorer
   - Click Run on test files

---

## 7. Troubleshooting

### Issue: "JAVA_HOME not set"
**Solution**: Set JAVA_HOME environment variable
```bash
# macOS/Linux
export JAVA_HOME=$(/usr/libexec/java_home -v 21)

# Windows (PowerShell)
$env:JAVA_HOME = "C:\Program Files\Java\jdk-21"
```

### Issue: "Gradle wrapper not found"
**Solution**: Regenerate wrapper
```bash
gradle wrapper --gradle-version 8.12
```

### Issue: "Incompatible Kotlin version"
**Solution**: Clear Gradle cache
```bash
./gradlew clean --refresh-dependencies
```

### Issue: Tests not running
**Solution**: Ensure JUnit Platform is configured
```bash
./gradlew test --info
```

---

## 8. Environment Variables (Optional)

### macOS/Linux
Add to `~/.bashrc` or `~/.zshrc`:
```bash
export JAVA_HOME=$(/usr/libexec/java_home -v 21)
export GRADLE_HOME=/path/to/gradle-8.12
export PATH=$JAVA_HOME/bin:$GRADLE_HOME/bin:$PATH
```

### Windows
Set in System Properties → Environment Variables:
- `JAVA_HOME`: `C:\Program Files\Java\jdk-21`
- `GRADLE_HOME`: `C:\gradle-8.12`
- Add `%JAVA_HOME%\bin;%GRADLE_HOME%\bin` to `PATH`

---

## 9. Version Compatibility Matrix

| Component | Version | Min Supported | Max Tested |
|-----------|---------|---------------|-----------|
| JVM | 21 LTS | 17 | 21 |
| Kotlin | 2.1.0 | 2.0.0 | 2.1.0 |
| Gradle | 8.12 | 8.0 | 8.12 |
| Arrow-kt | 1.2.5 | 1.2.0 | 1.2.5 |
| KoTest | 5.10.0 | 5.8.0 | 5.10.0 |

---

## 10. Quick Start Checklist

- [ ] JDK 21 installed and `JAVA_HOME` set
- [ ] Gradle 8.12+ installed
- [ ] Git installed
- [ ] Project cloned
- [ ] `./gradlew build` runs successfully
- [ ] `./gradlew test` passes
- [ ] IDE configured with JDK 21

---

## 11. Additional Resources

- [Kotlin Official Documentation](https://kotlinlang.org/docs/)
- [Gradle User Manual](https://docs.gradle.org/current/userguide/userguide.html)
- [OpenJDK 21 Documentation](https://openjdk.java.net/projects/jdk/21/)
- [Arrow-kt Documentation](https://arrow-kt.io/)
- [KoTest Documentation](https://kotest.io/)

---

## Support

For issues or questions:
1. Check this guide's Troubleshooting section
2. Review project README.md
3. Check Gradle build output with `--info` flag
4. Consult official documentation links above

