---
layout: page
title: Developer Guide
---

--------------------------------------------------------------------------------------------------------------------

## **Acknowledgements**

* [TelegramBots](https://github.com/rubenlagus/TelegramBots)
* [TelegramBots tutorial](https://monsterdeveloper.gitbook.io/java-telegram-bot-tutorial)

--------------------------------------------------------------------------------------------------------------------

## **What is RoombaSan about?**

* Aiding students' proficiency in modules through **the power of trivia!**
* Store trivia questions and notes to gauge their own proficiencies!

--------------------------------------------------------------------------------------------------------------------

### **User stories**

Priorities: High (must have) - `* * *`, Medium (nice to have) - `* *`, Low (unlikely to have) - `*`

| Priority | As a …​  | I want to …​                        | So that I can…​                                         |
|----------|----------|-------------------------------------|---------------------------------------------------------|
| `* * `  | student | add modules/subjects          | have a module in which I can add topics to keep track of.  |
| `* * * `  | student | add and store trivia         | have questions or concepts that I can remember  |
| `* * * `  | student | delete trivia         | remove modules or questions I no longer need  |
| `* * `  | student | keep brief notes about topics |                                                  |
| `* * `  | student | have a proficiency tracker         | Keep a track of my learning progress.  |


--------------------------------------------------------------------------------------------------------------------
### **Design decisions and considerations**

**Commands**

* Adding Trivia `/add q/<question> a/<answer>`

* Delete Trivia `/remove q/<question>`

* Show Trivia `/show`
 
**Model**

* Trivia - Trivia.java

A Trivia class' role is to represent a Trivia. A Trivia comprises of two things:

1) Question
2) Answer

Current design suggestions:

- Question and Answers stored as strings within the Trivia class.

Pros:
- Less code and easier to track.

Cons:
- Not as extendible. Furthermore, for future updates it'll potentially be nice to add metrics to the Question and Answer

* UI - Ui.java

--------------------------------------------------------------------------------------------------------------------
### **Use cases**