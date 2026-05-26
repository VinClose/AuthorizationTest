**Стек:** Java 21, Gradle, JUnit 5, Playwright, Google Chrome

---

## Шаг 1 — Установить Java 21

### Windows

1. Открыть сайт https://adoptium.net
2. Нажать на кнопку **Windows x64 .msi** (скачается установщик, ~180 МБ)
3. Запустить скачанный файл
4. В установщике везде нажимать **Next**. На одном из шагов будет пункт **«Set JAVA_HOME variable»** — убедиться что переключатель стоит на **«Will be installed»**
5. Нажать **Install**, дождаться окончания, нажать **Finish**

Проверить что Java установилась:
- Нажать `Win + R`, в появившемся окне написать `cmd`, нажать Enter — откроется чёрное окно (командная строка)
- Написать `java -version` и нажать Enter

Должно появиться:
```
openjdk version "21.x.x"
```
Если появилось — Java установлена, продолжаем.

---

### Mac

Открыть приложение Terminal и выполнить команду:
```
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
```
Проверить установку:
```
brew --version
```
Выполнить:
```
brew install openjdk@21
```
После установки выполнить команды, которые покажет Terminal.

Проверить:
```
java -version
```
Должно появиться:
```
openjdk version "21.x.x"
```

## Шаг 2 — Установить Git

### Windows

1. Открыть сайт https://git-scm.com
2. Нажать **Download for Windows** — скачается установщик
3. Запустить его, везде нажимать **Next**, в конце **Install**

Проверить — открыть **новую** командную строку (`Win + R` → `cmd`) и написать:
```
git --version
```
Должно появиться: `git version 2.x.x`

---

### Mac

Обычно Git уже установлен.

Проверить:
```
git --version
```
Если команды нет:
```
brew install git
```

## Шаг 3 — Установить Google Chrome

### Windows

1. Открыть Открыть сайт https://gradle.org/releases/
2. Найти раздел Current Release
3. Скачать файл Binary-only
4. Распаковать архив, например в:
```
C:\Gradle
```
Должна получиться папка примерно такого вида:
```
C:\Gradle\gradle-8.7
```
---

Добавить Gradle в PATH
1. Нажать Win
2. Ввести:
```
Изменение системных переменных среды
```
3. Открыть найденное окно
4. Нажать Переменные среды
5. В разделе Системные переменные найти Path
6. Нажать Изменить
7. Нажать Создать
8. Добавить путь:
```
C:\Gradle\gradle-8.7\bin
```
9. Нажать OK во всех окнах

Проверить установку Gradle

Открыть НОВУЮ командную строку и выполнить:
```
gradle -v
```
Должна появиться информация о версии Gradle.

### Mac

Выполнить:
```
brew install gradle
```
Проверить:
```
gradle -v
```

## Шаг 4 — Установить Google Chrome

### Windows

Если Chrome уже установлен — пропустить этот шаг.

1. Открыть https://google.com/chrome
2. Нажать **Скачать Chrome**, запустить установщик

---

### Mac

Скачать и установить Chrome:

https://google.com/chrome


## Шаг 5 — Скачать проект

### Windows

Открыть командную строку (`Win + R` → `cmd` → Enter) и выполнить две команды по очереди — каждую вводить и нажимать Enter:

```
git clone https://github.com/VinClose/AuthorizationTest
```
```
cd AuthorizationTest
```

После второй команды в командной строке появится путь с `login-test` в конце — это значит вы находитесь внутри папки проекта.

> **Важно:** все следующие команды вводить в этой же командной строке. Не закрывайте окно.

---

### Mac

В Terminal выполнить:
```
git clone https://github.com/VinClose/AuthorizationTest
```
Затем:
```
cd AuthorizationTest
```

## Шаг 6 — Запустить тесты

Ввести команду и нажать Enter:

```
gradle test
```

При первом запуске Gradle скачается автоматически (~100 МБ) — это займёт 1–2 минуты, просто подождите.

Затем откроется окно Google Chrome, тесты пройдут и браузер закроется.

В конце в командной строке должно появиться:

```
tests.AuthorizationTest > successfulLogin PASSED
tests.AuthorizationTest > loginWithInvalidUsername PASSED
tests.AuthorizationTest > loginWithInvalidPassword PASSED

BUILD SUCCESSFUL
3 tests completed, 0 failed
```