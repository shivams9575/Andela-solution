# British Spoken Time

A Java program to convert digital time into its **British English spoken form**.

---

## Overview

In British English, the expression `"half [hour]"` is used colloquially to denote **30 minutes past the hour**. For example:

- `"half ten"` → 10:30 (half past ten)

This differs from some European languages, where `"half ten"` or its equivalent means 30 minutes **before** the hour.

The project converts a time input (HH:mm) into its spoken form, such as:

| Time  | Spoken Form         |
|-------|---------------------|
| 01:00 | one o'clock         |
| 02:05 | five past two       |
| 03:10 | ten past three      |
| 04:15 | quarter past four   |
| 05:20 | twenty past five    |
| 06:25 | twenty five past six|
| 06:32 | six thirty two      |
| 07:30 | half past seven     |
| 07:35 | twenty five to eight|
| 08:40 | twenty to nine      |
| 09:45 | quarter to ten      |
| 10:50 | ten to eleven       |
| 11:55 | five to twelve      |
| 00:00 | midnight            |
| 12:00 | noon                |

---

## Features

- Converts **HH:mm** format into British spoken time.
- Handles special cases:
  - Midnight (`00:00`)
  - Noon (`12:00`)
  - Quarter past/to, half past
- Easily extensible for other locales.
- Fully tested with **unit tests** and **integration tests**.

---

## Project Structure

