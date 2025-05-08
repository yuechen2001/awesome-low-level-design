# Java Development Notes

## Table of Contents
1. [Concurrency and Synchronization](#concurrency-and-synchronization)
   - [When to Use Synchronization](#when-to-use-synchronization)
   - [Methods That Don't Need Synchronization](#methods-that-dont-need-synchronization)
   - [Synchronization Alternatives](#synchronization-alternatives)
2. [Working with Optional](#working-with-optional)
   - [Creating Optional Objects](#creating-optional-objects)
   - [Checking and Accessing Values](#checking-and-accessing-values)
   - [Transforming Optional Values](#transforming-optional-values)
   - [Handling Default Cases](#handling-default-cases)
   - [Stream Operations with Optional](#stream-operations-with-optional)
   - [Optional Best Practices](#optional-best-practices)

---

## Concurrency and Synchronization

### When to Use Synchronization

In multi-threaded Java applications, these method types require synchronization:

1. **Methods Accessing Shared Mutable State**
   - Methods that read and modify instance variables shared between threads
   - Methods that modify static fields accessed by multiple threads
   - Methods that update shared collections or data structures
   - Any method that changes object state that could be viewed by other threads

2. **Methods with Race Condition Potential**
   - Methods that perform check-then-act operations
   - Methods with read-modify-write sequences
   - Methods where the outcome depends on state remaining consistent during execution

3. **Methods Performing Composite Operations**
   - Methods performing multiple related steps that must be treated as a single unit
   - Methods that update multiple related fields together
   - Methods that maintain invariants across multiple objects
   - Methods that need to preserve the relationship between multiple values

4. **Methods for Resource Management**
   - Methods initializing shared resources (especially lazy initialization)
   - Methods acquiring or releasing resources
   - Methods that coordinate access to limited resources

### Methods That Don't Need Synchronization

- Methods that only read immutable data
- Methods operating solely on local variables
- Methods using thread-local storage
- Methods in classes designed for single-threaded use
- Methods already protected by other concurrency mechanisms

### Synchronization Alternatives

- Thread-safe collections and utilities from `java.util.concurrent`
- Atomic variables for simple counters and references
- Explicit locks for more flexible locking
- Immutable objects where possible

---

## Working with Optional

### Creating Optional Objects

- `Optional.of(nonNullValue)` - Creates Optional with non-null value
- `Optional.ofNullable(possiblyNullValue)` - Creates Optional that might be empty
- `Optional.empty()` - Creates empty Optional

### Checking and Accessing Values

- `optional.isPresent()` - Returns true if value exists
- `optional.isEmpty()` - Returns true if no value (Java 11+)
- `optional.ifPresent(value -> doSomething(value))` - Execute if present
- `optional.ifPresentOrElse(value -> useValue(), () -> handleEmpty())` - Handle both cases

### Transforming Optional Values

- `optional.map(value -> transform(value))` - Apply function if present
- `optional.flatMap(value -> optionalOperation(value))` - Chain Optional-returning operations

### Handling Default Cases

- `optional.orElse(defaultValue)` - Return value or default
- `optional.orElseGet(() -> computeDefaultValue())` - Return value or compute default
- `optional.orElseThrow(() -> new Exception())` - Return value or throw exception

### Stream Operations with Optional

- `optional.stream()` - Convert to Stream with 0/1 elements
- `optionals.flatMap(Optional::stream)` - Filter out empty Optionals

### Optional Best Practices

1. Use as return type, not parameter type or field
2. Never return null from Optional-returning method
3. Don't call `get()` without checking `isPresent()` first
4. Use `orElseGet()` for computed defaults
5. Prefer method references for cleaner code
6. Chain operations with `map`/`flatMap` instead of multiple if checks
7. Use for nullable results, not for collections (empty collection is better)