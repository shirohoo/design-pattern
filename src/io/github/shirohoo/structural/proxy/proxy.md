# π νλ‘μ ν¨ν΄(Proxy Pattern)

<br />

`νλ‘μ ν¨ν΄`μ `κ΅¬μ‘° ν¨ν΄` μ€ νλμ΄λ©°, `νλ‘μ`λ νκΈλ‘ λλ¦¬μ, λλ¦¬μΈμ΄λΌλ λ»μ κ°μ΅λλ€.

νλ‘μ ν¨ν΄μ λ³λμ λΌμ΄λΈλ¬λ¦¬λ₯Ό ν΅ν΄ μ¬μ©νκ² λλ κ²½μ°κ° λ§κΈ° λλ¬Έμ, μ€μ λ‘ μ§μ  κ΅¬νν  μΌμ μκ°λ³΄λ€ λ§μ§λ μμ§λ§, νλ‘μκ° λ­μ§μ λν μ΄ν΄λ μ λλ‘ ν΄μΌ ν©λλ€.

μ€μ λ‘ μ¬μ©λλ κ³³μ΄ λ§€μ° λ§κΈ° λλ¬Έμλλ€.

λͺκ°μ§ μλ₯Ό λ€μ΄λ³΄μλ©΄ JPAμ μ§μ°λ‘λ©, ASMκ³Ό ASMμ μ¬μ©νλ ByteBuddy, κ°μ’ μΊμκ΄λ ¨ λΌμ΄λΈλ¬λ¦¬ λ±μ΄ μκ² μ΅λλ€.

μλ°μλ νλ‘μ ν¨ν΄μ μ½κ² μ¬μ©ν  μ μκ² μ΄λ―Έ `java.lang.reflect.Proxy`λΌλ ν΄λμ€λ₯Ό λ§λ€μ΄λμμ΅λλ€.

μλ¬΄νΌ νλ‘μλ μ€μ λ‘ κ΅μ₯ν μ μ©νκ² μ¬μ©λκ³  μλ ν¨ν΄μ΄λ©°, λλΆλΆμ λΌμ΄λΈλ¬λ¦¬μμ ν΅μ¬μ μΈ μ­ν μ λ΄λΉνκ³  μμΌλ, μ΄μ λν μ΄ν΄κ° μ λλ‘ μλ°λμ΄μΌ ν  κ²μλλ€.

<br />

νλ‘κ·Έλλ°μλ `μΈλλ μ(Indirection)`μ΄λΌλ κ°λμ΄ μμ΅λλ€.

**<br />**

> π Dennis DeBruler
> > μ»΄ν¨ν° κ³Όνμ μΈλλ μ κ³μΈ΅μ ν λ¨κ³ λ λ§λ€λ©΄ λͺ¨λ  λ¬Έμ λ₯Ό ν μ μλ€κ³  λ―Ώλ νλ¬Έμ΄λ€.

<br />

μΈλλ μμ λν μ¬λ¬ μν°ν΄μ μ°Έκ³ ν΄λ³΄λ©΄ λ κ³μΈ΅μ¬μ΄μ μ΄λ€ λ¬Έμ κ° λ°μνμ λ λ κ³μΈ΅ μ¬μ΄μ λ³λμ κ³μΈ΅μ νλ μΆκ°νλ©΄ ν΄λΉ λ¬Έμ κ° κΉλνκ² ν΄κ²°λλ κ²½μ°κ° λ§λ€λ λ΄μ©μ΄ μμ£Ό λμ΅λλ€

κ·Έλ¦¬κ³  μ΄λ° κ°λμ νλ‘κ·Έλλ° μ©μ΄λ‘ λ°κΏλ³΄λ©΄ `κ°μ μ°Έμ‘°` νΉμ `μΆμν`λ‘ μ΄ν΄ν΄λ λ¬΄λ°© ν  κ² κ°μ΅λλ€.

<br />

`νλ‘μ`λ μ΄ μ λ΄μ©κ³Ό κΆ€λ₯Ό κ°μ΄νλ©° νλ‘μ ν¨ν΄μ SOLIDμ€ `κ°λ°©νμμμΉ(OCP)`κ³Ό `μμ‘΄μ­μ μμΉ(DIP)`μ μΆ©μ€ν λ°λ¦λλ€.

