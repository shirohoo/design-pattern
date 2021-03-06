# π μ±κΈν΄ ν¨ν΄(Singleton Pattern)

<br />

`μμ± ν¨ν΄` μ€ νλμΈ μ±κΈν΄ ν¨ν΄μ λ©λͺ¨λ¦¬μ λ¨ νκ°λ§ μ‘΄μ¬ν  μ μλ κ°μ²΄λ₯Ό μ μν©λλ€.

λ¨ νκ°μ κ°μ²΄λ₯Ό λͺ¨λ  μ°λ λκ° κ³΅μ νμ¬ μ¬μ©ν¨μΌλ‘μ¨ λ©λͺ¨λ¦¬λ₯Ό ν¨μ¨μ μΌλ‘ μ¬μ©ν  μ μκ² λ©λλ€.

λ€λ§ μ€μνκ² μκ°ν΄μΌ ν  κ²μ, μ±κΈν΄ ν¨ν΄μΌλ‘ κ΅¬νλ κ°μ²΄λ μ¬λ¬ μ°λ λμμ κ³΅μ λλ©° μ¬μ©λκΈ° λλ¬Έμ λΆλ³κ°μ²΄μ¬μΌλ§ ν©λλ€.

λ§μ½ μ΄λ¬ν μ¬ν­μ μλ° ν  κ²½μ° μ¬κ°ν λ²κ·Έλ₯Ό λ§μ£ΌμΉ  μλ μμ΅λλ€.

λν κ°μ²΄λ₯Ό λ μ΄μ νμ₯ν  μ μκΈ° λλ¬Έμ λμμΈ ν¨ν΄μμλ μν° ν¨ν΄μ μνλ ν¨ν΄μ΄κΈ°λ ν©λλ€.

μ΄λ¬ν μ₯λ¨μ μ΄ μ‘΄μ¬νλ μ κ³ λ €νμ¬ μ¬μ©νλ κ²μ΄ μ€μνκ² μ΅λλ€.

<br />

μ±κΈν΄ ν¨ν΄μ λ€μκ³Ό κ°μ κ·μΉμΌλ‘ κ΅¬νλ©λλ€.

1. λͺ¨λ  μμ±μμ μ κ·Ό λ λ²¨μ `private`μΌλ‘ μ ννμ¬ μΈλΆμμ ν΄λΉ κ°μ²΄λ₯Ό λ μ΄μ μμ±νμ§ λͺ»νκ² ν©λλ€.
2. κ°μ²΄κ° `ν΄λμ€ λ‘λ`μ μν΄ μ΄κΈ°ν λλ μμ μ μμ±μλ₯Ό μ€μ€λ‘ νΈμΆνμ¬ λ°νλ μΈμ€ν΄μ€λ₯Ό μκΈ° μμ μ΄ κ°μ΅λλ€.
3. `ν΄λμ€ λ‘λ`μ μν΄ μ΄κΈ°ν λ λ¨ νλμ μΈμ€ν΄μ€λ₯Ό κ³΅κ°λ μ μ  λ©μλλ₯Ό ν΅ν΄ μΈλΆμ μ κ³΅ν©λλ€.

<br />

---

<br />

# β Eager Initialization

<br />

```java
public class EagerInitialization {
    private static final EagerInitialization instance = new EagerInitialization();

    private EagerInitialization() {
    }

    public static EagerInitialization getInstance() {
        return instance;
    }
}
```

<br />

μ΄λ»κ² μ¬μ©λμ΄λ λ¬΄λ°©ν κ°μ₯ κΈ°λ³Έμ μΈ ννμ μ±κΈν΄ ν¨ν΄μλλ€.

ν΄λμ€ λ‘λμ μν΄ ν΄λμ€κ° μ΅μ΄λ‘ λ‘λ©λλ μμ μ μΈμ€ν΄μ€κ° μμ±λκΈ° λλ¬Έμ `Thread-safe`λ₯Ό λ³΄μ₯ν©λλ€.

<br />

# β Synchronized Lazy Initialization

<br />

```java
public class SyncLazyInitialization {
    private static SyncLazyInitialization instance;

    private SyncLazyInitialization() {
    }

    public static synchronized SyncLazyInitialization getInstance() {
        if (Objects.isNull(instance)) {
            instance = new SyncLazyInitialization();
        }
        return instance;
    }
}
```

<br />

