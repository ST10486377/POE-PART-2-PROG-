# Njabulo Ndlovu — QuickChat Part 2

**Student:** Njabulo Ndlovu  
**Student number:** ST10486377  
**Programme:** Bachelor of IT in Business Systems  
**Institution:** IIE Rosebank College

A console-only Java 17 Maven project that extends Part 1 registration/login with Part 2 messaging.

## Run

```bash
mvn clean test
mvn exec:java
```

Or open the project as a Maven project in NetBeans and run `Main.java`.

## Functionality

- Validated registration and login before the messaging menu.
- Welcome to QuickChat; menu options 1 Send, 2 Coming Soon, 3 Quit.
- Message quota, 10-digit random IDs, auto message number and uppercase hash.
- Recipient and 250-character checks; send, discard, or JSON-store messages.
- Full sent-message details and total count.
- JUnit 5 tests and GitHub Actions CI.


## References

- Google Gson project: https://github.com/google/gson (JSON serialization).
- Oracle Java `Pattern`: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/regex/Pattern.html (regular-expression syntax).

## Suggested six or more genuine commits

1. Create feature branch and retain Part 1.
2. Add Message model and ID validation.
3. Add recipient/length validation.
4. Add hash generation and menu.
5. Add send/discard/JSON storage.
6. Add unit tests and GitHub Actions workflow.

Push the feature branch, verify tests, then merge into main. A zip cannot manufacture an authentic commit history; make real incremental commits during your own review/development.

## Video presentation

Demonstrate registration, login, menu, successful send, invalid recipient, overlong message, discard, JSON store, tests, and GitHub Actions. Explain the loops and hash logic in your own voice.

## Part 2 Testing and Verification

The QuickChat application was tested using Apache NetBeans
and JUnit.

Automated test results:
- Tests executed: 10
- Failures: 0
- Errors: 0
- Build status: SUCCESS

Manual testing completed:
- User registration and login
- Sending a valid message
- Rejecting an invalid recipient number
- Disregarding a message without increasing the sent count

GitHub Actions runs the Maven test suite automatically.

