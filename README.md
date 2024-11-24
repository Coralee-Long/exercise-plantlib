# Plant Library

## 1. Planning Project Structure:
```
PlantLibrary/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/plantlibrary/
│   │   │       ├── Main.java
│   │   │       ├── Plant.java
│   │   │       └── PlantLibrary.java
│   │   └── resources/
│   │       └── public/
│   │           └── style.css
│   ├── test/
│       ├── java/
│       │   └── com/plantlibrary/
│       │       ├── PlantTest.java
│       │       └── PlantLibraryTest.java
├── pom.xml
├── README.md
```

---

## 2. Setting up Plant Class:

### Direct Filed Access (not-recommended):
```java
public class Plant {
    public String commonName;
}
```
    
### Private Fields with Getter/Setter method:
```java
private class Plant {
    private String commonName;
    
    // Getter Method:
    public String getCommonName() {
        return commonName;
    }
    
    // Setter Method:
    public void setCommonName(String commonName) {
        if (commonName == null || commonName.isEmpty()) {
            throw new IllegalArgumentException("Common Name cannot be null of empty.")
        }
        this.commonName = commonName;
        }
    }
```

---

## 3. Using ArrayList over a normal Array:

### Arrays:
- Fixed Size: When you create an array, you must specify its size at the time of creation, and that size cannot be changed.
    ```java
    Plant[] plants = new Plant[10]; // Array of size 10
    ```
- If you try to add more than 10 items, you’ll get an ArrayIndexOutOfBoundsException.
- If you want to "resize" an array, you need to manually create a new array and copy the elements over, which is cumbersome.

### ArrayList
- An ArrayList is part of the Java Collections Framework and can grow or shrink dynamically as needed.
```java
List<Plant> plants = new ArrayList<>();
plants.add(new Plant(...)); // Adds a plant, no size specified
plants.add(new Plant(...)); // Keeps growing as needed
```
- The `ArrayList` starts with an initial capacity (default is 10).
- When the internal array runs out of space, the ArrayList automatically creates a larger array and copies the elements into it. This happens behind the scenes, so you don’t need to worry about resizing.
---

### 4. Clarification of names and methods:
When you build a class, these three components often work together:

1. **Constructor:** Initializes the object with valid values when it is created.
2. **Getters:** Allow controlled read access to the fields.
3. **Setters:** Allow controlled modification of the fields after the object is created.

### 5. Printing out the Strings correctly:

```java
// Override toString() Method
    @Override
    public String toString() {
        return commonName + " (" + scientificName + ") - Genus: " + genusName +
               ", Category: " + category + ", Size: " + sizeInCm + " cm, Price: €" + approxPrice;
    }
```

#### What Does @Override Do?
**1. Tells the Compiler You’re Overriding a Method:**
   - In this case, you’re overriding the toString() method from the Object class.
   - If the method signature doesn’t match the parent class’s method exactly, the compiler will throw an error.

**2. Improves Code Readability:**
   - It signals to other developers (and yourself) that this method is intended to override a parent class’s method.