μ±κΈν΄ ν¨ν΄μμ μ½κ° λ λ©λͺ¨λ¦¬λ₯Ό μ μ½νκΈ° μν΄ κ³ μ λ λ°©λ²μλλ€.

νμ§λ§ λμμ± λ¬Έμ λ₯Ό ν΄κ²°νκΈ° μν΄ `synchronized`κ΅¬λ¬Έμ μ¬μ© ν¨μΌλ‘μ¨ μλκ° μ΄λ§μ΄λ§νκ² λλ €μ§λ€λ μΉλͺμ μΈ λ¨μ μ κ°μ΅λλ€.

μ΄λ₯Ό ν΄κ²°νκΈ° μν΄ μΈμ€ν΄μ€κ° `null`μΈ κ²½μ°μλ§ `synchronized`κ΅¬λ¬Έμ μ¬μ©νλ κ°μ  λ°©μλ μ‘΄μ¬νμ§λ§, μ½λμ κ°λμ±μ΄ λ¨μ΄μ§λ€λ λ¨μ μ κ°μ΅λλ€.

<br />

# β Lazy Holder

<br />

```java
public class LazyHolderInitialization {
    private LazyHolderInitialization() {
    }

    public static LazyHolderInitialization getInstance() {
        return LazyHolder.instance;
    }

    private static class LazyHolder {
        private static final LazyHolderInitialization instance = new LazyHolderInitialization();
    }
}
```

<br />

`synchronized`κ°μ κ΅¬λ¬Έμ μ¬μ©νμ§ μλλΌλ λμμ± λ¬Έμ λ₯Ό ν΄κ²° ν  μ μμ΅λλ€.

λμμ `μ§μ°λ‘λ©`κΉμ§ κ°λ₯νκΈ° λλ¬Έμ κ°μ₯ κΆμ₯λλ μ±κΈν΄ ν¨ν΄ κ΅¬ν λ°©λ²μλλ€.

`μ μ  λ΄λΆ ν΄λμ€`μ `λμ λ°μΈλ©`μ κ·ΉνμΌλ‘ νμ©ν μμλλ€.

<br />

# π  μ€μ  μ¬μ© μμ 

<br />

νμ¬ νλ‘κ·Έλ¨μμ μ¬λ¬κ°μ§ `Random`ν κ°λ€μ μ¬μ©ν΄μΌ ν©λλ€.

νμ§λ§ λ³ μκ° μμ΄ νμν  λλ§λ€ `new Random`μ λ§€λ² νΈμΆν΄μ μ¬μ©νλ€λ©΄ μ΄λ λ©λͺ¨λ¦¬μ λ­λΉλΌκ³  λ³Ό μ μμ κ²μλλ€.

λ°λΌμ λ΄λΆμ μΌλ‘ `Random`μ μμ±νμ¬ κ°κ³  μ΄ `Random`μ ν΅ν΄ μΈλΆμ κ°μ’ λλ€ν κ°μ μ κ³΅νλ μ νΈλ¦¬ν° μ±κΈν΄ κ°μ²΄λ₯Ό μμ±ν΄λ³΄κ² μ΅λλ€.

<br />

```java
public class RandomValueGenerator {
    private final Random random;

    private RandomValueGenerator(Random random) {
        this.random = random;
    }

    public static RandomValueGenerator getInstance() {
        return RandomValueGeneratorHolder.instance;
    }

    public int nextInt(int bound) {
        return random.nextInt(bound);
    }

    public boolean nextBoolean() {
        return random.nextBoolean();
    }

    private static class RandomValueGeneratorHolder {
        private static final RandomValueGenerator instance = new RandomValueGenerator(new Random());
    }
}
```

<br />

μ΄μ λΆν° νλ‘κ·Έλ¨μμλ `RandomValueGenerator.getInstance()`λ₯Ό ν΅ν΄ `Random`μ μΈν°νμ΄μ€λ₯Ό μ¬μ©ν  μ μμΌλ©΄μ λ©λͺ¨λ¦¬λ μλ μ μκ² λ©λλ€.

κ·Έλ¦¬κ³  `Random`μ μ΄λ€ μΈν°νμ΄μ€λ₯Ό μΈλΆμ κ³΅κ°ν μ§μ λν νλ¨ λν κ°λ°μμ μ μ΄νμ λ€μ΄μ΅λλ€. (`Encapsulation`)

<br />
