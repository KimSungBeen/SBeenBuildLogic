
# 🏗️ Build Logic for Android Projects

Android 프로젝트의 **공통 Gradle 설정**을 관리하기 위한 Build Logic 저장소입니다.  
멀티모듈 환경에서의 일관성과 생산성을 높이기 위해 구성되었습니다.

## ✨ 장점

- ✅ 모듈화된 설정 관리
- ✅ 공통 코드 재사용
- ✅ 유지보수성 향상

---

## 🚀 사용 방법

### ✅ 방법 1: Git Submodule로 프로젝트에 추가

프로젝트가 SBeenBuildLogic Repository의 형상과 동기화 되어야 할 때 적합

#### 1.1. Submodule로 추가 및 .gitmodules 셋팅

```bash
git submodule add https://github.com/KimSungBeen/SBeenBuildLogic.git
```

디렉토리 명을 `build-logic`으로 변경 한 후 아래와 같이 `.gitmodules` 수정

```
[submodule "build-logic"]
path = build-logic
url = https://github.com/KimSungBeen/SBeenBuildLogic.git
```

#### 1.2. `settings.gradle.kts` 또는 `build.gradle.kts`에 설정 추가

```kotlin
pluginManagement {
    includeBuild("build-logic")
}
```

> `includeBuild("build-logic")` 경로는 현재 프로젝트 구조에 따라 조정.

---

### ✅ 방법 2: 저장소를 별도로 Clone

독립적으로 `build-logic`을 사용하고 싶을 때 적합

#### 2.1. Clone

```bash
git clone https://github.com/KimSungBeen/SBeenBuildLogic.git
```

#### 2.2. `settings.gradle.kts` 또는 `build.gradle.kts`에 설정 추가

```kotlin
pluginManagement {
    includeBuild("../build-logic")
}
```

> 상대 경로는 실제 `build-logic` 저장소의 위치에 따라 수정.

---

## ⚙️ Gradle Script 설명

| 파일명                              | 설명                            |
|------------------------------------|-------------------------------|
| `sbeen.android.application.gradle.kts` | Android Application 모듈용 공통 설정 |
| `sbeen.android.compose.gradle.kts`     | Jetpack Compose 관련 설정 포함      |
| `sbeen.android.library.gradle.kts`     | Android Library 모듈 공통 설정      |
| `sbeen.data.gradle.kts`                | `data` 계층 모듈 공통 설정            |
| `sbeen.domain.gradle.kts`              | `domain` 계층 모듈 공통 설정          |
| `sbeen.feature.gradle.kts`             | `feature` 모듈 전용 설정            |
| `sbeen.hilt.android.gradle.kts`        | Android + Hilt 관련 DI 설정       |
| `sbeen.hilt.kotlin.gradle.kts`         | Kotlin + Hilt DI 설정 전용        |
| `sbeen.kotlin.library.gradle.kts`      | Kotlin Library 모듈 공통 설정       |

---

## 🧩 예시: 모듈에 적용

```kotlin
// app/build.gradle.kts
plugins {
    id("sbeen.android.application")
    id("sbeen.android.compose")
    id("sbeen.hilt.android")
}
```

## 📌 Versioning Rule

- Major: compile java 버전, kotlin 버전, android target & min SDK 버전의 변경이 있을 때
- Minor: 새로운 컨벤션 및 플러그인이 추가될 때
- Patch: 기존에 존재하는 컨벤션 및 플러그인에 Major에 기재된 사항 외 변경이 있을 때