<br />

μ¬κΈ°κΉμ§λ μ¬μ μ μΈ μ μλ€μ΄μμ΅λλ€.

κ·Έλ λ€λ©΄ μ λ§ νλ‘μλ λ­κΉμ?

<br />

νλ‘κ·Έλλ°μμμ νλ‘μλ μ λ§ μ¬μ μ μΈ λ» κ·Έλλ‘ νΉμ  κ°μ²΄μ μ¬μ΄μ μμΉνλ, μ§μ§μΈ μ²μ νλ κ°μ§ κ°μ²΄μλλ€.

κ·Έλ¦¬κ³  μ΄λ κ² μ§μ§μΈμ²μ νλ©΄μκΉμ§ λͺ©νλ‘ νλ κ²μ `μ€μ  κ°μ²΄λ₯Ό μΊ‘μννκ³ , μ€μ  κ°μ²΄μ λν μ κ·Όμ μ μ΄νλ κ²`μλλ€.

κ²°κ³Όμ μΌλ‘ μ€μ  λ κ°μ²΄λ μ¬μ΄μ νλ‘μλΌλ κ°μ§ κ°μ²΄κ° μλμ§ μ ν λͺ¨λ₯Έμ±λ‘ μλ‘λ₯Ό μ§μ§λΌκ³  μ λ’°νκ³  λ©μμ§λ₯Ό μ£Όκ³ λ°κ² λ©λλ€.

μ΄ νλ‘μ ν¨ν΄μ `μ΄λν° ν¨ν΄`, `λ°μ½λ μ΄ν° ν¨ν΄`, `νμ¬λ ν¨ν΄` λ±κ³Ό κ°μ₯ νΌλμ΄ λλ ν¨ν΄μΈλ°, μ΄λ `νλ‘μ ν¨ν΄` μμ²΄κ° μμ©νκΈ°μ λ°λΌ μ λ§ μ¬λ¬κ°μ§ μ©λλ‘ μ¬μ© λ  μ μλ νΉμ΄ν ν¨ν΄μ΄κΈ° λλ¬Έμλλ€.

<br />

μ½λλ₯Ό ν΅ν΄ λ³΄μμ£ .

<br />

