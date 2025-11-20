## RangeWatch(Just anime backend api)

### Features:

- User Auth
- User Profiles
- Anime adding
- Season Adding
- Episode Adding
- bla bla im so lazy for adding more

## How to start
### prerequis
### 1. **Go to src/main/resources**

### 2.find **example.env** make your env like that

### 3. run with this command if u run in some other ide
```shell
export $(grep -v '^#' src/main/resources/.env | xargs) && ./gradlew bootRun
```
#### if You're using intellij idea add env file in app started
