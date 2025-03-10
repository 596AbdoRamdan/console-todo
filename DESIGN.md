# Design document

## Example

Example: Task Type Design
Decision: Implement different task types (`SimpleTask`, `RecurringTask`, `DeadlineTask`) using inheritance from a common `Task` abstract class.

**Why?**

1. Enables polymorphism, allowing the system to handle all tasks uniformly while allowing type-specific behaviors.
2. Improves code reusability by defining shared attributes (title, description, priority) in the base class.

---
