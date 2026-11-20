# Java Console Chess

A two-player command-line chess engine written in Java using object-oriented design and an ASCII board display.

## Features
* **Object-Oriented Architecture:** Structured around an abstract `Piece` superclass with polymorphic movement validation across individual piece subclasses (`Pawn`, `Rook`, `Knight`, `Bishop`, `Queen`, `King`), `Board` and `Square` state models, and a `Player` hierarchy.
* **Algebraic Notation Parser:** Accepts standard short algebraic notation (e.g., `Nf3`, `exd5`, `0-0`, `0-0-0`) and records a formatted move history viewable anytime via the `Moves` command.
* **Special Rules:** Supports kingside and queenside castling, *en passant* captures, and interactive pawn promotion (`Q`, `R`, `B`, `N`).

## How to Run
1. Compile all Java source files:
   `javac *.java`
2. Start the game:
   `java Main`

*Built as an early object-oriented programming project to practice inheritance, state tracking, and input parsing.*