![image](https://user-images.githubusercontent.com/71188307/125183114-d42d5800-e24e-11eb-927c-62399c15aaab.png)

<br />

ν΅μμ μΈ νλ‘μ ν¨ν΄μ ν΄λμ€ λ€μ΄μ΄κ·Έλ¨μλλ€.

μ΄λ₯Ό μ½λλ‘ νμ΄λ΄λ©΄ λ€μκ³Ό κ°μ΅λλ€.

<br />

```java
public class Client {
    private final Operator operator;

    public Client(Operator operator) {
        this.operator = operator;
    }

    public void callOperation() {
        operator.operate();
    }
}
```

<br />

```java
public interface Operator {
    void operate();
}
```

<br />

```java
public class RealOperator implements Operator {
    @Override
    public void operate() {
        System.out.println("it's real operator !");
    }
}
```

<br />

```java
public class ProxyOperator implements Operator {
    private final Operator operator = new RealOperator();

    @Override
    public void operate() {
        System.out.println("it's proxy operator !");
        operator.operate();
    }
}
```

<br />

```java
public class ConsoleRunner {
    public static void main(String[] args) {
        Client connector = new Client(new ProxyOperator());
        connector.callOperation();
    }
}
```

<br />

μΆλ ₯μ λ€μκ³Ό κ°μ΅λλ€.

<br />

```shell
it's proxy operator !
it's real operator !
```

<br />

μ€κ°μ `ProxyOperator`μ λ‘μ§μ΄ μΆκ°λ  μ μμΌλ©΄μ

μ€μ  κ²°κ³Όλ `RealOperator`μ μ°μ°κ²°κ³Όκ° λμ΄μ λ³Ό μ μμ΅λλ€.

<br />

## π€ νλ‘μλ₯Ό μ¬μ©νλ μ΄μ  ?

---

μ΄μ  νλ‘μκ° λμΆ© λ­μ§ μμλ€λ©΄ νλ‘μλ₯Ό μ¬μ©νλ μ΄μ μ λν λ©λμ΄ νμν©λλ€.

νλ‘μλ λνμ μΌλ‘ λ€μκ³Ό κ°μ μ­ν λ€μ μνν  μ μμ΅λλ€.

<br />

1. νλ¦μ μ΄
2. μΊμ±
3. μ§μ°μ°μ°

<br />

### π‘ νλ¦μ μ΄

---

μλ¬Έμ μμμ½λμ κ°μ΅λλ€.

μμμ½λμμλ λ¨μν

<br />

```java
System.out.println("it's proxy operator !");
```

<br />

νμ€λ§μ μΆκ°νμ§λ§, μ΄κ³³μ κ°λ°μκ° μμμ μ½λλ₯Ό μΆκ°ν  μλ μμ κ²μλλ€.

μΌλ°μ μΌλ‘λ μ‘°κ±΄λ¬Έμ μ¬μ©νμ¬ νΉμ  μ‘°κ±΄μ λν νλ¦μ μ μ΄νκ² λλ κ²½μ°κ° λ§μ΅λλ€.

μ΄λ¬ν νλ¦μ μ΄ κΈ°λ₯μ κ·ΉνμΌλ‘ νμ©νλ μλ‘ `ν¬μλ νλ‘μ`, `λ¦¬λ²μ€ νλ‘μ` λ±μ΄ μμ κ² κ°μ΅λλ€.

λν, μ€νλ§μμλ μ΄λ₯Ό νμ©ν΄ `AOP` κΈ°μ μ κ΅¬ννκ³  μμΌλ©° `AOP` κΈ°μ μ ν΅ν΄ κ΅¬νλλ λνμ μΈ κΈ°μ λ‘λ μ°λ¦¬κ° μμ£Ό μ¬μ©νλ `@Transactional`μ΄ μμ΅λλ€.

<br />

### π‘ μΊμ±

---

> π μλλ¦¬μ€
>
> νΉμ ν νμ€νΈλ₯Ό μ½μ΄ λ³΅νΈννμ¬ λ°νν΄μ£Όλ κΈ°λ₯μ΄ μμ΅λλ€.
>
> λ§€λ² μλ‘μ΄ νμ€νΈλ₯Ό λ°ννλ λ¦¬μμ€μ λ­λΉκ° μ¬ν΄ μ΄λ₯Ό μΊμνκ³ μ ν©λλ€.

<br />

```java
public interface TextFileReader {
    SecretText read();
}
```

<br />

```java
public class RealTextFileReader implements TextFileReader {
    private final String plainText;

    public RealTextFileReader(String encryptedText) {
        this.plainText = SecretUtil.decode(encryptedText);
    }

    @Override
    public SecretText read() {
        System.out.println("reading text from : " + plainText);
        return new SecretText(plainText);
    }
}
```

<br />

```java
public class ConsoleRunner {
    public static void main(String[] args) {
        // μΊμνμ§ μμ
        TextFileReader realTextFileReader = new RealTextFileReader("plainText");
        realTextFileReader.read();
        realTextFileReader.read();
        realTextFileReader.read();
        realTextFileReader.read();
        realTextFileReader.read();
    }
}
```

<br />

μΆλ ₯μ λ€μκ³Ό κ°μ΅λλ€.

<br />

```shell
reading text from : plainText
reading text from : plainText
reading text from : plainText
reading text from : plainText
reading text from : plainText
```

<br />

μ΄λ₯Ό νλ‘μ ν¨ν΄μ νμ©ν΄ μΊμν΄λ³Όκ²λλ€.

<br />

```java
public class ProxyTextFileReader implements TextFileReader {
    private final String plainText;
    private SecretText secretText;

    public ProxyTextFileReader(String encryptedText) {
        this.plainText = SecretUtil.decode(encryptedText);
    }

    @Override
    public SecretText read() {
        // κ°μ§κ³  μλ νμΌμ΄ μκ±°λ, κ°μ§κ³  μλ νμΌκ³Ό μμ²­λ°μ νμΌμ΄ λ€λ₯Έ κ²½μ° μλ‘μ΄ νμΌμ μμ±νμ¬ μΊμ
        if (secretText == null || !Objects.equals(secretText.getPlainText(), this.plainText)) {
            System.out.println("reading text from : " + plainText);
            this.secretText = new SecretText(plainText);
            return this.secretText;
        }

        System.out.println("using cached text.");
        return new SecretText(plainText);
    }
}
```

<br />

μμ±μλ₯Ό ν΅ν΄ `ProxyTextFileReader`κ° μ΄κΈ°νλλ©΄ λ΄λΆμ λ³΅νΈν ν νμΌμ μΊμν΄λκ³  μ΄ν νΈμΆλλ©΄ μΊμν΄λ νμΌμ μ¦μ λ¦¬ν΄νλ μ½λμλλ€.

<br />

```java
public class ConsoleRunner {
    public static void main(String[] args) {
        // νλ‘μ ν¨ν΄μ νμ©ν μΊμ κΈ°λ₯ κ΅¬ν
        TextFileReader proxyTextFileReader = new ProxyTextFileReader("plainText");
        proxyTextFileReader.read();
        proxyTextFileReader.read();
        proxyTextFileReader.read();
        proxyTextFileReader.read();
        proxyTextFileReader.read();
    }
}
```

<br />

```text
reading text from : plainText
using cached text.
using cached text.
using cached text.
using cached text.
```

<br />

μ΄μ²λΌ νλ‘μλ₯Ό μ¬μ©νμ¬ κΈ°μ‘΄μ μν€νμ²μ μν₯μ μ£Όμ§ μλ μ μμ μΊμ κΈ°λ₯μ κ°λ¨νκ² μΆκ°ν  μλ μμ΅λλ€.

<br />

### π‘ μ§μ°μ°μ°

---

μ§μ°μ°μ°μ΄λΌλ κ²μ μ΄λ€ μ°μ°μ΄ μ λ§λ‘ μ€νλμ΄μΌ νκΈ° μ κΉμ§ ν΄λΉ μ°μ°μ μ€νμ μ μνλ κ²μλλ€.

μ΄λ κ² ν¨μΌλ‘μ¨ νμνμ§ μμ μ°μ°μ μ΅μννμ¬ μ±λ₯ μ΅μ νλ₯Ό μλν  μ μμ΅λλ€.

<br />

κ΅¬νμ μ λ§μ λ§ κ°λ¨ν©λλ€.

μ§μ§ κ°μ²΄λ₯Ό νλ‘μλ‘ νλ² λννλ©΄ λμλλ€.

<br />

```java
public class LazyTextFileReader implements TextFileReader {
    private final String plainText;
    private TextFileReader reader;

    public LazyTextFileReader(String encryptedText) {
        this.plainText = SecretUtil.decode(encryptedText);
    }

    @Override
    public SecretText read() {
        if (reader == null) {
            System.out.println("lazy initialisation");
            reader = new RealTextFileReader(plainText);
        }
        return reader.read();
    }
}
```

<br />

```java
public class ConsoleRunner {
    public static void main(String[] args) {
        TextFileReader lazyTextFileReader = new LazyTextFileReader("plainText");
        lazyTextFileReader.read();
        lazyTextFileReader.read();
        lazyTextFileReader.read();
        lazyTextFileReader.read();
        lazyTextFileReader.read();
    }
}
```

<br />

```text
lazy initialisation
reading text from : plainText
reading text from : plainText
reading text from : plainText
reading text from : plainText
reading text from : plainText
```

<br />

μ΄λ κ² νλ©΄ `read()`κ° μ λ§λ‘ μ€νλμΌ ν  μκ°μ΄ μ€λ©΄ κ·Έμ μΌ μ§μ§ κ°μ²΄λ₯Ό μμ±νκ³  νΈμΆνμ¬ μ°μ°μ μμν©λλ€.

<br />  
