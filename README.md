# dumping-agent


<div align="center">
  <a href="https://www.oracle.com/java/">
    <img
      src="https://img.shields.io/badge/Written%20in-java-%23EF4041?style=for-the-badge"
      height="30"
    />
  </a>
  <a href="https://jitpack.io/#micartey/dumping-agent/master-SNAPSHOT">
    <img
      src="https://img.shields.io/badge/jitpack-master-%2321f21?style=for-the-badge"
      height="30"
    />
  </a>
  <a href="https://micartey.github.io/jairo/docs" target="_blank">
    <img
      src="https://img.shields.io/badge/javadoc-reference-5272B4.svg?style=for-the-badge"
      height="30"
    />
  </a>
</div>

<br>

<p align="center">
  <a href="#-introduction">Introduction</a> |
  <a href="#motivation">Motivation</a>
</p>

## 📚 Introduction

`dumping agent`  is a succinct project designed to extract JVM or specific packages along with their corresponding class files. Its current implementation strives to dump all class files, barring a few blacklisted default Java packages. However, be aware that this could potentially lead to a JVM crash, especially when obfuscation techniques are applied.
### Motivation

The inception of this project lies in the research requirements of [jCloak](https://micartey.github.io/jCloak/). It was created to facilitate the development and testing of Java agent detection mechanisms, with the ultimate goal of safeguarding classes from Java agents.

## 🎈 Getting started

There are usually two ways to start use a java agent.

1. Start the JVM with the `-javaagent` flag and specify the java agent
2. Attach the java agent dynamically at runtime
   
For the first method you don't need anything except that flag.
For the second method, please take a look at [this project](https://github.com/micartey/Injection-Base)
