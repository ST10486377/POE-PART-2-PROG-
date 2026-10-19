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

## Important rubric clarifications

- The rubric says recipient numbers have a maximum of 10 characters but its accepted example `+27718693002` contains 12 characters. The implementation validates `+27` plus nine mobile digits to match the accepted test case.
- The expected `00:0:HITONIGHT` hash requires an ID starting with `00`; the unit test supplies a deterministic ID `0012345678` while production IDs are random ten-digit numbers. The first message number is zero as shown in the example.
- The sample second recipient `08575975889` is invalid; the test verifies its rejection. To demonstrate discard action separately, tests use a valid recipient.
- The instructions disagree on exact messages in some places; this project follows the explicit Part 2 assertEquals messages.
- JSON is saved to `data/stored-messages.json` only after choosing Store.
- JSON stores message content as plain text for this educational task. Do not use real passwords or sensitive conversations in demos.

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


## Correction after Part 1 feedback

This ZIP is a complete Maven project, **not individual Java files**. Upload the entire folder structure including `pom.xml`, `.github/workflows`, `src/main/java`, and `src/test/java`.

### NetBeans instructions
1. Unzip the project. In NetBeans select **File > Open Project** and select the folder containing `pom.xml`.
2. Right-click the project > **Clean and Build**.
3. Right-click the project > **Test** (or run `mvn clean test` in a terminal).
4. Run `Main.java` and demonstrate a valid registration, failed login, successful login, and Part 2 messaging.
5. Check that `data/stored-messages.json` appears after choosing Store Message.
6. Record actual output and actual JUnit results; do not claim tests passed unless you see green results.

### GitHub workflow (preserve existing history)
Clone `https://github.com/ST10486377/PROG-POE-PART-1`, create a new branch `feature/part2-messaging`, and copy the **contents** of this folder into the cloned repository root. Stage and commit your changes in meaningful increments during development; do not create artificial historical commits. Push the branch and open a pull request. Check the Actions tab before merging.

### Important assignment ambiguities
- The rubric says recipient numbers have a maximum of 10 characters, but its accepted `+27718693002` example has 12. This implementation uses international `+27` plus 9 digits to match the accepted example.
- The expected `00:0:HITONIGHT` hash uses a fixed ID beginning with `00` in tests; actual generated IDs are random and their first two digits vary.
- Part 2's menu deliberately prints `Coming Soon.` for option 2, as specified.
- The source-code regex reference is Oracle's Java Pattern API; adapt the citation format if your lecturer requires a particular style.
